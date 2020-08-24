package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private static LoginRequest loginRequest = null;

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

    public static LoginRequest getLoginObject() {

        if (loginRequest == null) {

            loginRequest = new LoginRequest();
        }

        return loginRequest;
    }

    public static void createLoginObject(String userName, String password) {

        loginRequest = getLoginObject();

        loginRequest.setUserName(userName);

        loginRequest.setPassword(password);
    }
}
