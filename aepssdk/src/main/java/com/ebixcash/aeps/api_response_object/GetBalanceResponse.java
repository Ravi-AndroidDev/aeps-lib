package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.AccountBalance;

import java.util.ArrayList;

public class GetBalanceResponse {

    private String responseMessage;

    private String responseCode;

    private String accountno;

    private String ifsccode;

    private ArrayList<AccountBalance> accountBalanceArrayList;

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

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public ArrayList<AccountBalance> getAccountBalanceArrayList() {
        return accountBalanceArrayList;
    }

    public void setAccountBalanceArrayList(ArrayList<AccountBalance> accountBalanceArrayList) {
        this.accountBalanceArrayList = accountBalanceArrayList;
    }
}
