package com.ebixcash.aeps.api_response_object;


import com.ebixcash.aeps.pojo.BankBranchData;

import java.util.ArrayList;

public class BankBranchListResponse {

    private ArrayList<BankBranchData> bankBranchDataArrayList;

    public ArrayList<BankBranchData> getBankBranchDataArrayList() {
        return bankBranchDataArrayList;
    }

    public void setBankBranchDataArrayList(ArrayList<BankBranchData> bankBranchDataArrayList) {
        this.bankBranchDataArrayList = bankBranchDataArrayList;
    }
}
