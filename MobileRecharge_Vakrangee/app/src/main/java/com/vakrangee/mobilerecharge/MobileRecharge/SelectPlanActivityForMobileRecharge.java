package com.vakrangee.mobilerecharge.MobileRecharge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vakrangee.mobilerecharge.MobileRecharge.adapter.DashBoardAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.PlanForMobileRechargeAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.DashBoardModel;
import com.vakrangee.mobilerecharge.MobileRecharge.models.MobileRechargePlansModel;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;

public class SelectPlanActivityForMobileRecharge extends AppCompatActivity {
    RecyclerView rvPlans;
    private RecyclerView.LayoutManager layoutManagerPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_plan_for_mobile_recharge);
        rvPlans = findViewById(R.id.rv_planList);
        layoutManagerPlan = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvPlans.setLayoutManager(layoutManagerPlan);
        ArrayList<MobileRechargePlansModel> mobileRechargePlansModels = new ArrayList<MobileRechargePlansModel>();
        mobileRechargePlansModels.add(new MobileRechargePlansModel("₹ 699","Get 12 GB Data","Validity 28 Days"));
        mobileRechargePlansModels.add(new MobileRechargePlansModel("₹ 699","Get 12 GB Data","Validity 28 Days"));
        mobileRechargePlansModels.add(new MobileRechargePlansModel("₹ 699","Get 12 GB Data","Validity 28 Days"));
        mobileRechargePlansModels.add(new MobileRechargePlansModel("₹ 699","Get 12 GB Data","Validity 28 Days"));

        PlanForMobileRechargeAdapter adapter = new PlanForMobileRechargeAdapter(mobileRechargePlansModels,this);
        rvPlans.setAdapter(adapter);
    }
}