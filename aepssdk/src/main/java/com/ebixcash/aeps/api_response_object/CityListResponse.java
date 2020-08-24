package com.ebixcash.aeps.api_response_object;

import com.ebixcash.aeps.pojo.CityData;

import java.util.ArrayList;

public class CityListResponse {

    private ArrayList<CityData> cityDataArrayList;

    public ArrayList<CityData> getCityDataArrayList() {
        return cityDataArrayList;
    }

    public void setCityDataArrayList(ArrayList<CityData> cityDataArrayList) {
        this.cityDataArrayList = cityDataArrayList;
    }
}
