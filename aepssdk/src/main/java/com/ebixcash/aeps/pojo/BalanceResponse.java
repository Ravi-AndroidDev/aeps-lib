package com.ebixcash.aeps.pojo;

public class BalanceResponse {

    private String mATMReqId;

    private String responseCode;

    private String rrn;

    private String acBalance;

    private String agentId;

    private String txnStatus;

    private String bcLocation;

    private String txnAmount;

    private String responseMessage;

    private String terminalId;

    private String aadhaarNo;

    private String stan;

    private String uidaiAuthCode;

    private String dateAndTime;

    private String bcName;

    private String crId;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getmATMReqId() {
        return mATMReqId;
    }

    public void setmATMReqId(String mATMReqId) {
        this.mATMReqId = mATMReqId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getAcBalance() {
        return acBalance;
    }

    public void setAcBalance(String acBalance) {
        this.acBalance = acBalance;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getBcLocation() {
        return bcLocation;
    }

    public void setBcLocation(String bcLocation) {
        this.bcLocation = bcLocation;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getUidaiAuthCode() {
        return uidaiAuthCode;
    }

    public void setUidaiAuthCode(String uidaiAuthCode) {
        this.uidaiAuthCode = uidaiAuthCode;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName;
    }

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }
}
