package com.ebixcash.aeps.api_response_object;

public class FinalTransferResponse {

    private String responseCode;

    private String responseMessage;

    private String fromAccountUpdatedBalance;

    private String toAccountUpdatedBalance;

    public String getFromAccountUpdatedBalance() {
        return fromAccountUpdatedBalance;
    }

    public void setFromAccountUpdatedBalance(String fromAccountUpdatedBalance) {
        this.fromAccountUpdatedBalance = fromAccountUpdatedBalance;
    }

    public String getToAccountUpdatedBalance() {
        return toAccountUpdatedBalance;
    }

    public void setToAccountUpdatedBalance(String toAccountUpdatedBalance) {
        this.toAccountUpdatedBalance = toAccountUpdatedBalance;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
