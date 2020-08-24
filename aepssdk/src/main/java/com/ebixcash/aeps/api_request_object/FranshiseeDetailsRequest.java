package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class FranshiseeDetailsRequest {

    private static FranshiseeDetailsRequest franshiseeDetailsRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("status")
    private String status;

    @SerializedName("customerType")
    private String customerType;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public static FranshiseeDetailsRequest getFranshiseeDetailsRequestObject() {

        if (franshiseeDetailsRequest == null) {

            franshiseeDetailsRequest = new FranshiseeDetailsRequest();
        }

        return franshiseeDetailsRequest;
    }

    public static void createFranshiseeDetailsRequestObject(String userName, String password, String status, String customerType) {

        franshiseeDetailsRequest = getFranshiseeDetailsRequestObject();

        franshiseeDetailsRequest.setUserName(userName);

        franshiseeDetailsRequest.setPassword(password);

        franshiseeDetailsRequest.setStatus(status);

        franshiseeDetailsRequest.setCustomerType(customerType);
    }
}
