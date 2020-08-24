package com.ebixcash.aeps.api_response_object;


import com.ebixcash.aeps.pojo.ResponseStatus;
import com.ebixcash.aeps.pojo.StatementList;

import java.util.ArrayList;

public class AccountStatementResponse {

    private ResponseStatus responseStatus;

    private ArrayList<StatementList> statementList;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ArrayList<StatementList> getStatementList() {
        return statementList;
    }

    public void setStatementList(ArrayList<StatementList> statementList) {
        this.statementList = statementList;
    }
}
