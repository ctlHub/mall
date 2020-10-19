package com.mall.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GmsTagExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public GmsTagExample() {
    oredCriteria = new ArrayList<>();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andIdIsNull() {
      addCriterion("id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("id like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("id not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andMerchantIdIsNull() {
      addCriterion("merchant_id is null");
      return (Criteria) this;
    }

    public Criteria andMerchantIdIsNotNull() {
      addCriterion("merchant_id is not null");
      return (Criteria) this;
    }

    public Criteria andMerchantIdEqualTo(String value) {
      addCriterion("merchant_id =", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdNotEqualTo(String value) {
      addCriterion("merchant_id <>", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdGreaterThan(String value) {
      addCriterion("merchant_id >", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
      addCriterion("merchant_id >=", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdLessThan(String value) {
      addCriterion("merchant_id <", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdLessThanOrEqualTo(String value) {
      addCriterion("merchant_id <=", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdLike(String value) {
      addCriterion("merchant_id like", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdNotLike(String value) {
      addCriterion("merchant_id not like", value, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdIn(List<String> values) {
      addCriterion("merchant_id in", values, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdNotIn(List<String> values) {
      addCriterion("merchant_id not in", values, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdBetween(String value1, String value2) {
      addCriterion("merchant_id between", value1, value2, "merchantId");
      return (Criteria) this;
    }

    public Criteria andMerchantIdNotBetween(String value1, String value2) {
      addCriterion("merchant_id not between", value1, value2, "merchantId");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("name is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andTypeIsNull() {
      addCriterion("type is null");
      return (Criteria) this;
    }

    public Criteria andTypeIsNotNull() {
      addCriterion("type is not null");
      return (Criteria) this;
    }

    public Criteria andTypeEqualTo(String value) {
      addCriterion("type =", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeNotEqualTo(String value) {
      addCriterion("type <>", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeGreaterThan(String value) {
      addCriterion("type >", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeGreaterThanOrEqualTo(String value) {
      addCriterion("type >=", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeLessThan(String value) {
      addCriterion("type <", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeLessThanOrEqualTo(String value) {
      addCriterion("type <=", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeLike(String value) {
      addCriterion("type like", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeNotLike(String value) {
      addCriterion("type not like", value, "type");
      return (Criteria) this;
    }

    public Criteria andTypeIn(List<String> values) {
      addCriterion("type in", values, "type");
      return (Criteria) this;
    }

    public Criteria andTypeNotIn(List<String> values) {
      addCriterion("type not in", values, "type");
      return (Criteria) this;
    }

    public Criteria andTypeBetween(String value1, String value2) {
      addCriterion("type between", value1, value2, "type");
      return (Criteria) this;
    }

    public Criteria andTypeNotBetween(String value1, String value2) {
      addCriterion("type not between", value1, value2, "type");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNull() {
      addCriterion("remark is null");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNotNull() {
      addCriterion("remark is not null");
      return (Criteria) this;
    }

    public Criteria andRemarkEqualTo(String value) {
      addCriterion("remark =", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotEqualTo(String value) {
      addCriterion("remark <>", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThan(String value) {
      addCriterion("remark >", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("remark >=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThan(String value) {
      addCriterion("remark <", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("remark <=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLike(String value) {
      addCriterion("remark like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotLike(String value) {
      addCriterion("remark not like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkIn(List<String> values) {
      addCriterion("remark in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotIn(List<String> values) {
      addCriterion("remark not in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("remark between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("remark not between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andAppUserIsNull() {
      addCriterion("app_user is null");
      return (Criteria) this;
    }

    public Criteria andAppUserIsNotNull() {
      addCriterion("app_user is not null");
      return (Criteria) this;
    }

    public Criteria andAppUserEqualTo(String value) {
      addCriterion("app_user =", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserNotEqualTo(String value) {
      addCriterion("app_user <>", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserGreaterThan(String value) {
      addCriterion("app_user >", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserGreaterThanOrEqualTo(String value) {
      addCriterion("app_user >=", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserLessThan(String value) {
      addCriterion("app_user <", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserLessThanOrEqualTo(String value) {
      addCriterion("app_user <=", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserLike(String value) {
      addCriterion("app_user like", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserNotLike(String value) {
      addCriterion("app_user not like", value, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserIn(List<String> values) {
      addCriterion("app_user in", values, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserNotIn(List<String> values) {
      addCriterion("app_user not in", values, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserBetween(String value1, String value2) {
      addCriterion("app_user between", value1, value2, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppUserNotBetween(String value1, String value2) {
      addCriterion("app_user not between", value1, value2, "appUser");
      return (Criteria) this;
    }

    public Criteria andAppDateIsNull() {
      addCriterion("app_date is null");
      return (Criteria) this;
    }

    public Criteria andAppDateIsNotNull() {
      addCriterion("app_date is not null");
      return (Criteria) this;
    }

    public Criteria andAppDateEqualTo(Date value) {
      addCriterion("app_date =", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateNotEqualTo(Date value) {
      addCriterion("app_date <>", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateGreaterThan(Date value) {
      addCriterion("app_date >", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateGreaterThanOrEqualTo(Date value) {
      addCriterion("app_date >=", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateLessThan(Date value) {
      addCriterion("app_date <", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateLessThanOrEqualTo(Date value) {
      addCriterion("app_date <=", value, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateIn(List<Date> values) {
      addCriterion("app_date in", values, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateNotIn(List<Date> values) {
      addCriterion("app_date not in", values, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateBetween(Date value1, Date value2) {
      addCriterion("app_date between", value1, value2, "appDate");
      return (Criteria) this;
    }

    public Criteria andAppDateNotBetween(Date value1, Date value2) {
      addCriterion("app_date not between", value1, value2, "appDate");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIsNull() {
      addCriterion("update_user is null");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIsNotNull() {
      addCriterion("update_user is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateUserEqualTo(String value) {
      addCriterion("update_user =", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserNotEqualTo(String value) {
      addCriterion("update_user <>", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserGreaterThan(String value) {
      addCriterion("update_user >", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
      addCriterion("update_user >=", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserLessThan(String value) {
      addCriterion("update_user <", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserLessThanOrEqualTo(String value) {
      addCriterion("update_user <=", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserLike(String value) {
      addCriterion("update_user like", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserNotLike(String value) {
      addCriterion("update_user not like", value, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserIn(List<String> values) {
      addCriterion("update_user in", values, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserNotIn(List<String> values) {
      addCriterion("update_user not in", values, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserBetween(String value1, String value2) {
      addCriterion("update_user between", value1, value2, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateUserNotBetween(String value1, String value2) {
      addCriterion("update_user not between", value1, value2, "updateUser");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIsNull() {
      addCriterion("update_date is null");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIsNotNull() {
      addCriterion("update_date is not null");
      return (Criteria) this;
    }

    public Criteria andUpdateDateEqualTo(Date value) {
      addCriterion("update_date =", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotEqualTo(Date value) {
      addCriterion("update_date <>", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateGreaterThan(Date value) {
      addCriterion("update_date >", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("update_date >=", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateLessThan(Date value) {
      addCriterion("update_date <", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
      addCriterion("update_date <=", value, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateIn(List<Date> values) {
      addCriterion("update_date in", values, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotIn(List<Date> values) {
      addCriterion("update_date not in", values, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateBetween(Date value1, Date value2) {
      addCriterion("update_date between", value1, value2, "updateDate");
      return (Criteria) this;
    }

    public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
      addCriterion("update_date not between", value1, value2, "updateDate");
      return (Criteria) this;
    }
  }

  public static class Criteria extends GeneratedCriteria {
    protected Criteria() {
      super();
    }
  }

  public static class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }
}