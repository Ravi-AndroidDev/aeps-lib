package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest {

    private static ChangePasswordRequest changePasswordRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("dob")
    private String dob;

    @SerializedName("oldPwd")
    private String oldPwd;

    @SerializedName("password")
    private String password;

    @SerializedName("confirmPwd")
    private String confirmPwd;

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

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public static ChangePasswordRequest getChangePasswordRequestObject() {

        if (changePasswordRequest == null) {

            changePasswordRequest = new ChangePasswordRequest();
        }

        return changePasswordRequest;
    }

    public static void createChangePasswordRequestObject(String userName, String dob, String oldPassword, String newPassword, String confirmPassword) {

        changePasswordRequest = getChangePasswordRequestObject();

        changePasswordRequest.setUserName(userName);

        changePasswordRequest.setDob(dob);

        changePasswordRequest.setOldPwd(oldPassword);

        changePasswordRequest.setPassword(newPassword);

        changePasswordRequest.setConfirmPwd(confirmPassword);
    }
}
