package com.ebixcash.aeps.pojo;

import java.util.ArrayList;

public class AccountTypeDto {

    private String isOverDraft;

    private String minTopUpAmount;

    private String maxTopUpAmount;

    private String ssChannel;

    private String ssChannelName;

    private String isZeroAccount;

    private String isGeneralDebitAccount;

    private String isTransactionalAllowed;

    private String customerTypeName;

    private ArrayList<CustomerTypeDto> walletB2BDetailModel;

    public String getIsOverDraft() {
        return isOverDraft;
    }

    public void setIsOverDraft(String isOverDraft) {
        this.isOverDraft = isOverDraft;
    }

    public String getMinTopUpAmount() {
        return minTopUpAmount;
    }

    public void setMinTopUpAmount(String minTopUpAmount) {
        this.minTopUpAmount = minTopUpAmount;
    }

    public String getMaxTopUpAmount() {
        return maxTopUpAmount;
    }

    public void setMaxTopUpAmount(String maxTopUpAmount) {
        this.maxTopUpAmount = maxTopUpAmount;
    }

    public String getSsChannel() {
        return ssChannel;
    }

    public void setSsChannel(String ssChannel) {
        this.ssChannel = ssChannel;
    }

    public String getSsChannelName() {
        return ssChannelName;
    }

    public void setSsChannelName(String ssChannelName) {
        this.ssChannelName = ssChannelName;
    }

    public String getIsZeroAccount() {
        return isZeroAccount;
    }

    public void setIsZeroAccount(String isZeroAccount) {
        this.isZeroAccount = isZeroAccount;
    }

    public String getIsGeneralDebitAccount() {
        return isGeneralDebitAccount;
    }

    public void setIsGeneralDebitAccount(String isGeneralDebitAccount) {
        this.isGeneralDebitAccount = isGeneralDebitAccount;
    }

    public String getIsTransactionalAllowed() {
        return isTransactionalAllowed;
    }

    public void setIsTransactionalAllowed(String isTransactionalAllowed) {
        this.isTransactionalAllowed = isTransactionalAllowed;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public ArrayList<CustomerTypeDto> getWalletB2BDetailModel() {
        return walletB2BDetailModel;
    }

    public void setWalletB2BDetailModel(ArrayList<CustomerTypeDto> walletB2BDetailModel) {
        this.walletB2BDetailModel = walletB2BDetailModel;
    }
}
