package com.ebixcash.aeps.api_response_object;

import java.util.ArrayList;

public class MerchantB2BDefAccountMapListResponse {

    private MerchantAccountResponseStatus responseStatus;

    private ArrayList<MerchantAccountData> merchantB2bAccountList;

    public ArrayList<MerchantAccountData> getMerchantB2bAccountList() {
        return merchantB2bAccountList;
    }

    public void setMerchantB2bAccountList(ArrayList<MerchantAccountData> merchantB2bAccountList) {
        this.merchantB2bAccountList = merchantB2bAccountList;
    }

    public MerchantAccountResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(MerchantAccountResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
