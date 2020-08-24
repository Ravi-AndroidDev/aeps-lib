package com.ebixcash.aeps.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ebixcash.aeps.R;
import com.ebixcash.aeps.api_response_object.BankTransferReportResponse;
import com.ebixcash.aeps.pojo.AEPSReportData;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private Context context;

    List<Object> dataList = new ArrayList<Object>();

    public CustomListAdapter(Context context, int textViewResourceId, String[] objects, List<Object> dataList) {

        super(context, textViewResourceId, objects);

        this.dataList = dataList;

        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        view = inflater.inflate(R.layout.row_aeps_bank_transfer_report, parent, false);

        TextView dateTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_date);

        TextView orderIDTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_order_id);

        TextView statusCheckBox = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_status);

        TextView amountTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_amount);

        if(dataList.get(position) instanceof BankTransferReportResponse) {

            BankTransferReportResponse bankTransferReportResponse = (BankTransferReportResponse) dataList.get(position);

            dateTextView.setText("Transaction date: " + bankTransferReportResponse.getRequestdate());

            orderIDTextView.setText("Order Id: " + bankTransferReportResponse.getSettlementid());

            orderIDTextView.setEllipsize(TextUtils.TruncateAt.END);

            String status = "";

            if (bankTransferReportResponse.getStatus().equals("U")) {

                status = "Unsuccessful";
            }

            if (bankTransferReportResponse.getStatus().equals("F")) {

                status = "Failed";
            }

            if (bankTransferReportResponse.getStatus().equals("S")) {

                status = "Success";
            }

            statusCheckBox.setText(Html.fromHtml("Status: " + "<font color=#00a896>" + status + "</font>"));

            amountTextView.setText("Amount: Rs." + bankTransferReportResponse.getAmount());

        }else if(dataList.get(position) instanceof AEPSReportData) {

            AEPSReportData aepsReportData = (AEPSReportData) dataList.get(position);

            dateTextView.setText("Transaction date: " + aepsReportData.getTransactiondate());

            orderIDTextView.setText("Order Id: " + aepsReportData.getOrderid());

            statusCheckBox.setText(Html.fromHtml("Status: " + "<font color=#00a896>" + aepsReportData.getTxnstatus() + "</font>"));

            amountTextView.setText("Amount: Rs." + aepsReportData.getAmount());
        }

        return view;
    }
}
