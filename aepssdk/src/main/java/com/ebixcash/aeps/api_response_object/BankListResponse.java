package com.ebixcash.aeps.api_response_object;


import com.ebixcash.aeps.pojo.BankData;

import java.util.ArrayList;

public class BankListResponse {

    private ArrayList<BankData> bankDataArrayList;

    public ArrayList<BankData> getBankDataArrayList() {
        return bankDataArrayList;
    }

    public void setBankDataArrayList(ArrayList<BankData> bankDataArrayList) {
        this.bankDataArrayList = bankDataArrayList;
    }
}
