package com.ebixcash.aeps.api_request_object;

public class BankTransferRequest {

    private static BankTransferRequest bankTransferRequest = null;

    private String username;

    private String password;

    private String transCode;

    private String dcode;

    private String easywallet;

    private String amount;

    private String module;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEasywallet() {
        return easywallet;
    }

    public void setEasywallet(String easywallet) {
        this.easywallet = easywallet;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public static BankTransferRequest getBankTransferRequestObject() {

        if (bankTransferRequest == null) {

            bankTransferRequest = new BankTransferRequest();
        }

        return bankTransferRequest;
    }

    public static void createBankTransferRequestObject(String username, String password, String transCode, String dcode, String easywallet, String amount) {

        bankTransferRequest = getBankTransferRequestObject();

        bankTransferRequest.setUsername(username);

        bankTransferRequest.setPassword(password);

        bankTransferRequest.setTransCode(transCode);

        bankTransferRequest.setDcode(dcode);

        bankTransferRequest.setEasywallet(easywallet);

        bankTransferRequest.setAmount(amount);
    }

    public static void createBankTransferRequestObject(String username, String password, String transCode, String dcode, String easywallet, String amount, String module) {

        bankTransferRequest = getBankTransferRequestObject();

        bankTransferRequest.setUsername(username);

        bankTransferRequest.setPassword(password);

        bankTransferRequest.setTransCode(transCode);

        bankTransferRequest.setDcode(dcode);

        bankTransferRequest.setEasywallet(easywallet);

        bankTransferRequest.setAmount(amount);

        bankTransferRequest.setModule(module);
    }
}
