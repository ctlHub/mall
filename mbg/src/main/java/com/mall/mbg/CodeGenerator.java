package com.mall.mbg;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * mybatisPlus代码生成器
 *
 * @author 李重辰
 * @date 2020/10/21 19:51
 */
public class CodeGenerator {

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotBlank(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) throws IOException {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/main/src/main/java");
    gc.setAuthor("ctlLab");
    gc.setIdType(IdType.ASSIGN_ID);
    gc.setOpen(false);
    gc.setSwagger2(true);
    gc.setFileOverride(true);
    gc.setBaseResultMap(true);
    gc.setBaseColumnList(true);
    gc.setServiceName("%s" + ConstVal.SERVICE);
    mpg.setGlobalConfig(gc);
    // 数据源配置
    Properties properties = new Properties();
    // 使用ClassLoader加载properties配置文件生成对应的输入流
    InputStream in = CodeGenerator.class.getClassLoader().getResourceAsStream("mybatisGenerator.properties");
    // 使用properties对象加载输入流
    properties.load(in);

    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(properties.getProperty("jdbc.url"));
    dsc.setDriverName(properties.getProperty("jdbc.driverClass"));
    dsc.setUsername(properties.getProperty("jdbc.username"));
    dsc.setPassword(properties.getProperty("jdbc.password"));
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setEntity("model");
    pc.setParent("com.mall");
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
      }
    };
    //  如果模板引擎是 velocity
    String templatePath = "templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return projectPath + "/main/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }
    });
    cfg.setFileCreate(new IFileCreate() {
      @Override
      public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
        checkDir(filePath);
        if (fileType == FileType.MAPPER) {
          // 已经生成 mapper 文件判断存在，不想重新生成返回 false
          return !new File(filePath).exists();
        }
        // 允许生成模板文件
        return true;
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    TemplateConfig tc = new TemplateConfig();
    //resource下的模板   想要修改可以自己改动
    tc.setController("templates/controller.java");
    tc.setService("templates/service.java");
    tc.setServiceImpl("templates/serviceImpl.java");
    tc.setEntity("templates/entity.java");
    tc.setMapper("templates/mapper.java");
    tc.setXml(null);
    mpg.setTemplate(tc);

    List<TableFill> tableFills = new ArrayList<>();
    tableFills.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
    tableFills.add(new TableFill("update_user_id", FieldFill.INSERT_UPDATE));
    tableFills.add(new TableFill("create_time", FieldFill.INSERT));
    tableFills.add(new TableFill("create_user_id", FieldFill.INSERT));

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNameConvert(new MpNameConvert());
    strategy.setVersionFieldName("version");
    strategy.setLogicDeleteFieldName("deleted");
    strategy.setTableFillList(tableFills);
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(false);
    strategy.setRestControllerStyle(true);
    strategy.setInclude("u_biz_permission", "u_biz_role", "u_biz_user");
    strategy.setControllerMappingHyphenStyle(false);
    strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    mpg.execute();
  }

}
