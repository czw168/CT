package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.List;

public class ShippingLabel2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShippingLabel2Example() {
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

        public Criteria andItemIsNull() {
            addCriterion("item is null");
            return (Criteria) this;
        }

        public Criteria andItemIsNotNull() {
            addCriterion("item is not null");
            return (Criteria) this;
        }

        public Criteria andItemEqualTo(Integer value) {
            addCriterion("item =", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotEqualTo(Integer value) {
            addCriterion("item <>", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThan(Integer value) {
            addCriterion("item >", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("item >=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThan(Integer value) {
            addCriterion("item <", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemLessThanOrEqualTo(Integer value) {
            addCriterion("item <=", value, "item");
            return (Criteria) this;
        }

        public Criteria andItemIn(List<Integer> values) {
            addCriterion("item in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotIn(List<Integer> values) {
            addCriterion("item not in", values, "item");
            return (Criteria) this;
        }

        public Criteria andItemBetween(Integer value1, Integer value2) {
            addCriterion("item between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andItemNotBetween(Integer value1, Integer value2) {
            addCriterion("item not between", value1, value2, "item");
            return (Criteria) this;
        }

        public Criteria andUbotPnIsNull() {
            addCriterion("ubot_pn is null");
            return (Criteria) this;
        }

        public Criteria andUbotPnIsNotNull() {
            addCriterion("ubot_pn is not null");
            return (Criteria) this;
        }

        public Criteria andUbotPnEqualTo(String value) {
            addCriterion("ubot_pn =", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnNotEqualTo(String value) {
            addCriterion("ubot_pn <>", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnGreaterThan(String value) {
            addCriterion("ubot_pn >", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnGreaterThanOrEqualTo(String value) {
            addCriterion("ubot_pn >=", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnLessThan(String value) {
            addCriterion("ubot_pn <", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnLessThanOrEqualTo(String value) {
            addCriterion("ubot_pn <=", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnLike(String value) {
            addCriterion("ubot_pn like", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnNotLike(String value) {
            addCriterion("ubot_pn not like", value, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnIn(List<String> values) {
            addCriterion("ubot_pn in", values, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnNotIn(List<String> values) {
            addCriterion("ubot_pn not in", values, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnBetween(String value1, String value2) {
            addCriterion("ubot_pn between", value1, value2, "ubotPn");
            return (Criteria) this;
        }

        public Criteria andUbotPnNotBetween(String value1, String value2) {
            addCriterion("ubot_pn not between", value1, value2, "ubotPn");
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

        public Criteria andUomIsNull() {
            addCriterion("uom is null");
            return (Criteria) this;
        }

        public Criteria andUomIsNotNull() {
            addCriterion("uom is not null");
            return (Criteria) this;
        }

        public Criteria andUomEqualTo(String value) {
            addCriterion("uom =", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomNotEqualTo(String value) {
            addCriterion("uom <>", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomGreaterThan(String value) {
            addCriterion("uom >", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomGreaterThanOrEqualTo(String value) {
            addCriterion("uom >=", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomLessThan(String value) {
            addCriterion("uom <", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomLessThanOrEqualTo(String value) {
            addCriterion("uom <=", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomLike(String value) {
            addCriterion("uom like", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomNotLike(String value) {
            addCriterion("uom not like", value, "uom");
            return (Criteria) this;
        }

        public Criteria andUomIn(List<String> values) {
            addCriterion("uom in", values, "uom");
            return (Criteria) this;
        }

        public Criteria andUomNotIn(List<String> values) {
            addCriterion("uom not in", values, "uom");
            return (Criteria) this;
        }

        public Criteria andUomBetween(String value1, String value2) {
            addCriterion("uom between", value1, value2, "uom");
            return (Criteria) this;
        }

        public Criteria andUomNotBetween(String value1, String value2) {
            addCriterion("uom not between", value1, value2, "uom");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andEtdDateIsNull() {
            addCriterion("etd_date is null");
            return (Criteria) this;
        }

        public Criteria andEtdDateIsNotNull() {
            addCriterion("etd_date is not null");
            return (Criteria) this;
        }

        public Criteria andEtdDateEqualTo(String value) {
            addCriterion("etd_date =", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateNotEqualTo(String value) {
            addCriterion("etd_date <>", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateGreaterThan(String value) {
            addCriterion("etd_date >", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateGreaterThanOrEqualTo(String value) {
            addCriterion("etd_date >=", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateLessThan(String value) {
            addCriterion("etd_date <", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateLessThanOrEqualTo(String value) {
            addCriterion("etd_date <=", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateLike(String value) {
            addCriterion("etd_date like", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateNotLike(String value) {
            addCriterion("etd_date not like", value, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateIn(List<String> values) {
            addCriterion("etd_date in", values, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateNotIn(List<String> values) {
            addCriterion("etd_date not in", values, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateBetween(String value1, String value2) {
            addCriterion("etd_date between", value1, value2, "etdDate");
            return (Criteria) this;
        }

        public Criteria andEtdDateNotBetween(String value1, String value2) {
            addCriterion("etd_date not between", value1, value2, "etdDate");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
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