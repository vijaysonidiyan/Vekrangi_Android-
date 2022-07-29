package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vakrangee.mobilerecharge.MobileRecharge.models.DashBoardModel;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;

public class DashBoardAdapter  extends ArrayAdapter<DashBoardModel> {
    public DashBoardAdapter(@NonNull Context context, ArrayList<DashBoardModel> dashBoardModelArrayList) {
        super(context, 0, dashBoardModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.item_dashboard, parent, false);
        }
        DashBoardModel dashBoardModel = getItem(position);
        TextView tv_dashboard_item_name = listitemView.findViewById(R.id.tv_dashboard_text);
        ImageView iv_dashboard_item_image = listitemView.findViewById(R.id.iv_dashboard_icon);
        tv_dashboard_item_name.setText(dashBoardModel.getItemName());
        iv_dashboard_item_image.setImageResource(dashBoardModel.getItem_imgid());
        return listitemView;
    }
}
