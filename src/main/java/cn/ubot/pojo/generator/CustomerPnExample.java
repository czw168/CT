package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.List;

public class CustomerPnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerPnExample() {
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

        public Criteria andPnIsNull() {
            addCriterion("pn is null");
            return (Criteria) this;
        }

        public Criteria andPnIsNotNull() {
            addCriterion("pn is not null");
            return (Criteria) this;
        }

        public Criteria andPnEqualTo(String value) {
            addCriterion("pn =", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotEqualTo(String value) {
            addCriterion("pn <>", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThan(String value) {
            addCriterion("pn >", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThanOrEqualTo(String value) {
            addCriterion("pn >=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThan(String value) {
            addCriterion("pn <", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThanOrEqualTo(String value) {
            addCriterion("pn <=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLike(String value) {
            addCriterion("pn like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotLike(String value) {
            addCriterion("pn not like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnIn(List<String> values) {
            addCriterion("pn in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotIn(List<String> values) {
            addCriterion("pn not in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnBetween(String value1, String value2) {
            addCriterion("pn between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotBetween(String value1, String value2) {
            addCriterion("pn not between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIsNull() {
            addCriterion("customer_pn is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIsNotNull() {
            addCriterion("customer_pn is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPnEqualTo(String value) {
            addCriterion("customer_pn =", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotEqualTo(String value) {
            addCriterion("customer_pn <>", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnGreaterThan(String value) {
            addCriterion("customer_pn >", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnGreaterThanOrEqualTo(String value) {
            addCriterion("customer_pn >=", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLessThan(String value) {
            addCriterion("customer_pn <", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLessThanOrEqualTo(String value) {
            addCriterion("customer_pn <=", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLike(String value) {
            addCriterion("customer_pn like", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotLike(String value) {
            addCriterion("customer_pn not like", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIn(List<String> values) {
            addCriterion("customer_pn in", values, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotIn(List<String> values) {
            addCriterion("customer_pn not in", values, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnBetween(String value1, String value2) {
            addCriterion("customer_pn between", value1, value2, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotBetween(String value1, String value2) {
            addCriterion("customer_pn not between", value1, value2, "customerPn");
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