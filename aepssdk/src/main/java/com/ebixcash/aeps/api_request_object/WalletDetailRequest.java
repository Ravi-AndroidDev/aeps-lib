package com.ebixcash.aeps.api_request_object;

import com.google.gson.annotations.SerializedName;

public class WalletDetailRequest {

    private static WalletDetailRequest walletDetailRequest = null;

    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("machineIP")
    private String machineIP;

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

    public static WalletDetailRequest getWalletDetailRequestObject() {

        if (walletDetailRequest == null) {

            walletDetailRequest = new WalletDetailRequest();
        }

        return walletDetailRequest;
    }

    public static void createWalletDetailRequestObject(String userName, String password, String machineIP) {

        walletDetailRequest = getWalletDetailRequestObject();

        walletDetailRequest.setUserName(userName);

        walletDetailRequest.setPassword(password);

        //walletDetailRequest.setMachineIP(machineIP);
    }
}
