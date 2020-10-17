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

        public Criteria andUidIsNull() {
            addCriterion("uid_ is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid_ is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid_ =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid_ <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid_ >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid_ >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid_ <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid_ <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid_ in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid_ not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid_ between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid_ not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCorpNoIsNull() {
            addCriterion("corp_no_ is null");
            return (Criteria) this;
        }

        public Criteria andCorpNoIsNotNull() {
            addCriterion("corp_no_ is not null");
            return (Criteria) this;
        }

        public Criteria andCorpNoEqualTo(String value) {
            addCriterion("corp_no_ =", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoNotEqualTo(String value) {
            addCriterion("corp_no_ <>", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoGreaterThan(String value) {
            addCriterion("corp_no_ >", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoGreaterThanOrEqualTo(String value) {
            addCriterion("corp_no_ >=", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoLessThan(String value) {
            addCriterion("corp_no_ <", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoLessThanOrEqualTo(String value) {
            addCriterion("corp_no_ <=", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoLike(String value) {
            addCriterion("corp_no_ like", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoNotLike(String value) {
            addCriterion("corp_no_ not like", value, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoIn(List<String> values) {
            addCriterion("corp_no_ in", values, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoNotIn(List<String> values) {
            addCriterion("corp_no_ not in", values, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoBetween(String value1, String value2) {
            addCriterion("corp_no_ between", value1, value2, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCorpNoNotBetween(String value1, String value2) {
            addCriterion("corp_no_ not between", value1, value2, "corpNo");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code_ is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code_ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code_ =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code_ <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code_ >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code_ >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code_ <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code_ <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code_ like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code_ not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code_ in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code_ not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code_ between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code_ not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andOldCodeIsNull() {
            addCriterion("old_code_ is null");
            return (Criteria) this;
        }

        public Criteria andOldCodeIsNotNull() {
            addCriterion("old_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andOldCodeEqualTo(String value) {
            addCriterion("old_code_ =", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeNotEqualTo(String value) {
            addCriterion("old_code_ <>", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeGreaterThan(String value) {
            addCriterion("old_code_ >", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("old_code_ >=", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeLessThan(String value) {
            addCriterion("old_code_ <", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeLessThanOrEqualTo(String value) {
            addCriterion("old_code_ <=", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeLike(String value) {
            addCriterion("old_code_ like", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeNotLike(String value) {
            addCriterion("old_code_ not like", value, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeIn(List<String> values) {
            addCriterion("old_code_ in", values, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeNotIn(List<String> values) {
            addCriterion("old_code_ not in", values, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeBetween(String value1, String value2) {
            addCriterion("old_code_ between", value1, value2, "oldCode");
            return (Criteria) this;
        }

        public Criteria andOldCodeNotBetween(String value1, String value2) {
            addCriterion("old_code_ not between", value1, value2, "oldCode");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand_ is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand_ is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand_ =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand_ <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand_ >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand_ >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand_ <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand_ <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand_ like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand_ not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand_ in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand_ not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand_ between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand_ not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andClass1IsNull() {
            addCriterion("class1_ is null");
            return (Criteria) this;
        }

        public Criteria andClass1IsNotNull() {
            addCriterion("class1_ is not null");
            return (Criteria) this;
        }

        public Criteria andClass1EqualTo(String value) {
            addCriterion("class1_ =", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotEqualTo(String value) {
            addCriterion("class1_ <>", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1GreaterThan(String value) {
            addCriterion("class1_ >", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1GreaterThanOrEqualTo(String value) {
            addCriterion("class1_ >=", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1LessThan(String value) {
            addCriterion("class1_ <", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1LessThanOrEqualTo(String value) {
            addCriterion("class1_ <=", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1Like(String value) {
            addCriterion("class1_ like", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotLike(String value) {
            addCriterion("class1_ not like", value, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1In(List<String> values) {
            addCriterion("class1_ in", values, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotIn(List<String> values) {
            addCriterion("class1_ not in", values, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1Between(String value1, String value2) {
            addCriterion("class1_ between", value1, value2, "class1");
            return (Criteria) this;
        }

        public Criteria andClass1NotBetween(String value1, String value2) {
            addCriterion("class1_ not between", value1, value2, "class1");
            return (Criteria) this;
        }

        public Criteria andClass2IsNull() {
            addCriterion("class2_ is null");
            return (Criteria) this;
        }

        public Criteria andClass2IsNotNull() {
            addCriterion("class2_ is not null");
            return (Criteria) this;
        }

        public Criteria andClass2EqualTo(String value) {
            addCriterion("class2_ =", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotEqualTo(String value) {
            addCriterion("class2_ <>", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2GreaterThan(String value) {
            addCriterion("class2_ >", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2GreaterThanOrEqualTo(String value) {
            addCriterion("class2_ >=", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2LessThan(String value) {
            addCriterion("class2_ <", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2LessThanOrEqualTo(String value) {
            addCriterion("class2_ <=", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2Like(String value) {
            addCriterion("class2_ like", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotLike(String value) {
            addCriterion("class2_ not like", value, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2In(List<String> values) {
            addCriterion("class2_ in", values, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotIn(List<String> values) {
            addCriterion("class2_ not in", values, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2Between(String value1, String value2) {
            addCriterion("class2_ between", value1, value2, "class2");
            return (Criteria) this;
        }

        public Criteria andClass2NotBetween(String value1, String value2) {
            addCriterion("class2_ not between", value1, value2, "class2");
            return (Criteria) this;
        }

        public Criteria andClass3IsNull() {
            addCriterion("class3_ is null");
            return (Criteria) this;
        }

        public Criteria andClass3IsNotNull() {
            addCriterion("class3_ is not null");
            return (Criteria) this;
        }

        public Criteria andClass3EqualTo(String value) {
            addCriterion("class3_ =", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotEqualTo(String value) {
            addCriterion("class3_ <>", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3GreaterThan(String value) {
            addCriterion("class3_ >", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3GreaterThanOrEqualTo(String value) {
            addCriterion("class3_ >=", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3LessThan(String value) {
            addCriterion("class3_ <", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3LessThanOrEqualTo(String value) {
            addCriterion("class3_ <=", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3Like(String value) {
            addCriterion("class3_ like", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotLike(String value) {
            addCriterion("class3_ not like", value, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3In(List<String> values) {
            addCriterion("class3_ in", values, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotIn(List<String> values) {
            addCriterion("class3_ not in", values, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3Between(String value1, String value2) {
            addCriterion("class3_ between", value1, value2, "class3");
            return (Criteria) this;
        }

        public Criteria andClass3NotBetween(String value1, String value2) {
            addCriterion("class3_ not between", value1, value2, "class3");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc_ is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc_ is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc_ =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc_ <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc_ >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc_ >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc_ <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc_ <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc_ like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc_ not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc_ in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc_ not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc_ between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc_ not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNull() {
            addCriterion("part_type_ is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNotNull() {
            addCriterion("part_type_ is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeEqualTo(String value) {
            addCriterion("part_type_ =", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotEqualTo(String value) {
            addCriterion("part_type_ <>", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThan(String value) {
            addCriterion("part_type_ >", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThanOrEqualTo(String value) {
            addCriterion("part_type_ >=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThan(String value) {
            addCriterion("part_type_ <", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThanOrEqualTo(String value) {
            addCriterion("part_type_ <=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLike(String value) {
            addCriterion("part_type_ like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotLike(String value) {
            addCriterion("part_type_ not like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeIn(List<String> values) {
            addCriterion("part_type_ in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotIn(List<String> values) {
            addCriterion("part_type_ not in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeBetween(String value1, String value2) {
            addCriterion("part_type_ between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotBetween(String value1, String value2) {
            addCriterion("part_type_ not between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPyCodeIsNull() {
            addCriterion("py_code_ is null");
            return (Criteria) this;
        }

        public Criteria andPyCodeIsNotNull() {
            addCriterion("py_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andPyCodeEqualTo(String value) {
            addCriterion("py_code_ =", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeNotEqualTo(String value) {
            addCriterion("py_code_ <>", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeGreaterThan(String value) {
            addCriterion("py_code_ >", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("py_code_ >=", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeLessThan(String value) {
            addCriterion("py_code_ <", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeLessThanOrEqualTo(String value) {
            addCriterion("py_code_ <=", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeLike(String value) {
            addCriterion("py_code_ like", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeNotLike(String value) {
            addCriterion("py_code_ not like", value, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeIn(List<String> values) {
            addCriterion("py_code_ in", values, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeNotIn(List<String> values) {
            addCriterion("py_code_ not in", values, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeBetween(String value1, String value2) {
            addCriterion("py_code_ between", value1, value2, "pyCode");
            return (Criteria) this;
        }

        public Criteria andPyCodeNotBetween(String value1, String value2) {
            addCriterion("py_code_ not between", value1, value2, "pyCode");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec_ is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec_ is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec_ =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec_ <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec_ >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec_ >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec_ <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec_ <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec_ like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec_ not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec_ in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec_ not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec_ between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec_ not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit_ is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit_ is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit_ =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit_ <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit_ >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit_ >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit_ <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit_ <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit_ like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit_ not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit_ in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit_ not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit_ between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit_ not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCwCodeIsNull() {
            addCriterion("cw_code_ is null");
            return (Criteria) this;
        }

        public Criteria andCwCodeIsNotNull() {
            addCriterion("cw_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andCwCodeEqualTo(String value) {
            addCriterion("cw_code_ =", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeNotEqualTo(String value) {
            addCriterion("cw_code_ <>", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeGreaterThan(String value) {
            addCriterion("cw_code_ >", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cw_code_ >=", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeLessThan(String value) {
            addCriterion("cw_code_ <", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeLessThanOrEqualTo(String value) {
            addCriterion("cw_code_ <=", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeLike(String value) {
            addCriterion("cw_code_ like", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeNotLike(String value) {
            addCriterion("cw_code_ not like", value, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeIn(List<String> values) {
            addCriterion("cw_code_ in", values, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeNotIn(List<String> values) {
            addCriterion("cw_code_ not in", values, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeBetween(String value1, String value2) {
            addCriterion("cw_code_ between", value1, value2, "cwCode");
            return (Criteria) this;
        }

        public Criteria andCwCodeNotBetween(String value1, String value2) {
            addCriterion("cw_code_ not between", value1, value2, "cwCode");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIsNull() {
            addCriterion("default_cw_ is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIsNotNull() {
            addCriterion("default_cw_ is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCwEqualTo(String value) {
            addCriterion("default_cw_ =", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotEqualTo(String value) {
            addCriterion("default_cw_ <>", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwGreaterThan(String value) {
            addCriterion("default_cw_ >", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwGreaterThanOrEqualTo(String value) {
            addCriterion("default_cw_ >=", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLessThan(String value) {
            addCriterion("default_cw_ <", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLessThanOrEqualTo(String value) {
            addCriterion("default_cw_ <=", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwLike(String value) {
            addCriterion("default_cw_ like", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotLike(String value) {
            addCriterion("default_cw_ not like", value, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwIn(List<String> values) {
            addCriterion("default_cw_ in", values, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotIn(List<String> values) {
            addCriterion("default_cw_ not in", values, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwBetween(String value1, String value2) {
            addCriterion("default_cw_ between", value1, value2, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andDefaultCwNotBetween(String value1, String value2) {
            addCriterion("default_cw_ not between", value1, value2, "defaultCw");
            return (Criteria) this;
        }

        public Criteria andInUpIsNull() {
            addCriterion("in_up_ is null");
            return (Criteria) this;
        }

        public Criteria andInUpIsNotNull() {
            addCriterion("in_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andInUpEqualTo(BigDecimal value) {
            addCriterion("in_up_ =", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotEqualTo(BigDecimal value) {
            addCriterion("in_up_ <>", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpGreaterThan(BigDecimal value) {
            addCriterion("in_up_ >", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_up_ >=", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpLessThan(BigDecimal value) {
            addCriterion("in_up_ <", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_up_ <=", value, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpIn(List<BigDecimal> values) {
            addCriterion("in_up_ in", values, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotIn(List<BigDecimal> values) {
            addCriterion("in_up_ not in", values, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_up_ between", value1, value2, "inUp");
            return (Criteria) this;
        }

        public Criteria andInUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_up_ not between", value1, value2, "inUp");
            return (Criteria) this;
        }

        public Criteria andOutUpIsNull() {
            addCriterion("out_up_ is null");
            return (Criteria) this;
        }

        public Criteria andOutUpIsNotNull() {
            addCriterion("out_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andOutUpEqualTo(BigDecimal value) {
            addCriterion("out_up_ =", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotEqualTo(BigDecimal value) {
            addCriterion("out_up_ <>", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpGreaterThan(BigDecimal value) {
            addCriterion("out_up_ >", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up_ >=", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpLessThan(BigDecimal value) {
            addCriterion("out_up_ <", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up_ <=", value, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpIn(List<BigDecimal> values) {
            addCriterion("out_up_ in", values, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotIn(List<BigDecimal> values) {
            addCriterion("out_up_ not in", values, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up_ between", value1, value2, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up_ not between", value1, value2, "outUp");
            return (Criteria) this;
        }

        public Criteria andOutUp2IsNull() {
            addCriterion("out_up2_ is null");
            return (Criteria) this;
        }

        public Criteria andOutUp2IsNotNull() {
            addCriterion("out_up2_ is not null");
            return (Criteria) this;
        }

        public Criteria andOutUp2EqualTo(BigDecimal value) {
            addCriterion("out_up2_ =", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotEqualTo(BigDecimal value) {
            addCriterion("out_up2_ <>", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2GreaterThan(BigDecimal value) {
            addCriterion("out_up2_ >", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up2_ >=", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2LessThan(BigDecimal value) {
            addCriterion("out_up2_ <", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("out_up2_ <=", value, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2In(List<BigDecimal> values) {
            addCriterion("out_up2_ in", values, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotIn(List<BigDecimal> values) {
            addCriterion("out_up2_ not in", values, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up2_ between", value1, value2, "outUp2");
            return (Criteria) this;
        }

        public Criteria andOutUp2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("out_up2_ not between", value1, value2, "outUp2");
            return (Criteria) this;
        }

        public Criteria andListUpIsNull() {
            addCriterion("list_up_ is null");
            return (Criteria) this;
        }

        public Criteria andListUpIsNotNull() {
            addCriterion("list_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andListUpEqualTo(BigDecimal value) {
            addCriterion("list_up_ =", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotEqualTo(BigDecimal value) {
            addCriterion("list_up_ <>", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpGreaterThan(BigDecimal value) {
            addCriterion("list_up_ >", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("list_up_ >=", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpLessThan(BigDecimal value) {
            addCriterion("list_up_ <", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("list_up_ <=", value, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpIn(List<BigDecimal> values) {
            addCriterion("list_up_ in", values, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotIn(List<BigDecimal> values) {
            addCriterion("list_up_ not in", values, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("list_up_ between", value1, value2, "listUp");
            return (Criteria) this;
        }

        public Criteria andListUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("list_up_ not between", value1, value2, "listUp");
            return (Criteria) this;
        }

        public Criteria andCostUpIsNull() {
            addCriterion("cost_up_ is null");
            return (Criteria) this;
        }

        public Criteria andCostUpIsNotNull() {
            addCriterion("cost_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andCostUpEqualTo(BigDecimal value) {
            addCriterion("cost_up_ =", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotEqualTo(BigDecimal value) {
            addCriterion("cost_up_ <>", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpGreaterThan(BigDecimal value) {
            addCriterion("cost_up_ >", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_up_ >=", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpLessThan(BigDecimal value) {
            addCriterion("cost_up_ <", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_up_ <=", value, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpIn(List<BigDecimal> values) {
            addCriterion("cost_up_ in", values, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotIn(List<BigDecimal> values) {
            addCriterion("cost_up_ not in", values, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_up_ between", value1, value2, "costUp");
            return (Criteria) this;
        }

        public Criteria andCostUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_up_ not between", value1, value2, "costUp");
            return (Criteria) this;
        }

        public Criteria andVipUpIsNull() {
            addCriterion("vip_up_ is null");
            return (Criteria) this;
        }

        public Criteria andVipUpIsNotNull() {
            addCriterion("vip_up_ is not null");
            return (Criteria) this;
        }

        public Criteria andVipUpEqualTo(BigDecimal value) {
            addCriterion("vip_up_ =", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotEqualTo(BigDecimal value) {
            addCriterion("vip_up_ <>", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpGreaterThan(BigDecimal value) {
            addCriterion("vip_up_ >", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_up_ >=", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpLessThan(BigDecimal value) {
            addCriterion("vip_up_ <", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_up_ <=", value, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpIn(List<BigDecimal> values) {
            addCriterion("vip_up_ in", values, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotIn(List<BigDecimal> values) {
            addCriterion("vip_up_ not in", values, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_up_ between", value1, value2, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_up_ not between", value1, value2, "vipUp");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIsNull() {
            addCriterion("vip_discount_ is null");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIsNotNull() {
            addCriterion("vip_discount_ is not null");
            return (Criteria) this;
        }

        public Criteria andVipDiscountEqualTo(BigDecimal value) {
            addCriterion("vip_discount_ =", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotEqualTo(BigDecimal value) {
            addCriterion("vip_discount_ <>", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountGreaterThan(BigDecimal value) {
            addCriterion("vip_discount_ >", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_discount_ >=", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountLessThan(BigDecimal value) {
            addCriterion("vip_discount_ <", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_discount_ <=", value, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountIn(List<BigDecimal> values) {
            addCriterion("vip_discount_ in", values, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotIn(List<BigDecimal> values) {
            addCriterion("vip_discount_ not in", values, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_discount_ between", value1, value2, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andVipDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_discount_ not between", value1, value2, "vipDiscount");
            return (Criteria) this;
        }

        public Criteria andUpControlIsNull() {
            addCriterion("up_control_ is null");
            return (Criteria) this;
        }

        public Criteria andUpControlIsNotNull() {
            addCriterion("up_control_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpControlEqualTo(Integer value) {
            addCriterion("up_control_ =", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotEqualTo(Integer value) {
            addCriterion("up_control_ <>", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlGreaterThan(Integer value) {
            addCriterion("up_control_ >", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlGreaterThanOrEqualTo(Integer value) {
            addCriterion("up_control_ >=", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlLessThan(Integer value) {
            addCriterion("up_control_ <", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlLessThanOrEqualTo(Integer value) {
            addCriterion("up_control_ <=", value, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlIn(List<Integer> values) {
            addCriterion("up_control_ in", values, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotIn(List<Integer> values) {
            addCriterion("up_control_ not in", values, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlBetween(Integer value1, Integer value2) {
            addCriterion("up_control_ between", value1, value2, "upControl");
            return (Criteria) this;
        }

        public Criteria andUpControlNotBetween(Integer value1, Integer value2) {
            addCriterion("up_control_ not between", value1, value2, "upControl");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used_ is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used_ is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Integer value) {
            addCriterion("used_ =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Integer value) {
            addCriterion("used_ <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Integer value) {
            addCriterion("used_ >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("used_ >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Integer value) {
            addCriterion("used_ <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Integer value) {
            addCriterion("used_ <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Integer> values) {
            addCriterion("used_ in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Integer> values) {
            addCriterion("used_ not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Integer value1, Integer value2) {
            addCriterion("used_ between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("used_ not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("obj_type_ is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("obj_type_ is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(String value) {
            addCriterion("obj_type_ =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(String value) {
            addCriterion("obj_type_ <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(String value) {
            addCriterion("obj_type_ >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("obj_type_ >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(String value) {
            addCriterion("obj_type_ <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(String value) {
            addCriterion("obj_type_ <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLike(String value) {
            addCriterion("obj_type_ like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotLike(String value) {
            addCriterion("obj_type_ not like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<String> values) {
            addCriterion("obj_type_ in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<String> values) {
            addCriterion("obj_type_ not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(String value1, String value2) {
            addCriterion("obj_type_ between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(String value1, String value2) {
            addCriterion("obj_type_ not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNull() {
            addCriterion("share_rate_ is null");
            return (Criteria) this;
        }

        public Criteria andShareRateIsNotNull() {
            addCriterion("share_rate_ is not null");
            return (Criteria) this;
        }

        public Criteria andShareRateEqualTo(BigDecimal value) {
            addCriterion("share_rate_ =", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotEqualTo(BigDecimal value) {
            addCriterion("share_rate_ <>", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThan(BigDecimal value) {
            addCriterion("share_rate_ >", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate_ >=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThan(BigDecimal value) {
            addCriterion("share_rate_ <", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_rate_ <=", value, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateIn(List<BigDecimal> values) {
            addCriterion("share_rate_ in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotIn(List<BigDecimal> values) {
            addCriterion("share_rate_ not in", values, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate_ between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andShareRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_rate_ not between", value1, value2, "shareRate");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNull() {
            addCriterion("id_code_ is null");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNotNull() {
            addCriterion("id_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdCodeEqualTo(String value) {
            addCriterion("id_code_ =", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotEqualTo(String value) {
            addCriterion("id_code_ <>", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThan(String value) {
            addCriterion("id_code_ >", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("id_code_ >=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThan(String value) {
            addCriterion("id_code_ <", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThanOrEqualTo(String value) {
            addCriterion("id_code_ <=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLike(String value) {
            addCriterion("id_code_ like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotLike(String value) {
            addCriterion("id_code_ not like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeIn(List<String> values) {
            addCriterion("id_code_ in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotIn(List<String> values) {
            addCriterion("id_code_ not in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeBetween(String value1, String value2) {
            addCriterion("id_code_ between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotBetween(String value1, String value2) {
            addCriterion("id_code_ not between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeIsNull() {
            addCriterion("box_code_ is null");
            return (Criteria) this;
        }

        public Criteria andBoxCodeIsNotNull() {
            addCriterion("box_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andBoxCodeEqualTo(String value) {
            addCriterion("box_code_ =", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotEqualTo(String value) {
            addCriterion("box_code_ <>", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeGreaterThan(String value) {
            addCriterion("box_code_ >", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("box_code_ >=", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLessThan(String value) {
            addCriterion("box_code_ <", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLessThanOrEqualTo(String value) {
            addCriterion("box_code_ <=", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLike(String value) {
            addCriterion("box_code_ like", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotLike(String value) {
            addCriterion("box_code_ not like", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeIn(List<String> values) {
            addCriterion("box_code_ in", values, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotIn(List<String> values) {
            addCriterion("box_code_ not in", values, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeBetween(String value1, String value2) {
            addCriterion("box_code_ between", value1, value2, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotBetween(String value1, String value2) {
            addCriterion("box_code_ not between", value1, value2, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIsNull() {
            addCriterion("box_unit_ is null");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIsNotNull() {
            addCriterion("box_unit_ is not null");
            return (Criteria) this;
        }

        public Criteria andBoxUnitEqualTo(String value) {
            addCriterion("box_unit_ =", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotEqualTo(String value) {
            addCriterion("box_unit_ <>", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitGreaterThan(String value) {
            addCriterion("box_unit_ >", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitGreaterThanOrEqualTo(String value) {
            addCriterion("box_unit_ >=", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLessThan(String value) {
            addCriterion("box_unit_ <", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLessThanOrEqualTo(String value) {
            addCriterion("box_unit_ <=", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitLike(String value) {
            addCriterion("box_unit_ like", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotLike(String value) {
            addCriterion("box_unit_ not like", value, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitIn(List<String> values) {
            addCriterion("box_unit_ in", values, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotIn(List<String> values) {
            addCriterion("box_unit_ not in", values, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitBetween(String value1, String value2) {
            addCriterion("box_unit_ between", value1, value2, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxUnitNotBetween(String value1, String value2) {
            addCriterion("box_unit_ not between", value1, value2, "boxUnit");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNull() {
            addCriterion("box_num_ is null");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNotNull() {
            addCriterion("box_num_ is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNumEqualTo(BigDecimal value) {
            addCriterion("box_num_ =", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotEqualTo(BigDecimal value) {
            addCriterion("box_num_ <>", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThan(BigDecimal value) {
            addCriterion("box_num_ >", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("box_num_ >=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThan(BigDecimal value) {
            addCriterion("box_num_ <", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("box_num_ <=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumIn(List<BigDecimal> values) {
            addCriterion("box_num_ in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotIn(List<BigDecimal> values) {
            addCriterion("box_num_ not in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_num_ between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_num_ not between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode_ is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode_ is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode_ =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode_ <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode_ >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode_ >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode_ <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode_ <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode_ like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode_ not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode_ in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode_ not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode_ between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode_ not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeIsNull() {
            addCriterion("old_barcode_ is null");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeIsNotNull() {
            addCriterion("old_barcode_ is not null");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeEqualTo(String value) {
            addCriterion("old_barcode_ =", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeNotEqualTo(String value) {
            addCriterion("old_barcode_ <>", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeGreaterThan(String value) {
            addCriterion("old_barcode_ >", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("old_barcode_ >=", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeLessThan(String value) {
            addCriterion("old_barcode_ <", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeLessThanOrEqualTo(String value) {
            addCriterion("old_barcode_ <=", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeLike(String value) {
            addCriterion("old_barcode_ like", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeNotLike(String value) {
            addCriterion("old_barcode_ not like", value, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeIn(List<String> values) {
            addCriterion("old_barcode_ in", values, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeNotIn(List<String> values) {
            addCriterion("old_barcode_ not in", values, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeBetween(String value1, String value2) {
            addCriterion("old_barcode_ between", value1, value2, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andOldBarcodeNotBetween(String value1, String value2) {
            addCriterion("old_barcode_ not between", value1, value2, "oldBarcode");
            return (Criteria) this;
        }

        public Criteria andPushMonthIsNull() {
            addCriterion("push_month_ is null");
            return (Criteria) this;
        }

        public Criteria andPushMonthIsNotNull() {
            addCriterion("push_month_ is not null");
            return (Criteria) this;
        }

        public Criteria andPushMonthEqualTo(Integer value) {
            addCriterion("push_month_ =", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotEqualTo(Integer value) {
            addCriterion("push_month_ <>", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthGreaterThan(Integer value) {
            addCriterion("push_month_ >", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("push_month_ >=", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthLessThan(Integer value) {
            addCriterion("push_month_ <", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthLessThanOrEqualTo(Integer value) {
            addCriterion("push_month_ <=", value, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthIn(List<Integer> values) {
            addCriterion("push_month_ in", values, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotIn(List<Integer> values) {
            addCriterion("push_month_ not in", values, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthBetween(Integer value1, Integer value2) {
            addCriterion("push_month_ between", value1, value2, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andPushMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("push_month_ not between", value1, value2, "pushMonth");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIsNull() {
            addCriterion("readme_url_ is null");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIsNotNull() {
            addCriterion("readme_url_ is not null");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlEqualTo(String value) {
            addCriterion("readme_url_ =", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotEqualTo(String value) {
            addCriterion("readme_url_ <>", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlGreaterThan(String value) {
            addCriterion("readme_url_ >", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("readme_url_ >=", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLessThan(String value) {
            addCriterion("readme_url_ <", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLessThanOrEqualTo(String value) {
            addCriterion("readme_url_ <=", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlLike(String value) {
            addCriterion("readme_url_ like", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotLike(String value) {
            addCriterion("readme_url_ not like", value, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlIn(List<String> values) {
            addCriterion("readme_url_ in", values, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotIn(List<String> values) {
            addCriterion("readme_url_ not in", values, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlBetween(String value1, String value2) {
            addCriterion("readme_url_ between", value1, value2, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andReadmeUrlNotBetween(String value1, String value2) {
            addCriterion("readme_url_ not between", value1, value2, "readmeUrl");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark_ is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark_ is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark_ =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark_ <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark_ >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark_ >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark_ <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark_ <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark_ like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark_ not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark_ in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark_ not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark_ between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark_ not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSupCodeIsNull() {
            addCriterion("sup_code_ is null");
            return (Criteria) this;
        }

        public Criteria andSupCodeIsNotNull() {
            addCriterion("sup_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andSupCodeEqualTo(String value) {
            addCriterion("sup_code_ =", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotEqualTo(String value) {
            addCriterion("sup_code_ <>", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeGreaterThan(String value) {
            addCriterion("sup_code_ >", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sup_code_ >=", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLessThan(String value) {
            addCriterion("sup_code_ <", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLessThanOrEqualTo(String value) {
            addCriterion("sup_code_ <=", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeLike(String value) {
            addCriterion("sup_code_ like", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotLike(String value) {
            addCriterion("sup_code_ not like", value, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeIn(List<String> values) {
            addCriterion("sup_code_ in", values, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotIn(List<String> values) {
            addCriterion("sup_code_ not in", values, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeBetween(String value1, String value2) {
            addCriterion("sup_code_ between", value1, value2, "supCode");
            return (Criteria) this;
        }

        public Criteria andSupCodeNotBetween(String value1, String value2) {
            addCriterion("sup_code_ not between", value1, value2, "supCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNull() {
            addCriterion("file_num_ is null");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNotNull() {
            addCriterion("file_num_ is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumEqualTo(Integer value) {
            addCriterion("file_num_ =", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotEqualTo(Integer value) {
            addCriterion("file_num_ <>", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThan(Integer value) {
            addCriterion("file_num_ >", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_num_ >=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThan(Integer value) {
            addCriterion("file_num_ <", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThanOrEqualTo(Integer value) {
            addCriterion("file_num_ <=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumIn(List<Integer> values) {
            addCriterion("file_num_ in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotIn(List<Integer> values) {
            addCriterion("file_num_ not in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumBetween(Integer value1, Integer value2) {
            addCriterion("file_num_ between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotBetween(Integer value1, Integer value2) {
            addCriterion("file_num_ not between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeIsNull() {
            addCriterion("last_sup_code_ is null");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeIsNotNull() {
            addCriterion("last_sup_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeEqualTo(String value) {
            addCriterion("last_sup_code_ =", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeNotEqualTo(String value) {
            addCriterion("last_sup_code_ <>", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeGreaterThan(String value) {
            addCriterion("last_sup_code_ >", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("last_sup_code_ >=", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeLessThan(String value) {
            addCriterion("last_sup_code_ <", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeLessThanOrEqualTo(String value) {
            addCriterion("last_sup_code_ <=", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeLike(String value) {
            addCriterion("last_sup_code_ like", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeNotLike(String value) {
            addCriterion("last_sup_code_ not like", value, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeIn(List<String> values) {
            addCriterion("last_sup_code_ in", values, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeNotIn(List<String> values) {
            addCriterion("last_sup_code_ not in", values, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeBetween(String value1, String value2) {
            addCriterion("last_sup_code_ between", value1, value2, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andLastSupCodeNotBetween(String value1, String value2) {
            addCriterion("last_sup_code_ not between", value1, value2, "lastSupCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user_ =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user_ <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user_ >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_ >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user_ <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user_ <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user_ like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user_ not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user_ in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user_ not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user_ between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user_ not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date_ =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date_ <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date_ >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date_ >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date_ <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date_ <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date_ in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date_ not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date_ between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date_ not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andAppUserIsNull() {
            addCriterion("app_user_ is null");
            return (Criteria) this;
        }

        public Criteria andAppUserIsNotNull() {
            addCriterion("app_user_ is not null");
            return (Criteria) this;
        }

        public Criteria andAppUserEqualTo(String value) {
            addCriterion("app_user_ =", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotEqualTo(String value) {
            addCriterion("app_user_ <>", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserGreaterThan(String value) {
            addCriterion("app_user_ >", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserGreaterThanOrEqualTo(String value) {
            addCriterion("app_user_ >=", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLessThan(String value) {
            addCriterion("app_user_ <", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLessThanOrEqualTo(String value) {
            addCriterion("app_user_ <=", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLike(String value) {
            addCriterion("app_user_ like", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotLike(String value) {
            addCriterion("app_user_ not like", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserIn(List<String> values) {
            addCriterion("app_user_ in", values, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotIn(List<String> values) {
            addCriterion("app_user_ not in", values, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserBetween(String value1, String value2) {
            addCriterion("app_user_ between", value1, value2, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotBetween(String value1, String value2) {
            addCriterion("app_user_ not between", value1, value2, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNull() {
            addCriterion("app_date_ is null");
            return (Criteria) this;
        }

        public Criteria andAppDateIsNotNull() {
            addCriterion("app_date_ is not null");
            return (Criteria) this;
        }

        public Criteria andAppDateEqualTo(Date value) {
            addCriterion("app_date_ =", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotEqualTo(Date value) {
            addCriterion("app_date_ <>", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThan(Date value) {
            addCriterion("app_date_ >", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateGreaterThanOrEqualTo(Date value) {
            addCriterion("app_date_ >=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThan(Date value) {
            addCriterion("app_date_ <", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateLessThanOrEqualTo(Date value) {
            addCriterion("app_date_ <=", value, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateIn(List<Date> values) {
            addCriterion("app_date_ in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotIn(List<Date> values) {
            addCriterion("app_date_ not in", values, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateBetween(Date value1, Date value2) {
            addCriterion("app_date_ between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andAppDateNotBetween(Date value1, Date value2) {
            addCriterion("app_date_ not between", value1, value2, "appDate");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyIsNull() {
            addCriterion("update_key_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyIsNotNull() {
            addCriterion("update_key_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyEqualTo(String value) {
            addCriterion("update_key_ =", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotEqualTo(String value) {
            addCriterion("update_key_ <>", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyGreaterThan(String value) {
            addCriterion("update_key_ >", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("update_key_ >=", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLessThan(String value) {
            addCriterion("update_key_ <", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLessThanOrEqualTo(String value) {
            addCriterion("update_key_ <=", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyLike(String value) {
            addCriterion("update_key_ like", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotLike(String value) {
            addCriterion("update_key_ not like", value, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyIn(List<String> values) {
            addCriterion("update_key_ in", values, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotIn(List<String> values) {
            addCriterion("update_key_ not in", values, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyBetween(String value1, String value2) {
            addCriterion("update_key_ between", value1, value2, "updateKey");
            return (Criteria) this;
        }

        public Criteria andUpdateKeyNotBetween(String value1, String value2) {
            addCriterion("update_key_ not between", value1, value2, "updateKey");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIsNull() {
            addCriterion("allow_discount_ is null");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIsNotNull() {
            addCriterion("allow_discount_ is not null");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountEqualTo(Integer value) {
            addCriterion("allow_discount_ =", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotEqualTo(Integer value) {
            addCriterion("allow_discount_ <>", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountGreaterThan(Integer value) {
            addCriterion("allow_discount_ >", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_discount_ >=", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountLessThan(Integer value) {
            addCriterion("allow_discount_ <", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("allow_discount_ <=", value, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountIn(List<Integer> values) {
            addCriterion("allow_discount_ in", values, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotIn(List<Integer> values) {
            addCriterion("allow_discount_ not in", values, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountBetween(Integer value1, Integer value2) {
            addCriterion("allow_discount_ between", value1, value2, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andAllowDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_discount_ not between", value1, value2, "allowDiscount");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("model_code_ is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("model_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("model_code_ =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("model_code_ <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("model_code_ >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("model_code_ >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("model_code_ <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("model_code_ <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("model_code_ like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("model_code_ not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("model_code_ in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("model_code_ not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("model_code_ between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("model_code_ not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andBomLevelIsNull() {
            addCriterion("bom_level_ is null");
            return (Criteria) this;
        }

        public Criteria andBomLevelIsNotNull() {
            addCriterion("bom_level_ is not null");
            return (Criteria) this;
        }

        public Criteria andBomLevelEqualTo(Integer value) {
            addCriterion("bom_level_ =", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotEqualTo(Integer value) {
            addCriterion("bom_level_ <>", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelGreaterThan(Integer value) {
            addCriterion("bom_level_ >", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("bom_level_ >=", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelLessThan(Integer value) {
            addCriterion("bom_level_ <", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelLessThanOrEqualTo(Integer value) {
            addCriterion("bom_level_ <=", value, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelIn(List<Integer> values) {
            addCriterion("bom_level_ in", values, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotIn(List<Integer> values) {
            addCriterion("bom_level_ not in", values, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelBetween(Integer value1, Integer value2) {
            addCriterion("bom_level_ between", value1, value2, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andBomLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("bom_level_ not between", value1, value2, "bomLevel");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIsNull() {
            addCriterion("part_view_top_ is null");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIsNotNull() {
            addCriterion("part_view_top_ is not null");
            return (Criteria) this;
        }

        public Criteria andPartViewTopEqualTo(Integer value) {
            addCriterion("part_view_top_ =", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotEqualTo(Integer value) {
            addCriterion("part_view_top_ <>", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopGreaterThan(Integer value) {
            addCriterion("part_view_top_ >", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("part_view_top_ >=", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopLessThan(Integer value) {
            addCriterion("part_view_top_ <", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopLessThanOrEqualTo(Integer value) {
            addCriterion("part_view_top_ <=", value, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopIn(List<Integer> values) {
            addCriterion("part_view_top_ in", values, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotIn(List<Integer> values) {
            addCriterion("part_view_top_ not in", values, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopBetween(Integer value1, Integer value2) {
            addCriterion("part_view_top_ between", value1, value2, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andPartViewTopNotBetween(Integer value1, Integer value2) {
            addCriterion("part_view_top_ not between", value1, value2, "partViewTop");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume_ is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume_ is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(BigDecimal value) {
            addCriterion("volume_ =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(BigDecimal value) {
            addCriterion("volume_ <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(BigDecimal value) {
            addCriterion("volume_ >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("volume_ >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(BigDecimal value) {
            addCriterion("volume_ <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("volume_ <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<BigDecimal> values) {
            addCriterion("volume_ in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<BigDecimal> values) {
            addCriterion("volume_ not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume_ between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume_ not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight_ is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight_ is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight_ =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight_ <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight_ >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_ >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight_ <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight_ <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight_ in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight_ not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_ between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight_ not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNull() {
            addCriterion("sales_status_ is null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNotNull() {
            addCriterion("sales_status_ is not null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusEqualTo(Integer value) {
            addCriterion("sales_status_ =", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotEqualTo(Integer value) {
            addCriterion("sales_status_ <>", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThan(Integer value) {
            addCriterion("sales_status_ >", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_status_ >=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThan(Integer value) {
            addCriterion("sales_status_ <", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sales_status_ <=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIn(List<Integer> values) {
            addCriterion("sales_status_ in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotIn(List<Integer> values) {
            addCriterion("sales_status_ not in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusBetween(Integer value1, Integer value2) {
            addCriterion("sales_status_ between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_status_ not between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIsNull() {
            addCriterion("box_sales_ is null");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIsNotNull() {
            addCriterion("box_sales_ is not null");
            return (Criteria) this;
        }

        public Criteria andBoxSalesEqualTo(Boolean value) {
            addCriterion("box_sales_ =", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotEqualTo(Boolean value) {
            addCriterion("box_sales_ <>", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesGreaterThan(Boolean value) {
            addCriterion("box_sales_ >", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("box_sales_ >=", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesLessThan(Boolean value) {
            addCriterion("box_sales_ <", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesLessThanOrEqualTo(Boolean value) {
            addCriterion("box_sales_ <=", value, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesIn(List<Boolean> values) {
            addCriterion("box_sales_ in", values, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotIn(List<Boolean> values) {
            addCriterion("box_sales_ not in", values, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesBetween(Boolean value1, Boolean value2) {
            addCriterion("box_sales_ between", value1, value2, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxSalesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("box_sales_ not between", value1, value2, "boxSales");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIsNull() {
            addCriterion("box_purchase_ is null");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIsNotNull() {
            addCriterion("box_purchase_ is not null");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseEqualTo(Boolean value) {
            addCriterion("box_purchase_ =", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotEqualTo(Boolean value) {
            addCriterion("box_purchase_ <>", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseGreaterThan(Boolean value) {
            addCriterion("box_purchase_ >", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("box_purchase_ >=", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseLessThan(Boolean value) {
            addCriterion("box_purchase_ <", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseLessThanOrEqualTo(Boolean value) {
            addCriterion("box_purchase_ <=", value, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseIn(List<Boolean> values) {
            addCriterion("box_purchase_ in", values, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotIn(List<Boolean> values) {
            addCriterion("box_purchase_ not in", values, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseBetween(Boolean value1, Boolean value2) {
            addCriterion("box_purchase_ between", value1, value2, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andBoxPurchaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("box_purchase_ not between", value1, value2, "boxPurchase");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIsNull() {
            addCriterion("lower_shelf_ is null");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIsNotNull() {
            addCriterion("lower_shelf_ is not null");
            return (Criteria) this;
        }

        public Criteria andLowerShelfEqualTo(Boolean value) {
            addCriterion("lower_shelf_ =", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotEqualTo(Boolean value) {
            addCriterion("lower_shelf_ <>", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfGreaterThan(Boolean value) {
            addCriterion("lower_shelf_ >", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("lower_shelf_ >=", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfLessThan(Boolean value) {
            addCriterion("lower_shelf_ <", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfLessThanOrEqualTo(Boolean value) {
            addCriterion("lower_shelf_ <=", value, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfIn(List<Boolean> values) {
            addCriterion("lower_shelf_ in", values, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotIn(List<Boolean> values) {
            addCriterion("lower_shelf_ not in", values, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfBetween(Boolean value1, Boolean value2) {
            addCriterion("lower_shelf_ between", value1, value2, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andLowerShelfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("lower_shelf_ not between", value1, value2, "lowerShelf");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIsNull() {
            addCriterion("pur_front_day_ is null");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIsNotNull() {
            addCriterion("pur_front_day_ is not null");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayEqualTo(Integer value) {
            addCriterion("pur_front_day_ =", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotEqualTo(Integer value) {
            addCriterion("pur_front_day_ <>", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayGreaterThan(Integer value) {
            addCriterion("pur_front_day_ >", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pur_front_day_ >=", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayLessThan(Integer value) {
            addCriterion("pur_front_day_ <", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayLessThanOrEqualTo(Integer value) {
            addCriterion("pur_front_day_ <=", value, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayIn(List<Integer> values) {
            addCriterion("pur_front_day_ in", values, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotIn(List<Integer> values) {
            addCriterion("pur_front_day_ not in", values, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayBetween(Integer value1, Integer value2) {
            addCriterion("pur_front_day_ between", value1, value2, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andPurFrontDayNotBetween(Integer value1, Integer value2) {
            addCriterion("pur_front_day_ not between", value1, value2, "purFrontDay");
            return (Criteria) this;
        }

        public Criteria andForbidPurIsNull() {
            addCriterion("forbid_pur_ is null");
            return (Criteria) this;
        }

        public Criteria andForbidPurIsNotNull() {
            addCriterion("forbid_pur_ is not null");
            return (Criteria) this;
        }

        public Criteria andForbidPurEqualTo(Boolean value) {
            addCriterion("forbid_pur_ =", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotEqualTo(Boolean value) {
            addCriterion("forbid_pur_ <>", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurGreaterThan(Boolean value) {
            addCriterion("forbid_pur_ >", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurGreaterThanOrEqualTo(Boolean value) {
            addCriterion("forbid_pur_ >=", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurLessThan(Boolean value) {
            addCriterion("forbid_pur_ <", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurLessThanOrEqualTo(Boolean value) {
            addCriterion("forbid_pur_ <=", value, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurIn(List<Boolean> values) {
            addCriterion("forbid_pur_ in", values, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotIn(List<Boolean> values) {
            addCriterion("forbid_pur_ not in", values, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurBetween(Boolean value1, Boolean value2) {
            addCriterion("forbid_pur_ between", value1, value2, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andForbidPurNotBetween(Boolean value1, Boolean value2) {
            addCriterion("forbid_pur_ not between", value1, value2, "forbidPur");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify_ is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify_ is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(Integer value) {
            addCriterion("classify_ =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(Integer value) {
            addCriterion("classify_ <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(Integer value) {
            addCriterion("classify_ >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("classify_ >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(Integer value) {
            addCriterion("classify_ <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(Integer value) {
            addCriterion("classify_ <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<Integer> values) {
            addCriterion("classify_ in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<Integer> values) {
            addCriterion("classify_ not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(Integer value1, Integer value2) {
            addCriterion("classify_ between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(Integer value1, Integer value2) {
            addCriterion("classify_ not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andMarqueIsNull() {
            addCriterion("marque_ is null");
            return (Criteria) this;
        }

        public Criteria andMarqueIsNotNull() {
            addCriterion("marque_ is not null");
            return (Criteria) this;
        }

        public Criteria andMarqueEqualTo(String value) {
            addCriterion("marque_ =", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotEqualTo(String value) {
            addCriterion("marque_ <>", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueGreaterThan(String value) {
            addCriterion("marque_ >", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueGreaterThanOrEqualTo(String value) {
            addCriterion("marque_ >=", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLessThan(String value) {
            addCriterion("marque_ <", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLessThanOrEqualTo(String value) {
            addCriterion("marque_ <=", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueLike(String value) {
            addCriterion("marque_ like", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotLike(String value) {
            addCriterion("marque_ not like", value, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueIn(List<String> values) {
            addCriterion("marque_ in", values, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotIn(List<String> values) {
            addCriterion("marque_ not in", values, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueBetween(String value1, String value2) {
            addCriterion("marque_ between", value1, value2, "marque");
            return (Criteria) this;
        }

        public Criteria andMarqueNotBetween(String value1, String value2) {
            addCriterion("marque_ not between", value1, value2, "marque");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIsNull() {
            addCriterion("forecast_count_mrp_ is null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIsNotNull() {
            addCriterion("forecast_count_mrp_ is not null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp_ =", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp_ <>", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpGreaterThan(Boolean value) {
            addCriterion("forecast_count_mrp_ >", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp_ >=", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpLessThan(Boolean value) {
            addCriterion("forecast_count_mrp_ <", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpLessThanOrEqualTo(Boolean value) {
            addCriterion("forecast_count_mrp_ <=", value, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpIn(List<Boolean> values) {
            addCriterion("forecast_count_mrp_ in", values, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotIn(List<Boolean> values) {
            addCriterion("forecast_count_mrp_ not in", values, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpBetween(Boolean value1, Boolean value2) {
            addCriterion("forecast_count_mrp_ between", value1, value2, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMrpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("forecast_count_mrp_ not between", value1, value2, "forecastCountMrp");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIsNull() {
            addCriterion("forecast_count_month_ is null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIsNotNull() {
            addCriterion("forecast_count_month_ is not null");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthEqualTo(Integer value) {
            addCriterion("forecast_count_month_ =", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotEqualTo(Integer value) {
            addCriterion("forecast_count_month_ <>", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthGreaterThan(Integer value) {
            addCriterion("forecast_count_month_ >", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("forecast_count_month_ >=", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthLessThan(Integer value) {
            addCriterion("forecast_count_month_ <", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthLessThanOrEqualTo(Integer value) {
            addCriterion("forecast_count_month_ <=", value, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthIn(List<Integer> values) {
            addCriterion("forecast_count_month_ in", values, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotIn(List<Integer> values) {
            addCriterion("forecast_count_month_ not in", values, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthBetween(Integer value1, Integer value2) {
            addCriterion("forecast_count_month_ between", value1, value2, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andForecastCountMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("forecast_count_month_ not between", value1, value2, "forecastCountMonth");
            return (Criteria) this;
        }

        public Criteria andSeNoIsNull() {
            addCriterion("se_no_ is null");
            return (Criteria) this;
        }

        public Criteria andSeNoIsNotNull() {
            addCriterion("se_no_ is not null");
            return (Criteria) this;
        }

        public Criteria andSeNoEqualTo(String value) {
            addCriterion("se_no_ =", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotEqualTo(String value) {
            addCriterion("se_no_ <>", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoGreaterThan(String value) {
            addCriterion("se_no_ >", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoGreaterThanOrEqualTo(String value) {
            addCriterion("se_no_ >=", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLessThan(String value) {
            addCriterion("se_no_ <", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLessThanOrEqualTo(String value) {
            addCriterion("se_no_ <=", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoLike(String value) {
            addCriterion("se_no_ like", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotLike(String value) {
            addCriterion("se_no_ not like", value, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoIn(List<String> values) {
            addCriterion("se_no_ in", values, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotIn(List<String> values) {
            addCriterion("se_no_ not in", values, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoBetween(String value1, String value2) {
            addCriterion("se_no_ between", value1, value2, "seNo");
            return (Criteria) this;
        }

        public Criteria andSeNoNotBetween(String value1, String value2) {
            addCriterion("se_no_ not between", value1, value2, "seNo");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNull() {
            addCriterion("is_sync_ is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNotNull() {
            addCriterion("is_sync_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncEqualTo(Boolean value) {
            addCriterion("is_sync_ =", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotEqualTo(Boolean value) {
            addCriterion("is_sync_ <>", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThan(Boolean value) {
            addCriterion("is_sync_ >", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_sync_ >=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThan(Boolean value) {
            addCriterion("is_sync_ <", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThanOrEqualTo(Boolean value) {
            addCriterion("is_sync_ <=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncIn(List<Boolean> values) {
            addCriterion("is_sync_ in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotIn(List<Boolean> values) {
            addCriterion("is_sync_ not in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sync_ between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sync_ not between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIsNull() {
            addCriterion("bom_property_ is null");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIsNotNull() {
            addCriterion("bom_property_ is not null");
            return (Criteria) this;
        }

        public Criteria andBomPropertyEqualTo(Boolean value) {
            addCriterion("bom_property_ =", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotEqualTo(Boolean value) {
            addCriterion("bom_property_ <>", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyGreaterThan(Boolean value) {
            addCriterion("bom_property_ >", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bom_property_ >=", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyLessThan(Boolean value) {
            addCriterion("bom_property_ <", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyLessThanOrEqualTo(Boolean value) {
            addCriterion("bom_property_ <=", value, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyIn(List<Boolean> values) {
            addCriterion("bom_property_ in", values, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotIn(List<Boolean> values) {
            addCriterion("bom_property_ not in", values, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyBetween(Boolean value1, Boolean value2) {
            addCriterion("bom_property_ between", value1, value2, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andBomPropertyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bom_property_ not between", value1, value2, "bomProperty");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNull() {
            addCriterion("dept_code_ is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("dept_code_ is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(String value) {
            addCriterion("dept_code_ =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(String value) {
            addCriterion("dept_code_ <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(String value) {
            addCriterion("dept_code_ >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_code_ >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(String value) {
            addCriterion("dept_code_ <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("dept_code_ <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLike(String value) {
            addCriterion("dept_code_ like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotLike(String value) {
            addCriterion("dept_code_ not like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<String> values) {
            addCriterion("dept_code_ in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<String> values) {
            addCriterion("dept_code_ not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(String value1, String value2) {
            addCriterion("dept_code_ between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(String value1, String value2) {
            addCriterion("dept_code_ not between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNull() {
            addCriterion("cost_amount_ is null");
            return (Criteria) this;
        }

        public Criteria andCostAmountIsNotNull() {
            addCriterion("cost_amount_ is not null");
            return (Criteria) this;
        }

        public Criteria andCostAmountEqualTo(BigDecimal value) {
            addCriterion("cost_amount_ =", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotEqualTo(BigDecimal value) {
            addCriterion("cost_amount_ <>", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThan(BigDecimal value) {
            addCriterion("cost_amount_ >", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_amount_ >=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThan(BigDecimal value) {
            addCriterion("cost_amount_ <", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_amount_ <=", value, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountIn(List<BigDecimal> values) {
            addCriterion("cost_amount_ in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotIn(List<BigDecimal> values) {
            addCriterion("cost_amount_ not in", values, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_amount_ between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andCostAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_amount_ not between", value1, value2, "costAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIsNull() {
            addCriterion("delivery_cycle_ is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIsNotNull() {
            addCriterion("delivery_cycle_ is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleEqualTo(Integer value) {
            addCriterion("delivery_cycle_ =", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotEqualTo(Integer value) {
            addCriterion("delivery_cycle_ <>", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleGreaterThan(Integer value) {
            addCriterion("delivery_cycle_ >", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_cycle_ >=", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleLessThan(Integer value) {
            addCriterion("delivery_cycle_ <", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_cycle_ <=", value, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleIn(List<Integer> values) {
            addCriterion("delivery_cycle_ in", values, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotIn(List<Integer> values) {
            addCriterion("delivery_cycle_ not in", values, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleBetween(Integer value1, Integer value2) {
            addCriterion("delivery_cycle_ between", value1, value2, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andDeliveryCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_cycle_ not between", value1, value2, "deliveryCycle");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIsNull() {
            addCriterion("virtual_stock_ is null");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIsNotNull() {
            addCriterion("virtual_stock_ is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualStockEqualTo(BigDecimal value) {
            addCriterion("virtual_stock_ =", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotEqualTo(BigDecimal value) {
            addCriterion("virtual_stock_ <>", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockGreaterThan(BigDecimal value) {
            addCriterion("virtual_stock_ >", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("virtual_stock_ >=", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockLessThan(BigDecimal value) {
            addCriterion("virtual_stock_ <", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("virtual_stock_ <=", value, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockIn(List<BigDecimal> values) {
            addCriterion("virtual_stock_ in", values, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotIn(List<BigDecimal> values) {
            addCriterion("virtual_stock_ not in", values, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("virtual_stock_ between", value1, value2, "virtualStock");
            return (Criteria) this;
        }

        public Criteria andVirtualStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("virtual_stock_ not between", value1, value2, "virtualStock");
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