package com.ebixcash.aeps.api_response_object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="easyWallet", strict = false)
public class EasyWalletData {

    @Element(name="easyWalletId", required=false)
    private String easyWalletId;

    @Element(name="easyWalletType", required=false)
    private String easyWalletType;

    @Element(name="easyWalletBalance", required=false)
    private String easyWalletBalance;

    public String getEasyWalletId() {
        return easyWalletId;
    }

    public void setEasyWalletId(String easyWalletId) {
        this.easyWalletId = easyWalletId;
    }

    public String getEasyWalletType() {
        return easyWalletType;
    }

    public void setEasyWalletType(String easyWalletType) {
        this.easyWalletType = easyWalletType;
    }

    public String getEasyWalletBalance() {
        return easyWalletBalance;
    }

    public void setEasyWalletBalance(String easyWalletBalance) {
        this.easyWalletBalance = easyWalletBalance;
    }
}
