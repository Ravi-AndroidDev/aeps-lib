package com.ebixcash.aeps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ebixcash.aeps.R;
import com.ebixcash.aeps.Utils.Util;
import com.ebixcash.aeps.api_response_object.BankTransferReportResponse;
import com.ebixcash.aeps.pojo.AEPSReportData;

import java.util.ArrayList;
import java.util.List;


public abstract class BankTrasferReportListAdapter extends RecyclerView.Adapter<BankTrasferReportListAdapter.ViewHolder> {

    private Context context;

    private List<Object> dataList;

    private ArrayList<String> arrayList;

    private boolean isSamePosion = false;

    private Util util;

    public BankTrasferReportListAdapter(Context context, List<Object> dataList) {

        this.context = context;

        this.dataList = dataList;

        arrayList = new ArrayList<>();

        util = new Util(context);
    }

    protected abstract void onSettelClicke(int position);


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.row_aeps_bank_transfer_report, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (dataList.get(position) instanceof BankTransferReportResponse) {

            BankTransferReportResponse bankTransferReportResponse = (BankTransferReportResponse) dataList.get(position);

            if (((BankTransferReportResponse) dataList.get(position)).isSelected()) {

                holder.llExpendableLayout.setVisibility(View.VISIBLE);

            } else {

                holder.llExpendableLayout.setVisibility(View.GONE);
            }

            String status = "";

            if (bankTransferReportResponse.getStatus().equals("U")) {

                status = "Submitted on " + util.dateFormatForBankReportDisplay(bankTransferReportResponse.getFilegenerated());
            }

            if (bankTransferReportResponse.getStatus().equals("F")) {

                status = "Failed";
            }

            if (bankTransferReportResponse.getStatus().equals("S")) {

                status = "Successful";
            }

            if (bankTransferReportResponse.getStatus().equals("C")) {

                status = "Debited";
            }

            if (bankTransferReportResponse.getStatus().equals("F")) {

                holder.statusCheckBox.setText(Html.fromHtml("<font color=#f44444>" + status + "</font>"));

            } else {

                holder.statusCheckBox.setText(Html.fromHtml("<font color=#00a896>" + status + "</font>"));
            }

            holder.dateTextView.setText(util.dateFormatForDMTTransactions(bankTransferReportResponse.getRequestdate()));

            String orderID = "<font color=#7f38ba>Order Id: </font>" + bankTransferReportResponse.getSettlementid();

            holder.orderIDTextView.setText(Html.fromHtml(orderID));

            holder.orderIDTextView.setEllipsize(TextUtils.TruncateAt.END);

            holder.amountTextView.setText("₹ " + bankTransferReportResponse.getAmount());

            String utr = "<font color=#7f38ba>UTR: </font>" + bankTransferReportResponse.getUtr();

            holder.textViewUTR.setText(Html.fromHtml(utr));


            holder.tvDateTime.setVisibility(View.GONE);

            holder.tvType.setVisibility(View.GONE);

            holder.tvRrn.setVisibility(View.GONE);

            holder.tvStatus.setVisibility(View.GONE);

            holder.tvBank.setVisibility(View.GONE);

            holder.tvMatm.setVisibility(View.GONE);

            holder.tvSettlement.setVisibility(View.GONE);

            holder.tvAeps.setVisibility(View.GONE);

            holder.tvEasy.setVisibility(View.GONE);

            holder.lltype.setVisibility(View.GONE);

            holder.llrrn.setVisibility(View.GONE);

            holder.llmatm.setVisibility(View.GONE);

            holder.lleasy.setVisibility(View.GONE);

        }else if(dataList.get(position) instanceof AEPSReportData) {

            AEPSReportData bankTransferReportResponse = (AEPSReportData) dataList.get(position);

            if (bankTransferReportResponse.isSelected()) {

                holder.llExpendableLayout.setVisibility(View.VISIBLE);

            } else {

                holder.llExpendableLayout.setVisibility(View.GONE);
            }

            String status = bankTransferReportResponse.getTxnstatus();

            if(!status.equalsIgnoreCase("Success")) {

                holder.statusCheckBox.setText(Html.fromHtml("Status: " + "<font color=#f44444>" + status + "</font>"));

            }else{

                holder.statusCheckBox.setText(Html.fromHtml("Status: " + "<font color=#00a896>" + status + "</font>"));
            }

            holder.dateTextView.setText("Transaction date: " + util.formatReportDateAndTime(bankTransferReportResponse.getTransactiondate()));

            holder.orderIDTextView.setText("Order Id: " + bankTransferReportResponse.getOrderid());

            holder.orderIDTextView.setEllipsize(TextUtils.TruncateAt.END);

            holder.amountTextView.setText("Amount: Rs." + bankTransferReportResponse.getAmount());


            holder.tvDateTime.setText(util.formatTime(bankTransferReportResponse.getTransactiondate()));

            holder.tvType.setText(bankTransferReportResponse.getTranscode());

            holder.tvRrn.setText(bankTransferReportResponse.getRrn());

            holder.tvStatus.setText(bankTransferReportResponse.getTxnstatus());

            holder.tvBank.setText(util.getBankNameBasedOnIINNumber(bankTransferReportResponse.getBankiinno()));

            holder.tvMatm.setText(bankTransferReportResponse.getMatmreqid());

            if(bankTransferReportResponse.getPgtransactionid() != null) {

                holder.tvSettlement.setText(bankTransferReportResponse.getPgtransactionid());
            }

            holder.llaeps.setVisibility(View.GONE);

            holder.lleasy.setVisibility(View.GONE);

            holder.row.setOnClickListener(v -> {

                isSamePosion = false;

                if (bankTransferReportResponse.getTranscode().equals("CW") && bankTransferReportResponse.getPgresponsecode() != null && !bankTransferReportResponse.getPgresponsecode().equals("0") && bankTransferReportResponse.getTxnstatus().equalsIgnoreCase("Success")) {

                    if (arrayList != null && arrayList.size() > 0) {

                        for (int i = 0; i < arrayList.size(); i++) {

                            if (arrayList.get(i).equals(String.valueOf(holder.getAdapterPosition()))) {

                                isSamePosion = true;

                                arrayList.remove(String.valueOf(holder.getAdapterPosition()));

                                ((AEPSReportData) dataList.get(position)).setSelected(false);

                                notifyItemChanged(holder.getAdapterPosition());
                            }
                        }
                    }

                    if (!isSamePosion) {

                        arrayList.add(String.valueOf(holder.getAdapterPosition()));

                        ((AEPSReportData) dataList.get(position)).setSelected(true);

                        notifyItemChanged(holder.getAdapterPosition());
                    }
                }
            });

            holder.rlSettle.setOnClickListener(v -> {

                onSettelClicke(holder.getAdapterPosition());

            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rlSettle;

        private LinearLayout lldataTime, lltype, llrrn, llstatus, llbank, llmatm, llsettlement, llaeps, lleasy, llUTR;

        TextView tvDateTime, tvType, tvRrn, tvStatus, tvBank, tvMatm, tvSettlement, tvAeps, tvEasy, tvUTR;

        TextView dateTextView, orderIDTextView, statusCheckBox, amountTextView, textViewUTR;

        LinearLayout llExpendableLayout, row;

        public ViewHolder(View view) {

            super(view);

            dateTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_date);

            orderIDTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_order_id);

            statusCheckBox = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_status);

            amountTextView = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_amount);

