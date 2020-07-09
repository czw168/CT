package cn.ubot.pojo.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LtcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LtcExample() {
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

        public Criteria andJoNoIsNull() {
            addCriterion("jo_no is null");
            return (Criteria) this;
        }

        public Criteria andJoNoIsNotNull() {
            addCriterion("jo_no is not null");
            return (Criteria) this;
        }

        public Criteria andJoNoEqualTo(String value) {
            addCriterion("jo_no =", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoNotEqualTo(String value) {
            addCriterion("jo_no <>", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoGreaterThan(String value) {
            addCriterion("jo_no >", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoGreaterThanOrEqualTo(String value) {
            addCriterion("jo_no >=", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoLessThan(String value) {
            addCriterion("jo_no <", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoLessThanOrEqualTo(String value) {
            addCriterion("jo_no <=", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoLike(String value) {
            addCriterion("jo_no like", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoNotLike(String value) {
            addCriterion("jo_no not like", value, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoIn(List<String> values) {
            addCriterion("jo_no in", values, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoNotIn(List<String> values) {
            addCriterion("jo_no not in", values, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoBetween(String value1, String value2) {
            addCriterion("jo_no between", value1, value2, "joNo");
            return (Criteria) this;
        }

        public Criteria andJoNoNotBetween(String value1, String value2) {
            addCriterion("jo_no not between", value1, value2, "joNo");
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

        public Criteria andCustPnIsNull() {
            addCriterion("cust_pn is null");
            return (Criteria) this;
        }

        public Criteria andCustPnIsNotNull() {
            addCriterion("cust_pn is not null");
            return (Criteria) this;
        }

        public Criteria andCustPnEqualTo(String value) {
            addCriterion("cust_pn =", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnNotEqualTo(String value) {
            addCriterion("cust_pn <>", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnGreaterThan(String value) {
            addCriterion("cust_pn >", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnGreaterThanOrEqualTo(String value) {
            addCriterion("cust_pn >=", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnLessThan(String value) {
            addCriterion("cust_pn <", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnLessThanOrEqualTo(String value) {
            addCriterion("cust_pn <=", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnLike(String value) {
            addCriterion("cust_pn like", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnNotLike(String value) {
            addCriterion("cust_pn not like", value, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnIn(List<String> values) {
            addCriterion("cust_pn in", values, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnNotIn(List<String> values) {
            addCriterion("cust_pn not in", values, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnBetween(String value1, String value2) {
            addCriterion("cust_pn between", value1, value2, "custPn");
            return (Criteria) this;
        }

        public Criteria andCustPnNotBetween(String value1, String value2) {
            addCriterion("cust_pn not between", value1, value2, "custPn");
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

        public Criteria andLaneEqualTo(Integer value) {
            addCriterion("lane =", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotEqualTo(Integer value) {
            addCriterion("lane <>", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThan(Integer value) {
            addCriterion("lane >", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThanOrEqualTo(Integer value) {
            addCriterion("lane >=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThan(Integer value) {
            addCriterion("lane <", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThanOrEqualTo(Integer value) {
            addCriterion("lane <=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneIn(List<Integer> values) {
            addCriterion("lane in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotIn(List<Integer> values) {
            addCriterion("lane not in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneBetween(Integer value1, Integer value2) {
            addCriterion("lane between", value1, value2, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotBetween(Integer value1, Integer value2) {
            addCriterion("lane not between", value1, value2, "lane");
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

        public Criteria andPuchingToolIsNull() {
            addCriterion("puching_tool is null");
            return (Criteria) this;
        }

        public Criteria andPuchingToolIsNotNull() {
            addCriterion("puching_tool is not null");
            return (Criteria) this;
        }

        public Criteria andPuchingToolEqualTo(String value) {
            addCriterion("puching_tool =", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolNotEqualTo(String value) {
            addCriterion("puching_tool <>", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolGreaterThan(String value) {
            addCriterion("puching_tool >", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolGreaterThanOrEqualTo(String value) {
            addCriterion("puching_tool >=", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolLessThan(String value) {
            addCriterion("puching_tool <", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolLessThanOrEqualTo(String value) {
            addCriterion("puching_tool <=", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolLike(String value) {
            addCriterion("puching_tool like", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolNotLike(String value) {
            addCriterion("puching_tool not like", value, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolIn(List<String> values) {
            addCriterion("puching_tool in", values, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolNotIn(List<String> values) {
            addCriterion("puching_tool not in", values, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolBetween(String value1, String value2) {
            addCriterion("puching_tool between", value1, value2, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andPuchingToolNotBetween(String value1, String value2) {
            addCriterion("puching_tool not between", value1, value2, "puchingTool");
            return (Criteria) this;
        }

        public Criteria andMaterialLotIsNull() {
            addCriterion("material_lot is null");
            return (Criteria) this;
        }

        public Criteria andMaterialLotIsNotNull() {
            addCriterion("material_lot is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialLotEqualTo(String value) {
            addCriterion("material_lot =", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotNotEqualTo(String value) {
            addCriterion("material_lot <>", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotGreaterThan(String value) {
            addCriterion("material_lot >", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotGreaterThanOrEqualTo(String value) {
            addCriterion("material_lot >=", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotLessThan(String value) {
            addCriterion("material_lot <", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotLessThanOrEqualTo(String value) {
            addCriterion("material_lot <=", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotLike(String value) {
            addCriterion("material_lot like", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotNotLike(String value) {
            addCriterion("material_lot not like", value, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotIn(List<String> values) {
            addCriterion("material_lot in", values, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotNotIn(List<String> values) {
            addCriterion("material_lot not in", values, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotBetween(String value1, String value2) {
            addCriterion("material_lot between", value1, value2, "materialLot");
            return (Criteria) this;
        }

        public Criteria andMaterialLotNotBetween(String value1, String value2) {
            addCriterion("material_lot not between", value1, value2, "materialLot");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeIsNull() {
            addCriterion("source_batch_code is null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeIsNotNull() {
            addCriterion("source_batch_code is not null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeEqualTo(String value) {
            addCriterion("source_batch_code =", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeNotEqualTo(String value) {
            addCriterion("source_batch_code <>", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeGreaterThan(String value) {
            addCriterion("source_batch_code >", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("source_batch_code >=", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeLessThan(String value) {
            addCriterion("source_batch_code <", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeLessThanOrEqualTo(String value) {
            addCriterion("source_batch_code <=", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeLike(String value) {
            addCriterion("source_batch_code like", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeNotLike(String value) {
            addCriterion("source_batch_code not like", value, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeIn(List<String> values) {
            addCriterion("source_batch_code in", values, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeNotIn(List<String> values) {
            addCriterion("source_batch_code not in", values, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeBetween(String value1, String value2) {
            addCriterion("source_batch_code between", value1, value2, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andSourceBatchCodeNotBetween(String value1, String value2) {
            addCriterion("source_batch_code not between", value1, value2, "sourceBatchCode");
            return (Criteria) this;
        }

        public Criteria andLotTypeIsNull() {
            addCriterion("lot_type is null");
            return (Criteria) this;
        }

        public Criteria andLotTypeIsNotNull() {
            addCriterion("lot_type is not null");
            return (Criteria) this;
        }

        public Criteria andLotTypeEqualTo(String value) {
            addCriterion("lot_type =", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeNotEqualTo(String value) {
            addCriterion("lot_type <>", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeGreaterThan(String value) {
            addCriterion("lot_type >", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lot_type >=", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeLessThan(String value) {
            addCriterion("lot_type <", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeLessThanOrEqualTo(String value) {
            addCriterion("lot_type <=", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeLike(String value) {
            addCriterion("lot_type like", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeNotLike(String value) {
            addCriterion("lot_type not like", value, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeIn(List<String> values) {
            addCriterion("lot_type in", values, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeNotIn(List<String> values) {
            addCriterion("lot_type not in", values, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeBetween(String value1, String value2) {
            addCriterion("lot_type between", value1, value2, "lotType");
            return (Criteria) this;
        }

        public Criteria andLotTypeNotBetween(String value1, String value2) {
            addCriterion("lot_type not between", value1, value2, "lotType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
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

        public Criteria andProductionDateIsNull() {
            addCriterion("production_date is null");
            return (Criteria) this;
        }

        public Criteria andProductionDateIsNotNull() {
            addCriterion("production_date is not null");
            return (Criteria) this;
        }

        public Criteria andProductionDateEqualTo(Date value) {
            addCriterion("production_date =", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotEqualTo(Date value) {
            addCriterion("production_date <>", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThan(Date value) {
            addCriterion("production_date >", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("production_date >=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThan(Date value) {
            addCriterion("production_date <", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThanOrEqualTo(Date value) {
            addCriterion("production_date <=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateIn(List<Date> values) {
            addCriterion("production_date in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotIn(List<Date> values) {
            addCriterion("production_date not in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateBetween(Date value1, Date value2) {
            addCriterion("production_date between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotBetween(Date value1, Date value2) {
            addCriterion("production_date not between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andLotSericsIsNull() {
            addCriterion("lot_serics is null");
            return (Criteria) this;
        }

        public Criteria andLotSericsIsNotNull() {
            addCriterion("lot_serics is not null");
            return (Criteria) this;
        }

        public Criteria andLotSericsEqualTo(String value) {
            addCriterion("lot_serics =", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsNotEqualTo(String value) {
            addCriterion("lot_serics <>", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsGreaterThan(String value) {
            addCriterion("lot_serics >", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsGreaterThanOrEqualTo(String value) {
            addCriterion("lot_serics >=", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsLessThan(String value) {
            addCriterion("lot_serics <", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsLessThanOrEqualTo(String value) {
            addCriterion("lot_serics <=", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsLike(String value) {
            addCriterion("lot_serics like", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsNotLike(String value) {
            addCriterion("lot_serics not like", value, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsIn(List<String> values) {
            addCriterion("lot_serics in", values, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsNotIn(List<String> values) {
            addCriterion("lot_serics not in", values, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsBetween(String value1, String value2) {
            addCriterion("lot_serics between", value1, value2, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andLotSericsNotBetween(String value1, String value2) {
            addCriterion("lot_serics not between", value1, value2, "lotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsIsNull() {
            addCriterion("sublot_serics is null");
            return (Criteria) this;
        }

        public Criteria andSublotSericsIsNotNull() {
            addCriterion("sublot_serics is not null");
            return (Criteria) this;
        }

        public Criteria andSublotSericsEqualTo(String value) {
            addCriterion("sublot_serics =", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsNotEqualTo(String value) {
            addCriterion("sublot_serics <>", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsGreaterThan(String value) {
            addCriterion("sublot_serics >", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsGreaterThanOrEqualTo(String value) {
            addCriterion("sublot_serics >=", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsLessThan(String value) {
            addCriterion("sublot_serics <", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsLessThanOrEqualTo(String value) {
            addCriterion("sublot_serics <=", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsLike(String value) {
            addCriterion("sublot_serics like", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsNotLike(String value) {
            addCriterion("sublot_serics not like", value, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsIn(List<String> values) {
            addCriterion("sublot_serics in", values, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsNotIn(List<String> values) {
            addCriterion("sublot_serics not in", values, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsBetween(String value1, String value2) {
            addCriterion("sublot_serics between", value1, value2, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andSublotSericsNotBetween(String value1, String value2) {
            addCriterion("sublot_serics not between", value1, value2, "sublotSerics");
            return (Criteria) this;
        }

        public Criteria andFormingToolIsNull() {
            addCriterion("forming_tool is null");
            return (Criteria) this;
        }

        public Criteria andFormingToolIsNotNull() {
            addCriterion("forming_tool is not null");
            return (Criteria) this;
        }

        public Criteria andFormingToolEqualTo(String value) {
            addCriterion("forming_tool =", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolNotEqualTo(String value) {
            addCriterion("forming_tool <>", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolGreaterThan(String value) {
            addCriterion("forming_tool >", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolGreaterThanOrEqualTo(String value) {
            addCriterion("forming_tool >=", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolLessThan(String value) {
            addCriterion("forming_tool <", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolLessThanOrEqualTo(String value) {
            addCriterion("forming_tool <=", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolLike(String value) {
            addCriterion("forming_tool like", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolNotLike(String value) {
            addCriterion("forming_tool not like", value, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolIn(List<String> values) {
            addCriterion("forming_tool in", values, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolNotIn(List<String> values) {
            addCriterion("forming_tool not in", values, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolBetween(String value1, String value2) {
            addCriterion("forming_tool between", value1, value2, "formingTool");
            return (Criteria) this;
        }

        public Criteria andFormingToolNotBetween(String value1, String value2) {
            addCriterion("forming_tool not between", value1, value2, "formingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolIsNull() {
            addCriterion("scitting_tool is null");
            return (Criteria) this;
        }

        public Criteria andScittingToolIsNotNull() {
            addCriterion("scitting_tool is not null");
            return (Criteria) this;
        }

        public Criteria andScittingToolEqualTo(String value) {
            addCriterion("scitting_tool =", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolNotEqualTo(String value) {
            addCriterion("scitting_tool <>", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolGreaterThan(String value) {
            addCriterion("scitting_tool >", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolGreaterThanOrEqualTo(String value) {
            addCriterion("scitting_tool >=", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolLessThan(String value) {
            addCriterion("scitting_tool <", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolLessThanOrEqualTo(String value) {
            addCriterion("scitting_tool <=", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolLike(String value) {
            addCriterion("scitting_tool like", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolNotLike(String value) {
            addCriterion("scitting_tool not like", value, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolIn(List<String> values) {
            addCriterion("scitting_tool in", values, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolNotIn(List<String> values) {
            addCriterion("scitting_tool not in", values, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolBetween(String value1, String value2) {
            addCriterion("scitting_tool between", value1, value2, "scittingTool");
            return (Criteria) this;
        }

        public Criteria andScittingToolNotBetween(String value1, String value2) {
            addCriterion("scitting_tool not between", value1, value2, "scittingTool");
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