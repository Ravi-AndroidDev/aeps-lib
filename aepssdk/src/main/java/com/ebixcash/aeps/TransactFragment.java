package com.ebixcash.aeps;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ebixcash.aeps.Utils.Constants;
import com.ebixcash.aeps.Utils.Util;
import com.ebixcash.aeps.adapter.AutoCompleteCustomListAdapter;
import com.ebixcash.aeps.api_request_object.WithdrawRequest;
import com.ebixcash.aeps.parser.ParseResponse;
import com.ebixcash.aeps.pojo.BalanceResponse;
import com.ebixcash.aeps.pojo.BankDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mantra.mfs100.FingerData;
import com.mantra.mfs100.MFS100;
import com.mantra.mfs100.MFS100Event;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TransactFragment extends Fragment implements View.OnClickListener, MFS100Event {

    String adharNumberFirst = "", adharNumberSecond = "";

    private static final String EMPTY_STRING = "";

    private static final String WHITE_SPACE = " ";

    private String lastSource = EMPTY_STRING;

    AlertDialog alertDialog1;

    private BalanceResponse balanceResponse;

    private String selectedTab = "WITHDRAW", xmlBiometricString = "", crId = "";

    private EditText editTextMobileNumber, editTextWithdrawAmount, editTextAdhaarNumberFirst, editTextAdhaarNumberSecond, editTextAdhaarNumberThird, editTextVirtualIDFirst, editTextVirtualIDSecond, editTextVirtualIDThird, editTextVirtualIDFourth;

    private AutoCompleteTextView spinnerBank;

    private RelativeLayout layoutSubmit;

    private CheckBox checkBoxTermsAndConditions;

    private LinearLayout layoutTransactWithdraw, layoutTransactDeposit, layoutTransactBalance;

    private Context context;

    private Util util;

    private ArrayAdapter arrayAdapter;

    String mobileNumber = "", withdrawAmount = "", adhaarNumber = "", virtualID = "", bankName = "", termsAndConditionValue = "";

    private LinearLayout layoutWithdraw;

    private TextView textViewWithdraw, textViewDeposit, textViewBalance;

    private boolean isCaptureRunning = false;

    private FingerData lastCapFingerData = null;

    ScannerAction scannerAction = ScannerAction.Capture;

    private ImageView imageViewWithdraw, imageViewBalance;

    private LinearLayout layout_aeps_report;

    private TextView tvReport,tvWithdraw,tvBalance, txtTermsAndConditions;

    private enum ScannerAction {

        Capture, Verify
    }

    private int timeout = 10000;

    private MFS100 mfs100 = null;

    private byte[] Enroll_Template;

    private byte[] Verify_Template;

    private ArrayList<Object> bankList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_aeps_transact, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        context = getActivity();

        util = new Util(context);

        initView(view);

        String whichTab = getArguments().getString("click");

        if (whichTab.equals("withdraw")) {

            initializeWithdrawTab();

        } else {

            initializeBalanceTab();
        }

        onClickAdharNumberFirst();

        onClickAdharNumberSecond();

        bankList = util.readExcelFileFromAssets();

        createBankSpinner(bankList);

        return view;
    }

    private void createBankSpinner(List<Object> dataList) {

        AutoCompleteCustomListAdapter adapter = new AutoCompleteCustomListAdapter(context, R.layout.layout_autocomplete, dataList);

        spinnerBank.setAdapter(adapter);

        spinnerBank.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Object object = adapterView.getItemAtPosition(i);

            if (object instanceof BankDetail) {

                BankDetail bankDetail = (BankDetail) object;

                bankName = bankDetail.getBankIINNumber();

                System.out.println("BANK IIN NUMBER :" + bankName);

                spinnerBank.setText(bankDetail.getBankName());
            }
        }
    };

    @SuppressLint("SimpleDateFormat")
    private void initView(View view) {

        layoutTransactWithdraw = (LinearLayout) view.findViewById(R.id.layout_aeps_transact_withdraw);

        layoutTransactDeposit = (LinearLayout) view.findViewById(R.id.layout_aeps_transact_deposit);

        layoutTransactBalance = (LinearLayout) view.findViewById(R.id.layout_aeps_transact_balance);


        layout_aeps_report = (LinearLayout) view.findViewById(R.id.layout_aeps_report);


        layoutWithdraw = (LinearLayout) view.findViewById(R.id.layout_withdraw);

        editTextMobileNumber = (EditText) view.findViewById(R.id.edittext_aeps_transact_mobile_number);

        editTextWithdrawAmount = (EditText) view.findViewById(R.id.edittext_aeps_transact_withdraw_amount);

        editTextAdhaarNumberFirst = (EditText) view.findViewById(R.id.edittext_aeps_transact_adhaar_number_first);

        editTextAdhaarNumberSecond = (EditText) view.findViewById(R.id.edittext_aeps_transact_adhaar_number_second);

        editTextAdhaarNumberThird = (EditText) view.findViewById(R.id.edittext_aeps_transact_adhaar_number_third);

        editTextVirtualIDFirst = (EditText) view.findViewById(R.id.edittext_aeps_transact_virtual_id_first);

        editTextVirtualIDSecond = (EditText) view.findViewById(R.id.edittext_aeps_transact_virtual_id_second);

        editTextVirtualIDThird = (EditText) view.findViewById(R.id.edittext_aeps_transact_virtual_id_third);

        editTextVirtualIDFourth = (EditText) view.findViewById(R.id.edittext_aeps_transact_virtual_id_fourth);

        spinnerBank = (AutoCompleteTextView) view.findViewById(R.id.spinner_aeps_transact_select_bank);

        checkBoxTermsAndConditions = (CheckBox) view.findViewById(R.id.checkBox_terms_and_conditions);

        txtTermsAndConditions = (TextView) view.findViewById(R.id.txt_terms_and_conditions);

        layoutSubmit = (RelativeLayout) view.findViewById(R.id.layout_submit);

        tvWithdraw = (TextView) view.findViewById(R.id.tvWithdraw);

        tvBalance = (TextView) view.findViewById(R.id.tvBalance);

        tvReport = (TextView) view.findViewById(R.id.tvReport);

        layoutSubmit.setEnabled(false);

        textViewWithdraw = (TextView) view.findViewById(R.id.txt_aeps_transact_withdraw);

        textViewDeposit = (TextView) view.findViewById(R.id.txt_aeps_transact_deposit);

        textViewBalance = (TextView) view.findViewById(R.id.txt_aeps_transact_balance);

        imageViewBalance = (ImageView) view.findViewById(R.id.aeps_image_view_balance);

        imageViewWithdraw = (ImageView) view.findViewById(R.id.aeps_image_view_withdraw);


        layoutTransactWithdraw.setOnClickListener(this);

        layoutTransactDeposit.setOnClickListener(this);

        layoutTransactBalance.setOnClickListener(this);

        layoutSubmit.setOnClickListener(this);

        layout_aeps_report.setOnClickListener(this);

        tvBalance.setOnClickListener(this);

        tvWithdraw.setOnClickListener(this);

        txtTermsAndConditions.setOnClickListener(this);

        tvReport.setOnClickListener(this);

        onClickCheckBoxTAndC();

        setTAndCSelected();
    }

    private void setTAndCSelected(){

        checkBoxTermsAndConditions.setChecked(true);

        termsAndConditionValue = "true";

        layoutSubmit.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

        layoutSubmit.setEnabled(true);
    }

    private void initializeWithdrawTab(){

        tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

        tvBalance.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        tvReport.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        selectedTab = "WITHDRAW";

        editTextWithdrawAmount.setVisibility(View.VISIBLE);

        resetData();
    }

    private void initializeBalanceTab(){

        tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        tvBalance.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

        tvReport.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        selectedTab = "BALANCE";

        editTextWithdrawAmount.setVisibility(View.GONE);

        resetData();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.tvWithdraw) {

            initializeWithdrawTab();

        } else if (v.getId() == R.id.tvBalance) {

            initializeBalanceTab();

        } else if (v.getId() == R.id.tvReport) {

            replaceFragment(new AEPSReportFragment());

        } else if (v.getId() == R.id.layout_submit) {

            onClickSubmit();

        } else if (v.getId() == R.id.layout_aeps_report) {

            replaceFragment(new AEPSReportFragment());

        }else if (v.getId() == R.id.txt_terms_and_conditions) {

            String message = "I hereby voluntarily submit at my own discretion, the above Aadhaar number for authentication of my details for the purpose of enrolling or using Aadhaar enabled Payment System (AePS) of RBL Bank . The consent and purpose of collecting Aadhaar has been explained to me in local language. I hereby give consent to authenticate and establishing my identity/ address proof for enabling use of AePS. EbixCash/RBL Bank has informed me that my Aadhaar number submitted to RBL Bank shall not be used for any other purpose except as mentioned above, or as per statutory requirements of law.";

            util.alertboxConnectivity("Info", message);
        }
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.layout, fragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    private void captureFingerPrint() {

        boolean networkFlag = util.checkInternetConnection();

        if (networkFlag == true) {

            Intent intent = new Intent();

            intent.setAction("in.gov.uidai.rdservice.fp.INFO");

            startActivityForResult(intent, 1);

        }else{

            util.alertboxConnectivity("Alert!", Constants.CONNECTIVITY_MESSAGE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            String result = data.getStringExtra("DEVICE_INFO");

            String rdService = data.getStringExtra("RD_SERVICE_INFO");

            if (rdService != null) {

                System.out.println("RD SERVICE INFO: " + rdService);
            }

            if (result != null && !rdService.contains("status=\"NOTREADY\"")) {

                String pidOption = "<PidOptions ver=\"2.0\">" +

                        //"<Opts env=\"P\" Dtype=\"P\" fCount=\"1\" fType=\"0\" format=\"0\" iCount=\"0\" iType=\"0\" otp=\"1234\" wadh=\"Hello\" pCount=\"0\" pType=\"0\" pidVer=\"2.0\" posh=\"UNKNOWN\" timeout=\"10000\"/>" +
                        "<Opts env=\"P\" Dtype=\"P\" fCount=\"1\" fType=\"0\" format=\"1\" iCount=\"0\" iType=\"0\" pCount=\"0\" pType=\"0\" pidVer=\"2.0\" timeout=\"30000\"/>" +

                        "</PidOptions>";

                Intent intent2 = new Intent();

                intent2.setAction("in.gov.uidai.rdservice.fp.CAPTURE");

                intent2.putExtra("PID_OPTIONS", pidOption);

                startActivityForResult(intent2, 2);

            } else {

                util.alertboxConnectivity("Alert!", "Device not ready");
            }
        }

        if (requestCode == 2) {

            String result = data.getStringExtra("PID_DATA");

            if (result != null) {

                try {

                    xmlBiometricString = "<?xml version=\"1.0\"?>" + result;

                    xmlBiometricString = xmlBiometricString.replaceAll("\"", "'");

                    xmlBiometricString = xmlBiometricString.replaceAll("\n", "");

                    byte[] byteText = xmlBiometricString.getBytes(Charset.forName("UTF-8"));

                    xmlBiometricString = new String(byteText, "UTF-8");

                    /*if(xmlBiometricString.contains("errInfo")){

                        util.alertboxConnectivity("Alert!", "Unknown error occured. Please try again.");

                    }else{

                        callWithdrawAPI(xmlBiometricString);
                    }*/
                    callWithdrawAPI(xmlBiometricString);

                    System.out.println("RESULT PID DATA 1: " + xmlBiometricString);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
    }

    private void callWithdrawAPI(String xmlBiometricString) {

        AEPSIntent aepsIntent = new AEPSIntent(getActivity().getIntent());

        String username = aepsIntent.getUsername();

        String dcode = aepsIntent.getDcode();

        String transCode = "";

        String bankIINNumber = bankName;

        long uniqueID = (long) (System.currentTimeMillis());

        crId = "AEPS" + String.valueOf(uniqueID);

        if (selectedTab.equals("WITHDRAW")) {

            transCode = "CW";
        }

        if (selectedTab.equals("DEPOSIT")) {

            transCode = "CD";
        }

        if (selectedTab.equals("BALANCE")) {

            transCode = "BE";
        }

        WithdrawRequest.createWithdrawRequestObject(withdrawAmount, bankIINNumber, xmlBiometricString, adhaarNumber, crId, transCode, username, dcode, mobileNumber);

        boolean networkFlag = util.checkInternetConnection();

        if (networkFlag == true) {

            new GetCallFromCounselorTask().execute();

        }else{

            util.alertboxConnectivity("Alert!", Constants.CONNECTIVITY_MESSAGE);
        }
    }

    private void onClickCheckBoxTAndC() {

        checkBoxTermsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    termsAndConditionValue = "true";

                    layoutSubmit.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

                    layoutSubmit.setEnabled(true);

                } else {

                    layoutSubmit.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

                    layoutSubmit.setEnabled(false);
                }
            }
        });
    }

    private void onClickSubmit() {

        mobileNumber = editTextMobileNumber.getText().toString();

        withdrawAmount = editTextWithdrawAmount.getText().toString();

        adhaarNumber = editTextAdhaarNumberFirst.getText().toString() + editTextAdhaarNumberSecond.getText().toString() + editTextAdhaarNumberThird.getText().toString();

        virtualID = editTextVirtualIDFirst.getText().toString() + editTextVirtualIDSecond.getText().toString() + editTextVirtualIDThird.getText().toString() + editTextVirtualIDFourth.getText().toString();

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

        linkedHashMap.put("Mobile number", mobileNumber);

        if (selectedTab.equals("WITHDRAW")) {

            linkedHashMap.put("Withdraw Amount", withdrawAmount);
        }

        if (adhaarNumber.equals("") && virtualID.equals("")) {

            linkedHashMap.put("Adhaar Number / Virtual id", adhaarNumber);
        }

        linkedHashMap.put("Select Bank", bankName);

        linkedHashMap.put("Terms and Conditions", termsAndConditionValue);

        String validateStr = util.validateData(linkedHashMap);

        if (validateStr.equals("")) {

            if(mobileNumber.length() == 10) {

                if (adhaarNumber.length() == 12 || virtualID.length() == 16) {

                    if (selectedTab.equals("WITHDRAW") && Integer.parseInt(withdrawAmount) >= 100 && Integer.parseInt(withdrawAmount) <= 10000) {

                        captureFingerPrint();

                    } else {

                        if (selectedTab.equals("BALANCE")) {

                            captureFingerPrint();

                        } else {

                            util.alertboxConnectivity("Alert!", "Amount should be in between 100 and 10000.");
                        }
                    }

                } else {

                    util.alertboxConnectivity("Alert!", "Please enter valid adhaar number.");
                }

            }else{

                util.alertboxConnectivity("Alert!", "Please enter valid mobile number.");
            }

        } else {

            util.alertboxConnectivity("Alert!", validateStr);
        }
    }

    @Override
    public void OnHostCheckFailed(String err) {

        try {

            System.out.println(err);

        } catch (Exception ignored) {

        }
    }

    @Override
    public void OnDeviceDetached() {

        System.out.println("Device removed");
    }

    @Override

    public void OnDeviceAttached(int vid, int pid, boolean hasPermission) {

        int ret;

        if (!hasPermission) {

            System.out.println("Permission denied");

            return;
        }

        if (vid == 1204 || vid == 11279) {

            if (pid == 34323) {

                ret = mfs100.LoadFirmware();

                if (ret != 0) {

                    System.out.println(mfs100.GetErrorMsg(ret));

                } else {

                    System.out.println("Load firmware success");

                }

            } else if (pid == 4101) {

                String key = "Without Key";

                ret = mfs100.Init();

                if (ret == 0) {

                    System.out.println(key);

                } else {

                    System.out.println(mfs100.GetErrorMsg(ret));
                }
            }
        }
    }

    private class GetCallFromCounselorTask extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {

            super.onPreExecute();

            util.showProgressDialog(context, true);
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

                String url = Constants.AEPS_BASE_URL + "AEPSAPI";

                Gson gson = new GsonBuilder().disableHtmlEscaping().create();

                String jsonString = gson.toJson(WithdrawRequest.getWithdrawRequestObject());

                System.out.println("WITHDRAW REQUEST: " + jsonString);

                System.out.println("AEPS URL :" + url);

                String response = util.httpPostJsonRequest(url, jsonString);

                System.out.println("RESPONSE :" + response);

                if (!response.equals("")) {

                    ParseResponse parseResponse = new ParseResponse();

                    balanceResponse = parseResponse.parseBalanceResponse(response);
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

                if (balanceResponse != null) {

                    if (balanceResponse.getErrorMessage() != null) {

                        util.alertboxConnectivity("Alert!", balanceResponse.getErrorMessage());

                    } else {

                        createAlertBox(balanceResponse);
                    }

                } else {

                    String message = crId + " is your CR ID, Please contact customer care in case amount has been deducted.";

                    util.alertboxConnectivity("Alert!", message);
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void createAlertBox(BalanceResponse balanceResponse) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.layout_aeps_receipt, null);

        alertDialog.setView(view);

        alertDialog1 = alertDialog.create();

        alertDialog1.setCancelable(false);

        TextView textViewAlertHeader = (TextView) view.findViewById(R.id.txt_aeps_receipt_successful);

        TextView dateAndTime = (TextView) view.findViewById(R.id.aeps_receipt_txt_date_and_time);

        TextView terminalId = (TextView) view.findViewById(R.id.aeps_receipt_txt_terminal_id);

        TextView agentId = (TextView) view.findViewById(R.id.aeps_receipt_txt_agent_id);

        TextView bcName = (TextView) view.findViewById(R.id.aeps_receipt_txt_bc_name);

        TextView bcLocation = (TextView) view.findViewById(R.id.aeps_receipt_txt_bc_location);

        TextView adhaarNumber = (TextView) view.findViewById(R.id.aeps_receipt_txt_adhaar_number);

        TextView rrn = (TextView) view.findViewById(R.id.aeps_receipt_txt_rrn);

        TextView stan = (TextView) view.findViewById(R.id.aeps_receipt_txt_stan);

        TextView mATMReqId = (TextView) view.findViewById(R.id.aeps_receipt_txt_matm_req_id);

        TextView uidaiAuthCode = (TextView) view.findViewById(R.id.aeps_receipt_txt_uidai_auth_code);

        TextView transactionStatus = (TextView) view.findViewById(R.id.aeps_receipt_txt_transaction_status);

        TextView accountBalance = (TextView) view.findViewById(R.id.aeps_receipt_txt_account_balance);

        TextView responseCode = (TextView) view.findViewById(R.id.aeps_receipt_txt_response_code);

        TextView responseMessage = (TextView) view.findViewById(R.id.aeps_receipt_txt_response_message);

        TextView textViewTransactionAmount = (TextView) view.findViewById(R.id.aeps_receipt_txt_amount);

        RelativeLayout layoutPDF = (RelativeLayout) view.findViewById(R.id.layout_aeps_receipt_pdf);

        RelativeLayout layoutSMS = (RelativeLayout) view.findViewById(R.id.layout_aeps_receipt_sms);

        RelativeLayout layoutNewRequest = (RelativeLayout) view.findViewById(R.id.layout_aeps_receipt_new_request);

        ImageView imageViewClose = (ImageView) view.findViewById(R.id.image_view_aeps_receipt_close);

        LinearLayout layoutAmount = (LinearLayout) view.findViewById(R.id.layout_aeps_receipt_amount);


        dateAndTime.setText(balanceResponse.getDateAndTime());

        terminalId.setText(balanceResponse.getTerminalId());

        agentId.setText(balanceResponse.getAgentId());

        bcName.setText(balanceResponse.getBcName());

        bcLocation.setText(balanceResponse.getBcLocation());

        adhaarNumber.setText(balanceResponse.getAadhaarNo());

        rrn.setText(balanceResponse.getRrn());

        stan.setText(balanceResponse.getStan());

        mATMReqId.setText(balanceResponse.getmATMReqId());

        uidaiAuthCode.setText(balanceResponse.getUidaiAuthCode());

        transactionStatus.setText(balanceResponse.getTxnStatus());

        accountBalance.setText(balanceResponse.getAcBalance());

        responseCode.setText(balanceResponse.getResponseCode());

        responseMessage.setText(balanceResponse.getResponseMessage());

        textViewAlertHeader.setText("Transaction " + balanceResponse.getTxnStatus());

        if (selectedTab.equals("WITHDRAW")) {

            layoutAmount.setVisibility(View.VISIBLE);

        } else {

            layoutAmount.setVisibility(View.GONE);
        }

        textViewTransactionAmount.setText("Rs." + balanceResponse.getTxnAmount());

        imageViewClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resetData();
            }
        });

        layoutNewRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resetData();
            }
        });

        alertDialog1.setInverseBackgroundForced(false);

        alertDialog1.show();
    }

    private void resetData() {

        if (alertDialog1 != null && alertDialog1.isShowing()) {

            alertDialog1.dismiss();
        }

        editTextMobileNumber.setText("");

        editTextWithdrawAmount.setText("");

        editTextAdhaarNumberFirst.setText("");

        editTextAdhaarNumberSecond.setText("");

        editTextAdhaarNumberThird.setText("");

        spinnerBank.setSelection(0);
    }

    private void onClickAdharNumberFirst() {


        editTextAdhaarNumberFirst.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adharNumberFirst = editTextAdhaarNumberFirst.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (adharNumberFirst.length() == 4) {

                    editTextAdhaarNumberSecond.requestFocus();
                }
            }
        });
    }

    private void onClickAdharNumberSecond() {

        editTextAdhaarNumberSecond.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adharNumberSecond = editTextAdhaarNumberSecond.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (adharNumberSecond.length() == 4) {

                    editTextAdhaarNumberThird.requestFocus();
                }
            }
        });
    }
}
