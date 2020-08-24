package com.ebixcash.aeps.pojo;

public class CustomerTypeDto {

    private String customerId;

    private String customerTypeDesc;

    private String fromAccountTypeId;

    private String accountType;

    private String fromAccountTypeName;

    private String merchantId;

    private String transferType;

    private String merchantName;

    private String availableBalance;

    private String status;

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTypeDesc() {
        return customerTypeDesc;
    }

    public void setCustomerTypeDesc(String customerTypeDesc) {
        this.customerTypeDesc = customerTypeDesc;
    }

    public String getFromAccountTypeId() {
        return fromAccountTypeId;
    }

    public void setFromAccountTypeId(String fromAccountTypeId) {
        this.fromAccountTypeId = fromAccountTypeId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getFromAccountTypeName() {
        return fromAccountTypeName;
    }

    public void setFromAccountTypeName(String fromAccountTypeName) {
        this.fromAccountTypeName = fromAccountTypeName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
