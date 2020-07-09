package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PackingLabelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackingLabelExample() {
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

        public Criteria andCartonIsNull() {
            addCriterion("carton is null");
            return (Criteria) this;
        }

        public Criteria andCartonIsNotNull() {
            addCriterion("carton is not null");
            return (Criteria) this;
        }

        public Criteria andCartonEqualTo(String value) {
            addCriterion("carton =", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonNotEqualTo(String value) {
            addCriterion("carton <>", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonGreaterThan(String value) {
            addCriterion("carton >", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonGreaterThanOrEqualTo(String value) {
            addCriterion("carton >=", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonLessThan(String value) {
            addCriterion("carton <", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonLessThanOrEqualTo(String value) {
            addCriterion("carton <=", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonLike(String value) {
            addCriterion("carton like", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonNotLike(String value) {
            addCriterion("carton not like", value, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonIn(List<String> values) {
            addCriterion("carton in", values, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonNotIn(List<String> values) {
            addCriterion("carton not in", values, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonBetween(String value1, String value2) {
            addCriterion("carton between", value1, value2, "carton");
            return (Criteria) this;
        }

        public Criteria andCartonNotBetween(String value1, String value2) {
            addCriterion("carton not between", value1, value2, "carton");
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

        public Criteria andQ1IsNull() {
            addCriterion("q1 is null");
            return (Criteria) this;
        }

        public Criteria andQ1IsNotNull() {
            addCriterion("q1 is not null");
            return (Criteria) this;
        }

        public Criteria andQ1EqualTo(String value) {
            addCriterion("q1 =", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1NotEqualTo(String value) {
            addCriterion("q1 <>", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1GreaterThan(String value) {
            addCriterion("q1 >", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1GreaterThanOrEqualTo(String value) {
            addCriterion("q1 >=", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1LessThan(String value) {
            addCriterion("q1 <", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1LessThanOrEqualTo(String value) {
            addCriterion("q1 <=", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1Like(String value) {
            addCriterion("q1 like", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1NotLike(String value) {
            addCriterion("q1 not like", value, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1In(List<String> values) {
            addCriterion("q1 in", values, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1NotIn(List<String> values) {
            addCriterion("q1 not in", values, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1Between(String value1, String value2) {
            addCriterion("q1 between", value1, value2, "q1");
            return (Criteria) this;
        }

        public Criteria andQ1NotBetween(String value1, String value2) {
            addCriterion("q1 not between", value1, value2, "q1");
            return (Criteria) this;
        }

        public Criteria andQ2IsNull() {
            addCriterion("q2 is null");
            return (Criteria) this;
        }

        public Criteria andQ2IsNotNull() {
            addCriterion("q2 is not null");
            return (Criteria) this;
        }

        public Criteria andQ2EqualTo(String value) {
            addCriterion("q2 =", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2NotEqualTo(String value) {
            addCriterion("q2 <>", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2GreaterThan(String value) {
            addCriterion("q2 >", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2GreaterThanOrEqualTo(String value) {
            addCriterion("q2 >=", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2LessThan(String value) {
            addCriterion("q2 <", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2LessThanOrEqualTo(String value) {
            addCriterion("q2 <=", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2Like(String value) {
            addCriterion("q2 like", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2NotLike(String value) {
            addCriterion("q2 not like", value, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2In(List<String> values) {
            addCriterion("q2 in", values, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2NotIn(List<String> values) {
            addCriterion("q2 not in", values, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2Between(String value1, String value2) {
            addCriterion("q2 between", value1, value2, "q2");
            return (Criteria) this;
        }

        public Criteria andQ2NotBetween(String value1, String value2) {
            addCriterion("q2 not between", value1, value2, "q2");
            return (Criteria) this;
        }

        public Criteria andQ3IsNull() {
            addCriterion("q3 is null");
            return (Criteria) this;
        }

        public Criteria andQ3IsNotNull() {
            addCriterion("q3 is not null");
            return (Criteria) this;
        }

        public Criteria andQ3EqualTo(String value) {
            addCriterion("q3 =", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotEqualTo(String value) {
            addCriterion("q3 <>", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3GreaterThan(String value) {
            addCriterion("q3 >", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3GreaterThanOrEqualTo(String value) {
            addCriterion("q3 >=", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3LessThan(String value) {
            addCriterion("q3 <", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3LessThanOrEqualTo(String value) {
            addCriterion("q3 <=", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3Like(String value) {
            addCriterion("q3 like", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotLike(String value) {
            addCriterion("q3 not like", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3In(List<String> values) {
            addCriterion("q3 in", values, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotIn(List<String> values) {
            addCriterion("q3 not in", values, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3Between(String value1, String value2) {
            addCriterion("q3 between", value1, value2, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotBetween(String value1, String value2) {
            addCriterion("q3 not between", value1, value2, "q3");
            return (Criteria) this;
        }

        public Criteria andPackingDateIsNull() {
            addCriterion("packing_date is null");
            return (Criteria) this;
        }

        public Criteria andPackingDateIsNotNull() {
            addCriterion("packing_date is not null");
            return (Criteria) this;
        }

        public Criteria andPackingDateEqualTo(Date value) {
            addCriterionForJDBCDate("packing_date =", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("packing_date <>", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateGreaterThan(Date value) {
            addCriterionForJDBCDate("packing_date >", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("packing_date >=", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateLessThan(Date value) {
            addCriterionForJDBCDate("packing_date <", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("packing_date <=", value, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateIn(List<Date> values) {
            addCriterionForJDBCDate("packing_date in", values, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("packing_date not in", values, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("packing_date between", value1, value2, "packingDate");
            return (Criteria) this;
        }

        public Criteria andPackingDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("packing_date not between", value1, value2, "packingDate");
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