package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ProfileRequest {

    private static ProfileRequest profileRequest = null;

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

    public static ProfileRequest getProfileRequestObject() {

        if (profileRequest == null) {

            profileRequest = new ProfileRequest();
        }

        return profileRequest;
    }

    public static void createProfileRequestObject(String userName, String password) {

        profileRequest = getProfileRequestObject();

        profileRequest.setUserName(userName);

        profileRequest.setPassword(password);
    }
}
