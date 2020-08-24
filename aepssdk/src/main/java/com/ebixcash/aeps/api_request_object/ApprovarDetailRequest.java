package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class ApprovarDetailRequest {

    private static ApprovarDetailRequest approvarDetailRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("jvId")
    private String jvId;

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

    public String getJvId() {
        return jvId;
    }

    public void setJvId(String jvId) {
        this.jvId = jvId;
    }

    public static ApprovarDetailRequest getApprovarDetailRequestObject() {

        if (approvarDetailRequest == null) {

            approvarDetailRequest = new ApprovarDetailRequest();
        }

        return approvarDetailRequest;
    }

    public static void createApprovarDetailRequestObject(String userName, String password, String jvId) {

        approvarDetailRequest = getApprovarDetailRequestObject();

        approvarDetailRequest.setUserName(userName);

        approvarDetailRequest.setPassword(password);

        approvarDetailRequest.setJvId(jvId);
    }
}
