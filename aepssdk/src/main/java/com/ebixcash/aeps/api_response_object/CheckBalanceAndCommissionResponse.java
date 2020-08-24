package com.ebixcash.aeps.api_response_object;

public class CheckBalanceAndCommissionResponse {

    private String responseCode;

    private String responseMessage;

    private String fromAccountAvailableBalanace;

    private String toAccountAvailableBalance;

    private String commission;

    private String serviceTax;

    private String tds;

    private String convenience;

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

    public String getFromAccountAvailableBalanace() {
        return fromAccountAvailableBalanace;
    }

    public void setFromAccountAvailableBalanace(String fromAccountAvailableBalanace) {
        this.fromAccountAvailableBalanace = fromAccountAvailableBalanace;
    }

    public String getToAccountAvailableBalance() {
        return toAccountAvailableBalance;
    }

    public void setToAccountAvailableBalance(String toAccountAvailableBalance) {
        this.toAccountAvailableBalance = toAccountAvailableBalance;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }
}
