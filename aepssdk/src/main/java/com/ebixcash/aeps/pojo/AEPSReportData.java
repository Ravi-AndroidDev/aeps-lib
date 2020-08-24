package com.ebixcash.aeps.pojo;

public class AEPSReportData {

    private String txnstatus;

    private String rrn;

    private String pgtransactionid;

    private String responsecode;

    private String uidno;

    private String matmreqid;

    private String csrid;

    private String terminalid;

    private String pgresponsecode;

    private String transcode;

    private String agentid;

    private String amount;

    private String transactiondate;

    private String bankiinno;

    private String stan;

    private String uidaiauthcode;

    private String orderid;

    private boolean isSelected = false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTxnstatus() {
        return txnstatus;
    }

    public void setTxnstatus(String txnstatus) {
        this.txnstatus = txnstatus;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getPgtransactionid() {
        return pgtransactionid;
    }

    public void setPgtransactionid(String pgtransactionid) {
        this.pgtransactionid = pgtransactionid;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getUidno() {
        return uidno;
    }

    public void setUidno(String uidno) {
        this.uidno = uidno;
    }

    public String getMatmreqid() {
        return matmreqid;
    }

    public void setMatmreqid(String matmreqid) {
        this.matmreqid = matmreqid;
    }

    public String getCsrid() {
        return csrid;
    }

    public void setCsrid(String csrid) {
        this.csrid = csrid;
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getPgresponsecode() {
        return pgresponsecode;
    }

    public void setPgresponsecode(String pgresponsecode) {
        this.pgresponsecode = pgresponsecode;
    }

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getBankiinno() {
        return bankiinno;
    }

    public void setBankiinno(String bankiinno) {
        this.bankiinno = bankiinno;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getUidaiauthcode() {
        return uidaiauthcode;
    }

    public void setUidaiauthcode(String uidaiauthcode) {
        this.uidaiauthcode = uidaiauthcode;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
