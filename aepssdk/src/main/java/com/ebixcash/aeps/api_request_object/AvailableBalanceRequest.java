package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class AvailableBalanceRequest {

    private static AvailableBalanceRequest availableBalanceRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("machineIP")
    private String machineIP;

    @SerializedName("accountId")
    private String accountId;

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

    public String getMachineIP() {
        return machineIP;
    }

    public void setMachineIP(String machineIP) {
        this.machineIP = machineIP;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public static AvailableBalanceRequest getAvailableBalanceRequestObject() {

        if (availableBalanceRequest == null) {

            availableBalanceRequest = new AvailableBalanceRequest();
        }

        return availableBalanceRequest;
    }

    public static void createAvailableBalanceRequestObject(String userName, String password, String machineIP, String accountID) {

        availableBalanceRequest = getAvailableBalanceRequestObject();

        availableBalanceRequest.setUserName(userName);

        availableBalanceRequest.setPassword(password);

        availableBalanceRequest.setMachineIP(machineIP);

        availableBalanceRequest.setAccountId(accountID);
    }
}
