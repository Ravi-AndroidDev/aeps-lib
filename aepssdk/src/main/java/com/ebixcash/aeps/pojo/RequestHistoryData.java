package com.ebixcash.aeps.pojo;

public class RequestHistoryData {

    private String approverFirmName;

    private String requesterFirmName;

    private String accountTypeName;

    private String accountNumber;

    private String requestAmount;

    private String reqDate;

    private String aprDate;

    private String statusFullName;

    private String jvId;

    private boolean isSelected = false;

    private String customerRequesterFirmName;

    private String customerRequesterName;

    private String requesterCity;

    private String rejectionRemark;

    public String getRejectionRemark() {
        return rejectionRemark;
    }

    public void setRejectionRemark(String rejectionRemark) {
        this.rejectionRemark = rejectionRemark;
    }

    public String getCustomerRequesterFirmName() {
        return customerRequesterFirmName;
    }

    public void setCustomerRequesterFirmName(String customerRequesterFirmName) {
        this.customerRequesterFirmName = customerRequesterFirmName;
    }

    public String getCustomerRequesterName() {
        return customerRequesterName;
    }

    public void setCustomerRequesterName(String customerRequesterName) {
        this.customerRequesterName = customerRequesterName;
    }

    public String getRequesterCity() {
        return requesterCity;
    }

    public void setRequesterCity(String requesterCity) {
        this.requesterCity = requesterCity;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getApproverFirmName() {
        return approverFirmName;
    }

    public void setApproverFirmName(String approverFirmName) {
        this.approverFirmName = approverFirmName;
    }

    public String getRequesterFirmName() {
        return requesterFirmName;
    }

    public void setRequesterFirmName(String requesterFirmName) {
        this.requesterFirmName = requesterFirmName;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getAprDate() {
        return aprDate;
    }

    public void setAprDate(String aprDate) {
        this.aprDate = aprDate;
    }

    public String getStatusFullName() {
        return statusFullName;
    }

    public void setStatusFullName(String statusFullName) {
        this.statusFullName = statusFullName;
    }

    public String getJvId() {
        return jvId;
    }

    public void setJvId(String jvId) {
        this.jvId = jvId;
    }
}
