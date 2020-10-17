package com.mall.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 将DataSet转化为List<Bean>
 * <p>
 * 使用方法：
 * 1. 请在Controller对应的方法的形参列表中，使用 {@linkplain DataSetJsonRequestParam} 来注解参数名称
 * 其中value对应HttpRequest请求中携带的参数名字，type对应List中将要存储的bean的类型
 * 例如：
 * public boolean syncGoods(@DataSetJsonRequestParam(value = "goods", type = Goods.class) List<Goods> goodsList) {
 * ...
 * }
 * 2. 当Bean中属性的值的名称，与DataSet.Records[0]中的参数相匹配时
 * （匹配规则：若请求参数中去除下划线后，忽略大小写与Bean中的属性名相同，则匹配成功），
 * 则值会直接被set进bean对象。否则请在Bean的属性上注解 {@linkplain DataSetFieldName}，
 * 例如：
 * // *     @DataSetFieldName("CorpNo_")
 * // *     private String corpNo;
 * 解析器会根据注解中的值进行匹配赋值。当通过该注解匹配成功并且成功赋后，则不再使用原参数匹配
 *
 * @author 李重辰
 * @date 2020/9/7 19:57
 * @see DataSetJsonRequestParam
 * @see DataSetFieldName
 */
public class DataSetJsonArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(DataSetJsonRequestParam.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    //得到 DataSetJsonRequestParam 注解信息并将其转换成用来记录注解信息的 DataSetJsonRequestParamNameValueInfo 对象
    DataSetJsonRequestParam dataSetJsonRequestParam = parameter.getParameterAnnotation(DataSetJsonRequestParam.class);
    assert dataSetJsonRequestParam != null;
    DataSetJsonRequestParamNameValueInfo namedValueInfo = new DataSetJsonRequestParamNameValueInfo(dataSetJsonRequestParam.value(), dataSetJsonRequestParam.type());
    if (namedValueInfo.name.isEmpty() || namedValueInfo.type == null) {
      namedValueInfo.name = parameter.getParameterName();
      if (namedValueInfo.name == null) {
        throw new IllegalArgumentException(
            "Name for argument type [" + parameter.getNestedParameterType().getName() +
                "] not available, and parameter name information not found in class file either.");
      }
    }
    //获得对应的 value 的 JSON 字符串
    HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
    assert servletRequest != null;
    String json = servletRequest.getParameter(namedValueInfo.name);
    if (StringUtils.isEmpty(json)) {
      throw new IllegalArgumentException("请求参数 " + namedValueInfo.name + " 不存在或无值");
    }

    Gson gson = new GsonBuilder().serializeNulls().create();
    Map<String, ArrayList<Object[]>> jsonMap;
    jsonMap = gson.fromJson(json, new TypeToken<Map<String, ArrayList<Object[]>>>() {
    }.getType());

    List<MutablePropertyValues> mpvList = new ArrayList<>();
    Class<?> elementClass = dataSetJsonRequestParam.type();
    addRecordToMutablePropertyValues(jsonMap, mpvList, elementClass);

    String name = ClassUtils.getShortNameAsProperty(elementClass);
    Object attribute;
    WebDataBinder binder;
    ServletRequestDataBinder servletBinder;
    Object element;
    List<Object> actualParameter = new ArrayList<>(mpvList.size());
    for (MutablePropertyValues propertyValues : mpvList) {
      attribute = BeanUtils.instantiateClass(elementClass);
      binder = binderFactory.createBinder(webRequest, attribute, name);
      servletBinder = (ServletRequestDataBinder) binder;
      servletBinder.bind(propertyValues);
      element = binder.getTarget();
      actualParameter.add(element);
    }
    return actualParameter;
  }

  /**
   * 将DataSet中的records拆解到对应的JavaBean的字段中，存放在List<MutablePropertyValues>中
   *
   * @param jsonMap      由json字符串转化而来的DataSet数据结构
   * @param mpvList      临时存放着即将要转为JavaBean的字段键值对
   * @param elementClass 目标Bean的类型
   */
  private void addRecordToMutablePropertyValues(Map<String, ArrayList<Object[]>> jsonMap, List<MutablePropertyValues> mpvList, Class<?> elementClass) {
    MutablePropertyValues mutablePropertyValues;
    Field[] declaredFields = elementClass.getDeclaredFields();
    if (jsonMap.isEmpty()) {
      throw new IllegalArgumentException("请求参数异常");
    }
    ArrayList<Object[]> dataset = jsonMap.get("dataset");
    Object[] paramFieldArray = dataset.get(0);
    for (int i = 1; i < dataset.size(); i++) {
      // 拿到dataSet某一行的记录
      Object[] record = dataset.get(i);
      mutablePropertyValues = new MutablePropertyValues();
      for (int j = 0; j < paramFieldArray.length; j++) {
        Object field = paramFieldArray[j];
        for (Field declaredField : declaredFields) {
          // 如果没有增加注解，那么如果dataSet的list的第一条中的字段，去除下划线且忽略大小写后和bean的字段一致，则set值进去
          if (field.toString().replace("_", "").equalsIgnoreCase(declaredField.getName())) {
            mutablePropertyValues.add(declaredField.getName(), record[j]);
            break;
          }
          // 遍历对应的Class中声明的所有变量，如果变量的名字，和dataSet第一行中的名字相对应，则按数组的索引，把数据放到变量的值中去
          if (declaredField.isAnnotationPresent(DataSetFieldName.class)) {
            DataSetFieldName annotation = declaredField.getAnnotation(DataSetFieldName.class);
            if (field.toString().equals(annotation.value())) {
              mutablePropertyValues.add(declaredField.getName(), record[j]);
              break;
            }
          }
        }
      }
      mpvList.add(mutablePropertyValues);
    }
  }

  private static class DataSetJsonRequestParamNameValueInfo {

    @NonNull
    private Class<?> type;

    private String name;

    public DataSetJsonRequestParamNameValueInfo(String name, Class<?> type) {
      this.name = name;
      this.type = type;
    }
  }
}
