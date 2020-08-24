package com.ebixcash.aeps.api_request_object;

public class BankTransferReportRequest {

    private static BankTransferReportRequest bankTransferReportRequest = null;

    private String fromDate;

    private String toDate;

    private String transCode;

    private String dcode;

    private String module;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public static BankTransferReportRequest getBankTransferReportRequestObject() {

        if (bankTransferReportRequest == null) {

            bankTransferReportRequest = new BankTransferReportRequest();
        }

        return bankTransferReportRequest;
    }

    public static void createBankTransferReportRequestObject(String fromDate, String toDate, String transCode, String dcode) {

        bankTransferReportRequest = getBankTransferReportRequestObject();

        bankTransferReportRequest.setFromDate(fromDate);

        bankTransferReportRequest.setToDate(toDate);

        bankTransferReportRequest.setTransCode(transCode);

        bankTransferReportRequest.setDcode(dcode);
    }

    public static void createBankTransferReportRequestObject(String fromDate, String toDate, String transCode, String dcode, String module) {

        bankTransferReportRequest = getBankTransferReportRequestObject();

        bankTransferReportRequest.setFromDate(fromDate);

        bankTransferReportRequest.setToDate(toDate);

        bankTransferReportRequest.setTransCode(transCode);

        bankTransferReportRequest.setDcode(dcode);

        bankTransferReportRequest.setModule(module);
    }
}
