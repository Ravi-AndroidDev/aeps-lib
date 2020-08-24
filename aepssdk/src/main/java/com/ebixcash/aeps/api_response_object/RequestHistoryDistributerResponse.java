package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.RequestHistoryData;
import com.ebixcash.aeps.pojo.ResponseStatus;

import java.util.ArrayList;

public class RequestHistoryDistributerResponse {

    private ResponseStatus responseStatus;

    private ArrayList<RequestHistoryData> topUpList;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ArrayList<RequestHistoryData> getTopUpList() {
        return topUpList;
    }

    public void setTopUpList(ArrayList<RequestHistoryData> topUpList) {
        this.topUpList = topUpList;
    }
}
