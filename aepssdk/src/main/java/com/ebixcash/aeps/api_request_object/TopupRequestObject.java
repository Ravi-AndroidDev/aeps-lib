package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class TopupRequestObject {

    private static TopupRequestObject topupRequestObject = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("machineIP")
    private String machineIP;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("requestAmount")
    private String requestAmount;

    @SerializedName("remark")
    private String remark;

    @SerializedName("paymentDateStr")
    private String paymentDate;

    @SerializedName("paymentMode")
    private String paymentMode;

    @SerializedName("bankName")
    private String bankName;

    @SerializedName("referenceNumber")
    private String referenceNumber;

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMachineIP() {
        return machineIP;
    }

    public void setMachineIP(String machineIP) {
        this.machineIP = machineIP;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public static TopupRequestObject getTopupRequestObjectObject() {

        if (topupRequestObject == null) {

            topupRequestObject = new TopupRequestObject();
        }

        return topupRequestObject;
    }

    public static void createTopupRequestObjectObject(String userName, String password, String machineIP, String accountId, String requestAmount, String remark, String paymentDate, String paymentMode, String bankName, String referenceNumber) {

        topupRequestObject = getTopupRequestObjectObject();

        topupRequestObject.setUserName(userName);

        topupRequestObject.setPassword(password);

        topupRequestObject.setMachineIP(machineIP);

        topupRequestObject.setAccountId(accountId);

        topupRequestObject.setRequestAmount(requestAmount);

        topupRequestObject.setRemark(remark);

        topupRequestObject.setPaymentDate(paymentDate);

        topupRequestObject.setPaymentMode(paymentMode);

        topupRequestObject.setBankName(bankName);

        topupRequestObject.setReferenceNumber(referenceNumber);
    }
}
