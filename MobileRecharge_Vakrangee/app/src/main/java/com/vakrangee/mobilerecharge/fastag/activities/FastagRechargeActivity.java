package com.vakrangee.mobilerecharge.fastag.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vakrangee.mobilerecharge.R;
import com.vakrangee.mobilerecharge.fastag.adapters.BankListAdapter;
import com.vakrangee.mobilerecharge.fastag.adapters.PreviousFastagRechargeAdapter;
import com.vakrangee.mobilerecharge.fastag.models.BankListModel;
import com.vakrangee.mobilerecharge.fastag.models.PreviousFasTagRechargeModel;

import java.util.ArrayList;

public class FastagRechargeActivity extends AppCompatActivity {

    private PreviousFastagRechargeAdapter previousRechargeBankListAdapter;
    private ArrayList<PreviousFasTagRechargeModel> previousFasTagRechargeModelArrayList;
    private RecyclerView bankRecycle;

    private RecyclerView bankListRecycle;
    private BankListAdapter bankListAdapter;
    private ArrayList<BankListModel> bankListModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastag_recharge);

        bankRecycle = findViewById(R.id.previousfastagRechargeRecycle);
        bankListRecycle = findViewById(R.id.fastagRechargeRecycle);

        previousFasTagRechargeModelArrayList = new ArrayList<PreviousFasTagRechargeModel>();
        previousFasTagRechargeModelArrayList.add(new PreviousFasTagRechargeModel(R.drawable.location_icon,"Axis Bank","DL12DQ5551","₹1000"));
        previousFasTagRechargeModelArrayList.add(new PreviousFasTagRechargeModel(R.drawable.location_icon,"IOB Fastag","DL12DQ5551","₹100"));
        previousFasTagRechargeModelArrayList.add(new PreviousFasTagRechargeModel(R.drawable.location_icon,"ICICI Bank","DL12DQ5551","₹500"));
        previousRechargeBankListAdapter = new PreviousFastagRechargeAdapter(previousFasTagRechargeModelArrayList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        bankRecycle.setLayoutManager(layoutManager);
        bankRecycle.setAdapter(previousRechargeBankListAdapter);

        bankListModels = new ArrayList<BankListModel>();
        bankListModels.add(new BankListModel(R.drawable.location_icon,"Axis Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"IOB Fastag"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"ICICI Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"Axis Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"IOB Fastag"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"ICICI Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"ICICI Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"Axis Bank"));
        bankListModels.add(new BankListModel(R.drawable.location_icon,"IOB Fastag"));
        bankListAdapter = new BankListAdapter(bankListModels,this);
        LinearLayoutManager lm = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        bankListRecycle.setLayoutManager(lm);
        bankListRecycle.setNestedScrollingEnabled(false);
        bankListRecycle.setAdapter(bankListAdapter);
    }
}