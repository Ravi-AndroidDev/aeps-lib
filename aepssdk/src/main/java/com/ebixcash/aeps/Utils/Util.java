package com.ebixcash.aeps.Utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.text.Html;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.ebixcash.aeps.R;
import com.ebixcash.aeps.pojo.BalanceResponse;
import com.ebixcash.aeps.pojo.BankDetail;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static android.graphics.Typeface.BOLD;

public class Util {

    public static boolean isAlert = false;

    private static final String ALGORITHM = "AES";

    private static final byte[] keyValue = new byte[]{'J', 'a', 'b', 'T', 'a', 'k', 'h', 'a', 'i', 'J', 'a', 'a', 'n', 'K', 'e', 'y'};

    private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    public static Typeface iconFont;

    private Context context;

    public Util(Context context){

        this.context = context;

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
    }

    public String callAPIUrlWithPost(String strUrl){

        strUrl = strUrl.replaceAll(" ", "%20");

        System.out.println("URLLLLLLLLLLLLLL :"+strUrl);

        String data = "";

        InputStream iStream = null;

        try{

            URL url = new URL(strUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(15000);

            urlConnection.setConnectTimeout(15000);

            urlConnection.setRequestMethod("POST");

            urlConnection.setDoInput(true);

            urlConnection.setDoOutput(true);

            urlConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            urlConnection.setRequestProperty("Accept", "application/json");

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";

            while( ( line = br.readLine())  != null){

                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){

            /*data = new Gson().toJson(createResponseOnConnectionFail());

            System.out.println("ON CONNECTION FAIL POST URL :" + data);*/

            e.printStackTrace();
        }

        return data;
    }

    public String authorize(String userName, String userType)  {

        String authorization="";

        try {

            String passbuffer = userName + ":" + userType;

            byte[] data = passbuffer.getBytes("UTF-8");

            String base64 = Base64.encodeToString(data, Base64.NO_WRAP);

            authorization = "Basic " + base64;

        }catch (UnsupportedEncodingException ex){

            ex.printStackTrace();
        }

        return authorization;
    }

    public String httpPostJsonRequest(String strUrl, String jsonObject){

        String auth = authorize("Ebix", "Ebix@2019");

        InputStream inputStream = null;

        String result = "";

        try {

            URL url = new URL(strUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(60000);

            conn.setConnectTimeout(60000);

            conn.setRequestMethod("POST");

            conn.setDoInput(true);

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            conn.setRequestProperty("Accept", "application/json");

            conn.setRequestProperty("Authorization", auth);

            conn.connect();

            OutputStream os = new BufferedOutputStream(conn.getOutputStream());

            os.write(jsonObject.getBytes());

            os.flush();

            inputStream = conn.getInputStream();

            if(inputStream != null){

                result = convertInputStreamToString(inputStream);
            }
            else{

                result = "Did not work!";
            }

        } catch (Exception e) {

            if(jsonObject.contains("xmlBiometricString")) { //xmlBiometricString means its aeps request

                result = new Gson().toJson(createResponseOnConnectionFailAEPS());

                System.out.println("ON CONNECTION FAIL AEPS :" + result);
            }

            e.printStackTrace();
        }

        return result;
    }

    private BalanceResponse createResponseOnConnectionFailAEPS(){

        BalanceResponse balanceResponse = new BalanceResponse();

        balanceResponse.setErrorMessage(Constants.NETWORK_ERROR_MESSAGE);

        return balanceResponse;
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        String line = "";

        String result = "";

        while((line = bufferedReader.readLine()) != null) {

            result += line;
        }

        inputStream.close();

        return result;
    }

    public JSONObject createJsonObject(LinkedHashMap<String, String> map){

        JSONObject jsonObject = new JSONObject();

        try {

            for (Map.Entry<String, String> entry : map.entrySet()) {

                String key = entry.getKey();

                String value = entry.getValue();

                jsonObject.put(key, value);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return jsonObject;
    }

    public void alertboxConnectivity(String title, String mymessage) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setNeutralButton(android.R.string.ok,

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                showProgressDialog(context, false);
                            }

                        }).show();
    }

    public void alertboxForLogin(String title, String mymessage) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setNeutralButton(android.R.string.ok,

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {


                            }

                        }).show();
    }

