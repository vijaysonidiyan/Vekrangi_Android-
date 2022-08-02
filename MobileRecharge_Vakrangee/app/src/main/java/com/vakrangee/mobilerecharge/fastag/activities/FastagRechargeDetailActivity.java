package com.vakrangee.mobilerecharge.fastag.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vakrangee.mobilerecharge.R;

public class FastagRechargeDetailActivity extends AppCompatActivity {

    RelativeLayout optionUPI;
    LinearLayout expandUpi;
    ImageView upiArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastag_recharge_detail);
        optionUPI = findViewById(R.id.option1);
        expandUpi = findViewById(R.id.upiExpandView);
        upiArrow = findViewById(R.id.upiArrow);

        optionUPI.setOnClickListener(view -> {
            if(expandUpi.getVisibility() == View.VISIBLE){
                expandUpi.setVisibility(View.GONE);
                upiArrow.setImageDrawable(getDrawable(R.drawable.ic_down_bluearrow));
            }else {
                expandUpi.setVisibility(View.VISIBLE);
                upiArrow.setImageDrawable(getDrawable(R.drawable.ic_top_bluearrow));
            }
        });
    }
}