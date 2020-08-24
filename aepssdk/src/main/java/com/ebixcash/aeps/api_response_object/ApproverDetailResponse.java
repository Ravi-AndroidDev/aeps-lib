package com.ebixcash.aeps.api_response_object;


import com.ebixcash.aeps.pojo.ApproverModel;
import com.ebixcash.aeps.pojo.RejectionReasonModel;
import com.ebixcash.aeps.pojo.ResponseStatus;

import java.util.ArrayList;

public class ApproverDetailResponse {

    private ResponseStatus responseStatus;

    private ApproverModel accountTopUpB2BResponseApprovalModel;

    private ArrayList<RejectionReasonModel> rejectionB2BListModel;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ApproverModel getAccountTopUpB2BResponseApprovalModel() {
        return accountTopUpB2BResponseApprovalModel;
    }

    public void setAccountTopUpB2BResponseApprovalModel(ApproverModel accountTopUpB2BResponseApprovalModel) {
        this.accountTopUpB2BResponseApprovalModel = accountTopUpB2BResponseApprovalModel;
    }

    public ArrayList<RejectionReasonModel> getRejectionB2BListModel() {
        return rejectionB2BListModel;
    }

    public void setRejectionB2BListModel(ArrayList<RejectionReasonModel> rejectionB2BListModel) {
        this.rejectionB2BListModel = rejectionB2BListModel;
    }
}
