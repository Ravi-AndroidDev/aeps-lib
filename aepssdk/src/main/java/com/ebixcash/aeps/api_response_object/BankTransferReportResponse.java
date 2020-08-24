package com.ebixcash.aeps.api_response_object;

public class BankTransferReportResponse {

    private String requestdate;

    private String amount;

    private String accountno;

    private String status;

    private String filegenerated;

    private String transactionid;

    private String Dcode;

    private String filename;

    private String Settlementid;

    private String ifsc;

    private String utr;

    private boolean isSelected = false;

    public String getUtr() {
        return utr;
    }

    public void setUtr(String utr) {
        this.utr = utr;
    }

    public String getFilegenerated() {
        return filegenerated;
    }

    public void setFilegenerated(String filegenerated) {
        this.filegenerated = filegenerated;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDcode() {
        return Dcode;
    }

    public void setDcode(String dcode) {
        Dcode = dcode;
    }

    public String getSettlementid() {
        return Settlementid;
    }

    public void setSettlementid(String settlementid) {
        Settlementid = settlementid;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
}
