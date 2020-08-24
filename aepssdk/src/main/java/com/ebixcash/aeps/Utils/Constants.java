package com.ebixcash.aeps.Utils;

import java.util.HashMap;
import java.util.List;

public class Constants {

  public static final String userDefinedKey = "itzcashmobileapp";

  public static final String currencyCode = "0356";

  // STAGING URLS
  /*public static final String ROLE_ID = "36";

  public static final String APP_VERSION_URL = "https://staging.itzcash.com/samsso/servlet/MWalletAppServlet";

  public static final String EBIX_MATM_TRANSACTION_TABLE_URL = "https://staging.itzcash.com/samsso/";

  public static final String EBIXCASH_NEW_URL = "https://staging.itzcash.com/easyci/b2bAPP/";

  public static final String DMT_URL = "https://staging.itzcash.com/samsso/servlet/RmtMobileAppServlet";

  public static final String ITZ_CASH_MWALLET_URL = "https://staging.itzcash.com/samsso/servlet/MWalletAppServlet";

  public static final String AEPS_BASE_URL = "https://staging.itzcash.com/samsso/servlet/";

  public static final String ITZ_CASH_MWALLET_DOMAIN = "https://staging.itzcash.com";

  public static final String EBIX_CASH_BBPS_CATEGORY_URL = "https://myaccount.itzcash.com/easy/servlet/BbpouApi?requestType=CATEGORYLIST";

  public static final String EBIX_CASH_BBPS_BILLER_URL = "https://myaccount.itzcash.com/easy/servlet/BbpouApi?requestType=BILLERLISTBYCAT";

  public static final String EBIX_CASH_BBPS_FETCH_PARAMS_URL = "https://myaccount.itzcash.com/easy/servlet/BbpouApi?requestType=BILLERLFORM";

  public static final String EBIX_CASH_BBPS_BILL_FETCH_URL = "http://staging.itzcash.com/samws/fetchBill";

  public static final String EBIX_CASH_BBPS_BILL_PAY_URL = "http://staging.itzcash.com/samws/billPayment";

  public static final String EBIX_SEARCH_BY_IFSC_URL = "https://staging.itzcash.com/samsso/servlet/RmtMobileAppServlet?about=";

  public static final String EBIX_SEARCH_BY_BANK_URL = "https://staging.itzcash.com/samsso/servlet/RmtMobileAppServlet?about=";

  public static final String EBIXCASH_TOPUP_URL = "https://staging.itzcash.com/EasyApi/api/";*/


  //PRODUCTION URLS
  public static final String ROLE_ID = "36";

  public static final String APP_VERSION_URL = "https://myaccount.itzcash.com/easypp/servlet/MWalletAppServlet";

  public static final String EBIXCASH_TOPUP_URL = "https://staging.itzcash.com/EasyApi/api/";

  public static final String EBIX_MATM_TRANSACTION_TABLE_URL = "https://myaccount.itzcash.com/easypp/";

  public static final String EBIXCASH_NEW_URL = "https://easy.itzcash.com/Itzcasheasycds/b2bAPP/";

  public static final String DMT_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet";

  public static final String AEPS_BASE_URL = "https://myaccount.itzcash.com/easypp/servlet/";

  public static final String EBIX_SEARCH_BY_IFSC_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet?about=";

  public static final String EBIX_SEARCH_BY_BANK_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet?about=";

  public static final String ITZ_CASH_MWALLET_URL = "https://myaccount.itzcash.com/easy/servlet/MWalletAppServlet"; // --- myaccount

  public static final String ITZ_CASH_MWALLET_DOMAIN = "https://myaccount.itzcash.com"; // --myaccount

  public static final String EBIX_CASH_BBPS_CATEGORY_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=CATEGORYLIST"; //

  public static final String EBIX_CASH_BBPS_BILLER_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLERLISTBYCAT"; //

  public static final String EBIX_CASH_BBPS_FETCH_PARAMS_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLERLFORM";//

