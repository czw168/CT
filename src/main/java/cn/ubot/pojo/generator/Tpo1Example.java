package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Tpo1Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Tpo1Example() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCustomerIsNull() {
            addCriterion("customer is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("customer is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("customer =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("customer <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("customer >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("customer >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("customer <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("customer <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("customer like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("customer not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("customer in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("customer not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("customer between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("customer not between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andBillToIsNull() {
            addCriterion("bill_to is null");
            return (Criteria) this;
        }

        public Criteria andBillToIsNotNull() {
            addCriterion("bill_to is not null");
            return (Criteria) this;
        }

        public Criteria andBillToEqualTo(String value) {
            addCriterion("bill_to =", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToNotEqualTo(String value) {
            addCriterion("bill_to <>", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToGreaterThan(String value) {
            addCriterion("bill_to >", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToGreaterThanOrEqualTo(String value) {
            addCriterion("bill_to >=", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToLessThan(String value) {
            addCriterion("bill_to <", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToLessThanOrEqualTo(String value) {
            addCriterion("bill_to <=", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToLike(String value) {
            addCriterion("bill_to like", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToNotLike(String value) {
            addCriterion("bill_to not like", value, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToIn(List<String> values) {
            addCriterion("bill_to in", values, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToNotIn(List<String> values) {
            addCriterion("bill_to not in", values, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToBetween(String value1, String value2) {
            addCriterion("bill_to between", value1, value2, "billTo");
            return (Criteria) this;
        }

        public Criteria andBillToNotBetween(String value1, String value2) {
            addCriterion("bill_to not between", value1, value2, "billTo");
            return (Criteria) this;
        }

        public Criteria andShipToIsNull() {
            addCriterion("ship_to is null");
            return (Criteria) this;
        }

        public Criteria andShipToIsNotNull() {
            addCriterion("ship_to is not null");
            return (Criteria) this;
        }

        public Criteria andShipToEqualTo(String value) {
            addCriterion("ship_to =", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotEqualTo(String value) {
            addCriterion("ship_to <>", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThan(String value) {
            addCriterion("ship_to >", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThanOrEqualTo(String value) {
            addCriterion("ship_to >=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThan(String value) {
            addCriterion("ship_to <", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThanOrEqualTo(String value) {
            addCriterion("ship_to <=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLike(String value) {
            addCriterion("ship_to like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotLike(String value) {
            addCriterion("ship_to not like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToIn(List<String> values) {
            addCriterion("ship_to in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotIn(List<String> values) {
            addCriterion("ship_to not in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToBetween(String value1, String value2) {
            addCriterion("ship_to between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotBetween(String value1, String value2) {
            addCriterion("ship_to not between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andTpoIsNull() {
            addCriterion("tpo is null");
            return (Criteria) this;
        }

        public Criteria andTpoIsNotNull() {
            addCriterion("tpo is not null");
            return (Criteria) this;
        }

        public Criteria andTpoEqualTo(String value) {
            addCriterion("tpo =", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoNotEqualTo(String value) {
            addCriterion("tpo <>", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoGreaterThan(String value) {
            addCriterion("tpo >", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoGreaterThanOrEqualTo(String value) {
            addCriterion("tpo >=", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoLessThan(String value) {
            addCriterion("tpo <", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoLessThanOrEqualTo(String value) {
            addCriterion("tpo <=", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoLike(String value) {
            addCriterion("tpo like", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoNotLike(String value) {
            addCriterion("tpo not like", value, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoIn(List<String> values) {
            addCriterion("tpo in", values, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoNotIn(List<String> values) {
            addCriterion("tpo not in", values, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoBetween(String value1, String value2) {
            addCriterion("tpo between", value1, value2, "tpo");
            return (Criteria) this;
        }

        public Criteria andTpoNotBetween(String value1, String value2) {
            addCriterion("tpo not between", value1, value2, "tpo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoIsNull() {
            addCriterion("customer_po is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPoIsNotNull() {
            addCriterion("customer_po is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPoEqualTo(String value) {
            addCriterion("customer_po =", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoNotEqualTo(String value) {
            addCriterion("customer_po <>", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoGreaterThan(String value) {
            addCriterion("customer_po >", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_po >=", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoLessThan(String value) {
            addCriterion("customer_po <", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoLessThanOrEqualTo(String value) {
            addCriterion("customer_po <=", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoLike(String value) {
            addCriterion("customer_po like", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoNotLike(String value) {
            addCriterion("customer_po not like", value, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoIn(List<String> values) {
            addCriterion("customer_po in", values, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoNotIn(List<String> values) {
            addCriterion("customer_po not in", values, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoBetween(String value1, String value2) {
            addCriterion("customer_po between", value1, value2, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCustomerPoNotBetween(String value1, String value2) {
            addCriterion("customer_po not between", value1, value2, "customerPo");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andTermsIsNull() {
            addCriterion("terms is null");
            return (Criteria) this;
        }

        public Criteria andTermsIsNotNull() {
            addCriterion("terms is not null");
            return (Criteria) this;
        }

        public Criteria andTermsEqualTo(String value) {
            addCriterion("terms =", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsNotEqualTo(String value) {
            addCriterion("terms <>", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsGreaterThan(String value) {
            addCriterion("terms >", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsGreaterThanOrEqualTo(String value) {
            addCriterion("terms >=", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsLessThan(String value) {
            addCriterion("terms <", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsLessThanOrEqualTo(String value) {
            addCriterion("terms <=", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsLike(String value) {
            addCriterion("terms like", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsNotLike(String value) {
            addCriterion("terms not like", value, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsIn(List<String> values) {
            addCriterion("terms in", values, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsNotIn(List<String> values) {
            addCriterion("terms not in", values, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsBetween(String value1, String value2) {
            addCriterion("terms between", value1, value2, "terms");
            return (Criteria) this;
        }

        public Criteria andTermsNotBetween(String value1, String value2) {
            addCriterion("terms not between", value1, value2, "terms");
            return (Criteria) this;
        }

        public Criteria andShipmodeIsNull() {
            addCriterion("shipmode is null");
            return (Criteria) this;
        }

        public Criteria andShipmodeIsNotNull() {
            addCriterion("shipmode is not null");
            return (Criteria) this;
        }

        public Criteria andShipmodeEqualTo(String value) {
            addCriterion("shipmode =", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeNotEqualTo(String value) {
            addCriterion("shipmode <>", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeGreaterThan(String value) {
            addCriterion("shipmode >", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipmode >=", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeLessThan(String value) {
            addCriterion("shipmode <", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeLessThanOrEqualTo(String value) {
            addCriterion("shipmode <=", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeLike(String value) {
            addCriterion("shipmode like", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeNotLike(String value) {
            addCriterion("shipmode not like", value, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeIn(List<String> values) {
            addCriterion("shipmode in", values, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeNotIn(List<String> values) {
            addCriterion("shipmode not in", values, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeBetween(String value1, String value2) {
            addCriterion("shipmode between", value1, value2, "shipmode");
            return (Criteria) this;
        }

        public Criteria andShipmodeNotBetween(String value1, String value2) {
            addCriterion("shipmode not between", value1, value2, "shipmode");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateIsNull() {
            addCriterion("required_shipdate is null");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateIsNotNull() {
            addCriterion("required_shipdate is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateEqualTo(String value) {
            addCriterion("required_shipdate =", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateNotEqualTo(String value) {
            addCriterion("required_shipdate <>", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateGreaterThan(String value) {
            addCriterion("required_shipdate >", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateGreaterThanOrEqualTo(String value) {
            addCriterion("required_shipdate >=", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateLessThan(String value) {
            addCriterion("required_shipdate <", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateLessThanOrEqualTo(String value) {
            addCriterion("required_shipdate <=", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateLike(String value) {
            addCriterion("required_shipdate like", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateNotLike(String value) {
            addCriterion("required_shipdate not like", value, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateIn(List<String> values) {
            addCriterion("required_shipdate in", values, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateNotIn(List<String> values) {
            addCriterion("required_shipdate not in", values, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateBetween(String value1, String value2) {
            addCriterion("required_shipdate between", value1, value2, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andRequiredShipdateNotBetween(String value1, String value2) {
            addCriterion("required_shipdate not between", value1, value2, "requiredShipdate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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