package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class AccountStatementRequest {

    private static AccountStatementRequest accountStatementRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("fromDate")
    private String fromDate;

    @SerializedName("toDate")
    private String toDate;

    @SerializedName("accountId")
    private String accountId;

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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public static AccountStatementRequest getAccountStatementRequestObject() {

        if (accountStatementRequest == null) {

            accountStatementRequest = new AccountStatementRequest();
        }

        return accountStatementRequest;
    }

    public static void createAccountStatementRequestObject(String userName, String password, String fromDate, String toDate, String accountId) {

        accountStatementRequest = getAccountStatementRequestObject();

        accountStatementRequest.setUserName(userName);

        accountStatementRequest.setPassword(password);

        accountStatementRequest.setFromDate(fromDate);

        accountStatementRequest.setToDate(toDate);

        accountStatementRequest.setAccountId(accountId);
    }
}
