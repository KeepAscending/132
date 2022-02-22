package com.lvg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGroupExample() {
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

        public Criteria andHostIdIsNull() {
            addCriterion("host_id is null");
            return (Criteria) this;
        }

        public Criteria andHostIdIsNotNull() {
            addCriterion("host_id is not null");
            return (Criteria) this;
        }

        public Criteria andHostIdEqualTo(Long value) {
            addCriterion("host_id =", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotEqualTo(Long value) {
            addCriterion("host_id <>", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdGreaterThan(Long value) {
            addCriterion("host_id >", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdGreaterThanOrEqualTo(Long value) {
            addCriterion("host_id >=", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdLessThan(Long value) {
            addCriterion("host_id <", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdLessThanOrEqualTo(Long value) {
            addCriterion("host_id <=", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdIn(List<Long> values) {
            addCriterion("host_id in", values, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotIn(List<Long> values) {
            addCriterion("host_id not in", values, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdBetween(Long value1, Long value2) {
            addCriterion("host_id between", value1, value2, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotBetween(Long value1, Long value2) {
            addCriterion("host_id not between", value1, value2, "hostId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andRestypeIsNull() {
            addCriterion("restype is null");
            return (Criteria) this;
        }

        public Criteria andRestypeIsNotNull() {
            addCriterion("restype is not null");
            return (Criteria) this;
        }

        public Criteria andRestypeEqualTo(String value) {
            addCriterion("restype =", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeNotEqualTo(String value) {
            addCriterion("restype <>", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeGreaterThan(String value) {
            addCriterion("restype >", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeGreaterThanOrEqualTo(String value) {
            addCriterion("restype >=", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeLessThan(String value) {
            addCriterion("restype <", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeLessThanOrEqualTo(String value) {
            addCriterion("restype <=", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeLike(String value) {
            addCriterion("restype like", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeNotLike(String value) {
            addCriterion("restype not like", value, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeIn(List<String> values) {
            addCriterion("restype in", values, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeNotIn(List<String> values) {
            addCriterion("restype not in", values, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeBetween(String value1, String value2) {
            addCriterion("restype between", value1, value2, "restype");
            return (Criteria) this;
        }

        public Criteria andRestypeNotBetween(String value1, String value2) {
            addCriterion("restype not between", value1, value2, "restype");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andDelineIsNull() {
            addCriterion("deline is null");
            return (Criteria) this;
        }

        public Criteria andDelineIsNotNull() {
            addCriterion("deline is not null");
            return (Criteria) this;
        }

        public Criteria andDelineEqualTo(String value) {
            addCriterion("deline =", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotEqualTo(String value) {
            addCriterion("deline <>", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineGreaterThan(String value) {
            addCriterion("deline >", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineGreaterThanOrEqualTo(String value) {
            addCriterion("deline >=", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineLessThan(String value) {
            addCriterion("deline <", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineLessThanOrEqualTo(String value) {
            addCriterion("deline <=", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineLike(String value) {
            addCriterion("deline like", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotLike(String value) {
            addCriterion("deline not like", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineIn(List<String> values) {
            addCriterion("deline in", values, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotIn(List<String> values) {
            addCriterion("deline not in", values, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineBetween(String value1, String value2) {
            addCriterion("deline between", value1, value2, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotBetween(String value1, String value2) {
            addCriterion("deline not between", value1, value2, "deline");
            return (Criteria) this;
        }

        public Criteria andEarliestIsNull() {
            addCriterion("earliest is null");
            return (Criteria) this;
        }

        public Criteria andEarliestIsNotNull() {
            addCriterion("earliest is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestEqualTo(String value) {
            addCriterion("earliest =", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestNotEqualTo(String value) {
            addCriterion("earliest <>", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestGreaterThan(String value) {
            addCriterion("earliest >", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestGreaterThanOrEqualTo(String value) {
            addCriterion("earliest >=", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestLessThan(String value) {
            addCriterion("earliest <", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestLessThanOrEqualTo(String value) {
            addCriterion("earliest <=", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestLike(String value) {
            addCriterion("earliest like", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestNotLike(String value) {
            addCriterion("earliest not like", value, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestIn(List<String> values) {
            addCriterion("earliest in", values, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestNotIn(List<String> values) {
            addCriterion("earliest not in", values, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestBetween(String value1, String value2) {
            addCriterion("earliest between", value1, value2, "earliest");
            return (Criteria) this;
        }

        public Criteria andEarliestNotBetween(String value1, String value2) {
            addCriterion("earliest not between", value1, value2, "earliest");
            return (Criteria) this;
        }

        public Criteria andLatestIsNull() {
            addCriterion("latest is null");
            return (Criteria) this;
        }

        public Criteria andLatestIsNotNull() {
            addCriterion("latest is not null");
            return (Criteria) this;
        }

        public Criteria andLatestEqualTo(String value) {
            addCriterion("latest =", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotEqualTo(String value) {
            addCriterion("latest <>", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestGreaterThan(String value) {
            addCriterion("latest >", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestGreaterThanOrEqualTo(String value) {
            addCriterion("latest >=", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestLessThan(String value) {
            addCriterion("latest <", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestLessThanOrEqualTo(String value) {
            addCriterion("latest <=", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestLike(String value) {
            addCriterion("latest like", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotLike(String value) {
            addCriterion("latest not like", value, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestIn(List<String> values) {
            addCriterion("latest in", values, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotIn(List<String> values) {
            addCriterion("latest not in", values, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestBetween(String value1, String value2) {
            addCriterion("latest between", value1, value2, "latest");
            return (Criteria) this;
        }

        public Criteria andLatestNotBetween(String value1, String value2) {
            addCriterion("latest not between", value1, value2, "latest");
            return (Criteria) this;
        }

        public Criteria andCheckoutIsNull() {
            addCriterion("checkout is null");
            return (Criteria) this;
        }

        public Criteria andCheckoutIsNotNull() {
            addCriterion("checkout is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoutEqualTo(String value) {
            addCriterion("checkout =", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotEqualTo(String value) {
            addCriterion("checkout <>", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutGreaterThan(String value) {
            addCriterion("checkout >", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutGreaterThanOrEqualTo(String value) {
            addCriterion("checkout >=", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLessThan(String value) {
            addCriterion("checkout <", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLessThanOrEqualTo(String value) {
            addCriterion("checkout <=", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutLike(String value) {
            addCriterion("checkout like", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotLike(String value) {
            addCriterion("checkout not like", value, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutIn(List<String> values) {
            addCriterion("checkout in", values, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotIn(List<String> values) {
            addCriterion("checkout not in", values, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutBetween(String value1, String value2) {
            addCriterion("checkout between", value1, value2, "checkout");
            return (Criteria) this;
        }

        public Criteria andCheckoutNotBetween(String value1, String value2) {
            addCriterion("checkout not between", value1, value2, "checkout");
            return (Criteria) this;
        }

        public Criteria andSupfaciIsNull() {
            addCriterion("supfaci is null");
            return (Criteria) this;
        }

        public Criteria andSupfaciIsNotNull() {
            addCriterion("supfaci is not null");
            return (Criteria) this;
        }

        public Criteria andSupfaciEqualTo(String value) {
            addCriterion("supfaci =", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciNotEqualTo(String value) {
            addCriterion("supfaci <>", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciGreaterThan(String value) {
            addCriterion("supfaci >", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciGreaterThanOrEqualTo(String value) {
            addCriterion("supfaci >=", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciLessThan(String value) {
            addCriterion("supfaci <", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciLessThanOrEqualTo(String value) {
            addCriterion("supfaci <=", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciLike(String value) {
            addCriterion("supfaci like", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciNotLike(String value) {
            addCriterion("supfaci not like", value, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciIn(List<String> values) {
            addCriterion("supfaci in", values, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciNotIn(List<String> values) {
            addCriterion("supfaci not in", values, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciBetween(String value1, String value2) {
            addCriterion("supfaci between", value1, value2, "supfaci");
            return (Criteria) this;
        }

        public Criteria andSupfaciNotBetween(String value1, String value2) {
            addCriterion("supfaci not between", value1, value2, "supfaci");
            return (Criteria) this;
        }

        public Criteria andRulesIsNull() {
            addCriterion("rules is null");
            return (Criteria) this;
        }

        public Criteria andRulesIsNotNull() {
            addCriterion("rules is not null");
            return (Criteria) this;
        }

        public Criteria andRulesEqualTo(String value) {
            addCriterion("rules =", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotEqualTo(String value) {
            addCriterion("rules <>", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesGreaterThan(String value) {
            addCriterion("rules >", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesGreaterThanOrEqualTo(String value) {
            addCriterion("rules >=", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLessThan(String value) {
            addCriterion("rules <", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLessThanOrEqualTo(String value) {
            addCriterion("rules <=", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLike(String value) {
            addCriterion("rules like", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotLike(String value) {
            addCriterion("rules not like", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesIn(List<String> values) {
            addCriterion("rules in", values, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotIn(List<String> values) {
            addCriterion("rules not in", values, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesBetween(String value1, String value2) {
            addCriterion("rules between", value1, value2, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotBetween(String value1, String value2) {
            addCriterion("rules not between", value1, value2, "rules");
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

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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