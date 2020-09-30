package com.ebixcash.aeps.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.ebixcash.aeps.R;
import com.ebixcash.aeps.pojo.BankBranchData;
import com.ebixcash.aeps.pojo.BankData;
import com.ebixcash.aeps.pojo.BankDetail;
import com.ebixcash.aeps.pojo.CityData;
import com.ebixcash.aeps.pojo.FranshiseeDetailData;
import com.ebixcash.aeps.pojo.StateData;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteCustomListAdapter extends ArrayAdapter {

    private List<Object> dataList;

    private Context mContext;

    private int itemLayout;

    private ListFilter listFilter = new ListFilter();

    private List<Object> dataListAllItems;

    public AutoCompleteCustomListAdapter(Context context, int resource, List<Object> storeDataLst) {

        super(context, resource, storeDataLst);

        dataList = storeDataLst;

        mContext = context;

        itemLayout = resource;
    }

    @Override
    public int getCount() {

        return dataList.size();
    }

    @Override
    public Object getItem(int position) {

        return dataList.get(position);
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        if (view == null) {

            view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        }

        TextView strName = (TextView) view.findViewById(R.id.textView);

        Object object = getItem(position);

        if(object instanceof BankData){

            BankData bankData = (BankData) object;

            strName.setText(bankData.getBankName());

        }else if(object instanceof StateData){

            StateData stateData = (StateData) object;

            strName.setText(stateData.getStateName());

        }else if(object instanceof CityData){

            CityData cityData = (CityData) object;

            strName.setText(cityData.getCityName());

        }else if(object instanceof BankBranchData){

            BankBranchData bankBranchData = (BankBranchData) object;

            strName.setText(bankBranchData.getBranchName());

        }else if(object instanceof BankDetail){

            BankDetail bankDetail = (BankDetail) object;

            strName.setText(bankDetail.getBankName());

        }else if(object instanceof FranshiseeDetailData){

            FranshiseeDetailData franshiseeDetailData = (FranshiseeDetailData) object;

            String name = "";

            if(franshiseeDetailData.getName1() != null){

                name += franshiseeDetailData.getName1();
            }

            if(franshiseeDetailData.getName2() != null){

                name += franshiseeDetailData.getName2();
            }

            strName.setText(name);
        }

        return view;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        return listFilter;
    }

    public class ListFilter extends Filter {

        private Object lock = new Object();

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {

            FilterResults results = new FilterResults();

            if (dataListAllItems == null) {

                synchronized (lock) {

                    dataListAllItems = new ArrayList<Object>(dataList);
                }
            }

            if (prefix == null || prefix.length() == 0) {

                synchronized (lock) {

                    results.values = dataListAllItems;

                    results.count = dataListAllItems.size();
                }

            } else {

                final String searchStrLowerCase = prefix.toString().toLowerCase();

                ArrayList<Object> matchValues = new ArrayList<Object>();

                for (Object dataItem : dataListAllItems) {

                    if(dataItem instanceof BankData){

                        BankData bankData = (BankData) dataItem;

                        if (bankData.getBankName().toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }

                    }else if(dataItem instanceof StateData){

                        StateData stateData = (StateData) dataItem;

                        if (stateData.getStateName().toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }

                    }else if(dataItem instanceof CityData){

                        CityData cityData = (CityData) dataItem;

                        if (cityData.getCityName().toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }

                    }else if(dataItem instanceof BankBranchData){

                        BankBranchData bankBranchData = (BankBranchData) dataItem;

                        if (bankBranchData.getBranchName().toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }

                    }else if(dataItem instanceof BankDetail){

                        BankDetail bankDetail = (BankDetail) dataItem;

                        if (bankDetail.getBankName().toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }

                    }else if(dataItem instanceof FranshiseeDetailData){

                        FranshiseeDetailData franshiseeDetailData = (FranshiseeDetailData) dataItem;

                        String name = "";

                        if(franshiseeDetailData.getName1() != null){

                            name += franshiseeDetailData.getName1();
                        }

                        if(franshiseeDetailData.getName2() != null){

                            name += franshiseeDetailData.getName2();
                        }

                        if (name.toLowerCase().startsWith(searchStrLowerCase)) {

                            matchValues.add(dataItem);
                        }
                    }

                }

                results.values = matchValues;

                results.count = matchValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            if (results.values != null) {

                dataList = (ArrayList<Object>)results.values;

            } else {

                dataList = null;
            }

            if (results.count > 0) {

                notifyDataSetChanged();

            } else {

                notifyDataSetInvalidated();
            }
        }
    }
}