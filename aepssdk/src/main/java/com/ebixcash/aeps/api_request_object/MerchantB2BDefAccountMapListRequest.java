package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class MerchantB2BDefAccountMapListRequest {

    private static MerchantB2BDefAccountMapListRequest merchantB2BDefAccountMapListRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

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

    public static MerchantB2BDefAccountMapListRequest getMerchantB2BDefAccountMapListRequestObject() {

        if (merchantB2BDefAccountMapListRequest == null) {

            merchantB2BDefAccountMapListRequest = new MerchantB2BDefAccountMapListRequest();
        }

        return merchantB2BDefAccountMapListRequest;
    }

    public static void createMerchantB2BDefAccountMapListRequestObject(String userName, String password) {

        merchantB2BDefAccountMapListRequest = getMerchantB2BDefAccountMapListRequestObject();

        merchantB2BDefAccountMapListRequest.setUserName(userName);

        merchantB2BDefAccountMapListRequest.setPassword(password);
    }
}
