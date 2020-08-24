package com.ebixcash.aeps.pojo;

public class BankData {

    private String bankId;

    private String bankName;

    private String ifscCode;

    private String isimps;

    public String getIsimps() {
        return isimps;
    }

    public void setIsimps(String isimps) {
        this.isimps = isimps;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
