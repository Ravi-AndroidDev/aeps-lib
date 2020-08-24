package com.ebixcash.aeps.api_response_object;

public class MerchantAccountData {

    private String id;

    private String merchantId;

    private String merchantKeyName;

    private String merchantName;

    private String vertical;

    private String verticalGrp;

    private String merchantKey;

    private String accountType;

    private String custType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantKeyName() {
        return merchantKeyName;
    }

    public void setMerchantKeyName(String merchantKeyName) {
        this.merchantKeyName = merchantKeyName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getVerticalGrp() {
        return verticalGrp;
    }

    public void setVerticalGrp(String verticalGrp) {
        this.verticalGrp = verticalGrp;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }
}
