package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.MobileRecharge.MobileRecharge;
import com.vakrangee.mobilerecharge.MobileRecharge.models.MobileRechargePlansModel;
import com.vakrangee.mobilerecharge.R;

import java.util.List;

public class PlanForMobileRechargeAdapter extends RecyclerView.Adapter<PlanForMobileRechargeAdapter.ViewHolder> {

    List<MobileRechargePlansModel> mobileRechargePlansModelList;
    Context context;

    public PlanForMobileRechargeAdapter(List<MobileRechargePlansModel> mobileRechargePlansModelList, Context context) {
        this.mobileRechargePlansModelList = mobileRechargePlansModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MobileRechargePlansModel mobileRechargePlansModel = mobileRechargePlansModelList.get(position);
        holder.tvPlanPrice.setText(mobileRechargePlansModel.getPlan_price());
        holder.tvPlantitle.setText(mobileRechargePlansModel.getPlan_title());
        holder.tv_plan_validity.setText(mobileRechargePlansModel.getPlan_validity());


    }

    @Override
    public int getItemCount() {
        return mobileRechargePlansModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlanPrice,tvPlantitle,tv_plan_validity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlanPrice = itemView.findViewById(R.id.tv_plan_price);
            tvPlantitle = itemView.findViewById(R.id.tv_plan_title);
            tv_plan_validity = itemView.findViewById(R.id.tv_plan_validity);
        }
    }
}
