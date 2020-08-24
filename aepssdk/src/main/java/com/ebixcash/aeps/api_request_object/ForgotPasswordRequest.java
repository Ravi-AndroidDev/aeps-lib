package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequest {

    private static ForgotPasswordRequest forgotPasswordRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("dob")
    private String dob;

    @SerializedName("emailId")
    private String emailId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public static ForgotPasswordRequest getForgotPasswordRequestObject() {

        if (forgotPasswordRequest == null) {

            forgotPasswordRequest = new ForgotPasswordRequest();
        }

        return forgotPasswordRequest;
    }

    public static void createForgotPasswordRequestObject(String userName, String dob, String emailID) {

        forgotPasswordRequest = getForgotPasswordRequestObject();

        forgotPasswordRequest.setUserName(userName);

        forgotPasswordRequest.setDob(dob);

        forgotPasswordRequest.setEmailId(emailID);
    }
}
