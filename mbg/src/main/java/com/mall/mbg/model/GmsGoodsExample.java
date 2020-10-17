package com.mall.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GmsGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GmsGoodsExample() {
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

        public Criteria andOldIdIsNull() {
            addCriterion("old_id is null");
            return (Criteria) this;
        }

        public Criteria andOldIdIsNotNull() {
            addCriterion("old_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldIdEqualTo(String value) {
            addCriterion("old_id =", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotEqualTo(String value) {
            addCriterion("old_id <>", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThan(String value) {
            addCriterion("old_id >", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThanOrEqualTo(String value) {
            addCriterion("old_id >=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThan(String value) {
            addCriterion("old_id <", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThanOrEqualTo(String value) {
            addCriterion("old_id <=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLike(String value) {
            addCriterion("old_id like", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotLike(String value) {
            addCriterion("old_id not like", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdIn(List<String> values) {
            addCriterion("old_id in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotIn(List<String> values) {
            addCriterion("old_id not in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdBetween(String value1, String value2) {
            addCriterion("old_id between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotBetween(String value1, String value2) {
            addCriterion("old_id not between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andClass1IsNull() {
            addCriterion("class1 is null");
            return (Criteria) this;
        }

        public Criteria andClass1IsNotNull() {
            addCriterion("class1 is not null");
            return (Criteria) this;
        }

        public Criteria andClass1EqualTo(String value) {
            addCriterion("class1 =", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotEqualTo(String value) {
            addCriterion("class1 <>", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1GreaterThan(String value) {
            addCriterion("class1 >", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1GreaterThanOrEqualTo(String value) {
            addCriterion("class1 >=", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1LessThan(String value) {
            addCriterion("class1 <", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1LessThanOrEqualTo(String value) {
            addCriterion("class1 <=", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1Like(String value) {
            addCriterion("class1 like", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotLike(String value) {
            addCriterion("class1 not like", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1In(List<String> values) {
            addCriterion("class1 in", values, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotIn(List<String> values) {
            addCriterion("class1 not in", values, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1Between(String value1, String value2) {
            addCriterion("class1 between", value1, value2, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotBetween(String value1, String value2) {
            addCriterion("class1 not between", value1, value2, "class1");
            return (Criteria) this;
        }

        public Criteria andClass2IsNull() {
            addCriterion("class2 is null");
            return (Criteria) this;
        }

        public Criteria andClass2IsNotNull() {
            addCriterion("class2 is not null");
            return (Criteria) this;
        }

        public Criteria andClass2EqualTo(String value) {
            addCriterion("class2 =", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotEqualTo(String value) {
            addCriterion("class2 <>", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2GreaterThan(String value) {
            addCriterion("class2 >", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2GreaterThanOrEqualTo(String value) {
            addCriterion("class2 >=", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2LessThan(String value) {
            addCriterion("class2 <", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2LessThanOrEqualTo(String value) {
            addCriterion("class2 <=", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2Like(String value) {
            addCriterion("class2 like", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotLike(String value) {
            addCriterion("class2 not like", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2In(List<String> values) {
            addCriterion("class2 in", values, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotIn(List<String> values) {
            addCriterion("class2 not in", values, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2Between(String value1, String value2) {
            addCriterion("class2 between", value1, value2, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotBetween(String value1, String value2) {
            addCriterion("class2 not between", value1, value2, "class2");
            return (Criteria) this;
        }

        public Criteria andClass3IsNull() {
            addCriterion("class3 is null");
            return (Criteria) this;
        }

        public Criteria andClass3IsNotNull() {
            addCriterion("class3 is not null");
            return (Criteria) this;
        }

        public Criteria andClass3EqualTo(String value) {
            addCriterion("class3 =", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotEqualTo(String value) {
            addCriterion("class3 <>", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3GreaterThan(String value) {
            addCriterion("class3 >", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3GreaterThanOrEqualTo(String value) {
            addCriterion("class3 >=", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3LessThan(String value) {
            addCriterion("class3 <", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3LessThanOrEqualTo(String value) {
            addCriterion("class3 <=", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3Like(String value) {
            addCriterion("class3 like", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotLike(String value) {
            addCriterion("class3 not like", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3In(List<String> values) {
            addCriterion("class3 in", values, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotIn(List<String> values) {
            addCriterion("class3 not in", values, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3Between(String value1, String value2) {
            addCriterion("class3 between", value1, value2, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotBetween(String value1, String value2) {
            addCriterion("class3 not between", value1, value2, "class3");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNull() {
            addCriterion("part_type is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNotNull() {
            addCriterion("part_type is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeEqualTo(String value) {
            addCriterion("part_type =", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotEqualTo(String value) {
            addCriterion("part_type <>", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThan(String value) {
            addCriterion("part_type >", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThanOrEqualTo(String value) {
            addCriterion("part_type >=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThan(String value) {
            addCriterion("part_type <", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThanOrEqualTo(String value) {
            addCriterion("part_type <=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLike(String value) {
            addCriterion("part_type like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotLike(String value) {
            addCriterion("part_type not like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeIn(List<String> values) {
            addCriterion("part_type in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotIn(List<String> values) {
            addCriterion("part_type not in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeBetween(String value1, String value2) {
            addCriterion("part_type between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotBetween(String value1, String value2) {
            addCriterion("part_type not between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPyIdIsNull() {
            addCriterion("py_id is null");
            return (Criteria) this;
        }

        public Criteria andPyIdIsNotNull() {
            addCriterion("py_id is not null");
            return (Criteria) this;
        }

        public Criteria andPyIdEqualTo(String value) {
            addCriterion("py_id =", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdNotEqualTo(String value) {
            addCriterion("py_id <>", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdGreaterThan(String value) {
            addCriterion("py_id >", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdGreaterThanOrEqualTo(String value) {
            addCriterion("py_id >=", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdLessThan(String value) {
            addCriterion("py_id <", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdLessThanOrEqualTo(String value) {
            addCriterion("py_id <=", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdLike(String value) {
            addCriterion("py_id like", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdNotLike(String value) {
            addCriterion("py_id not like", value, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdIn(List<String> values) {
            addCriterion("py_id in", values, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdNotIn(List<String> values) {
            addCriterion("py_id not in", values, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdBetween(String value1, String value2) {
            addCriterion("py_id between", value1, value2, "pyId");
            return (Criteria) this;
        }

        public Criteria andPyIdNotBetween(String value1, String value2) {
            addCriterion("py_id not between", value1, value2, "pyId");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCwIdIsNull() {
            addCriterion("cw_id is null");
            return (Criteria) this;
        }

        public Criteria andCwIdIsNotNull() {
            addCriterion("cw_id is not null");
            return (Criteria) this;
        }

        public Criteria andCwIdEqualTo(String value) {
            addCriterion("cw_id =", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotEqualTo(String value) {
            addCriterion("cw_id <>", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdGreaterThan(String value) {
            addCriterion("cw_id >", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdGreaterThanOrEqualTo(String value) {
            addCriterion("cw_id >=", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLessThan(String value) {
            addCriterion("cw_id <", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLessThanOrEqualTo(String value) {
            addCriterion("cw_id <=", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLike(String value) {
            addCriterion("cw_id like", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotLike(String value) {
            addCriterion("cw_id not like", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdIn(List<String> values) {
            addCriterion("cw_id in", values, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotIn(List<String> values) {
            addCriterion("cw_id not in", values, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdBetween(String value1, String value2) {
            addCriterion("cw_id between", value1, value2, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotBetween(String value1, String value2) {
            addCriterion("cw_id not between", value1, value2, "cwId");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIsNull() {
            addCriterion("default_cw is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIsNotNull() {
            addCriterion("default_cw is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCwEqualTo(String value) {
            addCriterion("default_cw =", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotEqualTo(String value) {
            addCriterion("default_cw <>", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwGreaterThan(String value) {
            addCriterion("default_cw >", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwGreaterThanOrEqualTo(String value) {
            addCriterion("default_cw >=", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLessThan(String value) {
            addCriterion("default_cw <", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLessThanOrEqualTo(String value) {
            addCriterion("default_cw <=", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLike(String value) {
            addCriterion("default_cw like", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotLike(String value) {
            addCriterion("default_cw not like", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIn(List<String> values) {
            addCriterion("default_cw in", values, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotIn(List<String> values) {
            addCriterion("default_cw not in", values, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwBetween(String value1, String value2) {
            addCriterion("default_cw between", value1, value2, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotBetween(String value1, String value2) {
            addCriterion("default_cw not between", value1, value2, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andInUpIsNull() {
            addCriterion("in_up is null");
            return (Criteria) this;
        }

        public Criteria andInUpIsNotNull() {
            addCriterion("in_up is not null");
            return (Criteria) this;
        }

        public Criteria andInUpEqualTo(BigDecimal value) {
            addCriterion("in_up =", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotEqualTo(BigDecimal value) {
            addCriterion("in_up <>", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpGreaterThan(BigDecimal value) {
            addCriterion("in_up >", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_up >=", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpLessThan(BigDecimal value) {
            addCriterion("in_up <", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_up <=", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpIn(List<BigDecimal> values) {
            addCriterion("in_up in", values, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotIn(List<BigDecimal> values) {
            addCriterion("in_up not in", values, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_up between", value1, value2, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_up not between", value1, value2, "inUp");
            return (Criteria) this;
        }

        public Criteria andOutUpIsNull() {
            addCriterion("out_up is null");
            return (Criteria) this;
        }

        public Criteria andOutUpIsNotNull() {
            addCriterion("out_up is not null");
            return (Criteria) this;
        }

        public Criteria andOutUpEqualTo(BigDecimal value) {
            addCriterion("out_up =", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotEqualTo(BigDecimal value) {
            addCriterion("out_up <>", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpGreaterThan(BigDecimal value) {
            addCriterion("out_up >", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up >=", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpLessThan(BigDecimal value) {
            addCriterion("out_up <", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up <=", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpIn(List<BigDecimal> values) {
            addCriterion("out_up in", values, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotIn(List<BigDecimal> values) {
            addCriterion("out_up not in", values, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up between", value1, value2, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up not between", value1, value2, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUp2IsNull() {
            addCriterion("out_up2 is null");
            return (Criteria) this;
        }

        public Criteria andOutUp2IsNotNull() {
            addCriterion("out_up2 is not null");
            return (Criteria) this;
        }

        public Criteria andOutUp2EqualTo(BigDecimal value) {
            addCriterion("out_up2 =", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotEqualTo(BigDecimal value) {
            addCriterion("out_up2 <>", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2GreaterThan(BigDecimal value) {
            addCriterion("out_up2 >", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up2 >=", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2LessThan(BigDecimal value) {
            addCriterion("out_up2 <", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up2 <=", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2In(List<BigDecimal> values) {
            addCriterion("out_up2 in", values, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotIn(List<BigDecimal> values) {
            addCriterion("out_up2 not in", values, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up2 between", value1, value2, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up2 not between", value1, value2, "outUp2");
            return (Criteria) this;
        }

        public Criteria andListUpIsNull() {
            addCriterion("list_up is null");
            return (Criteria) this;
        }

        public Criteria andListUpIsNotNull() {
            addCriterion("list_up is not null");
            return (Criteria) this;
        }

        public Criteria andListUpEqualTo(BigDecimal value) {
            addCriterion("list_up =", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotEqualTo(BigDecimal value) {
            addCriterion("list_up <>", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpGreaterThan(BigDecimal value) {
            addCriterion("list_up >", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("list_up >=", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpLessThan(BigDecimal value) {
            addCriterion("list_up <", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("list_up <=", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpIn(List<BigDecimal> values) {
            addCriterion("list_up in", values, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotIn(List<BigDecimal> values) {
            addCriterion("list_up not in", values, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("list_up between", value1, value2, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("list_up not between", value1, value2, "listUp");
            return (Criteria) this;
        }

        public Criteria andCostUpIsNull() {
            addCriterion("cost_up is null");
            return (Criteria) this;
        }

        public Criteria andCostUpIsNotNull() {
            addCriterion("cost_up is not null");
            return (Criteria) this;
        }

        public Criteria andCostUpEqualTo(BigDecimal value) {
            addCriterion("cost_up =", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotEqualTo(BigDecimal value) {
            addCriterion("cost_up <>", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpGreaterThan(BigDecimal value) {
            addCriterion("cost_up >", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_up >=", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpLessThan(BigDecimal value) {
            addCriterion("cost_up <", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_up <=", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpIn(List<BigDecimal> values) {
            addCriterion("cost_up in", values, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotIn(List<BigDecimal> values) {
            addCriterion("cost_up not in", values, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_up between", value1, value2, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_up not between", value1, value2, "costUp");
            return (Criteria) this;
        }

        public Criteria andVipUpIsNull() {
            addCriterion("vip_up is null");
            return (Criteria) this;
        }

        public Criteria andVipUpIsNotNull() {
            addCriterion("vip_up is not null");
            return (Criteria) this;
        }

        public Criteria andVipUpEqualTo(BigDecimal value) {
            addCriterion("vip_up =", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotEqualTo(BigDecimal value) {
            addCriterion("vip_up <>", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpGreaterThan(BigDecimal value) {
            addCriterion("vip_up >", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_up >=", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpLessThan(BigDecimal value) {
            addCriterion("vip_up <", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_up <=", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpIn(List<BigDecimal> values) {
            addCriterion("vip_up in", values, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotIn(List<BigDecimal> values) {
            addCriterion("vip_up not in", values, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_up between", value1, value2, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_up not between", value1, value2, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIsNull() {
            addCriterion("vip_discount is null");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIsNotNull() {
            addCriterion("vip_discount is not null");
            return (Criteria) this;
        }

        public Criteria andVipDiscountEqualTo(BigDecimal value) {
            addCriterion("vip_discount =", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotEqualTo(BigDecimal value) {
            addCriterion("vip_discount <>", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountGreaterThan(BigDecimal value) {
            addCriterion("vip_discount >", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_discount >=", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountLessThan(BigDecimal value) {
            addCriterion("vip_discount <", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_discount <=", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIn(List<BigDecimal> values) {
            addCriterion("vip_discount in", values, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotIn(List<BigDecimal> values) {
            addCriterion("vip_discount not in", values, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_discount between", value1, value2, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_discount not between", value1, value2, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andUpControlIsNull() {
            addCriterion("up_control is null");
            return (Criteria) this;
        }

        public Criteria andUpControlIsNotNull() {
            addCriterion("up_control is not null");
            return (Criteria) this;
        }

        public Criteria andUpControlEqualTo(Integer value) {
            addCriterion("up_control =", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotEqualTo(Integer value) {
            addCriterion("up_control <>", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlGreaterThan(Integer value) {
            addCriterion("up_control >", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlGreaterThanOrEqualTo(Integer value) {
            addCriterion("up_control >=", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlLessThan(Integer value) {
            addCriterion("up_control <", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlLessThanOrEqualTo(Integer value) {
            addCriterion("up_control <=", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlIn(List<Integer> values) {
            addCriterion("up_control in", values, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotIn(List<Integer> values) {
            addCriterion("up_control not in", values, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlBetween(Integer value1, Integer value2) {
            addCriterion("up_control between", value1, value2, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotBetween(Integer value1, Integer value2) {
            addCriterion("up_control not between", value1, value2, "upControl");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Integer value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Integer value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Integer value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Integer value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Integer value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Integer> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Integer> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Integer value1, Integer value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("obj_type is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("obj_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(String value) {
            addCriterion("obj_type =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(String value) {
            addCriterion("obj_type <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(String value) {
            addCriterion("obj_type >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("obj_type >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(String value) {
            addCriterion("obj_type <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(String value) {
            addCriterion("obj_type <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLike(String value) {
            addCriterion("obj_type like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotLike(String value) {
            addCriterion("obj_type not like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<String> values) {
            addCriterion("obj_type in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<String> values) {
            addCriterion("obj_type not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(String value1, String value2) {
            addCriterion("obj_type between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(String value1, String value2) {
            addCriterion("obj_type not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNull() {
            addCriterion("share_rate is null");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNotNull() {
            addCriterion("share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andShareRateEqualTo(BigDecimal value) {
            addCriterion("share_rate =", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotEqualTo(BigDecimal value) {
            addCriterion("share_rate <>", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThan(BigDecimal value) {
            addCriterion("share_rate >", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate >=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThan(BigDecimal value) {
            addCriterion("share_rate <", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate <=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateIn(List<BigDecimal> values) {
            addCriterion("share_rate in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotIn(List<BigDecimal> values) {
            addCriterion("share_rate not in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate not between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andIdIdIsNull() {
            addCriterion("id_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIdIsNotNull() {
            addCriterion("id_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdIdEqualTo(String value) {
            addCriterion("id_id =", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotEqualTo(String value) {
            addCriterion("id_id <>", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdGreaterThan(String value) {
            addCriterion("id_id >", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_id >=", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdLessThan(String value) {
            addCriterion("id_id <", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdLessThanOrEqualTo(String value) {
            addCriterion("id_id <=", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdLike(String value) {
            addCriterion("id_id like", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotLike(String value) {
            addCriterion("id_id not like", value, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdIn(List<String> values) {
            addCriterion("id_id in", values, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotIn(List<String> values) {
            addCriterion("id_id not in", values, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdBetween(String value1, String value2) {
            addCriterion("id_id between", value1, value2, "idId");
            return (Criteria) this;
        }

        public Criteria andIdIdNotBetween(String value1, String value2) {
            addCriterion("id_id not between", value1, value2, "idId");
            return (Criteria) this;
        }

        public Criteria andBoxIdIsNull() {
            addCriterion("box_id is null");
            return (Criteria) this;
        }

        public Criteria andBoxIdIsNotNull() {
            addCriterion("box_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoxIdEqualTo(String value) {
            addCriterion("box_id =", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotEqualTo(String value) {
            addCriterion("box_id <>", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdGreaterThan(String value) {
            addCriterion("box_id >", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdGreaterThanOrEqualTo(String value) {
            addCriterion("box_id >=", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLessThan(String value) {
            addCriterion("box_id <", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLessThanOrEqualTo(String value) {
            addCriterion("box_id <=", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdLike(String value) {
            addCriterion("box_id like", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotLike(String value) {
            addCriterion("box_id not like", value, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdIn(List<String> values) {
            addCriterion("box_id in", values, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotIn(List<String> values) {
            addCriterion("box_id not in", values, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdBetween(String value1, String value2) {
            addCriterion("box_id between", value1, value2, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxIdNotBetween(String value1, String value2) {
            addCriterion("box_id not between", value1, value2, "boxId");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIsNull() {
            addCriterion("box_unit is null");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIsNotNull() {
            addCriterion("box_unit is not null");
            return (Criteria) this;
        }

        public Criteria andBoxUnitEqualTo(String value) {
            addCriterion("box_unit =", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotEqualTo(String value) {
            addCriterion("box_unit <>", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitGreaterThan(String value) {
            addCriterion("box_unit >", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitGreaterThanOrEqualTo(String value) {
            addCriterion("box_unit >=", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLessThan(String value) {
            addCriterion("box_unit <", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLessThanOrEqualTo(String value) {
            addCriterion("box_unit <=", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLike(String value) {
            addCriterion("box_unit like", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotLike(String value) {
            addCriterion("box_unit not like", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIn(List<String> values) {
            addCriterion("box_unit in", values, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotIn(List<String> values) {
            addCriterion("box_unit not in", values, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitBetween(String value1, String value2) {
            addCriterion("box_unit between", value1, value2, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotBetween(String value1, String value2) {
            addCriterion("box_unit not between", value1, value2, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNull() {
            addCriterion("box_num is null");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNotNull() {
            addCriterion("box_num is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNumEqualTo(BigDecimal value) {
            addCriterion("box_num =", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotEqualTo(BigDecimal value) {
            addCriterion("box_num <>", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThan(BigDecimal value) {
            addCriterion("box_num >", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("box_num >=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThan(BigDecimal value) {
            addCriterion("box_num <", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("box_num <=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumIn(List<BigDecimal> values) {
            addCriterion("box_num in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotIn(List<BigDecimal> values) {
            addCriterion("box_num not in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_num between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_num not between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBaridIsNull() {
            addCriterion("barid is null");
            return (Criteria) this;
        }

        public Criteria andBaridIsNotNull() {
            addCriterion("barid is not null");
            return (Criteria) this;
        }

        public Criteria andBaridEqualTo(String value) {
            addCriterion("barid =", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridNotEqualTo(String value) {
            addCriterion("barid <>", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridGreaterThan(String value) {
            addCriterion("barid >", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridGreaterThanOrEqualTo(String value) {
            addCriterion("barid >=", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridLessThan(String value) {
            addCriterion("barid <", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridLessThanOrEqualTo(String value) {
            addCriterion("barid <=", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridLike(String value) {
            addCriterion("barid like", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridNotLike(String value) {
            addCriterion("barid not like", value, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridIn(List<String> values) {
            addCriterion("barid in", values, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridNotIn(List<String> values) {
            addCriterion("barid not in", values, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridBetween(String value1, String value2) {
            addCriterion("barid between", value1, value2, "barid");
            return (Criteria) this;
        }

        public Criteria andBaridNotBetween(String value1, String value2) {
            addCriterion("barid not between", value1, value2, "barid");
            return (Criteria) this;
        }

        public Criteria andOldBaridIsNull() {
            addCriterion("old_barid is null");
            return (Criteria) this;
        }

        public Criteria andOldBaridIsNotNull() {
            addCriterion("old_barid is not null");
            return (Criteria) this;
        }

        public Criteria andOldBaridEqualTo(String value) {
            addCriterion("old_barid =", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridNotEqualTo(String value) {
            addCriterion("old_barid <>", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridGreaterThan(String value) {
            addCriterion("old_barid >", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridGreaterThanOrEqualTo(String value) {
            addCriterion("old_barid >=", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridLessThan(String value) {
            addCriterion("old_barid <", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridLessThanOrEqualTo(String value) {
            addCriterion("old_barid <=", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridLike(String value) {
            addCriterion("old_barid like", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridNotLike(String value) {
            addCriterion("old_barid not like", value, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridIn(List<String> values) {
            addCriterion("old_barid in", values, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridNotIn(List<String> values) {
            addCriterion("old_barid not in", values, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridBetween(String value1, String value2) {
            addCriterion("old_barid between", value1, value2, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andOldBaridNotBetween(String value1, String value2) {
            addCriterion("old_barid not between", value1, value2, "oldBarid");
            return (Criteria) this;
        }

        public Criteria andPushMonthIsNull() {
            addCriterion("push_month is null");
            return (Criteria) this;
        }

        public Criteria andPushMonthIsNotNull() {
            addCriterion("push_month is not null");
            return (Criteria) this;
        }

        public Criteria andPushMonthEqualTo(Integer value) {
            addCriterion("push_month =", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotEqualTo(Integer value) {
            addCriterion("push_month <>", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthGreaterThan(Integer value) {
            addCriterion("push_month >", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("push_month >=", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthLessThan(Integer value) {
            addCriterion("push_month <", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthLessThanOrEqualTo(Integer value) {
            addCriterion("push_month <=", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthIn(List<Integer> values) {
            addCriterion("push_month in", values, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotIn(List<Integer> values) {
            addCriterion("push_month not in", values, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthBetween(Integer value1, Integer value2) {
            addCriterion("push_month between", value1, value2, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("push_month not between", value1, value2, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIsNull() {
            addCriterion("readme_url is null");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIsNotNull() {
            addCriterion("readme_url is not null");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlEqualTo(String value) {
            addCriterion("readme_url =", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotEqualTo(String value) {
            addCriterion("readme_url <>", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlGreaterThan(String value) {
            addCriterion("readme_url >", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("readme_url >=", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLessThan(String value) {
            addCriterion("readme_url <", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLessThanOrEqualTo(String value) {
            addCriterion("readme_url <=", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLike(String value) {
            addCriterion("readme_url like", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotLike(String value) {
            addCriterion("readme_url not like", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIn(List<String> values) {
            addCriterion("readme_url in", values, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotIn(List<String> values) {
            addCriterion("readme_url not in", values, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlBetween(String value1, String value2) {
            addCriterion("readme_url between", value1, value2, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotBetween(String value1, String value2) {
            addCriterion("readme_url not between", value1, value2, "readmeUrl");
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

        public Criteria andSupIdIsNull() {
            addCriterion("sup_id is null");
            return (Criteria) this;
        }

        public Criteria andSupIdIsNotNull() {
            addCriterion("sup_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupIdEqualTo(String value) {
            addCriterion("sup_id =", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotEqualTo(String value) {
            addCriterion("sup_id <>", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThan(String value) {
            addCriterion("sup_id >", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThanOrEqualTo(String value) {
            addCriterion("sup_id >=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThan(String value) {
            addCriterion("sup_id <", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThanOrEqualTo(String value) {
            addCriterion("sup_id <=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLike(String value) {
            addCriterion("sup_id like", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotLike(String value) {
            addCriterion("sup_id not like", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdIn(List<String> values) {
            addCriterion("sup_id in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotIn(List<String> values) {
            addCriterion("sup_id not in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdBetween(String value1, String value2) {
            addCriterion("sup_id between", value1, value2, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotBetween(String value1, String value2) {
            addCriterion("sup_id not between", value1, value2, "supId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNull() {
            addCriterion("file_num is null");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNotNull() {
            addCriterion("file_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumEqualTo(Integer value) {
            addCriterion("file_num =", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotEqualTo(Integer value) {
            addCriterion("file_num <>", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThan(Integer value) {
            addCriterion("file_num >", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_num >=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThan(Integer value) {
            addCriterion("file_num <", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThanOrEqualTo(Integer value) {
            addCriterion("file_num <=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumIn(List<Integer> values) {
            addCriterion("file_num in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotIn(List<Integer> values) {
            addCriterion("file_num not in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumBetween(Integer value1, Integer value2) {
            addCriterion("file_num between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotBetween(Integer value1, Integer value2) {
            addCriterion("file_num not between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andLastSupIdIsNull() {
            addCriterion("last_sup_id is null");
            return (Criteria) this;
        }

        public Criteria andLastSupIdIsNotNull() {
            addCriterion("last_sup_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastSupIdEqualTo(String value) {
            addCriterion("last_sup_id =", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdNotEqualTo(String value) {
            addCriterion("last_sup_id <>", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdGreaterThan(String value) {
            addCriterion("last_sup_id >", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_sup_id >=", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdLessThan(String value) {
            addCriterion("last_sup_id <", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdLessThanOrEqualTo(String value) {
            addCriterion("last_sup_id <=", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdLike(String value) {
            addCriterion("last_sup_id like", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdNotLike(String value) {
            addCriterion("last_sup_id not like", value, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdIn(List<String> values) {
            addCriterion("last_sup_id in", values, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdNotIn(List<String> values) {
            addCriterion("last_sup_id not in", values, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdBetween(String value1, String value2) {
            addCriterion("last_sup_id between", value1, value2, "lastSupId");
            return (Criteria) this;
        }

        public Criteria andLastSupIdNotBetween(String value1, String value2) {
            addCriterion("last_sup_id not between", value1, value2, "lastSupId");
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

        public Criteria andUpdateKeyIsNull() {
            addCriterion("update_key is null");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyIsNotNull() {
            addCriterion("update_key is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyEqualTo(String value) {
            addCriterion("update_key =", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotEqualTo(String value) {
            addCriterion("update_key <>", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyGreaterThan(String value) {
            addCriterion("update_key >", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("update_key >=", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLessThan(String value) {
            addCriterion("update_key <", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLessThanOrEqualTo(String value) {
            addCriterion("update_key <=", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLike(String value) {
            addCriterion("update_key like", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotLike(String value) {
            addCriterion("update_key not like", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyIn(List<String> values) {
            addCriterion("update_key in", values, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotIn(List<String> values) {
            addCriterion("update_key not in", values, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyBetween(String value1, String value2) {
            addCriterion("update_key between", value1, value2, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotBetween(String value1, String value2) {
            addCriterion("update_key not between", value1, value2, "updateKey");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIsNull() {
            addCriterion("allow_discount is null");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIsNotNull() {
            addCriterion("allow_discount is not null");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountEqualTo(Integer value) {
            addCriterion("allow_discount =", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotEqualTo(Integer value) {
            addCriterion("allow_discount <>", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountGreaterThan(Integer value) {
            addCriterion("allow_discount >", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_discount >=", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountLessThan(Integer value) {
            addCriterion("allow_discount <", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("allow_discount <=", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIn(List<Integer> values) {
            addCriterion("allow_discount in", values, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotIn(List<Integer> values) {
            addCriterion("allow_discount not in", values, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountBetween(Integer value1, Integer value2) {
            addCriterion("allow_discount between", value1, value2, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_discount not between", value1, value2, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andBomLevelIsNull() {
            addCriterion("bom_level is null");
            return (Criteria) this;
        }

        public Criteria andBomLevelIsNotNull() {
            addCriterion("bom_level is not null");
            return (Criteria) this;
        }

        public Criteria andBomLevelEqualTo(Integer value) {
            addCriterion("bom_level =", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotEqualTo(Integer value) {
            addCriterion("bom_level <>", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelGreaterThan(Integer value) {
            addCriterion("bom_level >", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("bom_level >=", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelLessThan(Integer value) {
            addCriterion("bom_level <", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelLessThanOrEqualTo(Integer value) {
            addCriterion("bom_level <=", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelIn(List<Integer> values) {
            addCriterion("bom_level in", values, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotIn(List<Integer> values) {
            addCriterion("bom_level not in", values, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelBetween(Integer value1, Integer value2) {
            addCriterion("bom_level between", value1, value2, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("bom_level not between", value1, value2, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIsNull() {
            addCriterion("part_view_top is null");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIsNotNull() {
            addCriterion("part_view_top is not null");
            return (Criteria) this;
        }

        public Criteria andPartViewTopEqualTo(Integer value) {
            addCriterion("part_view_top =", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotEqualTo(Integer value) {
            addCriterion("part_view_top <>", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopGreaterThan(Integer value) {
            addCriterion("part_view_top >", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("part_view_top >=", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopLessThan(Integer value) {
            addCriterion("part_view_top <", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopLessThanOrEqualTo(Integer value) {
            addCriterion("part_view_top <=", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIn(List<Integer> values) {
            addCriterion("part_view_top in", values, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotIn(List<Integer> values) {
            addCriterion("part_view_top not in", values, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopBetween(Integer value1, Integer value2) {
            addCriterion("part_view_top between", value1, value2, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotBetween(Integer value1, Integer value2) {
            addCriterion("part_view_top not between", value1, value2, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(BigDecimal value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(BigDecimal value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(BigDecimal value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(BigDecimal value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<BigDecimal> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<BigDecimal> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNull() {
            addCriterion("sales_status is null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNotNull() {
            addCriterion("sales_status is not null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusEqualTo(Integer value) {
            addCriterion("sales_status =", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotEqualTo(Integer value) {
            addCriterion("sales_status <>", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThan(Integer value) {
            addCriterion("sales_status >", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_status >=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThan(Integer value) {
            addCriterion("sales_status <", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sales_status <=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIn(List<Integer> values) {
            addCriterion("sales_status in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotIn(List<Integer> values) {
            addCriterion("sales_status not in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusBetween(Integer value1, Integer value2) {
            addCriterion("sales_status between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_status not between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIsNull() {
            addCriterion("box_sales is null");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIsNotNull() {
            addCriterion("box_sales is not null");
            return (Criteria) this;
        }

        public Criteria andBoxSalesEqualTo(Boolean value) {
            addCriterion("box_sales =", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotEqualTo(Boolean value) {
            addCriterion("box_sales <>", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesGreaterThan(Boolean value) {
            addCriterion("box_sales >", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("box_sales >=", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesLessThan(Boolean value) {
            addCriterion("box_sales <", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesLessThanOrEqualTo(Boolean value) {
            addCriterion("box_sales <=", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIn(List<Boolean> values) {
            addCriterion("box_sales in", values, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotIn(List<Boolean> values) {
            addCriterion("box_sales not in", values, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesBetween(Boolean value1, Boolean value2) {
            addCriterion("box_sales between", value1, value2, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("box_sales not between", value1, value2, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIsNull() {
            addCriterion("box_purchase is null");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIsNotNull() {
            addCriterion("box_purchase is not null");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseEqualTo(Boolean value) {
            addCriterion("box_purchase =", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotEqualTo(Boolean value) {
            addCriterion("box_purchase <>", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseGreaterThan(Boolean value) {
            addCriterion("box_purchase >", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("box_purchase >=", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseLessThan(Boolean value) {
            addCriterion("box_purchase <", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseLessThanOrEqualTo(Boolean value) {
            addCriterion("box_purchase <=", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIn(List<Boolean> values) {
            addCriterion("box_purchase in", values, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotIn(List<Boolean> values) {
            addCriterion("box_purchase not in", values, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseBetween(Boolean value1, Boolean value2) {
            addCriterion("box_purchase between", value1, value2, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("box_purchase not between", value1, value2, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIsNull() {
            addCriterion("lower_shelf is null");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIsNotNull() {
            addCriterion("lower_shelf is not null");
            return (Criteria) this;
        }

        public Criteria andLowerShelfEqualTo(Boolean value) {
            addCriterion("lower_shelf =", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotEqualTo(Boolean value) {
            addCriterion("lower_shelf <>", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfGreaterThan(Boolean value) {
            addCriterion("lower_shelf >", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("lower_shelf >=", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfLessThan(Boolean value) {
            addCriterion("lower_shelf <", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfLessThanOrEqualTo(Boolean value) {
            addCriterion("lower_shelf <=", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIn(List<Boolean> values) {
            addCriterion("lower_shelf in", values, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotIn(List<Boolean> values) {
            addCriterion("lower_shelf not in", values, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfBetween(Boolean value1, Boolean value2) {
            addCriterion("lower_shelf between", value1, value2, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("lower_shelf not between", value1, value2, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIsNull() {
            addCriterion("pur_front_day is null");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIsNotNull() {
            addCriterion("pur_front_day is not null");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayEqualTo(Integer value) {
            addCriterion("pur_front_day =", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotEqualTo(Integer value) {
            addCriterion("pur_front_day <>", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayGreaterThan(Integer value) {
            addCriterion("pur_front_day >", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pur_front_day >=", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayLessThan(Integer value) {
            addCriterion("pur_front_day <", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayLessThanOrEqualTo(Integer value) {
            addCriterion("pur_front_day <=", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIn(List<Integer> values) {
            addCriterion("pur_front_day in", values, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotIn(List<Integer> values) {
            addCriterion("pur_front_day not in", values, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayBetween(Integer value1, Integer value2) {
            addCriterion("pur_front_day between", value1, value2, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotBetween(Integer value1, Integer value2) {
            addCriterion("pur_front_day not between", value1, value2, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andForbidPurIsNull() {
            addCriterion("forbid_pur is null");
            return (Criteria) this;
        }

        public Criteria andForbidPurIsNotNull() {
            addCriterion("forbid_pur is not null");
            return (Criteria) this;
        }

        public Criteria andForbidPurEqualTo(Boolean value) {
            addCriterion("forbid_pur =", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotEqualTo(Boolean value) {
            addCriterion("forbid_pur <>", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurGreaterThan(Boolean value) {
            addCriterion("forbid_pur >", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurGreaterThanOrEqualTo(Boolean value) {
            addCriterion("forbid_pur >=", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurLessThan(Boolean value) {
            addCriterion("forbid_pur <", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurLessThanOrEqualTo(Boolean value) {
            addCriterion("forbid_pur <=", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurIn(List<Boolean> values) {
            addCriterion("forbid_pur in", values, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotIn(List<Boolean> values) {
            addCriterion("forbid_pur not in", values, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurBetween(Boolean value1, Boolean value2) {
            addCriterion("forbid_pur between", value1, value2, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotBetween(Boolean value1, Boolean value2) {
            addCriterion("forbid_pur not between", value1, value2, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(Integer value) {
            addCriterion("classify =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(Integer value) {
            addCriterion("classify <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(Integer value) {
            addCriterion("classify >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("classify >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(Integer value) {
            addCriterion("classify <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(Integer value) {
            addCriterion("classify <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<Integer> values) {
            addCriterion("classify in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<Integer> values) {
            addCriterion("classify not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(Integer value1, Integer value2) {
            addCriterion("classify between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(Integer value1, Integer value2) {
            addCriterion("classify not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andMarqueIsNull() {
            addCriterion("marque is null");
            return (Criteria) this;
        }

        public Criteria andMarqueIsNotNull() {
            addCriterion("marque is not null");
            return (Criteria) this;
        }

        public Criteria andMarqueEqualTo(String value) {
            addCriterion("marque =", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotEqualTo(String value) {
            addCriterion("marque <>", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueGreaterThan(String value) {
            addCriterion("marque >", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueGreaterThanOrEqualTo(String value) {
            addCriterion("marque >=", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLessThan(String value) {
            addCriterion("marque <", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLessThanOrEqualTo(String value) {
            addCriterion("marque <=", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLike(String value) {
            addCriterion("marque like", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotLike(String value) {
            addCriterion("marque not like", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueIn(List<String> values) {
            addCriterion("marque in", values, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotIn(List<String> values) {
            addCriterion("marque not in", values, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueBetween(String value1, String value2) {
            addCriterion("marque between", value1, value2, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotBetween(String value1, String value2) {
            addCriterion("marque not between", value1, value2, "marque");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIsNull() {
            addCriterion("forecast_count_mrp is null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIsNotNull() {
            addCriterion("forecast_count_mrp is not null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp =", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp <>", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpGreaterThan(Boolean value) {
            addCriterion("forecast_count_mrp >", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp >=", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpLessThan(Boolean value) {
            addCriterion("forecast_count_mrp <", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpLessThanOrEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp <=", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIn(List<Boolean> values) {
            addCriterion("forecast_count_mrp in", values, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotIn(List<Boolean> values) {
            addCriterion("forecast_count_mrp not in", values, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpBetween(Boolean value1, Boolean value2) {
            addCriterion("forecast_count_mrp between", value1, value2, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("forecast_count_mrp not between", value1, value2, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIsNull() {
            addCriterion("forecast_count_month is null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIsNotNull() {
            addCriterion("forecast_count_month is not null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthEqualTo(Integer value) {
            addCriterion("forecast_count_month =", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotEqualTo(Integer value) {
            addCriterion("forecast_count_month <>", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthGreaterThan(Integer value) {
            addCriterion("forecast_count_month >", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_count_month >=", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthLessThan(Integer value) {
            addCriterion("forecast_count_month <", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_count_month <=", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIn(List<Integer> values) {
            addCriterion("forecast_count_month in", values, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotIn(List<Integer> values) {
            addCriterion("forecast_count_month not in", values, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthBetween(Integer value1, Integer value2) {
            addCriterion("forecast_count_month between", value1, value2, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_count_month not between", value1, value2, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andSeNoIsNull() {
            addCriterion("se_no is null");
            return (Criteria) this;
        }

        public Criteria andSeNoIsNotNull() {
            addCriterion("se_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeNoEqualTo(String value) {
            addCriterion("se_no =", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotEqualTo(String value) {
            addCriterion("se_no <>", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoGreaterThan(String value) {
            addCriterion("se_no >", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoGreaterThanOrEqualTo(String value) {
            addCriterion("se_no >=", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLessThan(String value) {
            addCriterion("se_no <", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLessThanOrEqualTo(String value) {
            addCriterion("se_no <=", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLike(String value) {
            addCriterion("se_no like", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotLike(String value) {
            addCriterion("se_no not like", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoIn(List<String> values) {
            addCriterion("se_no in", values, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotIn(List<String> values) {
            addCriterion("se_no not in", values, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoBetween(String value1, String value2) {
            addCriterion("se_no between", value1, value2, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotBetween(String value1, String value2) {
            addCriterion("se_no not between", value1, value2, "seNo");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNull() {
            addCriterion("is_sync is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNotNull() {
            addCriterion("is_sync is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncEqualTo(Boolean value) {
            addCriterion("is_sync =", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotEqualTo(Boolean value) {
            addCriterion("is_sync <>", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThan(Boolean value) {
            addCriterion("is_sync >", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_sync >=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThan(Boolean value) {
            addCriterion("is_sync <", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThanOrEqualTo(Boolean value) {
            addCriterion("is_sync <=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncIn(List<Boolean> values) {
            addCriterion("is_sync in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotIn(List<Boolean> values) {
            addCriterion("is_sync not in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sync between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sync not between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIsNull() {
            addCriterion("bom_property is null");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIsNotNull() {
            addCriterion("bom_property is not null");
            return (Criteria) this;
        }

        public Criteria andBomPropertyEqualTo(Boolean value) {
            addCriterion("bom_property =", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotEqualTo(Boolean value) {
            addCriterion("bom_property <>", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyGreaterThan(Boolean value) {
            addCriterion("bom_property >", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bom_property >=", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyLessThan(Boolean value) {
            addCriterion("bom_property <", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyLessThanOrEqualTo(Boolean value) {
            addCriterion("bom_property <=", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIn(List<Boolean> values) {
            addCriterion("bom_property in", values, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotIn(List<Boolean> values) {
            addCriterion("bom_property not in", values, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyBetween(Boolean value1, Boolean value2) {
            addCriterion("bom_property between", value1, value2, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bom_property not between", value1, value2, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNull() {
            addCriterion("cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNotNull() {
            addCriterion("cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCostAmountEqualTo(BigDecimal value) {
            addCriterion("cost_amount =", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_amount <>", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_amount >", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_amount >=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThan(BigDecimal value) {
            addCriterion("cost_amount <", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_amount <=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountIn(List<BigDecimal> values) {
            addCriterion("cost_amount in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_amount not in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_amount between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_amount not between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIsNull() {
            addCriterion("delivery_cycle is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIsNotNull() {
            addCriterion("delivery_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleEqualTo(Integer value) {
            addCriterion("delivery_cycle =", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotEqualTo(Integer value) {
            addCriterion("delivery_cycle <>", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleGreaterThan(Integer value) {
            addCriterion("delivery_cycle >", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_cycle >=", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleLessThan(Integer value) {
            addCriterion("delivery_cycle <", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_cycle <=", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIn(List<Integer> values) {
            addCriterion("delivery_cycle in", values, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotIn(List<Integer> values) {
            addCriterion("delivery_cycle not in", values, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleBetween(Integer value1, Integer value2) {
            addCriterion("delivery_cycle between", value1, value2, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_cycle not between", value1, value2, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIsNull() {
            addCriterion("virtual_stock is null");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIsNotNull() {
            addCriterion("virtual_stock is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualStockEqualTo(BigDecimal value) {
            addCriterion("virtual_stock =", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotEqualTo(BigDecimal value) {
            addCriterion("virtual_stock <>", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockGreaterThan(BigDecimal value) {
            addCriterion("virtual_stock >", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("virtual_stock >=", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockLessThan(BigDecimal value) {
            addCriterion("virtual_stock <", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("virtual_stock <=", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIn(List<BigDecimal> values) {
            addCriterion("virtual_stock in", values, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotIn(List<BigDecimal> values) {
            addCriterion("virtual_stock not in", values, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("virtual_stock between", value1, value2, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("virtual_stock not between", value1, value2, "virtualStock");
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