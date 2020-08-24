package com.ebixcash.aeps.pojo;

public class WalletData {

    private String accountId;

    private String accountType;

    private String customerTypeName;

    private String customerName;

    private String accountNo;

    private String accountTypeId;

    private String accountCurrBal;

    private String blockAmount;

    private String availableBalance;

    private String status;

    private AccountTypeDto toAccountB2BTypeModel;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountCurrBal() {
        return accountCurrBal;
    }

    public void setAccountCurrBal(String accountCurrBal) {
        this.accountCurrBal = accountCurrBal;
    }

    public String getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(String blockAmount) {
        this.blockAmount = blockAmount;
    }

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

    public AccountTypeDto getToAccountB2BTypeModel() {
        return toAccountB2BTypeModel;
    }

    public void setToAccountB2BTypeModel(AccountTypeDto toAccountB2BTypeModel) {
        this.toAccountB2BTypeModel = toAccountB2BTypeModel;
    }
}
