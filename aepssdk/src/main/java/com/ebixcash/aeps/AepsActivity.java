package com.ebixcash.aeps;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AepsActivity extends FragmentActivity implements View.OnClickListener{

    private TextView tvReport,tvWithdraw,tvBalance;

    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aeps);

        getID();

        initializeWithdrawTab();
    }

    private void getID(){

        tvWithdraw = (TextView) findViewById(R.id.tvWithdraw);

        tvBalance = (TextView) findViewById(R.id.tvBalance);

        tvReport = (TextView) findViewById(R.id.tvReport);

        imageViewBack = (ImageView) findViewById(R.id.image_view_menu);

        tvBalance.setOnClickListener(this);

        tvWithdraw.setOnClickListener(this);

        tvReport.setOnClickListener(this);

        imageViewBack.setOnClickListener(this);

        AEPSIntent homeIntent = new AEPSIntent(getIntent());

        Log.d("HomeActivity", "username: " + homeIntent.getUsername());

        Log.d("HomeActivity", "password: " + homeIntent.getDcode());
    }

    private void initializeWithdrawTab(){

        TransactFragment transactFragment = new TransactFragment();

        Bundle transactBundle = new Bundle();

        transactBundle.putString("click", "withdraw");

        transactFragment.setArguments(transactBundle);

        callFragment(transactFragment);

        tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

        tvBalance.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        tvReport.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.tvWithdraw) {

            TransactFragment transactFragment = new TransactFragment();

            Bundle transactBundle = new Bundle();

            transactBundle.putString("click", "withdraw");

            transactFragment.setArguments(transactBundle);

            callFragment(transactFragment);

            tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

            tvBalance.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

            tvReport.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        } else if (v.getId() == R.id.tvBalance) {

            TransactFragment transactFragment = new TransactFragment();

            Bundle transactBundle = new Bundle();

            transactBundle.putString("click", "balance");

            transactFragment.setArguments(transactBundle);

            callFragment(transactFragment);

            tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

            tvBalance.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

            tvReport.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

        } else if (v.getId() == R.id.tvReport) {

            callFragment(new AEPSReportFragment());

            tvWithdraw.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

            tvBalance.setBackgroundResource(R.drawable.rounded_inner_light_indecatore);

            tvReport.setBackgroundResource(R.drawable.rounded_inner_indicator_color);

        } else if (v.getId() == R.id.image_view_menu) {

            finish();
        }
    }

    private void callFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.layout, fragment);

        fragmentTransaction.commit();
    }
}
