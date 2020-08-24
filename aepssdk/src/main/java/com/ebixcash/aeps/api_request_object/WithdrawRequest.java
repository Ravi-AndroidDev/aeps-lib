package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class WithdrawRequest {

    private static WithdrawRequest withdrawRequest = null;

    @SerializedName("amount")
    private String amount;

    @SerializedName("bankIINNumber")
    private String bankIINNumber;

    @SerializedName("xmlBiometricString")
    private String xmlBiometricString;

    @SerializedName("aadharNumber")
    private String aadharNumber;

    @SerializedName("orderId")
    private String crId;

    @SerializedName("transCode")
    private String transCode;

    @SerializedName("username")
    private String username;

    @SerializedName("dcode")
    private String dcode;

    @SerializedName("mobile")
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankIINNumber() {
        return bankIINNumber;
    }

    public void setBankIINNumber(String bankIINNumber) {
        this.bankIINNumber = bankIINNumber;
    }

    public String getXmlBiometricString() {
        return xmlBiometricString;
    }

    public void setXmlBiometricString(String xmlBiometricString) {
        this.xmlBiometricString = xmlBiometricString;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public static WithdrawRequest getWithdrawRequestObject() {

        if (withdrawRequest == null) {

            withdrawRequest = new WithdrawRequest();
        }

        return withdrawRequest;
    }

    public static void createWithdrawRequestObject(String amount, String bankIINNumber, String xmlBiometricString, String aadharNumber, String crId, String transCode, String username, String dcode, String mobileNuber) {

        withdrawRequest = getWithdrawRequestObject();

        withdrawRequest.setAmount(amount);

        withdrawRequest.setBankIINNumber(bankIINNumber);

        withdrawRequest.setXmlBiometricString(xmlBiometricString);

        withdrawRequest.setAadharNumber(aadharNumber);

        withdrawRequest.setCrId(crId);

        withdrawRequest.setTransCode(transCode);

        withdrawRequest.setUsername(username);

        withdrawRequest.setDcode(dcode);

        withdrawRequest.setMobileNumber(mobileNuber);
    }
}
