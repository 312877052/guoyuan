package cn.edu.glut.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WalletRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletRecordExample() {
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

        public Criteria andWalletRecordIdIsNull() {
            addCriterion("wallet_record_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdIsNotNull() {
            addCriterion("wallet_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdEqualTo(Integer value) {
            addCriterion("wallet_record_id =", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdNotEqualTo(Integer value) {
            addCriterion("wallet_record_id <>", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdGreaterThan(Integer value) {
            addCriterion("wallet_record_id >", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_record_id >=", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdLessThan(Integer value) {
            addCriterion("wallet_record_id <", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_record_id <=", value, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdIn(List<Integer> values) {
            addCriterion("wallet_record_id in", values, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdNotIn(List<Integer> values) {
            addCriterion("wallet_record_id not in", values, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("wallet_record_id between", value1, value2, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_record_id not between", value1, value2, "walletRecordId");
            return (Criteria) this;
        }

        public Criteria andWalletIdIsNull() {
            addCriterion("wallet_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletIdIsNotNull() {
            addCriterion("wallet_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletIdEqualTo(String value) {
            addCriterion("wallet_id =", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotEqualTo(String value) {
            addCriterion("wallet_id <>", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdGreaterThan(String value) {
            addCriterion("wallet_id >", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdGreaterThanOrEqualTo(String value) {
            addCriterion("wallet_id >=", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdLessThan(String value) {
            addCriterion("wallet_id <", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdLessThanOrEqualTo(String value) {
            addCriterion("wallet_id <=", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdLike(String value) {
            addCriterion("wallet_id like", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotLike(String value) {
            addCriterion("wallet_id not like", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdIn(List<String> values) {
            addCriterion("wallet_id in", values, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotIn(List<String> values) {
            addCriterion("wallet_id not in", values, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdBetween(String value1, String value2) {
            addCriterion("wallet_id between", value1, value2, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotBetween(String value1, String value2) {
            addCriterion("wallet_id not between", value1, value2, "walletId");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andTransactTimeIsNull() {
            addCriterion("transact_time is null");
            return (Criteria) this;
        }

        public Criteria andTransactTimeIsNotNull() {
            addCriterion("transact_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransactTimeEqualTo(Date value) {
            addCriterion("transact_time =", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeNotEqualTo(Date value) {
            addCriterion("transact_time <>", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeGreaterThan(Date value) {
            addCriterion("transact_time >", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("transact_time >=", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeLessThan(Date value) {
            addCriterion("transact_time <", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeLessThanOrEqualTo(Date value) {
            addCriterion("transact_time <=", value, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeIn(List<Date> values) {
            addCriterion("transact_time in", values, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeNotIn(List<Date> values) {
            addCriterion("transact_time not in", values, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeBetween(Date value1, Date value2) {
            addCriterion("transact_time between", value1, value2, "transactTime");
            return (Criteria) this;
        }

        public Criteria andTransactTimeNotBetween(Date value1, Date value2) {
            addCriterion("transact_time not between", value1, value2, "transactTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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