  public static final String EBIX_CASH_BBPS_BILL_FETCH_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=FETCHBILL"; // ---

  public static final String EBIX_CASH_BBPS_BILL_PAY_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLPAY"; // ---


  //PRE PRODUCTION URL
  /*public static final String EBIXCASH_WALLET_DETAIL_URL = "https://staging.itzcash.com/EasyApi/api/walletDetail";

  public static final String EBIXCASH_NEW_URL = "https://easy.itzcash.com/Itzcasheasycds/b2bAPP/";

  public static final String DMT_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet";

  public static final String AEPS_BASE_URL = "https://myaccount.itzcash.com/easypp/servlet/";

  public static final String EBIX_SEARCH_BY_IFSC_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet?about=";

  public static final String EBIX_SEARCH_BY_BANK_URL = "https://myaccount.itzcash.com/easypp/servlet/RmtMobileAppServlet?about=";

  public static final String ITZ_CASH_MWALLET_URL = "https://myaccount.itzcash.com/easypp/servlet/MWalletAppServlet"; // --- myaccount

  public static final String addMoneyReqURL = "https://myaccount.itzcash.com/easypp/servlet/MWalletReloadServlet"; // myaccount

  public static final String ITZ_CASH_MWALLET_DOMAIN = "https://myaccount.itzcash.com"; // --myaccount

  public static final String easyMobPaymentURL = "https://myaccount.itzcash.com/easypp/servlet/EasyRechargeMobilePaymentServlet"; // myaccount

  public static final String ITZ_CASH_ICW_LOCATOR_URL="https://myaccount.itzcash.com/itzcpms/map/test/itz.html";

  public static final String EBIX_CASH_AADHARKYC_URL="http://myaccount.itzcash.com/api/ekyc/kycrequest2.1"; // myaccount

  public static final String EBIX_AADHAR_PAN_AUTH_URL="https://myaccount.itzcash.com/samsso/servlet/EkycApi";  // myaccount

  public static final String EBIX_CASH_BBPS_CATEGORY_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=CATEGORYLIST"; //

  public static final String EBIX_CASH_BBPS_BILLER_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLERLISTBYCAT"; //

  public static final String EBIX_CASH_BBPS_FETCH_PARAMS_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLERLFORM";//

  public static final String EBIX_CASH_BBPS_BILL_FETCH_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=FETCHBILL"; // ---

  public static final String EBIX_CASH_BBPS_BILL_PAY_URL = "https://myaccount.itzcash.com/easypp/servlet/BbpouApi?requestType=BILLPAY"; // ---

  public static final String EBIX_MATM_TRANSACTION_TABLE_URL = "https://staging.itzcash.com/samsso/MatmService";

  public static final String EBIXCASH_TOPUP_URL = "https://staging.itzcash.com/EasyApi/api/";*/

  public static final String appVersionRequest = "406";

  public static final String profilePictureRequest = "104";

  public static final String loginRequest = "800";

  public static final String refreshWalletRequest = "800";

  public static final String rechargeMobRequest = "300";

  public static final String rechargeDTHRequest = "301";

  public static final String profileRequest = "400";

  public static final String gcmRegRequest = "501";

  public static final String changePwdRequest = "102";

  public static final String resetPwdChangeRequest = "107";

  public static final String resendOtpRequest = "108";

  public static final String paymentMode = "easyPay";

  public static final String notificationRequest = "405";

  public static final String pricingPolicyRequest = "403";

  public static final String faqsRequest = "404";

  public static final String utilityInputRequest = "600";

  public static final String utilityinfoRequest = "601";

  public static final String utilityPaymentRequest = "602";

  public static final String addLinkAccountRequest = "304";

  public static boolean isUtilityPaymentOpen = false;

  public static boolean isUtilityType = false;

  public static HashMap<String, String> utilityHashMap = new HashMap<String, String>();

  public static HashMap<String, String> utilityBBPSHashMap = new HashMap<String, String>();

  public static HashMap<String, String> utilityBBPSHashMap2 = new HashMap<String, String>();

