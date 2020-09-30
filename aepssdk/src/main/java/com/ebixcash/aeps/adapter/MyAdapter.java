package com.ebixcash.aeps.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ebixcash.aeps.R;
import com.ebixcash.aeps.pojo.BankDetail;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private Context context;

    private List<Object> spinnerList = new ArrayList<Object>();

    public MyAdapter(Context context, int textViewResourceId, String[] objects, List<Object> spinnerList) {

        super(context, textViewResourceId, objects);

        this.context = context;

        this.spinnerList = spinnerList;
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();

        View row = inflater.inflate(R.layout.row_spinner, parent, false);

        TextView label = (TextView)row.findViewById(R.id.title);

        if(spinnerList.get(position) instanceof BankDetail){

            BankDetail bankDetail = (BankDetail) spinnerList.get(position);

            label.setText(bankDetail.getBankName());

            row.setTag(bankDetail);
        }

        return row;
    }
}