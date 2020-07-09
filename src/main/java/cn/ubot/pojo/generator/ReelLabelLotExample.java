package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.List;

public class ReelLabelLotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReelLabelLotExample() {
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

        public Criteria andLtcIsNull() {
            addCriterion("ltc is null");
            return (Criteria) this;
        }

        public Criteria andLtcIsNotNull() {
            addCriterion("ltc is not null");
            return (Criteria) this;
        }

        public Criteria andLtcEqualTo(String value) {
            addCriterion("ltc =", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcNotEqualTo(String value) {
            addCriterion("ltc <>", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcGreaterThan(String value) {
            addCriterion("ltc >", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcGreaterThanOrEqualTo(String value) {
            addCriterion("ltc >=", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcLessThan(String value) {
            addCriterion("ltc <", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcLessThanOrEqualTo(String value) {
            addCriterion("ltc <=", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcLike(String value) {
            addCriterion("ltc like", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcNotLike(String value) {
            addCriterion("ltc not like", value, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcIn(List<String> values) {
            addCriterion("ltc in", values, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcNotIn(List<String> values) {
            addCriterion("ltc not in", values, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcBetween(String value1, String value2) {
            addCriterion("ltc between", value1, value2, "ltc");
            return (Criteria) this;
        }

        public Criteria andLtcNotBetween(String value1, String value2) {
            addCriterion("ltc not between", value1, value2, "ltc");
            return (Criteria) this;
        }

        public Criteria andLotNoIsNull() {
            addCriterion("lot_no is null");
            return (Criteria) this;
        }

        public Criteria andLotNoIsNotNull() {
            addCriterion("lot_no is not null");
            return (Criteria) this;
        }

        public Criteria andLotNoEqualTo(String value) {
            addCriterion("lot_no =", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotEqualTo(String value) {
            addCriterion("lot_no <>", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThan(String value) {
            addCriterion("lot_no >", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThanOrEqualTo(String value) {
            addCriterion("lot_no >=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThan(String value) {
            addCriterion("lot_no <", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThanOrEqualTo(String value) {
            addCriterion("lot_no <=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLike(String value) {
            addCriterion("lot_no like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotLike(String value) {
            addCriterion("lot_no not like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoIn(List<String> values) {
            addCriterion("lot_no in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotIn(List<String> values) {
            addCriterion("lot_no not in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoBetween(String value1, String value2) {
            addCriterion("lot_no between", value1, value2, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotBetween(String value1, String value2) {
            addCriterion("lot_no not between", value1, value2, "lotNo");
            return (Criteria) this;
        }

        public Criteria andMachineIsNull() {
            addCriterion("machine is null");
            return (Criteria) this;
        }

        public Criteria andMachineIsNotNull() {
            addCriterion("machine is not null");
            return (Criteria) this;
        }

        public Criteria andMachineEqualTo(String value) {
            addCriterion("machine =", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotEqualTo(String value) {
            addCriterion("machine <>", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThan(String value) {
            addCriterion("machine >", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineGreaterThanOrEqualTo(String value) {
            addCriterion("machine >=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThan(String value) {
            addCriterion("machine <", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLessThanOrEqualTo(String value) {
            addCriterion("machine <=", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineLike(String value) {
            addCriterion("machine like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotLike(String value) {
            addCriterion("machine not like", value, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineIn(List<String> values) {
            addCriterion("machine in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotIn(List<String> values) {
            addCriterion("machine not in", values, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineBetween(String value1, String value2) {
            addCriterion("machine between", value1, value2, "machine");
            return (Criteria) this;
        }

        public Criteria andMachineNotBetween(String value1, String value2) {
            addCriterion("machine not between", value1, value2, "machine");
            return (Criteria) this;
        }

        public Criteria andProductionDateIsNull() {
            addCriterion("production_date is null");
            return (Criteria) this;
        }

        public Criteria andProductionDateIsNotNull() {
            addCriterion("production_date is not null");
            return (Criteria) this;
        }

        public Criteria andProductionDateEqualTo(String value) {
            addCriterion("production_date =", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotEqualTo(String value) {
            addCriterion("production_date <>", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThan(String value) {
            addCriterion("production_date >", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThanOrEqualTo(String value) {
            addCriterion("production_date >=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThan(String value) {
            addCriterion("production_date <", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThanOrEqualTo(String value) {
            addCriterion("production_date <=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLike(String value) {
            addCriterion("production_date like", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotLike(String value) {
            addCriterion("production_date not like", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateIn(List<String> values) {
            addCriterion("production_date in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotIn(List<String> values) {
            addCriterion("production_date not in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateBetween(String value1, String value2) {
            addCriterion("production_date between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotBetween(String value1, String value2) {
            addCriterion("production_date not between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andLaneIsNull() {
            addCriterion("lane is null");
            return (Criteria) this;
        }

        public Criteria andLaneIsNotNull() {
            addCriterion("lane is not null");
            return (Criteria) this;
        }

        public Criteria andLaneEqualTo(String value) {
            addCriterion("lane =", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotEqualTo(String value) {
            addCriterion("lane <>", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThan(String value) {
            addCriterion("lane >", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThanOrEqualTo(String value) {
            addCriterion("lane >=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThan(String value) {
            addCriterion("lane <", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThanOrEqualTo(String value) {
            addCriterion("lane <=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLike(String value) {
            addCriterion("lane like", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotLike(String value) {
            addCriterion("lane not like", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneIn(List<String> values) {
            addCriterion("lane in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotIn(List<String> values) {
            addCriterion("lane not in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneBetween(String value1, String value2) {
            addCriterion("lane between", value1, value2, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotBetween(String value1, String value2) {
            addCriterion("lane not between", value1, value2, "lane");
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