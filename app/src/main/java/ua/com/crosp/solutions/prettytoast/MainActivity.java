package ua.com.crosp.solutions.prettytoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ua.com.crosp.solutions.library.prettytoast.PrettyToast;

/**
 * Created by Oleksandr "CROSP" Molochko
 * On 2/26/16.
 * Project : PrettyToast
 * Package : ua.com.crosp.solutions.prettytoast
 * Copyright (c) 2013-2016 Datascope Ltd. All Rights Reserved.
 */
public class MainActivity extends Activity {

    private Button mButtonToastSuccess;
    private Button mButtonToastWarning;
    private Button mButtonToastInfo;
    private Button mButtonToastDim;
    private Button mButtonToastCustom;
    private Button mButtonToastError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PrettyToast.initIcons();
        setContentView(R.layout.activity_main);
        mButtonToastSuccess = (Button) findViewById(R.id.button_success_toast);
        mButtonToastSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrettyToast.showSuccess(getApplicationContext(), "SUCCESS");
            }
        });
        mButtonToastWarning = (Button) findViewById(R.id.button_warning_toast);
        mButtonToastWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrettyToast.showWarning(getApplicationContext(), "WARNING");
            }
        });
        mButtonToastInfo = (Button) findViewById(R.id.button_info_toast);
        mButtonToastInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrettyToast.showInfo(getApplicationContext(), "INFO");
            }
        });
        mButtonToastError = (Button) findViewById(R.id.button_error_toast);
        mButtonToastError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrettyToast.showError(getApplicationContext(), "ERROR");
            }
        });
        mButtonToastDim = (Button) findViewById(R.id.button_dim_toast);
        mButtonToastDim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrettyToast.showDim(getApplicationContext(), "DIM");
            }
        });
        mButtonToastCustom = (Button) findViewById(R.id.button_custom_toast);
        mButtonToastCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PrettyToast.Builder(getApplicationContext())
                        .withRightIcon("mdi-earth")
                        .withMessage("Custom toast")
                        .withLeftIcon("mdi-stackoverflow")
                        .withDuration(Toast.LENGTH_SHORT)
                        .withLeftIconColor(R.color.firebrick)
                        .withBackgroundResource(R.drawable.background_custom)
                        .withGravity(new PrettyToast.Gravity(Gravity.START, 15, 0))
                        .withTextSize(24)
                        .withRightIconColor(R.color.blueviolet)
                        .withTextColor(R.color.blue)
                        .build()
                        .show();
            }
        });

    }
}
