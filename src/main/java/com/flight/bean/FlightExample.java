package com.flight.bean;

import java.util.ArrayList;
import java.util.List;

public class FlightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlightExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlightCodeIsNull() {
            addCriterion("flight_code is null");
            return (Criteria) this;
        }

        public Criteria andFlightCodeIsNotNull() {
            addCriterion("flight_code is not null");
            return (Criteria) this;
        }

        public Criteria andFlightCodeEqualTo(String value) {
            addCriterion("flight_code =", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeNotEqualTo(String value) {
            addCriterion("flight_code <>", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeGreaterThan(String value) {
            addCriterion("flight_code >", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeGreaterThanOrEqualTo(String value) {
            addCriterion("flight_code >=", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeLessThan(String value) {
            addCriterion("flight_code <", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeLessThanOrEqualTo(String value) {
            addCriterion("flight_code <=", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeLike(String value) {
            addCriterion("flight_code like", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeNotLike(String value) {
            addCriterion("flight_code not like", value, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeIn(List<String> values) {
            addCriterion("flight_code in", values, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeNotIn(List<String> values) {
            addCriterion("flight_code not in", values, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeBetween(String value1, String value2) {
            addCriterion("flight_code between", value1, value2, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightCodeNotBetween(String value1, String value2) {
            addCriterion("flight_code not between", value1, value2, "flightCode");
            return (Criteria) this;
        }

        public Criteria andFlightTypeIsNull() {
            addCriterion("flight_type is null");
            return (Criteria) this;
        }

        public Criteria andFlightTypeIsNotNull() {
            addCriterion("flight_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlightTypeEqualTo(String value) {
            addCriterion("flight_type =", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeNotEqualTo(String value) {
            addCriterion("flight_type <>", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeGreaterThan(String value) {
            addCriterion("flight_type >", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flight_type >=", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeLessThan(String value) {
            addCriterion("flight_type <", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeLessThanOrEqualTo(String value) {
            addCriterion("flight_type <=", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeLike(String value) {
            addCriterion("flight_type like", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeNotLike(String value) {
            addCriterion("flight_type not like", value, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeIn(List<String> values) {
            addCriterion("flight_type in", values, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeNotIn(List<String> values) {
            addCriterion("flight_type not in", values, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeBetween(String value1, String value2) {
            addCriterion("flight_type between", value1, value2, "flightType");
            return (Criteria) this;
        }

        public Criteria andFlightTypeNotBetween(String value1, String value2) {
            addCriterion("flight_type not between", value1, value2, "flightType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeIsNull() {
            addCriterion("cabin_type is null");
            return (Criteria) this;
        }

        public Criteria andCabinTypeIsNotNull() {
            addCriterion("cabin_type is not null");
            return (Criteria) this;
        }

        public Criteria andCabinTypeEqualTo(String value) {
            addCriterion("cabin_type =", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeNotEqualTo(String value) {
            addCriterion("cabin_type <>", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeGreaterThan(String value) {
            addCriterion("cabin_type >", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cabin_type >=", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeLessThan(String value) {
            addCriterion("cabin_type <", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeLessThanOrEqualTo(String value) {
            addCriterion("cabin_type <=", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeLike(String value) {
            addCriterion("cabin_type like", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeNotLike(String value) {
            addCriterion("cabin_type not like", value, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeIn(List<String> values) {
            addCriterion("cabin_type in", values, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeNotIn(List<String> values) {
            addCriterion("cabin_type not in", values, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeBetween(String value1, String value2) {
            addCriterion("cabin_type between", value1, value2, "cabinType");
            return (Criteria) this;
        }

        public Criteria andCabinTypeNotBetween(String value1, String value2) {
            addCriterion("cabin_type not between", value1, value2, "cabinType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIsNull() {
            addCriterion("plane_type is null");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIsNotNull() {
            addCriterion("plane_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeEqualTo(String value) {
            addCriterion("plane_type =", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotEqualTo(String value) {
            addCriterion("plane_type <>", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeGreaterThan(String value) {
            addCriterion("plane_type >", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plane_type >=", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLessThan(String value) {
            addCriterion("plane_type <", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLessThanOrEqualTo(String value) {
            addCriterion("plane_type <=", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeLike(String value) {
            addCriterion("plane_type like", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotLike(String value) {
            addCriterion("plane_type not like", value, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeIn(List<String> values) {
            addCriterion("plane_type in", values, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotIn(List<String> values) {
            addCriterion("plane_type not in", values, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeBetween(String value1, String value2) {
            addCriterion("plane_type between", value1, value2, "planeType");
            return (Criteria) this;
        }

        public Criteria andPlaneTypeNotBetween(String value1, String value2) {
            addCriterion("plane_type not between", value1, value2, "planeType");
            return (Criteria) this;
        }

        public Criteria andTimeUseIsNull() {
            addCriterion("time_use is null");
            return (Criteria) this;
        }

        public Criteria andTimeUseIsNotNull() {
            addCriterion("time_use is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUseEqualTo(Integer value) {
            addCriterion("time_use =", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseNotEqualTo(Integer value) {
            addCriterion("time_use <>", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseGreaterThan(Integer value) {
            addCriterion("time_use >", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_use >=", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseLessThan(Integer value) {
            addCriterion("time_use <", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseLessThanOrEqualTo(Integer value) {
            addCriterion("time_use <=", value, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseIn(List<Integer> values) {
            addCriterion("time_use in", values, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseNotIn(List<Integer> values) {
            addCriterion("time_use not in", values, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseBetween(Integer value1, Integer value2) {
            addCriterion("time_use between", value1, value2, "timeUse");
            return (Criteria) this;
        }

        public Criteria andTimeUseNotBetween(Integer value1, Integer value2) {
            addCriterion("time_use not between", value1, value2, "timeUse");
            return (Criteria) this;
        }

        public Criteria andBuildPriceIsNull() {
            addCriterion("build_price is null");
            return (Criteria) this;
        }

        public Criteria andBuildPriceIsNotNull() {
            addCriterion("build_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuildPriceEqualTo(Integer value) {
            addCriterion("build_price =", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceNotEqualTo(Integer value) {
            addCriterion("build_price <>", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceGreaterThan(Integer value) {
            addCriterion("build_price >", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("build_price >=", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceLessThan(Integer value) {
            addCriterion("build_price <", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceLessThanOrEqualTo(Integer value) {
            addCriterion("build_price <=", value, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceIn(List<Integer> values) {
            addCriterion("build_price in", values, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceNotIn(List<Integer> values) {
            addCriterion("build_price not in", values, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceBetween(Integer value1, Integer value2) {
            addCriterion("build_price between", value1, value2, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andBuildPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("build_price not between", value1, value2, "buildPrice");
            return (Criteria) this;
        }

        public Criteria andStopIsNull() {
            addCriterion("stop is null");
            return (Criteria) this;
        }

        public Criteria andStopIsNotNull() {
            addCriterion("stop is not null");
            return (Criteria) this;
        }

        public Criteria andStopEqualTo(Integer value) {
            addCriterion("stop =", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopNotEqualTo(Integer value) {
            addCriterion("stop <>", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopGreaterThan(Integer value) {
            addCriterion("stop >", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopGreaterThanOrEqualTo(Integer value) {
            addCriterion("stop >=", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopLessThan(Integer value) {
            addCriterion("stop <", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopLessThanOrEqualTo(Integer value) {
            addCriterion("stop <=", value, "stop");
            return (Criteria) this;
        }

        public Criteria andStopIn(List<Integer> values) {
            addCriterion("stop in", values, "stop");
            return (Criteria) this;
        }

        public Criteria andStopNotIn(List<Integer> values) {
            addCriterion("stop not in", values, "stop");
            return (Criteria) this;
        }

        public Criteria andStopBetween(Integer value1, Integer value2) {
            addCriterion("stop between", value1, value2, "stop");
            return (Criteria) this;
        }

        public Criteria andStopNotBetween(Integer value1, Integer value2) {
            addCriterion("stop not between", value1, value2, "stop");
            return (Criteria) this;
        }

        public Criteria andStopCityIsNull() {
            addCriterion("stop_city is null");
            return (Criteria) this;
        }

        public Criteria andStopCityIsNotNull() {
            addCriterion("stop_city is not null");
            return (Criteria) this;
        }

        public Criteria andStopCityEqualTo(String value) {
            addCriterion("stop_city =", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityNotEqualTo(String value) {
            addCriterion("stop_city <>", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityGreaterThan(String value) {
            addCriterion("stop_city >", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityGreaterThanOrEqualTo(String value) {
            addCriterion("stop_city >=", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityLessThan(String value) {
            addCriterion("stop_city <", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityLessThanOrEqualTo(String value) {
            addCriterion("stop_city <=", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityLike(String value) {
            addCriterion("stop_city like", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityNotLike(String value) {
            addCriterion("stop_city not like", value, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityIn(List<String> values) {
            addCriterion("stop_city in", values, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityNotIn(List<String> values) {
            addCriterion("stop_city not in", values, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityBetween(String value1, String value2) {
            addCriterion("stop_city between", value1, value2, "stopCity");
            return (Criteria) this;
        }

        public Criteria andStopCityNotBetween(String value1, String value2) {
            addCriterion("stop_city not between", value1, value2, "stopCity");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNull() {
            addCriterion("base_price is null");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNotNull() {
            addCriterion("base_price is not null");
            return (Criteria) this;
        }

        public Criteria andBasePriceEqualTo(Integer value) {
            addCriterion("base_price =", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotEqualTo(Integer value) {
            addCriterion("base_price <>", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThan(Integer value) {
            addCriterion("base_price >", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_price >=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThan(Integer value) {
            addCriterion("base_price <", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThanOrEqualTo(Integer value) {
            addCriterion("base_price <=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceIn(List<Integer> values) {
            addCriterion("base_price in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotIn(List<Integer> values) {
            addCriterion("base_price not in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceBetween(Integer value1, Integer value2) {
            addCriterion("base_price between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("base_price not between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTruePriceIsNull() {
            addCriterion("true_price is null");
            return (Criteria) this;
        }

        public Criteria andTruePriceIsNotNull() {
            addCriterion("true_price is not null");
            return (Criteria) this;
        }

        public Criteria andTruePriceEqualTo(Integer value) {
            addCriterion("true_price =", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotEqualTo(Integer value) {
            addCriterion("true_price <>", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceGreaterThan(Integer value) {
            addCriterion("true_price >", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("true_price >=", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceLessThan(Integer value) {
            addCriterion("true_price <", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceLessThanOrEqualTo(Integer value) {
            addCriterion("true_price <=", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceIn(List<Integer> values) {
            addCriterion("true_price in", values, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotIn(List<Integer> values) {
            addCriterion("true_price not in", values, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceBetween(Integer value1, Integer value2) {
            addCriterion("true_price between", value1, value2, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("true_price not between", value1, value2, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNull() {
            addCriterion("ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumIsNotNull() {
            addCriterion("ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumEqualTo(Integer value) {
            addCriterion("ticket_num =", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotEqualTo(Integer value) {
            addCriterion("ticket_num <>", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThan(Integer value) {
            addCriterion("ticket_num >", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_num >=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThan(Integer value) {
            addCriterion("ticket_num <", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_num <=", value, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumIn(List<Integer> values) {
            addCriterion("ticket_num in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotIn(List<Integer> values) {
            addCriterion("ticket_num not in", values, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumBetween(Integer value1, Integer value2) {
            addCriterion("ticket_num between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andTicketNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_num not between", value1, value2, "ticketNum");
            return (Criteria) this;
        }

        public Criteria andDepCityIsNull() {
            addCriterion("dep_city is null");
            return (Criteria) this;
        }

        public Criteria andDepCityIsNotNull() {
            addCriterion("dep_city is not null");
            return (Criteria) this;
        }

        public Criteria andDepCityEqualTo(String value) {
            addCriterion("dep_city =", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityNotEqualTo(String value) {
            addCriterion("dep_city <>", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityGreaterThan(String value) {
            addCriterion("dep_city >", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityGreaterThanOrEqualTo(String value) {
            addCriterion("dep_city >=", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityLessThan(String value) {
            addCriterion("dep_city <", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityLessThanOrEqualTo(String value) {
            addCriterion("dep_city <=", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityLike(String value) {
            addCriterion("dep_city like", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityNotLike(String value) {
            addCriterion("dep_city not like", value, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityIn(List<String> values) {
            addCriterion("dep_city in", values, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityNotIn(List<String> values) {
            addCriterion("dep_city not in", values, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityBetween(String value1, String value2) {
            addCriterion("dep_city between", value1, value2, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityNotBetween(String value1, String value2) {
            addCriterion("dep_city not between", value1, value2, "depCity");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeIsNull() {
            addCriterion("dep_city_code is null");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeIsNotNull() {
            addCriterion("dep_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeEqualTo(String value) {
            addCriterion("dep_city_code =", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeNotEqualTo(String value) {
            addCriterion("dep_city_code <>", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeGreaterThan(String value) {
            addCriterion("dep_city_code >", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dep_city_code >=", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeLessThan(String value) {
            addCriterion("dep_city_code <", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeLessThanOrEqualTo(String value) {
            addCriterion("dep_city_code <=", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeLike(String value) {
            addCriterion("dep_city_code like", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeNotLike(String value) {
            addCriterion("dep_city_code not like", value, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeIn(List<String> values) {
            addCriterion("dep_city_code in", values, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeNotIn(List<String> values) {
            addCriterion("dep_city_code not in", values, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeBetween(String value1, String value2) {
            addCriterion("dep_city_code between", value1, value2, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepCityCodeNotBetween(String value1, String value2) {
            addCriterion("dep_city_code not between", value1, value2, "depCityCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportIsNull() {
            addCriterion("dep_airport is null");
            return (Criteria) this;
        }

        public Criteria andDepAirportIsNotNull() {
            addCriterion("dep_airport is not null");
            return (Criteria) this;
        }

        public Criteria andDepAirportEqualTo(String value) {
            addCriterion("dep_airport =", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportNotEqualTo(String value) {
            addCriterion("dep_airport <>", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportGreaterThan(String value) {
            addCriterion("dep_airport >", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportGreaterThanOrEqualTo(String value) {
            addCriterion("dep_airport >=", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportLessThan(String value) {
            addCriterion("dep_airport <", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportLessThanOrEqualTo(String value) {
            addCriterion("dep_airport <=", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportLike(String value) {
            addCriterion("dep_airport like", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportNotLike(String value) {
            addCriterion("dep_airport not like", value, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportIn(List<String> values) {
            addCriterion("dep_airport in", values, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportNotIn(List<String> values) {
            addCriterion("dep_airport not in", values, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportBetween(String value1, String value2) {
            addCriterion("dep_airport between", value1, value2, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportNotBetween(String value1, String value2) {
            addCriterion("dep_airport not between", value1, value2, "depAirport");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeIsNull() {
            addCriterion("dep_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeIsNotNull() {
            addCriterion("dep_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeEqualTo(String value) {
            addCriterion("dep_airport_code =", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeNotEqualTo(String value) {
            addCriterion("dep_airport_code <>", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeGreaterThan(String value) {
            addCriterion("dep_airport_code >", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dep_airport_code >=", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeLessThan(String value) {
            addCriterion("dep_airport_code <", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("dep_airport_code <=", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeLike(String value) {
            addCriterion("dep_airport_code like", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeNotLike(String value) {
            addCriterion("dep_airport_code not like", value, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeIn(List<String> values) {
            addCriterion("dep_airport_code in", values, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeNotIn(List<String> values) {
            addCriterion("dep_airport_code not in", values, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeBetween(String value1, String value2) {
            addCriterion("dep_airport_code between", value1, value2, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepAirportCodeNotBetween(String value1, String value2) {
            addCriterion("dep_airport_code not between", value1, value2, "depAirportCode");
            return (Criteria) this;
        }

        public Criteria andDepTermIsNull() {
            addCriterion("dep_term is null");
            return (Criteria) this;
        }

        public Criteria andDepTermIsNotNull() {
            addCriterion("dep_term is not null");
            return (Criteria) this;
        }

        public Criteria andDepTermEqualTo(String value) {
            addCriterion("dep_term =", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermNotEqualTo(String value) {
            addCriterion("dep_term <>", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermGreaterThan(String value) {
            addCriterion("dep_term >", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermGreaterThanOrEqualTo(String value) {
            addCriterion("dep_term >=", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermLessThan(String value) {
            addCriterion("dep_term <", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermLessThanOrEqualTo(String value) {
            addCriterion("dep_term <=", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermLike(String value) {
            addCriterion("dep_term like", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermNotLike(String value) {
            addCriterion("dep_term not like", value, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermIn(List<String> values) {
            addCriterion("dep_term in", values, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermNotIn(List<String> values) {
            addCriterion("dep_term not in", values, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermBetween(String value1, String value2) {
            addCriterion("dep_term between", value1, value2, "depTerm");
            return (Criteria) this;
        }

        public Criteria andDepTermNotBetween(String value1, String value2) {
            addCriterion("dep_term not between", value1, value2, "depTerm");
            return (Criteria) this;
        }

        public Criteria andArrCityIsNull() {
            addCriterion("arr_city is null");
            return (Criteria) this;
        }

        public Criteria andArrCityIsNotNull() {
            addCriterion("arr_city is not null");
            return (Criteria) this;
        }

        public Criteria andArrCityEqualTo(String value) {
            addCriterion("arr_city =", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityNotEqualTo(String value) {
            addCriterion("arr_city <>", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityGreaterThan(String value) {
            addCriterion("arr_city >", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityGreaterThanOrEqualTo(String value) {
            addCriterion("arr_city >=", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityLessThan(String value) {
            addCriterion("arr_city <", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityLessThanOrEqualTo(String value) {
            addCriterion("arr_city <=", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityLike(String value) {
            addCriterion("arr_city like", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityNotLike(String value) {
            addCriterion("arr_city not like", value, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityIn(List<String> values) {
            addCriterion("arr_city in", values, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityNotIn(List<String> values) {
            addCriterion("arr_city not in", values, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityBetween(String value1, String value2) {
            addCriterion("arr_city between", value1, value2, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityNotBetween(String value1, String value2) {
            addCriterion("arr_city not between", value1, value2, "arrCity");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeIsNull() {
            addCriterion("arr_city_code is null");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeIsNotNull() {
            addCriterion("arr_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeEqualTo(String value) {
            addCriterion("arr_city_code =", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeNotEqualTo(String value) {
            addCriterion("arr_city_code <>", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeGreaterThan(String value) {
            addCriterion("arr_city_code >", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("arr_city_code >=", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeLessThan(String value) {
            addCriterion("arr_city_code <", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeLessThanOrEqualTo(String value) {
            addCriterion("arr_city_code <=", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeLike(String value) {
            addCriterion("arr_city_code like", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeNotLike(String value) {
            addCriterion("arr_city_code not like", value, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeIn(List<String> values) {
            addCriterion("arr_city_code in", values, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeNotIn(List<String> values) {
            addCriterion("arr_city_code not in", values, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeBetween(String value1, String value2) {
            addCriterion("arr_city_code between", value1, value2, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrCityCodeNotBetween(String value1, String value2) {
            addCriterion("arr_city_code not between", value1, value2, "arrCityCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportIsNull() {
            addCriterion("arr_airport is null");
            return (Criteria) this;
        }

        public Criteria andArrAirportIsNotNull() {
            addCriterion("arr_airport is not null");
            return (Criteria) this;
        }

        public Criteria andArrAirportEqualTo(String value) {
            addCriterion("arr_airport =", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotEqualTo(String value) {
            addCriterion("arr_airport <>", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportGreaterThan(String value) {
            addCriterion("arr_airport >", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportGreaterThanOrEqualTo(String value) {
            addCriterion("arr_airport >=", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLessThan(String value) {
            addCriterion("arr_airport <", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLessThanOrEqualTo(String value) {
            addCriterion("arr_airport <=", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportLike(String value) {
            addCriterion("arr_airport like", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotLike(String value) {
            addCriterion("arr_airport not like", value, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportIn(List<String> values) {
            addCriterion("arr_airport in", values, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotIn(List<String> values) {
            addCriterion("arr_airport not in", values, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportBetween(String value1, String value2) {
            addCriterion("arr_airport between", value1, value2, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportNotBetween(String value1, String value2) {
            addCriterion("arr_airport not between", value1, value2, "arrAirport");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeIsNull() {
            addCriterion("arr_airport_code is null");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeIsNotNull() {
            addCriterion("arr_airport_code is not null");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeEqualTo(String value) {
            addCriterion("arr_airport_code =", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeNotEqualTo(String value) {
            addCriterion("arr_airport_code <>", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeGreaterThan(String value) {
            addCriterion("arr_airport_code >", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("arr_airport_code >=", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeLessThan(String value) {
            addCriterion("arr_airport_code <", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeLessThanOrEqualTo(String value) {
            addCriterion("arr_airport_code <=", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeLike(String value) {
            addCriterion("arr_airport_code like", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeNotLike(String value) {
            addCriterion("arr_airport_code not like", value, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeIn(List<String> values) {
            addCriterion("arr_airport_code in", values, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeNotIn(List<String> values) {
            addCriterion("arr_airport_code not in", values, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeBetween(String value1, String value2) {
            addCriterion("arr_airport_code between", value1, value2, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrAirportCodeNotBetween(String value1, String value2) {
            addCriterion("arr_airport_code not between", value1, value2, "arrAirportCode");
            return (Criteria) this;
        }

        public Criteria andArrTermIsNull() {
            addCriterion("arr_term is null");
            return (Criteria) this;
        }

        public Criteria andArrTermIsNotNull() {
            addCriterion("arr_term is not null");
            return (Criteria) this;
        }

        public Criteria andArrTermEqualTo(String value) {
            addCriterion("arr_term =", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermNotEqualTo(String value) {
            addCriterion("arr_term <>", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermGreaterThan(String value) {
            addCriterion("arr_term >", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermGreaterThanOrEqualTo(String value) {
            addCriterion("arr_term >=", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermLessThan(String value) {
            addCriterion("arr_term <", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermLessThanOrEqualTo(String value) {
            addCriterion("arr_term <=", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermLike(String value) {
            addCriterion("arr_term like", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermNotLike(String value) {
            addCriterion("arr_term not like", value, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermIn(List<String> values) {
            addCriterion("arr_term in", values, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermNotIn(List<String> values) {
            addCriterion("arr_term not in", values, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermBetween(String value1, String value2) {
            addCriterion("arr_term between", value1, value2, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andArrTermNotBetween(String value1, String value2) {
            addCriterion("arr_term not between", value1, value2, "arrTerm");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andDepDateIsNull() {
            addCriterion("dep_date is null");
            return (Criteria) this;
        }

        public Criteria andDepDateIsNotNull() {
            addCriterion("dep_date is not null");
            return (Criteria) this;
        }

        public Criteria andDepDateEqualTo(String value) {
            addCriterion("dep_date =", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateNotEqualTo(String value) {
            addCriterion("dep_date <>", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateGreaterThan(String value) {
            addCriterion("dep_date >", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateGreaterThanOrEqualTo(String value) {
            addCriterion("dep_date >=", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateLessThan(String value) {
            addCriterion("dep_date <", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateLessThanOrEqualTo(String value) {
            addCriterion("dep_date <=", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateLike(String value) {
            addCriterion("dep_date like", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateNotLike(String value) {
            addCriterion("dep_date not like", value, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateIn(List<String> values) {
            addCriterion("dep_date in", values, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateNotIn(List<String> values) {
            addCriterion("dep_date not in", values, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateBetween(String value1, String value2) {
            addCriterion("dep_date between", value1, value2, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepDateNotBetween(String value1, String value2) {
            addCriterion("dep_date not between", value1, value2, "depDate");
            return (Criteria) this;
        }

        public Criteria andDepTimeIsNull() {
            addCriterion("dep_time is null");
            return (Criteria) this;
        }

        public Criteria andDepTimeIsNotNull() {
            addCriterion("dep_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepTimeEqualTo(String value) {
            addCriterion("dep_time =", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotEqualTo(String value) {
            addCriterion("dep_time <>", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeGreaterThan(String value) {
            addCriterion("dep_time >", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeGreaterThanOrEqualTo(String value) {
            addCriterion("dep_time >=", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeLessThan(String value) {
            addCriterion("dep_time <", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeLessThanOrEqualTo(String value) {
            addCriterion("dep_time <=", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeLike(String value) {
            addCriterion("dep_time like", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotLike(String value) {
            addCriterion("dep_time not like", value, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeIn(List<String> values) {
            addCriterion("dep_time in", values, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotIn(List<String> values) {
            addCriterion("dep_time not in", values, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeBetween(String value1, String value2) {
            addCriterion("dep_time between", value1, value2, "depTime");
            return (Criteria) this;
        }

        public Criteria andDepTimeNotBetween(String value1, String value2) {
            addCriterion("dep_time not between", value1, value2, "depTime");
            return (Criteria) this;
        }

        public Criteria andArrDateIsNull() {
            addCriterion("arr_date is null");
            return (Criteria) this;
        }

        public Criteria andArrDateIsNotNull() {
            addCriterion("arr_date is not null");
            return (Criteria) this;
        }

        public Criteria andArrDateEqualTo(String value) {
            addCriterion("arr_date =", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateNotEqualTo(String value) {
            addCriterion("arr_date <>", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateGreaterThan(String value) {
            addCriterion("arr_date >", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateGreaterThanOrEqualTo(String value) {
            addCriterion("arr_date >=", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateLessThan(String value) {
            addCriterion("arr_date <", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateLessThanOrEqualTo(String value) {
            addCriterion("arr_date <=", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateLike(String value) {
            addCriterion("arr_date like", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateNotLike(String value) {
            addCriterion("arr_date not like", value, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateIn(List<String> values) {
            addCriterion("arr_date in", values, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateNotIn(List<String> values) {
            addCriterion("arr_date not in", values, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateBetween(String value1, String value2) {
            addCriterion("arr_date between", value1, value2, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrDateNotBetween(String value1, String value2) {
            addCriterion("arr_date not between", value1, value2, "arrDate");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNull() {
            addCriterion("arr_time is null");
            return (Criteria) this;
        }

        public Criteria andArrTimeIsNotNull() {
            addCriterion("arr_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrTimeEqualTo(String value) {
            addCriterion("arr_time =", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotEqualTo(String value) {
            addCriterion("arr_time <>", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThan(String value) {
            addCriterion("arr_time >", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeGreaterThanOrEqualTo(String value) {
            addCriterion("arr_time >=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThan(String value) {
            addCriterion("arr_time <", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLessThanOrEqualTo(String value) {
            addCriterion("arr_time <=", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeLike(String value) {
            addCriterion("arr_time like", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotLike(String value) {
            addCriterion("arr_time not like", value, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeIn(List<String> values) {
            addCriterion("arr_time in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotIn(List<String> values) {
            addCriterion("arr_time not in", values, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeBetween(String value1, String value2) {
            addCriterion("arr_time between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andArrTimeNotBetween(String value1, String value2) {
            addCriterion("arr_time not between", value1, value2, "arrTime");
            return (Criteria) this;
        }

        public Criteria andStopAirportIsNull() {
            addCriterion("stop_airport is null");
            return (Criteria) this;
        }

        public Criteria andStopAirportIsNotNull() {
            addCriterion("stop_airport is not null");
            return (Criteria) this;
        }

        public Criteria andStopAirportEqualTo(String value) {
            addCriterion("stop_airport =", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportNotEqualTo(String value) {
            addCriterion("stop_airport <>", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportGreaterThan(String value) {
            addCriterion("stop_airport >", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportGreaterThanOrEqualTo(String value) {
            addCriterion("stop_airport >=", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportLessThan(String value) {
            addCriterion("stop_airport <", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportLessThanOrEqualTo(String value) {
            addCriterion("stop_airport <=", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportLike(String value) {
            addCriterion("stop_airport like", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportNotLike(String value) {
            addCriterion("stop_airport not like", value, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportIn(List<String> values) {
            addCriterion("stop_airport in", values, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportNotIn(List<String> values) {
            addCriterion("stop_airport not in", values, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportBetween(String value1, String value2) {
            addCriterion("stop_airport between", value1, value2, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andStopAirportNotBetween(String value1, String value2) {
            addCriterion("stop_airport not between", value1, value2, "stopAirport");
            return (Criteria) this;
        }

        public Criteria andMealIsNull() {
            addCriterion("meal is null");
            return (Criteria) this;
        }

        public Criteria andMealIsNotNull() {
            addCriterion("meal is not null");
            return (Criteria) this;
        }

        public Criteria andMealEqualTo(Integer value) {
            addCriterion("meal =", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealNotEqualTo(Integer value) {
            addCriterion("meal <>", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealGreaterThan(Integer value) {
            addCriterion("meal >", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealGreaterThanOrEqualTo(Integer value) {
            addCriterion("meal >=", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealLessThan(Integer value) {
            addCriterion("meal <", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealLessThanOrEqualTo(Integer value) {
            addCriterion("meal <=", value, "meal");
            return (Criteria) this;
        }

        public Criteria andMealIn(List<Integer> values) {
            addCriterion("meal in", values, "meal");
            return (Criteria) this;
        }

        public Criteria andMealNotIn(List<Integer> values) {
            addCriterion("meal not in", values, "meal");
            return (Criteria) this;
        }

        public Criteria andMealBetween(Integer value1, Integer value2) {
            addCriterion("meal between", value1, value2, "meal");
            return (Criteria) this;
        }

        public Criteria andMealNotBetween(Integer value1, Integer value2) {
            addCriterion("meal not between", value1, value2, "meal");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andPunctualityIsNull() {
            addCriterion("punctuality is null");
            return (Criteria) this;
        }

        public Criteria andPunctualityIsNotNull() {
            addCriterion("punctuality is not null");
            return (Criteria) this;
        }

        public Criteria andPunctualityEqualTo(Integer value) {
            addCriterion("punctuality =", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityNotEqualTo(Integer value) {
            addCriterion("punctuality <>", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityGreaterThan(Integer value) {
            addCriterion("punctuality >", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("punctuality >=", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityLessThan(Integer value) {
            addCriterion("punctuality <", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityLessThanOrEqualTo(Integer value) {
            addCriterion("punctuality <=", value, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityIn(List<Integer> values) {
            addCriterion("punctuality in", values, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityNotIn(List<Integer> values) {
            addCriterion("punctuality not in", values, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityBetween(Integer value1, Integer value2) {
            addCriterion("punctuality between", value1, value2, "punctuality");
            return (Criteria) this;
        }

        public Criteria andPunctualityNotBetween(Integer value1, Integer value2) {
            addCriterion("punctuality not between", value1, value2, "punctuality");
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