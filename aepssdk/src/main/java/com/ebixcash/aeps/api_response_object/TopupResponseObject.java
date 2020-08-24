package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.AproverDetail;

public class TopupResponseObject {

    private String responseMessage;

    private String responseCode;

    private String requesterId;

    private String status;

    private AproverDetail approverDetailsModel;

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

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AproverDetail getApproverDetailsModel() {
        return approverDetailsModel;
    }

    public void setApproverDetailsModel(AproverDetail approverDetailsModel) {
        this.approverDetailsModel = approverDetailsModel;
    }
}
