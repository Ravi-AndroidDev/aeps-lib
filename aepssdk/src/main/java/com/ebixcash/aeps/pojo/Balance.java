package com.ebixcash.aeps.pojo;

public class Balance {

    private String balance;

    private String name;

    private String module;

    private String accountno;

    private String ifsccode;

    private String accountholder;

    private String autoreco;

    private boolean isSelected = false;

    private String whitelisted;

    public String getWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(String whitelisted) {
        this.whitelisted = whitelisted;
    }

    public String getAutoreco() {
        return autoreco;
    }

    public void setAutoreco(String autoreco) {
        this.autoreco = autoreco;
    }

    public String getAccountholder() {
        return accountholder;
    }

    public void setAccountholder(String accountholder) {
        this.accountholder = accountholder;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }
}
