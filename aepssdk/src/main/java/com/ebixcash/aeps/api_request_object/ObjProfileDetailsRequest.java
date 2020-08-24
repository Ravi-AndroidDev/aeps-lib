package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ObjProfileDetailsRequest {

    private static ObjProfileDetailsRequest objProfileDetailsRequest = null;

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

    public static ObjProfileDetailsRequest getProfileRequestObject() {

        if (objProfileDetailsRequest == null) {

            objProfileDetailsRequest = new ObjProfileDetailsRequest();
        }

        return objProfileDetailsRequest;
    }

    public static void createProfileRequestObject(String userName, String password) {

        objProfileDetailsRequest = getProfileRequestObject();

        objProfileDetailsRequest.setUserName(userName);

        objProfileDetailsRequest.setPassword(password);
    }
}
