package com.vakrangee.mobilerecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.vakrangee.mobilerecharge.MobileRecharge.adapter.DashBoardAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.DashBoardModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvDashBoard = findViewById(R.id.gv_DashBoard_Option);
        ArrayList<DashBoardModel> dashBoardModels = new ArrayList<DashBoardModel>();
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_recarge_number), R.drawable.icon_mobile_recharge));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_postpaid_bill), R.drawable.icon_postpaid_bill));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_elec_bill), R.drawable.icon_electric_bill));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_fastag), R.drawable.icon_fastag));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_book_cylinder), R.drawable.icon_cylinder_book));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_water_bill), R.drawable.icon_water_bill));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_dth), R.drawable.icon_dth));
        dashBoardModels.add(new DashBoardModel(getResources().getString(R.string.lbl_cable_tv), R.drawable.icon_cable_tv));
        DashBoardAdapter adapter = new DashBoardAdapter(this, dashBoardModels);
        gvDashBoard.setAdapter(adapter);
    }
}