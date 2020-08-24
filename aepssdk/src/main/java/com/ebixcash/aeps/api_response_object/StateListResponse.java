package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.StateData;

import java.util.ArrayList;

public class StateListResponse {

    private ArrayList<StateData> stateDataArrayList;

    public ArrayList<StateData> getStateDataArrayList() {
        return stateDataArrayList;
    }

    public void setStateDataArrayList(ArrayList<StateData> stateDataArrayList) {
        this.stateDataArrayList = stateDataArrayList;
    }
}
