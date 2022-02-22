package com.lvg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUgcEvalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUgcEvalExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNull() {
            addCriterion("reviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIsNotNull() {
            addCriterion("reviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerIdEqualTo(Long value) {
            addCriterion("reviewer_id =", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotEqualTo(Long value) {
            addCriterion("reviewer_id <>", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThan(Long value) {
            addCriterion("reviewer_id >", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reviewer_id >=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThan(Long value) {
            addCriterion("reviewer_id <", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdLessThanOrEqualTo(Long value) {
            addCriterion("reviewer_id <=", value, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdIn(List<Long> values) {
            addCriterion("reviewer_id in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotIn(List<Long> values) {
            addCriterion("reviewer_id not in", values, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdBetween(Long value1, Long value2) {
            addCriterion("reviewer_id between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andReviewerIdNotBetween(Long value1, Long value2) {
            addCriterion("reviewer_id not between", value1, value2, "reviewerId");
            return (Criteria) this;
        }

        public Criteria andUgcIdIsNull() {
            addCriterion("ugc_id is null");
            return (Criteria) this;
        }

        public Criteria andUgcIdIsNotNull() {
            addCriterion("ugc_id is not null");
            return (Criteria) this;
        }

        public Criteria andUgcIdEqualTo(Long value) {
            addCriterion("ugc_id =", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotEqualTo(Long value) {
            addCriterion("ugc_id <>", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdGreaterThan(Long value) {
            addCriterion("ugc_id >", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ugc_id >=", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdLessThan(Long value) {
            addCriterion("ugc_id <", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdLessThanOrEqualTo(Long value) {
            addCriterion("ugc_id <=", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdIn(List<Long> values) {
            addCriterion("ugc_id in", values, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotIn(List<Long> values) {
            addCriterion("ugc_id not in", values, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdBetween(Long value1, Long value2) {
            addCriterion("ugc_id between", value1, value2, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotBetween(Long value1, Long value2) {
            addCriterion("ugc_id not between", value1, value2, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdIsNull() {
            addCriterion("ugceval_id is null");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdIsNotNull() {
            addCriterion("ugceval_id is not null");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdEqualTo(Long value) {
            addCriterion("ugceval_id =", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdNotEqualTo(Long value) {
            addCriterion("ugceval_id <>", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdGreaterThan(Long value) {
            addCriterion("ugceval_id >", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ugceval_id >=", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdLessThan(Long value) {
            addCriterion("ugceval_id <", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdLessThanOrEqualTo(Long value) {
            addCriterion("ugceval_id <=", value, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdIn(List<Long> values) {
            addCriterion("ugceval_id in", values, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdNotIn(List<Long> values) {
            addCriterion("ugceval_id not in", values, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdBetween(Long value1, Long value2) {
            addCriterion("ugceval_id between", value1, value2, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andUgcevalIdNotBetween(Long value1, Long value2) {
            addCriterion("ugceval_id not between", value1, value2, "ugcevalId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
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