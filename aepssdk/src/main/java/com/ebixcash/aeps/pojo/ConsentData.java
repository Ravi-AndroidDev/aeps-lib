package com.ebixcash.aeps.pojo;

public class ConsentData {

    private String mobileNumber;

    private String email;

    private String module;

    private String transCode;

    private String dcode;

    private String firmname;

    private String isConsentTaken;

    public String getIsConsentTaken() {
        return isConsentTaken;
    }

    public void setIsConsentTaken(String isConsentTaken) {
        this.isConsentTaken = isConsentTaken;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname;
    }
}
