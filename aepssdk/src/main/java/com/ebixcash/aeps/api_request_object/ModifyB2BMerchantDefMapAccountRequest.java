package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ModifyB2BMerchantDefMapAccountRequest {

    private static ModifyB2BMerchantDefMapAccountRequest modifyB2BMerchantDefMapAccountRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("id")
    private String id;

    @SerializedName("merchantId")
    private String merchantId;

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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public static ModifyB2BMerchantDefMapAccountRequest getModifyB2BMerchantDefMapAccountRequestObject() {

        if (modifyB2BMerchantDefMapAccountRequest == null) {

            modifyB2BMerchantDefMapAccountRequest = new ModifyB2BMerchantDefMapAccountRequest();
        }

        return modifyB2BMerchantDefMapAccountRequest;
    }

    public static void createModifyB2BMerchantDefMapAccountRequestObject(String userName, String password, String id, String merchantId) {

        modifyB2BMerchantDefMapAccountRequest = getModifyB2BMerchantDefMapAccountRequestObject();

        modifyB2BMerchantDefMapAccountRequest.setUserName(userName);

        modifyB2BMerchantDefMapAccountRequest.setPassword(password);

        modifyB2BMerchantDefMapAccountRequest.setId(id);

        modifyB2BMerchantDefMapAccountRequest.setMerchantId(merchantId);
    }
}
