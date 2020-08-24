package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.CustomerB2BWallletModel;
import com.ebixcash.aeps.pojo.ResponseStatus;
import com.ebixcash.aeps.pojo.WalletData;

import java.util.ArrayList;

public class WalletDetailResponse {

    private ResponseStatus responseStatus;

    private CustomerB2BWallletModel customerB2BWallletModel;

    private ArrayList<WalletData> accountB2BWalletModel;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public CustomerB2BWallletModel getCustomerB2BWallletModel() {
        return customerB2BWallletModel;
    }

    public void setCustomerB2BWallletModel(CustomerB2BWallletModel customerB2BWallletModel) {
        this.customerB2BWallletModel = customerB2BWallletModel;
    }

    public ArrayList<WalletData> getAccountB2BWalletModel() {
        return accountB2BWalletModel;
    }

    public void setAccountB2BWalletModel(ArrayList<WalletData> accountB2BWalletModel) {
        this.accountB2BWalletModel = accountB2BWalletModel;
    }
}