            textViewUTR = (TextView) view.findViewById(R.id.txt_aeps_bank_transfer_report_utr);

            llExpendableLayout = (LinearLayout) view.findViewById(R.id.llExpendableLayout);

            row = (LinearLayout) view.findViewById(R.id.row);


            tvDateTime = (TextView) view.findViewById(R.id.tvDateTime);

            tvType = (TextView) view.findViewById(R.id.tvType);

            tvRrn = (TextView) view.findViewById(R.id.tvRrn);

            tvStatus = (TextView) view.findViewById(R.id.tvStatus);

            tvBank = (TextView) view.findViewById(R.id.tvBank);

            tvMatm = (TextView) view.findViewById(R.id.tvMatm);

            tvSettlement = (TextView) view.findViewById(R.id.tvSettlement);

            tvAeps = (TextView) view.findViewById(R.id.tvAeps);

            tvEasy = (TextView) view.findViewById(R.id.tvEasy);

            tvUTR = (TextView) view.findViewById(R.id.tvUTR);


            lldataTime = (LinearLayout) view.findViewById(R.id.dataTime);

            lltype = (LinearLayout) view.findViewById(R.id.type);

            llrrn = (LinearLayout) view.findViewById(R.id.rrn);

            llstatus = (LinearLayout) view.findViewById(R.id.status);

            llbank = (LinearLayout) view.findViewById(R.id.bank);

            llmatm = (LinearLayout) view.findViewById(R.id.matm);

            llsettlement = (LinearLayout) view.findViewById(R.id.settlement);

            llaeps = (LinearLayout) view.findViewById(R.id.aeps);

            lleasy = (LinearLayout) view.findViewById(R.id.easy);

            rlSettle = (RelativeLayout) view.findViewById(R.id.settle);

            llUTR = (LinearLayout) view.findViewById(R.id.llUTR);
        }
    }
}