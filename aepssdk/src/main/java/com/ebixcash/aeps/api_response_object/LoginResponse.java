package com.ebixcash.aeps.api_response_object;

public class LoginResponse {

    private String userName;

    private String encrPwd;

    private String roleId;

    private String status;

    private String lastLoginTm;

    private String expiryDate;

    private String responseCode;

    private String responseMessage;

    private String dCode;

    private String customerTypeId;

    private String customerTypeName;

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public String getEncrPwd() {
        return encrPwd;
    }

    public void setEncrPwd(String encrPwd) {
        this.encrPwd = encrPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastLoginTm() {
        return lastLoginTm;
    }

    public void setLastLoginTm(String lastLoginTm) {
        this.lastLoginTm = lastLoginTm;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
