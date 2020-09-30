package com.ebixcash.aeps.parser;

import com.ebixcash.aeps.pojo.AEPSReportData;
import com.ebixcash.aeps.pojo.BalanceResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseResponse {

    public BalanceResponse parseBalanceResponse(String response){

        BalanceResponse balanceResponse = new BalanceResponse();

        try{

            JSONObject obj = new JSONObject(response);

            if(obj.has("mATMReqId")){

                balanceResponse.setmATMReqId(obj.getString("mATMReqId"));
            }

            if(obj.has("responseCode")){

                balanceResponse.setResponseCode(obj.getString("responseCode"));
            }

            if(obj.has("rrn")){

                balanceResponse.setRrn(obj.getString("rrn"));
            }

            if(obj.has("acBalance")){

                balanceResponse.setAcBalance(obj.getString("acBalance"));
            }

            if(obj.has("agentId")){

                balanceResponse.setAgentId(obj.getString("agentId"));
            }

            if(obj.has("txnStatus")){

                balanceResponse.setTxnStatus(obj.getString("txnStatus"));
            }

            if(obj.has("bcLocation")){

                balanceResponse.setBcLocation(obj.getString("bcLocation"));
            }

            if(obj.has("txnAmount")){

                balanceResponse.setTxnAmount(obj.getString("txnAmount"));
            }

            if(obj.has("responseMessage")){

                balanceResponse.setResponseMessage(obj.getString("responseMessage"));
            }

            if(obj.has("terminalId")){

                balanceResponse.setTerminalId(obj.getString("terminalId"));
            }

            if(obj.has("aadhaarNo")){

                balanceResponse.setAadhaarNo(obj.getString("aadhaarNo"));
            }

            if(obj.has("stan")){

                balanceResponse.setStan(obj.getString("stan"));
            }

            if(obj.has("uidaiAuthCode")){

                balanceResponse.setUidaiAuthCode(obj.getString("uidaiAuthCode"));
            }

            if(obj.has("dateAndTime")){

                balanceResponse.setDateAndTime(obj.getString("dateAndTime"));
            }

            if(obj.has("bcName")){

                balanceResponse.setBcName(obj.getString("bcName"));
            }

            if(obj.has("crId")){

                balanceResponse.setCrId(obj.getString("crId"));
            }

            if(obj.has("errorMessage")){

                balanceResponse.setErrorMessage(obj.getString("errorMessage"));
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return balanceResponse;
    }

    public ArrayList<Object> parseAEPSReportResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                AEPSReportData aepsReportData = new AEPSReportData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("txnstatus")) {

                    aepsReportData.setTxnstatus(obj.getString("txnstatus"));
                }

                if (obj.has("rrn")) {

                    aepsReportData.setRrn(obj.getString("rrn"));
                }

                if (obj.has("pgtransactionid")) {

                    aepsReportData.setPgtransactionid(obj.getString("pgtransactionid"));
                }

                if (obj.has("responsecode")) {

                    aepsReportData.setResponsecode(obj.getString("responsecode"));
                }

                if (obj.has("uidno")) {

                    aepsReportData.setUidno(obj.getString("uidno"));
                }

                if (obj.has("matmreqid")) {

                    aepsReportData.setMatmreqid(obj.getString("matmreqid"));
                }

                if (obj.has("csrid")) {

                    aepsReportData.setCsrid(obj.getString("csrid"));
                }

                if (obj.has("terminalid")) {

                    aepsReportData.setTerminalid(obj.getString("terminalid"));
                }

                if (obj.has("pgresponsecode")) {

                    aepsReportData.setPgresponsecode(obj.getString("pgresponsecode"));
                }

                if (obj.has("transcode")) {

                    aepsReportData.setTranscode(obj.getString("transcode"));
                }

                if (obj.has("agentid")) {

                    aepsReportData.setAgentid(obj.getString("agentid"));
                }

                if (obj.has("amount")) {

                    aepsReportData.setAmount(obj.getString("amount"));
                }

                if (obj.has("transactiondate")) {

                    aepsReportData.setTransactiondate(obj.getString("transactiondate"));
                }

                if (obj.has("bankiinno")) {

                    aepsReportData.setBankiinno(obj.getString("bankiinno"));
                }

                if (obj.has("stan")) {

                    aepsReportData.setStan(obj.getString("stan"));
                }

                if (obj.has("uidaiauthcode")) {

                    aepsReportData.setUidaiauthcode(obj.getString("uidaiauthcode"));
                }

                if (obj.has("orderid")) {

                    aepsReportData.setOrderid(obj.getString("orderid"));
                }

                list.add(aepsReportData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

}
