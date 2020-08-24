package com.ebixcash.aeps.api_request_object;

public class LinkAccountRequest {

    private static LinkAccountRequest linkAccountRequest = null;

    private String accountno;

    private String ifsc;

    private String transCode;

    private String dcode;

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
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

    public static LinkAccountRequest getLinkAccountRequestObject() {

        if (linkAccountRequest == null) {

            linkAccountRequest = new LinkAccountRequest();
        }

        return linkAccountRequest;
    }

    public static void createLinkAccountRequestObject(String accountno, String ifsc, String transCode, String dcode) {

        linkAccountRequest = getLinkAccountRequestObject();

        linkAccountRequest.setAccountno(accountno);

        linkAccountRequest.setIfsc(ifsc);

        linkAccountRequest.setTransCode(transCode);

        linkAccountRequest.setDcode(dcode);
    }
}
