package com.vakrangee.mobilerecharge.MobileRecharge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.vakrangee.mobilerecharge.MobileRecharge.adapter.PaymentOptionAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.Data;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mobile_Recharge_PaymentActivity extends AppCompatActivity {

    public RecyclerView rvlPaymentOption;
    PaymentOptionAdapter mPaymentOptionAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Data.Option_List> mOption_lists;
    Random rnd = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge_payment);

        initialization();
    }

    private void initialization() {

        mOption_lists=new ArrayList<>();

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mPaymentOptionAdapter = new PaymentOptionAdapter(getApplicationContext());
        rvlPaymentOption=findViewById(R.id.rvlPaymentOption);
        rvlPaymentOption.setLayoutManager(layoutManager);
        rvlPaymentOption.setAdapter(mPaymentOptionAdapter);


        for (int i = 0; i < 5; i++) {
            Data.Option_List item = new Data.Option_List();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

            item.setIcon(color);
            item.setOption("ASD"+i);
            item.setSelected(false);

            List<Data.Option> options = new ArrayList<>();

            for (int j = 0; j < 1;j++) {

                Data.Option option = new Data.Option() ;
                option.setId(""+i);
                option.setPay(""+i);
                option.setName(""+i);
                options.add(option);

            }

            item.setOptionList(options);

            mPaymentOptionAdapter.addItem(item);

        }



    }
}