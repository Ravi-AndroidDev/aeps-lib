package com.ebixcash.aeps.api_response_object;

import java.util.ArrayList;

public class ModifyB2BMerchantDefMapAccountResponse {

    private MerchantAccountResponseStatus responseStatus;

    private MerchantAccountData merchantB2bAccountList;

    private ArrayList<MerchantAccountModeData> merchantB2bAccountModelList;

    public MerchantAccountData getMerchantB2bAccountList() {
        return merchantB2bAccountList;
    }

    public void setMerchantB2bAccountList(MerchantAccountData merchantB2bAccountList) {
        this.merchantB2bAccountList = merchantB2bAccountList;
    }

    public MerchantAccountResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(MerchantAccountResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ArrayList<MerchantAccountModeData> getMerchantB2bAccountModelList() {
        return merchantB2bAccountModelList;
    }

    public void setMerchantB2bAccountModelList(ArrayList<MerchantAccountModeData> merchantB2bAccountModelList) {
        this.merchantB2bAccountModelList = merchantB2bAccountModelList;
    }
}
