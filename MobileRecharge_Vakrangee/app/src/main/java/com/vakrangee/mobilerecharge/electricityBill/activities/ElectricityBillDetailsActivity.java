package com.vakrangee.mobilerecharge.electricityBill.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vakrangee.mobilerecharge.R;
import com.vakrangee.mobilerecharge.electricityBill.FAQAcitivity;

public class ElectricityBillDetailsActivity extends AppCompatActivity {


    TextView paymentText;
    ImageView help_support;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill_details);
        paymentText = (TextView) findViewById(R.id.paymenttext);
        paymentText.setOnClickListener(view -> {
            Intent intent = new Intent(ElectricityBillDetailsActivity.this,PaymentSuccessActivity.class);
            startActivity(intent);
        });
        help_support = (ImageView) findViewById(R.id.viewHelp);
        help_support.setOnClickListener(view -> {
            Intent intent = new Intent(ElectricityBillDetailsActivity.this, FAQAcitivity.class);
            startActivity(intent);
        });
    }
}