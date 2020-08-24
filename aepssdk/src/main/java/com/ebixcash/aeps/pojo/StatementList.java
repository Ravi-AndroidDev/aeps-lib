package com.ebixcash.aeps.pojo;

public class StatementList {

    private String orderID;

    private String easyTransactionID;

    private String pgOrderID;

    private String transactionDate;

    private String description;

    private String transactionType;

    private String amount;

    private String crOrDb;

    private String balance;

    private String merchantDescription;

    private String commission;

    private String tds;

    private String servicetax;

    private String conveienceFee;

    private String vat;

    private boolean isSelected = false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getEasyTransactionID() {
        return easyTransactionID;
    }

    public void setEasyTransactionID(String easyTransactionID) {
        this.easyTransactionID = easyTransactionID;
    }

    public String getPgOrderID() {
        return pgOrderID;
    }

    public void setPgOrderID(String pgOrderID) {
        this.pgOrderID = pgOrderID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCrOrDb() {
        return crOrDb;
    }

    public void setCrOrDb(String crOrDb) {
        this.crOrDb = crOrDb;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMerchantDescription() {
        return merchantDescription;
    }

    public void setMerchantDescription(String merchantDescription) {
        this.merchantDescription = merchantDescription;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getServicetax() {
        return servicetax;
    }

    public void setServicetax(String servicetax) {
        this.servicetax = servicetax;
    }

    public String getConveienceFee() {
        return conveienceFee;
    }

    public void setConveienceFee(String conveienceFee) {
        this.conveienceFee = conveienceFee;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