    public String validateData(LinkedHashMap<String, String> linkedHashMap){

        String validateStr = "";

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()) {

            String key = entry.getKey();

            String value = entry.getValue();

            if(value.equals("")){

                if(key.equalsIgnoreCase("Terms and Conditions")){

                    validateStr += "Please accept " + key + ".\n";

                }else if(key.contains("select")){

                    validateStr += "Please " + key + ".\n";

                }else {

                    validateStr += "Please enter " + key + ".\n";
                }
            }
        }

        return validateStr;
    }

    public String displayAccountNumber(String number){

        String accountNumber = "";

        for(int i = 0; i < number.length() - 4; i++){

            accountNumber += "X";
        }

        accountNumber += number.substring(number.length() - 4, number.length());

        return accountNumber;
    }

    public String dateFormatForAPI(String date){

        String formattedDate = "";

        if(!date.equals("")){

            String dateArray[] = date.split("/");

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) - 1);

            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[0]));

            calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));

            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            formattedDate = dateFormat.format(calendar.getTime());
        }

        return formattedDate;
    }

    public String dateFormatForMATMReportAPI(String date){//06/16/2020

        String formattedDate = "";

        if(!date.equals("")){

            String dateArray[] = date.split("/");

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[0]) - 1);

            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[1]));

            calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            formattedDate = dateFormat.format(calendar.getTime());
        }

        return formattedDate;
    }

    public String dateFormatForPassbookAPI(String date){

        String formattedDate = "";

        if(!date.equals("")){

            String dateArray[] = date.split("/");

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) - 1);

            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[0]));

            calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            formattedDate = dateFormat.format(calendar.getTime());
        }

        return formattedDate;
    }

    public String dateFormatForRequestHistoryAPI(String date){

        String formattedDate = "";

        if(!date.equals("")){

            String dateArray[] = date.split("/");

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) - 1);

            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[0]));

            calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));

            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

            formattedDate = dateFormat.format(calendar.getTime());
        }

        return formattedDate;
    }

    public String formatReportDateAndTime(String dateAndTime){

        String finalDate = "";

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date date = format.parse(dateAndTime);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            if(dateAndTime.contains(" ")) {

                finalDate = dateFormat.format(date) + " " + formatTime(dateAndTime);

            }else{

                finalDate = dateFormat.format(date);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        return finalDate;
    }

    public String dateFormatForBankReportDisplay(String date){

        String formattedDate = "";

        if(!date.equals("") && date.contains(" ")){

            String dateTimeArray[] = date.split(" ");

            if(dateTimeArray[0].contains("-")) {

                String timeArray[] = dateTimeArray[0].split("-");

                Calendar calendar = Calendar.getInstance();

                calendar.set(Calendar.MONTH, Integer.parseInt(timeArray[1]) - 1);

                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(timeArray[2]));

                calendar.set(Calendar.YEAR, Integer.parseInt(timeArray[0]));

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                if (date.contains(" ")) {

                    formattedDate = dateFormat.format(calendar.getTime()) + " " + formatTime(date);

                } else {

                    formattedDate = dateFormat.format(calendar.getTime());
                }
            }
        }

        return formattedDate;
    }

    public String formatTime(String time){

        String finalDate = "";

        try {

            String timeArray[] = time.split(" ");

            String timeSplitArray[] = timeArray[1].split(":");

            Calendar c = Calendar.getInstance();

            c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSplitArray[0]));

            c.set(Calendar.MINUTE, Integer.parseInt(timeSplitArray[1]));

            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");

            finalDate = dateFormat.format(c.getTime());

        }catch (Exception e){

            e.printStackTrace();
        }

        return finalDate;
    }

    public ArrayList<Object> readExcelFileFromAssets() {

        ArrayList<Object> bankList = new ArrayList<Object>();

        try {

            InputStream myInput;

            AssetManager assetManager = context.getAssets();

            myInput = assetManager.open("iin.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(myInput));

            String line = "";

            while((line = br.readLine()) != null){

                String[] content = line.split("\t");

                String bankName = content[1];

                String bankIIN = content[2];

                String bankAcquirerID = content[3];

                String bankCode = content[4];

                System.out.println("BANK NAME :"+bankName+" BANK IIN: "+bankIIN);

                BankDetail bankDetail = new BankDetail();

                bankDetail.setBankName(bankName);

                bankDetail.setBankIINNumber(bankIIN);

                bankDetail.setAcquirerID(bankAcquirerID);

                bankDetail.setBankCode(bankCode);

                bankList.add(bankDetail);
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return bankList;
    }

    public String getBankNameBasedOnIINNumber(String iinNumber){

        String bankName = "";

        ArrayList<Object> bankList = readExcelFileFromAssets();

        for(int i = 0; i < bankList.size(); i++){

            BankDetail bankDetail = (BankDetail) bankList.get(i);

            if(bankDetail.getBankIINNumber().equals(iinNumber)){

                bankName = bankDetail.getBankName();
            }
        }

        return bankName;
    }

    public String getXMLRequest(String startNode, LinkedHashMap<String, String> linkedHashMap){

        String xml = "<" + startNode + ">";

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()) {

            String key = entry.getKey();

            String value = entry.getValue();

            xml += "<" + key + ">" + value + "</" + key + ">";
        }

        xml += "</" + startNode + ">";

        return xml;
    }

    public String getResponseFromRequest( String paramName, String xmlReq) {

        HashMap<String,String> parameterList = new HashMap<String, String>();

        parameterList.put(paramName, xmlReq);

        String response="";

        try {

            URL url = new URL(Constants.DMT_URL);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : parameterList.entrySet()){

                if (postData.length() != 0) postData.append('&');

                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));

                postData.append('=');

                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

            conn.setDoOutput(true);

            if(xmlReq.contains("fundTransferWalletRequest")) {

                conn.setConnectTimeout(180000);

                //conn.setConnectTimeout(1000);

            }else{

                conn.setConnectTimeout(15000);
            }

            DataOutputStream outputStream = new DataOutputStream( conn.getOutputStream() );

            OutputStreamWriter osw = new OutputStreamWriter(outputStream);

            osw.write(postData.toString());

            osw.flush();

            osw.close();

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (int c; (c = in.read()) >= 0; )

                sb.append((char) c);

            response = sb.toString();

            return  response;

        }catch (Exception excep){

            String startNode = xmlReq.substring(1, xmlReq.indexOf(">"));

            startNode = startNode.replaceAll("Request", "Response");

            response = createExceptionResponse(startNode);

            excep.printStackTrace();
        }

        return response;
    }

    public String getAppVersionResponse(String paramName, String xmlReq) {

        HashMap<String,String> parameterList = new HashMap<String, String>();

        parameterList.put(paramName, xmlReq);

        String response="";

        try {

            URL url = new URL(Constants.APP_VERSION_URL);

            StringBuilder postData = new StringBuilder();

            for (Map.Entry<String, String> param : parameterList.entrySet()){

                if (postData.length() != 0) postData.append('&');

                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));

                postData.append('=');

                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

            conn.setDoOutput(true);

            conn.setConnectTimeout(15000);

            DataOutputStream outputStream = new DataOutputStream( conn.getOutputStream() );

            OutputStreamWriter osw = new OutputStreamWriter(outputStream);

            osw.write(postData.toString());

            osw.flush();

            osw.close();

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (int c; (c = in.read()) >= 0; )

                sb.append((char) c);

            response = sb.toString();

            return  response;

        }catch (Exception excep){

            String startNode = xmlReq.substring(1, xmlReq.indexOf(">"));

            startNode = startNode.replaceAll("Request", "Response");

            response = createExceptionResponse(startNode);

            excep.printStackTrace();
        }

        return response;
    }

    private String createExceptionResponse(String startNode){

        String response = "", message = "";

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

        linkedHashMap.put("responseCode", "-99");

        if(startNode.equalsIgnoreCase("fundTransferWalletResponse")) {

            message = "Something went wrong, Please try again. If amount is debited from your account then same will be credited in 3 working days.";

        }else{

            message = "Something went wrong, Please try again.";
        }

        linkedHashMap.put("responseDesc", message);

        response = getXMLRequest(startNode, linkedHashMap);

        return response;
    }

    public String encryptPassword(String data , String userDefinedKey ){

       String encryptedPassword = "";

        /* try {

            SecretKeySpec skeySpec = new SecretKeySpec(userDefinedKey.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] original = cipher.doFinal(data.getBytes());

            Decoder.BASE64Encoder endecoder = new Decoder.BASE64Encoder();

            encryptedPassword = endecoder.encode(original);

        }catch(Exception e){

            e.printStackTrace();
        }*/

        return encryptedPassword;
    }

    public String dateFormatForDMTTransactions(String date){

        String formattedDate = "";

        if(!date.equals("")){

            String dateTimeArray[] = date.split(" ");

            int day = 0, month = 0, year = 0, hour = 0, minute = 0, second = 0;

            if(dateTimeArray[0].contains("-")){

                String dateArray[] = dateTimeArray[0].split("-");

                day = Integer.parseInt(dateArray[2]);

                month = Integer.parseInt(dateArray[1]);

                year = Integer.parseInt(dateArray[0]);
            }

            if(dateTimeArray[1].contains(":")){

                String timeArray[] = dateTimeArray[1].split(":");

                if(timeArray[2].contains(".")){

                    timeArray[2] = timeArray[2].substring(0, timeArray[2].indexOf("."));
                }

                second = Integer.parseInt(timeArray[2]);

                minute = Integer.parseInt(timeArray[1]);

                hour = Integer.parseInt(timeArray[0]);
            }

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.MONTH, month - 1);

            calendar.set(Calendar.DAY_OF_MONTH, day);

            calendar.set(Calendar.YEAR, year);


            calendar.set(Calendar.HOUR_OF_DAY, hour);

            calendar.set(Calendar.MINUTE, minute);

            calendar.set(Calendar.SECOND, second);

            DateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy hh:mm a");

            formattedDate = dateFormat.format(calendar.getTime());

        }else{

            Calendar calendar = Calendar.getInstance();

            DateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy hh:mm a");

            formattedDate = dateFormat.format(calendar.getTime());
        }

        return formattedDate;
    }

    public double getAmountInDouble(String amount){

        double amountDbl = Double.parseDouble(amount);

        DecimalFormat df = new DecimalFormat("#.##");

        String formattedAmount = df.format(amountDbl);

        return Double.parseDouble(formattedAmount);
    }

    public String getCurrentDate(){

        Calendar calendar = Calendar.getInstance();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String currentDate = dateFormat.format(calendar.getTime());

        return currentDate;
    }

    public boolean isEmptyString(String string){

        boolean isEmpty = true;

        if(string != null && !string.equals("") && !string.equalsIgnoreCase("null")){

            isEmpty = false;
        }

        return isEmpty;
    }

    public void alertboxExitFromApp(String title, String mymessage) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setPositiveButton("Yes",

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                Intent intent = new Intent(Intent.ACTION_MAIN);

                                intent.addCategory(Intent.CATEGORY_HOME);

                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                context.startActivity(intent);

                                System.exit(0);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                    }

                }).show();
    }

    public static void alertMessage(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle);

        builder.setTitle("");

        builder.setMessage(Html.fromHtml(message));

        builder.setCancelable(false);

        builder.setPositiveButton(

                Html.fromHtml("<font color='#1d83e9'>OK </font>"),

                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                        isAlert = false;
                    }
                });

        AlertDialog dialog = builder.create();

        try {

            if (dialog != null) {

                if (!isAlert) {

                    isAlert = true;

                    if (!message.equalsIgnoreCase("")) {

                        dialog.show();
                    }
                }

                TextView messageView = (TextView) dialog.findViewById(android.R.id.message);

                Typeface OpenSansLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");

                if(messageView != null) {

                    messageView.setTypeface(OpenSansLight);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String decodeRegex(String regeX) {

        String decodedRegeX = "";

        try {

            decodedRegeX = URLDecoder.decode(regeX, "UTF-8");

        } catch (UnsupportedEncodingException e) {

            throw new Error(e.getMessage(), e);
        }

        return decodedRegeX;
    }

    static ProgressDialog dialog = null;

    public static void showProgressDialog(Context context, boolean isShow) {

        try {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (dialog == null && isShow) {

                dialog = ProgressDialog.show(context, null, null);

                dialog.setContentView(R.layout.small_progress_bar);

                dialog.setProgressStyle(android.R.style.Widget_ProgressBar);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

                lp.dimAmount = 0.0f;

                dialog.getWindow().setAttributes(lp);

                dialog.getWindow().addFlags(WindowManager.LayoutParams.ALPHA_CHANGED);

                dialog.setCancelable(false);

                dialog.setCanceledOnTouchOutside(false);

                dialog.show();

            } else {

                if (dialog != null && dialog.isShowing()) {

                    dialog.dismiss();

                    dialog = null;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void alertboxForOpenLink(String title, String mymessage, TextView textViewKYC) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setPositiveButton("Yes",

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                openUrlInBrowser(textViewKYC);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                    }

                }).show();
    }

    public void alertboxForNextAlertBox(String title, String mymessage, TextView textViewKYC) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setNeutralButton(android.R.string.ok,

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {

                                alertboxForOpenLink("Alert!", "You will be redirected to a web page out of this application. You want to proceed?", textViewKYC);

                            }

                        }).show();
    }

    public void openUrlInBrowser(TextView textView){

        String url = "";

        if(textView.getText().toString().equalsIgnoreCase("ADD MONEY")){

            url = "https://www.itzcash.com/user/jsp/Login.jsp";

        }else{

            url = "https://www.itzcash.com/ckyc/kyc/kyc.jsp";
        }

        Uri webpage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        context.startActivity(intent);
    }

    public void hideKeyboard(View view){

        try {

            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public boolean checkInternetConnection() {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;
        }
    }

    public void writeFileInStorageRequest(String data){

        File sdcard = Environment.getExternalStorageDirectory();

        File dir = new File(sdcard.getAbsolutePath() + "/MOSAMBEE_RESPONSE/");

        if(!dir.exists()) {

            dir.mkdir();
        }

        File file = new File(dir, "mosambee_request.txt");

        FileOutputStream os = null;

        try {

            os = new FileOutputStream(file);

            os.write(data.getBytes());

            os.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void writeFileInStorageResponse(String data){

        File sdcard = Environment.getExternalStorageDirectory();

        File dir = new File(sdcard.getAbsolutePath() + "/MOSAMBEE_RESPONSE/");

        if(!dir.exists()) {

            dir.mkdir();
        }

        File file = new File(dir, "mosambee_response.txt");

        FileOutputStream os = null;

        try {

            os = new FileOutputStream(file);

            os.write(data.getBytes());

            os.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void deleteDirectory(File dir ){

        if ( dir.exists() && dir.isDirectory() )
        {
            String [] children = dir.list();
            for ( int i = 0 ; i < children.length ; i ++ )
            {
                File child =    new File( dir , children[i] );
                if(child.isDirectory()){
                    deleteDirectory( child );
                    child.delete();
                }else{
                    child.delete();

                }
            }
            dir.delete();
        }
    }

    public boolean isPasswordExpired(String value){

        boolean isExpired = false;

        Date date = new Date(Long.parseLong(value));

        Date currentDate = Calendar.getInstance().getTime();

        if(currentDate.after(date)){

            isExpired = true;
        }

        return isExpired;
    }
}
