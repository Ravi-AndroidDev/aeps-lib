package com.ebixcash.aeps;

import android.content.Context;
import android.content.Intent;

public class AEPSIntent extends Intent {

    private static final String ARG_USERNAME = "arg_username";

    private static final String ARG_DCODE = "arg_dcode";


    public AEPSIntent(Context ctx) {

        super(ctx, AepsActivity.class);
    }

    public AEPSIntent(Intent intent) {

        super(intent);
    }

    public void setData(String userName, String dcode) {

        putExtra(ARG_USERNAME, userName);

        putExtra(ARG_DCODE, dcode);
    }

    public String getUsername() {

        return getStringExtra(ARG_USERNAME);
    }

    public String getDcode() {

        return getStringExtra(ARG_DCODE);
    }
}