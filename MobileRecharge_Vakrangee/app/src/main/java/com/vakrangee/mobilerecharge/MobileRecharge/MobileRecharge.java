package com.vakrangee.mobilerecharge.MobileRecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vakrangee.mobilerecharge.R;

public class MobileRecharge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge);

        Button btn = findViewById(R.id.btnClick);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MobileRecharge.this,ContactActivity.class));
            }
        });
    }
}