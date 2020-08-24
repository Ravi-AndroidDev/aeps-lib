package com.ebixcash.aeps.api_response_object;

public class SearchByIFSCCodeResponse {

    private String branchName;

    private String ifscCode;

    private String bankName;

    private String cityName;

    private String stateName;

    private String address;

    private String isimps;

    public String getIsimps() {
        return isimps;
    }

    public void setIsimps(String isimps) {
        this.isimps = isimps;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
