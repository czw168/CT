package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductInfoExample() {
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

        public Criteria andDwgNoIsNull() {
            addCriterion("dwg_no is null");
            return (Criteria) this;
        }

        public Criteria andDwgNoIsNotNull() {
            addCriterion("dwg_no is not null");
            return (Criteria) this;
        }

        public Criteria andDwgNoEqualTo(String value) {
            addCriterion("dwg_no =", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoNotEqualTo(String value) {
            addCriterion("dwg_no <>", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoGreaterThan(String value) {
            addCriterion("dwg_no >", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoGreaterThanOrEqualTo(String value) {
            addCriterion("dwg_no >=", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoLessThan(String value) {
            addCriterion("dwg_no <", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoLessThanOrEqualTo(String value) {
            addCriterion("dwg_no <=", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoLike(String value) {
            addCriterion("dwg_no like", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoNotLike(String value) {
            addCriterion("dwg_no not like", value, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoIn(List<String> values) {
            addCriterion("dwg_no in", values, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoNotIn(List<String> values) {
            addCriterion("dwg_no not in", values, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoBetween(String value1, String value2) {
            addCriterion("dwg_no between", value1, value2, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andDwgNoNotBetween(String value1, String value2) {
            addCriterion("dwg_no not between", value1, value2, "dwgNo");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(String value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(String value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(String value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(String value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(String value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(String value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLike(String value) {
            addCriterion("length like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotLike(String value) {
            addCriterion("length not like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<String> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<String> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(String value1, String value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(String value1, String value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andA0IsNull() {
            addCriterion("a0 is null");
            return (Criteria) this;
        }

        public Criteria andA0IsNotNull() {
            addCriterion("a0 is not null");
            return (Criteria) this;
        }

        public Criteria andA0EqualTo(String value) {
            addCriterion("a0 =", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0NotEqualTo(String value) {
            addCriterion("a0 <>", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0GreaterThan(String value) {
            addCriterion("a0 >", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0GreaterThanOrEqualTo(String value) {
            addCriterion("a0 >=", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0LessThan(String value) {
            addCriterion("a0 <", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0LessThanOrEqualTo(String value) {
            addCriterion("a0 <=", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0Like(String value) {
            addCriterion("a0 like", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0NotLike(String value) {
            addCriterion("a0 not like", value, "a0");
            return (Criteria) this;
        }

        public Criteria andA0In(List<String> values) {
            addCriterion("a0 in", values, "a0");
            return (Criteria) this;
        }

        public Criteria andA0NotIn(List<String> values) {
            addCriterion("a0 not in", values, "a0");
            return (Criteria) this;
        }

        public Criteria andA0Between(String value1, String value2) {
            addCriterion("a0 between", value1, value2, "a0");
            return (Criteria) this;
        }

        public Criteria andA0NotBetween(String value1, String value2) {
            addCriterion("a0 not between", value1, value2, "a0");
            return (Criteria) this;
        }

        public Criteria andB0IsNull() {
            addCriterion("b0 is null");
            return (Criteria) this;
        }

        public Criteria andB0IsNotNull() {
            addCriterion("b0 is not null");
            return (Criteria) this;
        }

        public Criteria andB0EqualTo(String value) {
            addCriterion("b0 =", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotEqualTo(String value) {
            addCriterion("b0 <>", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0GreaterThan(String value) {
            addCriterion("b0 >", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0GreaterThanOrEqualTo(String value) {
            addCriterion("b0 >=", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0LessThan(String value) {
            addCriterion("b0 <", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0LessThanOrEqualTo(String value) {
            addCriterion("b0 <=", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0Like(String value) {
            addCriterion("b0 like", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotLike(String value) {
            addCriterion("b0 not like", value, "b0");
            return (Criteria) this;
        }

        public Criteria andB0In(List<String> values) {
            addCriterion("b0 in", values, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotIn(List<String> values) {
            addCriterion("b0 not in", values, "b0");
            return (Criteria) this;
        }

        public Criteria andB0Between(String value1, String value2) {
            addCriterion("b0 between", value1, value2, "b0");
            return (Criteria) this;
        }

        public Criteria andB0NotBetween(String value1, String value2) {
            addCriterion("b0 not between", value1, value2, "b0");
            return (Criteria) this;
        }

        public Criteria andK0IsNull() {
            addCriterion("k0 is null");
            return (Criteria) this;
        }

        public Criteria andK0IsNotNull() {
            addCriterion("k0 is not null");
            return (Criteria) this;
        }

        public Criteria andK0EqualTo(String value) {
            addCriterion("k0 =", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0NotEqualTo(String value) {
            addCriterion("k0 <>", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0GreaterThan(String value) {
            addCriterion("k0 >", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0GreaterThanOrEqualTo(String value) {
            addCriterion("k0 >=", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0LessThan(String value) {
            addCriterion("k0 <", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0LessThanOrEqualTo(String value) {
            addCriterion("k0 <=", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0Like(String value) {
            addCriterion("k0 like", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0NotLike(String value) {
            addCriterion("k0 not like", value, "k0");
            return (Criteria) this;
        }

        public Criteria andK0In(List<String> values) {
            addCriterion("k0 in", values, "k0");
            return (Criteria) this;
        }

        public Criteria andK0NotIn(List<String> values) {
            addCriterion("k0 not in", values, "k0");
            return (Criteria) this;
        }

        public Criteria andK0Between(String value1, String value2) {
            addCriterion("k0 between", value1, value2, "k0");
            return (Criteria) this;
        }

        public Criteria andK0NotBetween(String value1, String value2) {
            addCriterion("k0 not between", value1, value2, "k0");
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