package com.ebixcash.aeps.pojo;

public class AccountTransferMapping {

    private String id;

    private String fromAccountTypeId;

    private String toAccountTypeId;

    private String accountType;

    private String fromAccountTypeName;

    private String merchantId;

    private String merchantName;

    private String transferType;

    private String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromAccountTypeId() {
        return fromAccountTypeId;
    }

    public void setFromAccountTypeId(String fromAccountTypeId) {
        this.fromAccountTypeId = fromAccountTypeId;
    }

    public String getToAccountTypeId() {
        return toAccountTypeId;
    }

    public void setToAccountTypeId(String toAccountTypeId) {
        this.toAccountTypeId = toAccountTypeId;
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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
