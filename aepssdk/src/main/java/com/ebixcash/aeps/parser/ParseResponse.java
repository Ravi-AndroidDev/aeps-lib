package com.ebixcash.aeps.parser;

import com.ebixcash.aeps.api_response_object.BankTransferReportResponse;
import com.ebixcash.aeps.api_response_object.BankTransferResponse;
import com.ebixcash.aeps.api_response_object.EasyWalletData;
import com.ebixcash.aeps.api_response_object.GetBalanceResponse;
import com.ebixcash.aeps.api_response_object.LastTenTransactionResponse;
import com.ebixcash.aeps.api_response_object.LinkAccountResponse;
import com.ebixcash.aeps.api_response_object.SearchByIFSCCodeResponse;
import com.ebixcash.aeps.pojo.AEPSReportData;
import com.ebixcash.aeps.pojo.AccountBalance;
import com.ebixcash.aeps.pojo.BalanceResponse;
import com.ebixcash.aeps.pojo.BankBranchData;
import com.ebixcash.aeps.pojo.BankData;
import com.ebixcash.aeps.pojo.CityData;
import com.ebixcash.aeps.pojo.StateData;

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

    public ArrayList<Object> parseBankTransferReportResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                BankTransferReportResponse bankTransferReportResponse = new BankTransferReportResponse();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("requestdate")) {

                    bankTransferReportResponse.setRequestdate(obj.getString("requestdate"));
                }

                if (obj.has("amount")) {

                    bankTransferReportResponse.setAmount(obj.getString("amount"));
                }

                if (obj.has("accountno")) {

                    bankTransferReportResponse.setAccountno(obj.getString("accountno"));
                }

                if (obj.has("status")) {

                    bankTransferReportResponse.setStatus(obj.getString("status"));
                }

                if (obj.has("Dcode")) {

                    bankTransferReportResponse.setDcode(obj.getString("Dcode"));
                }

                if (obj.has("Settlementid")) {

                    bankTransferReportResponse.setSettlementid(obj.getString("Settlementid"));
                }

                if (obj.has("ifsc")) {

                    bankTransferReportResponse.setIfsc(obj.getString("ifsc"));
                }

                if (obj.has("filegenerated")) {

                    bankTransferReportResponse.setFilegenerated(obj.getString("filegenerated"));
                }

                if (obj.has("transactionid")) {

                    bankTransferReportResponse.setTransactionid(obj.getString("transactionid"));
                }

                if (obj.has("filename")) {

                    bankTransferReportResponse.setFilename(obj.getString("filename"));
                }

                if (obj.has("utr")) {

                    bankTransferReportResponse.setUtr(obj.getString("utr"));
                }

                list.add(bankTransferReportResponse);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
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

    public GetBalanceResponse parseGetBalanceResponse(String response){

        GetBalanceResponse getBalanceResponse = new GetBalanceResponse();

        try{

            JSONObject obj = new JSONObject(response);

            if(obj.has("responseMessage")){

                getBalanceResponse.setResponseMessage(obj.getString("responseMessage"));
            }

            if(obj.has("responseCode")){

                getBalanceResponse.setResponseCode(obj.getString("responseCode"));
            }

            if(obj.has("accountno")){

                getBalanceResponse.setAccountno(obj.getString("accountno"));
            }

            if(obj.has("ifsccode")){

                getBalanceResponse.setIfsccode(obj.getString("ifsccode"));
            }

            if(obj.has("balance")){

                ArrayList<AccountBalance> accountBalanceArrayList = new ArrayList<AccountBalance>();

                JSONArray jsonArray = obj.getJSONArray("balance");

                for(int i = 0; i < jsonArray.length(); i++) {

                    AccountBalance accountBalance = new AccountBalance();

                    JSONObject objArray = jsonArray.getJSONObject(i);

                    if (objArray.has("balance")) {

                        accountBalance.setBalance(objArray.getString("balance"));
                    }

                    if (objArray.has("name")) {

                        accountBalance.setName(objArray.getString("name"));
                    }

                    accountBalanceArrayList.add(accountBalance);
                }

                getBalanceResponse.setAccountBalanceArrayList(accountBalanceArrayList);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return getBalanceResponse;
    }

    public BankTransferResponse parseBankTransferResponse(String response){

        BankTransferResponse bankTransferResponse = new BankTransferResponse();

        try{

            JSONObject obj = new JSONObject(response);

            if(obj.has("username")){

                bankTransferResponse.setUsername(obj.getString("username"));
            }

            if(obj.has("transCode")){

                bankTransferResponse.setTransCode(obj.getString("transCode"));
            }

            if(obj.has("dcode")){

                bankTransferResponse.setDcode(obj.getString("dcode"));
            }

            if(obj.has("easywallet")){

                bankTransferResponse.setEasywallet(obj.getString("easywallet"));
            }

            if(obj.has("responseCode")){

                bankTransferResponse.setResponseCode(obj.getString("responseCode"));
            }

            if(obj.has("responseMessage")){

                bankTransferResponse.setResponseMessage(obj.getString("responseMessage"));
            }

            if(obj.has("orderId")){

                bankTransferResponse.setOrderID(obj.getString("orderId"));
            }

            if(obj.has("transactionId")){

                bankTransferResponse.setTransactionID(obj.getString("transactionId"));
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return bankTransferResponse;
    }

    public SearchByIFSCCodeResponse parseSearchByIFSCCodeResponseResponse(String response){

        SearchByIFSCCodeResponse searchByIFSCCodeResponse = null;

        try{

            JSONObject obj = new JSONObject(response);

            searchByIFSCCodeResponse = new SearchByIFSCCodeResponse();

            if(obj.has("branchName")){

                searchByIFSCCodeResponse.setBranchName(obj.getString("branchName"));
            }

            if(obj.has("ifscCode")){

                searchByIFSCCodeResponse.setIfscCode(obj.getString("ifscCode"));
            }

            if(obj.has("bankName")){

                searchByIFSCCodeResponse.setBankName(obj.getString("bankName"));
            }

            if(obj.has("cityName")){

                searchByIFSCCodeResponse.setCityName(obj.getString("cityName"));
            }

            if(obj.has("stateName")){

                searchByIFSCCodeResponse.setStateName(obj.getString("stateName"));
            }

            if(obj.has("address")){

                searchByIFSCCodeResponse.setAddress(obj.getString("address"));
            }

            if(obj.has("isimps")){

                searchByIFSCCodeResponse.setIsimps(obj.getString("isimps"));
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return searchByIFSCCodeResponse;
    }

    public LinkAccountResponse parseLinkAccountResponse(String response){

        LinkAccountResponse linkAccountResponse = new LinkAccountResponse();

        try{

            JSONObject obj = new JSONObject(response);

            if(obj.has("accountno")){

                linkAccountResponse.setAccountno(obj.getString("accountno"));
            }

            if(obj.has("ifsc")){

                linkAccountResponse.setIfsc(obj.getString("ifsc"));
            }

            if(obj.has("transCode")){

                linkAccountResponse.setTransCode(obj.getString("transCode"));
            }

            if(obj.has("dcode")){

                linkAccountResponse.setDcode(obj.getString("dcode"));
            }

            if(obj.has("responseCode")){

                linkAccountResponse.setResponsecode(obj.getString("responseCode"));
            }

            if(obj.has("responsedesc")){

                linkAccountResponse.setResponsedesc(obj.getString("responsedesc"));
            }

            if(obj.has("responseMessage")){

                linkAccountResponse.setResponseMessage(obj.getString("responseMessage"));
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return linkAccountResponse;
    }

    public ArrayList<Object> parseBankDataResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                BankData bankData = new BankData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("bankId")) {

                    bankData.setBankId(obj.getString("bankId"));
                }

                if (obj.has("bankName")) {

                    bankData.setBankName(obj.getString("bankName"));
                }

                if (obj.has("ifscCode")) {

                    bankData.setIfscCode(obj.getString("ifscCode"));
                }

                if (obj.has("isimps")) {

                    bankData.setIsimps(obj.getString("isimps"));
                }

                list.add(bankData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Object> parseStateDataResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                StateData stateData = new StateData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("stateId")) {

                    stateData.setStateId(obj.getString("stateId"));
                }

                if (obj.has("stateName")) {

                    stateData.setStateName(obj.getString("stateName"));
                }

                list.add(stateData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Object> parseCityDataResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                CityData cityData = new CityData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("cityId")) {

                    cityData.setCityId(obj.getString("cityId"));
                }

                if (obj.has("cityName")) {

                    cityData.setCityName(obj.getString("cityName"));
                }

                list.add(cityData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Object> parseBankBranchDataResponse(String response){

        ArrayList<Object> list = new ArrayList<Object>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                BankBranchData bankBranchData = new BankBranchData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("branchId")) {

                    bankBranchData.setBranchId(obj.getString("branchId"));
                }

                if (obj.has("branchName")) {

                    bankBranchData.setBranchName(obj.getString("branchName"));
                }

                if (obj.has("ifscCode")) {

                    bankBranchData.setIfscCode(obj.getString("ifscCode"));
                }

                list.add(bankBranchData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<LastTenTransactionResponse> parseLastTenTransactionResponse(String response){

        ArrayList<LastTenTransactionResponse> list = new ArrayList<>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                LastTenTransactionResponse lastTenTransactionResponse = new LastTenTransactionResponse();

                JSONObject obj = jsonArray.getJSONObject(i);



                if (obj.has("transactionId")) {

                    lastTenTransactionResponse.setTransactionId(obj.getString("transactionId"));
                }

                if (obj.has("transactionDate")) {

                    lastTenTransactionResponse.setTransactionDate(obj.getString("transactionDate"));
                }

                if (obj.has("amount")) {

                    lastTenTransactionResponse.setAmount(obj.getString("amount"));
                }

                if (obj.has("senderName")) {

                    lastTenTransactionResponse.setSenderName(obj.getString("senderName"));
                }

                if (obj.has("beneficiaryName")) {

                    lastTenTransactionResponse.setBeneficiaryName(obj.getString("beneficiaryName"));
                }

                if (obj.has("beneficiaryAccountNo")) {

                    lastTenTransactionResponse.setBeneficiaryAccountNo(obj.getString("beneficiaryAccountNo"));
                }

                if (obj.has("transactionStatus")) {

                    lastTenTransactionResponse.setTransactionStatus(obj.getString("transactionStatus"));
                }

                list.add(lastTenTransactionResponse);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<EasyWalletData> parseCheckBalanceResponse(String response){

        ArrayList<EasyWalletData> list = new ArrayList<EasyWalletData>();

        try{

            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++) {

                EasyWalletData easyWalletData = new EasyWalletData();

                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("easyWalletId")) {

                    easyWalletData.setEasyWalletId(obj.getString("easyWalletId"));
                }

                if (obj.has("easyWalletType")) {

                    easyWalletData.setEasyWalletType(obj.getString("easyWalletType"));
                }

                if (obj.has("easyWalletBalance")) {

                    easyWalletData.setEasyWalletBalance(obj.getString("easyWalletBalance"));
                }

                list.add(easyWalletData);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return list;
    }
}
