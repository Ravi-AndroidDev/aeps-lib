package com.ebixcash.aeps.api_request_object;

public class BankMappedRequest {

    private static BankMappedRequest bankMappedRequest = null;

    private String transCode;

    private String dcode;

    private String module;

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public static BankMappedRequest getBankMappedRequestObject() {

        if (bankMappedRequest == null) {

            bankMappedRequest = new BankMappedRequest();
        }

        return bankMappedRequest;
    }

    public static void createBankMappedRequestObject(String transCode, String dcode, String module) {

        bankMappedRequest = getBankMappedRequestObject();

        bankMappedRequest.setTransCode(transCode);

        bankMappedRequest.setDcode(dcode);

        bankMappedRequest.setModule(module);
    }
}
