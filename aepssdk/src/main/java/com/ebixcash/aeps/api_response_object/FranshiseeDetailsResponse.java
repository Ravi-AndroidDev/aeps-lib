package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.FranshiseeDetailData;
import com.ebixcash.aeps.pojo.ResponseStatus;

import java.util.ArrayList;

public class FranshiseeDetailsResponse {

    private ResponseStatus responseStatus;

    private ArrayList<FranshiseeDetailData> franshiseeList;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ArrayList<FranshiseeDetailData> getFranshiseeList() {
        return franshiseeList;
    }

    public void setFranshiseeList(ArrayList<FranshiseeDetailData> franshiseeList) {
        this.franshiseeList = franshiseeList;
    }
}
