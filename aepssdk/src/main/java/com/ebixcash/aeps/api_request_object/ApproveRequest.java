package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ApproveRequest {

    private static ApproveRequest approveRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("approverAccountId")
    private String approverAccountId;

    @SerializedName("approverAccountTypeId")
    private String approverAccountTypeId;

    @SerializedName("availableBalance")
    private String availableBalance;

    @SerializedName("jvDateStr")
    private String jvDateStr;

    @SerializedName("jvId")
    private String jvId;

    @SerializedName("rejectionId")
    private String rejectionId;

    @SerializedName("requestAmount")
    private String requestAmount;

    @SerializedName("actionType")
    private String actionType;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getApproverAccountId() {
        return approverAccountId;
    }

    public void setApproverAccountId(String approverAccountId) {
        this.approverAccountId = approverAccountId;
    }

    public String getApproverAccountTypeId() {
        return approverAccountTypeId;
    }

    public void setApproverAccountTypeId(String approverAccountTypeId) {
        this.approverAccountTypeId = approverAccountTypeId;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getJvDateStr() {
        return jvDateStr;
    }

    public void setJvDateStr(String jvDateStr) {
        this.jvDateStr = jvDateStr;
    }

    public String getJvId() {
        return jvId;
    }

    public void setJvId(String jvId) {
        this.jvId = jvId;
    }

    public String getRejectionId() {
        return rejectionId;
    }

    public void setRejectionId(String rejectionId) {
        this.rejectionId = rejectionId;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public static ApproveRequest getApproveRequestObject() {

        if (approveRequest == null) {

            approveRequest = new ApproveRequest();
        }

        return approveRequest;
    }

    public static void createApproveRequestObject(String userName, String password, String accountId, String approverAccountId, String approverAccountTypeId, String availableBalance, String jvDateStr, String jvId, String rejectionId, String requestAmount, String actionType) {

        approveRequest = getApproveRequestObject();

        approveRequest.setUserName(userName);

        approveRequest.setPassword(password);

        approveRequest.setAccountId(accountId);

        approveRequest.setApproverAccountId(approverAccountId);

        approveRequest.setApproverAccountTypeId(approverAccountTypeId);

        approveRequest.setAvailableBalance(availableBalance);

        approveRequest.setJvDateStr(jvDateStr);

        approveRequest.setJvId(jvId);

        approveRequest.setRejectionId(rejectionId);

        approveRequest.setRequestAmount(requestAmount);

        approveRequest.setActionType(actionType);
    }
}
