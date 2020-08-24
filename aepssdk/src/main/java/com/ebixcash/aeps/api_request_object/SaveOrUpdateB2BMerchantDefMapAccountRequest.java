package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class SaveOrUpdateB2BMerchantDefMapAccountRequest {

    private static SaveOrUpdateB2BMerchantDefMapAccountRequest saveOrUpdateB2BMerchantDefMapAccountRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("id")
    private String id;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("merchantKey")
    private String merchantKey;

    @SerializedName("status")
    private String status;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static SaveOrUpdateB2BMerchantDefMapAccountRequest getSaveOrUpdateB2BMerchantDefMapAccountRequestObject() {

        if (saveOrUpdateB2BMerchantDefMapAccountRequest == null) {

            saveOrUpdateB2BMerchantDefMapAccountRequest = new SaveOrUpdateB2BMerchantDefMapAccountRequest();
        }

        return saveOrUpdateB2BMerchantDefMapAccountRequest;
    }

    public static void createSaveOrUpdateB2BMerchantDefMapAccountRequestObject(String userName, String password, String id, String accountId, String merchantId, String merchantKey, String status) {

        saveOrUpdateB2BMerchantDefMapAccountRequest = getSaveOrUpdateB2BMerchantDefMapAccountRequestObject();

        saveOrUpdateB2BMerchantDefMapAccountRequest.setUserName(userName);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setPassword(password);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setId(id);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setAccountId(accountId);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setMerchantId(merchantId);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setMerchantKey(merchantKey);

        saveOrUpdateB2BMerchantDefMapAccountRequest.setStatus(status);
    }
}
