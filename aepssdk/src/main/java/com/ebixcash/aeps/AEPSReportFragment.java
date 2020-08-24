package com.ebixcash.aeps;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ebixcash.aeps.Utils.Constants;
import com.ebixcash.aeps.Utils.Util;
import com.ebixcash.aeps.adapter.BankTrasferReportListAdapter;
import com.ebixcash.aeps.api_request_object.BankTransferReportRequest;
import com.ebixcash.aeps.parser.ParseResponse;
import com.ebixcash.aeps.pojo.AEPSReportData;
import com.ebixcash.aeps.pojo.SettelRequestBodyModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class AEPSReportFragment extends Fragment implements View.OnClickListener {

    private ArrayList<Object> bankTransferReportList;

    private Context context;

    private Util util;

    private TextView textViewFromDate, textViewToDate, textViewDcode, textViewTerminalId, textViewCSRId;

    private RelativeLayout layoutDisplay, layoutPDF, layoutXlx;

    private int mYear, mMonth, mDay;

    private String fromDate = "", toDate = "";

    private ArrayAdapter<String> listAdapter;

    private RecyclerView listView;

    private ImageView imageViewFromCalendar, imageViewToCalendar;

    private SettelRequestBodyModel requestBodyModel;

    private LinearLayout layoutTransactWithdraw,layoutTransactBalance;

    private TextView tvWithdraw,tvBalance,tvReport;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aepsreport, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        context = getActivity();

        util = new Util(context);

        initView(view);

        return view;
    }

    @SuppressLint("SimpleDateFormat")
    private void initView(View view) {

        layoutDisplay = (RelativeLayout) view.findViewById(R.id.layout_aeps_bank_transfer_display);

        layoutTransactWithdraw = (LinearLayout) view.findViewById(R.id.layout_aeps_transact_withdraw);

        layoutTransactBalance = (LinearLayout) view.findViewById(R.id.layout_aeps_transact_balance);

        layoutPDF = (RelativeLayout) view.findViewById(R.id.layout_aeps_bank_transfer_pdf);

        layoutXlx = (RelativeLayout) view.findViewById(R.id.layout_aeps_bank_transfer_xlx);

        textViewFromDate = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_from_date);

        textViewToDate = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_to_date);

        textViewDcode = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_dcode_value);

        textViewCSRId = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_csr_id_value);

        textViewTerminalId = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_terminal_id_value);

        listView = (RecyclerView) view.findViewById(R.id.list_view);

        imageViewFromCalendar = (ImageView) view.findViewById(R.id.image_view_from_calendar);

        imageViewToCalendar = (ImageView) view.findViewById(R.id.image_view_to_calendar);

        tvWithdraw = (TextView) view.findViewById(R.id.tvWithdraw);

        tvBalance = (TextView) view.findViewById(R.id.tvBalance);

        tvReport = (TextView) view.findViewById(R.id.tvReport);

        tvBalance.setOnClickListener(this);

        tvWithdraw.setOnClickListener(this);

        tvReport.setOnClickListener(this);


        layoutDisplay.setOnClickListener(this);

        textViewFromDate.setOnClickListener(this);

        layoutTransactWithdraw.setOnClickListener(this);

        layoutTransactBalance.setOnClickListener(this);

        textViewToDate.setOnClickListener(this);

        imageViewFromCalendar.setOnClickListener(this);

        imageViewToCalendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.txt_aeps_bank_transfer_from_date) {

            openCalender(textViewFromDate);

        }else if (v.getId() == R.id.txt_aeps_bank_transfer_to_date) {

            openCalender(textViewToDate);

        }else if (v.getId() == R.id.layout_aeps_bank_transfer_display) {

            try {

                String fromDateString = util.dateFormatForAPI(textViewFromDate.getText().toString());

                String toDateString = util.dateFormatForAPI(textViewToDate.getText().toString());

                fromDate = fromDateString;

                toDate = toDateString;

                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

                linkedHashMap.put("From Date", fromDate);

                linkedHashMap.put("To Date", toDate);

                String validateStr = util.validateData(linkedHashMap);

                if (validateStr.equals("")) {

                    boolean networkFlag = util.checkInternetConnection();

                    if (networkFlag == true) {

                        callAPI();

                    }else{

                        util.alertboxConnectivity("Alert!", Constants.CONNECTIVITY_MESSAGE);
                    }

                } else {

                    util.alertboxConnectivity("Alert!", validateStr);
                }

            }catch (Exception e){

                e.printStackTrace();
            }

        }else if (v.getId() == R.id.image_view_from_calendar) {

            openCalender(textViewFromDate);

        }else if (v.getId() == R.id.image_view_to_calendar) {

            openCalender(textViewToDate);
        }

        else if (v.getId() == R.id.tvWithdraw) {

            TransactFragment fragment = new TransactFragment();

            Bundle bundle = new Bundle();

            bundle.putString("click","withdraw");

            fragment.setArguments(bundle);

            replaceFragment(fragment);

        }else if (v.getId() == R.id.tvBalance) {

            TransactFragment fragment = new TransactFragment();

            Bundle bundle = new Bundle();

            bundle.putString("click","balance");

            fragment.setArguments(bundle);

            replaceFragment(fragment);
        }
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.layout, fragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    private void openCalender(final TextView textView){

        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);

        mMonth = c.get(Calendar.MONTH);

        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                try {

                    String dateStr = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                    Date date = format.parse(dateStr);

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    String strDate = dateFormat.format(date);

                    textView.setText(strDate);


                    SimpleDateFormat checkDateformat = new SimpleDateFormat("dd/MM/yyyy");

                    Date fromDate = checkDateformat.parse(textViewFromDate.getText().toString());

                    Date toDate = checkDateformat.parse(textViewToDate.getText().toString());

                    if(fromDate.before(toDate) || fromDate.equals(toDate)) {

                        long diffInMillies = Math.abs(toDate.getTime() - fromDate.getTime());

                        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                        if(diff <= 15){

                        }else{

                            textViewToDate.setText("");

                            util.alertboxConnectivity("Alert!", "Maximum 15 days are allowed for statement request.");
                        }

                    }else{

                        textViewFromDate.setText("");

                        textViewToDate.setText("");

                        util.alertboxConnectivity("Alert!", "From date should be less than or equal to To date.");
                    }

                }catch (Exception e){

                    e.printStackTrace();
                }
            }

        }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }

    private void callAPI(){

        AEPSIntent aepsIntent = new AEPSIntent(getActivity().getIntent());

        String transCode = "R1";

        String dcode = aepsIntent.getDcode();

        String moduleName = "AEPS";

        BankTransferReportRequest.createBankTransferReportRequestObject(fromDate, toDate, transCode, dcode, moduleName);

        new BackgroundTask().execute();
    }

    private class BackgroundTask extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {

            super.onPreExecute();

            util.showProgressDialog(context, true);
        }

        @Override
        protected Void doInBackground(Void... params) {

            try{

                String url = Constants.AEPS_BASE_URL + "AEPSAPI";

                Gson gson = new GsonBuilder().disableHtmlEscaping().create();

                String jsonString = gson.toJson(BankTransferReportRequest.getBankTransferReportRequestObject());

                System.out.println("WITHDRAW REQUEST: "+jsonString);

                System.out.println("AEPS URL :"+url);

                String response = util.httpPostJsonRequest(url, jsonString);

                System.out.println("RESPONSE :" + response);

                if(!response.equals("")) {

                    ParseResponse parseResponse = new ParseResponse();

                    bankTransferReportList = parseResponse.parseAEPSReportResponse(response);
                }

            }catch(Exception e){

                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            try{

                util.showProgressDialog(context, false);

                if(!bankTransferReportList.isEmpty()){

                    createAdapter(bankTransferReportList, listView);

                }else{

                    Toast.makeText(context, "No records found.", Toast.LENGTH_LONG).show();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }

    public void createAdapter(List<Object> dataList, RecyclerView listView) {

        //Collections.reverse(dataList);

        for (int i = 0; i < dataList.size(); i++) {

            AEPSReportData aepsReportData = (AEPSReportData) dataList.get(i);

            aepsReportData.setSelected(false);
        }

        BankTrasferReportListAdapter adapter = new BankTrasferReportListAdapter(getActivity(), dataList) {

            @Override
            protected void onSettelClicke(int position) {

                boolean networkFlag = util.checkInternetConnection();

                if (networkFlag == true) {

                    callSettelApi(position, dataList);

                }else{

                    util.alertboxConnectivity("Alert!", Constants.CONNECTIVITY_MESSAGE);
                }
            }
        };

        listView.setAdapter(adapter);
    }

    private void callSettelApi(int position, List<Object> dataList) {

        AEPSReportData bankTransferReportResponse = (AEPSReportData) dataList.get(position);

        requestBodyModel = new SettelRequestBodyModel();

        requestBodyModel.setDcode(bankTransferReportResponse.getAgentid());

        requestBodyModel.setOrderId(bankTransferReportResponse.getOrderid());

        requestBodyModel.setTransCode("TC");

        new SettelBackgroundTask().execute();
    }

    private class SettelBackgroundTask extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {

            super.onPreExecute();

            util.showProgressDialog(context, true);
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

                String url = Constants.AEPS_BASE_URL + "AEPSAPI";

                Gson gson = new GsonBuilder().disableHtmlEscaping().create();

                String jsonString = gson.toJson(requestBodyModel);

                System.out.println("WITHDRAW REQUEST: " + jsonString);

                System.out.println("AEPS URL :" + url);

                String response = util.httpPostJsonRequest(url, jsonString);

                System.out.println("RESPONSE :" + response);

                if (!response.equals("")) {

                    Toast.makeText(context, response, Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            try {

                util.showProgressDialog(context, false);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
