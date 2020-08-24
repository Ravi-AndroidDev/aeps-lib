package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class RequestHistory {

    private static RequestHistory requestHistory = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("reqFromDate")
    private String fromDate;

    @SerializedName("reqToDate")
    private String toDate;

    @SerializedName("status")
    private String status;

    @SerializedName("requesterFirmName")
    private String requesterFirmName;

    @SerializedName("decode")
    private String decode;

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequesterFirmName() {
        return requesterFirmName;
    }

    public void setRequesterFirmName(String requesterFirmName) {
        this.requesterFirmName = requesterFirmName;
    }

    public static RequestHistory getRequestHistoryObject() {

        if (requestHistory == null) {

            requestHistory = new RequestHistory();
        }

        return requestHistory;
    }

    public static void createRequestHistoryObject(String userName, String password, String fromDate, String toDate, String status) {

        requestHistory = getRequestHistoryObject();

        requestHistory.setUserName(userName);

        requestHistory.setPassword(password);

        requestHistory.setFromDate(fromDate);

        requestHistory.setToDate(toDate);

        requestHistory.setStatus(status);
    }

    public static void createRequestHistoryDistributorEndObject(String userName, String password, String fromDate, String toDate, String status, String requesterFirmName, String decode) {

        requestHistory = null;

        requestHistory = getRequestHistoryObject();

        requestHistory.setUserName(userName);

        requestHistory.setPassword(password);

        requestHistory.setFromDate(fromDate);

        requestHistory.setToDate(toDate);

        requestHistory.setStatus(status);

        requestHistory.setRequesterFirmName(requesterFirmName);

        requestHistory.setDecode(decode);
    }
}
