package com.ebixcash.aeps.pojo;

public class BankDetail {

    private String serialNumber;

    private String bankName;

    private String bankIINNumber;

    private String acquirerID;

    private String bankCode;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankIINNumber() {
        return bankIINNumber;
    }

    public void setBankIINNumber(String bankIINNumber) {
        this.bankIINNumber = bankIINNumber;
    }

    public String getAcquirerID() {
        return acquirerID;
    }

    public void setAcquirerID(String acquirerID) {
        this.acquirerID = acquirerID;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