  public static HashMap<String, String> adhocBBPSParamsHashMap = new HashMap<String, String>();

  public static HashMap<String, String> adhocBBPSParamsHashMap2 = new HashMap<String, String>();

  public static List<String> paymentvals = null;

  public static HashMap<String, String> utilityBBPSPayOps= new HashMap<String, String>();

  public static String version = "";

  public static final String os = "A";

  public static boolean rersettimer=true;

  public static boolean launchActivityFlag=true;

  public static boolean islogout1=true;

  public static String webURL = "https://www.itzcash.com/ckyc/kyc/kyc.jsp";

  public static String NETWORK_ERROR_MESSAGE = "Something went wrong, Please try again.";

  public static String NETWORK_ERROR_MESSAGE_MATM = ". There is issue with internet connectivity. Please check the status before initiating a new transaction.";

  public static String utilityId, serviceId, utilityName;

  public static String ACTION_LOGIN = "ACTION_LOGIN";

  public static String ACTION_PROFILE = "ACTION_PROFILE";

  public static String ACTION_FORGOT_PASSWORD = "ACTION_FORGOT_PASSWORD";

  public static String ACTION_CHANGE_PASSWORD = "ACTION_CHANGE_PASSWORD";

  public static String ACTION_MERCHANT_ACCOUNT_LIST = "ACTION_MERCHANT_ACCOUNT_LIST";

  public static String ACTION_MODIFY_MERCHANT_ACCOUNT = "ACTION_MODIFY_MERCHANT_ACCOUNT";

  public static String ACTION_SAVE_OR_UPDATE_MERCHANT_ACCOUNT = "ACTION_SAVE_OR_UPDATE_MERCHANT_ACCOUNT";

  public static String ACTION_ACCOUNT_STATEMENT = "ACTION_ACCOUNT_STATEMENT";

  public static String ACTION_WALLET_DETAIL_PASSBOOK = "ACTION_WALLET_DETAIL_PASSBOOK";

  public static String ACTION_WALLET_DETAIL_ADD_MONEY = "ACTION_WALLET_DETAIL_ADD_MONEY";

  public static String ACTION_BALANCE_COMMISSION = "ACTION_BALANCE_COMMISSION";

  public static String ACTION_FINAL_TRANSFER = "ACTION_FINAL_TRANSFER";

  public static String ACTION_REQUEST_MONEY = "ACTION_REQUEST_MONEY";

  public static String ACTION_REQUEST_HISTORY = "ACTION_REQUEST_HISTORY";

  public static String ACTION_REQUEST_HISTORY_DISTRIBUTOR = "ACTION_REQUEST_HISTORY_DISTRIBUTOR";

  public static String ACTION_UPDATE_REQUEST = "ACTION_UPDATE_REQUEST";

  public static String ACTION_REQUEST_APPROVER_DETAIL = "ACTION_REQUEST_APPROVER_DETAIL";

  public static String ACTION_REQUEST_APPROVE = "ACTION_REQUEST_APPROVE";

  public static String ACTION_FRANCHAISEE_DETAIL = "ACTION_FRANCHAISEE_DETAIL";

  public static String CONNECTIVITY_MESSAGE = "Please check your internet connection!";

  public static String APPROVE_REQUEST_MESSAGE = "Are you sure to approve the request for amount of Rs. ";

  public static String BANK_TRANSFER_MESSAGE = "Are you sure?, Do you want to transfer amount of Rs. ";

  public static String REJECT_REQUEST_MESSAGE = "Are you sure to reject the request for amount of Rs. ";

  public static int maxRecordToDisplay = 10;

  public static String MESSAGE_TRANSFER_IMPS_NOT = "Currently fund transfer is not available due to unavailability of IMPS for the given bank.";

  public static String RESET_PASSWORD_CONTENT = "Your password has been expired, Please reset the same!";

  public static String PREF_KEY_REQUEST = "PREF_KEY_REQUEST";

  public static String MSG_NEW_VERSION = "A new version is available, Please update.";
}



