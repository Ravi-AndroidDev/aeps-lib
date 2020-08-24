package com.ebixcash.aeps.api_request_object;

public class GetBalanceRequest {

    private static GetBalanceRequest getBalanceRequest = null;

    private String dcode;

    private String transCode;

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public static GetBalanceRequest getGetBalanceRequestObject() {

        if (getBalanceRequest == null) {

            getBalanceRequest = new GetBalanceRequest();
        }

        return getBalanceRequest;
    }

    public static void createGetBalanceRequestObject(String transCode, String dcode) {

        getBalanceRequest = getGetBalanceRequestObject();

        getBalanceRequest.setTransCode(transCode);

        getBalanceRequest.setDcode(dcode);
    }
}
