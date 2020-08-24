package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class CheckBalanceAndCommissionRequest {

    private static CheckBalanceAndCommissionRequest checkBalanceAndCommissionRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("fromAccountTypeId")
    private String fromAccountTypeId;

    @SerializedName("toAccountTypeId")
    private String toAccountTypeId;

    @SerializedName("amount")
    private String amount;

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

    public String getFromAccountTypeId() {
        return fromAccountTypeId;
    }

    public void setFromAccountTypeId(String fromAccountTypeId) {
        this.fromAccountTypeId = fromAccountTypeId;
    }

    public String getToAccountTypeId() {
        return toAccountTypeId;
    }

    public void setToAccountTypeId(String toAccountTypeId) {
        this.toAccountTypeId = toAccountTypeId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public static CheckBalanceAndCommissionRequest getCheckBalanceAndCommissionRequestObject() {

        if (checkBalanceAndCommissionRequest == null) {

            checkBalanceAndCommissionRequest = new CheckBalanceAndCommissionRequest();
        }

        return checkBalanceAndCommissionRequest;
    }

    public static void createCheckBalanceAndCommissionRequestObject(String userName, String password, String fromAccountTypeId, String toAccountTypeId, String amount) {

        checkBalanceAndCommissionRequest = getCheckBalanceAndCommissionRequestObject();

        checkBalanceAndCommissionRequest.setUserName(userName);

        checkBalanceAndCommissionRequest.setPassword(password);

        checkBalanceAndCommissionRequest.setFromAccountTypeId(fromAccountTypeId);

        checkBalanceAndCommissionRequest.setToAccountTypeId(toAccountTypeId);

        checkBalanceAndCommissionRequest.setAmount(amount);
    }
}
