package com.ebixcash.aeps.api_response_object;


import com.ebixcash.aeps.pojo.Balance;

import java.util.ArrayList;

public class BankMappedResponse {

    private String responseMessage;

    private String responseCode;

    private ArrayList<Balance> wallets;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public ArrayList<Balance> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<Balance> wallets) {
        this.wallets = wallets;
    }
}
