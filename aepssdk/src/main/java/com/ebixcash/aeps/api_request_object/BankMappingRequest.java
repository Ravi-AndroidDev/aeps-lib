package com.ebixcash.aeps.api_request_object;

public class BankMappingRequest {

    private static BankMappingRequest bankMappingRequest = null;

    private String accountno;

    private String ifsc;

    private String transCode;

    private String dcode;

    private String module;

    private String accountholdername;

    private String autoreco;

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

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

    public String getAccountholdername() {
        return accountholdername;
    }

    public void setAccountholdername(String accountholdername) {
        this.accountholdername = accountholdername;
    }

    public String getAutoreco() {
        return autoreco;
    }

    public void setAutoreco(String autoreco) {
        this.autoreco = autoreco;
    }

    public static BankMappingRequest getBankMappingRequestObject() {

        if (bankMappingRequest == null) {

            bankMappingRequest = new BankMappingRequest();
        }

        return bankMappingRequest;
    }

    public static void createBankMappingRequestObject(String accountno, String ifsc, String transCode, String dcode, String module, String accountholdername, String autoreco) {

        bankMappingRequest = getBankMappingRequestObject();

        bankMappingRequest.setAccountno(accountno);

        bankMappingRequest.setIfsc(ifsc);

        bankMappingRequest.setTransCode(transCode);

        bankMappingRequest.setDcode(dcode);

        bankMappingRequest.setModule(module);

        bankMappingRequest.setAccountholdername(accountholdername);

        bankMappingRequest.setAutoreco(autoreco);
    }
}
