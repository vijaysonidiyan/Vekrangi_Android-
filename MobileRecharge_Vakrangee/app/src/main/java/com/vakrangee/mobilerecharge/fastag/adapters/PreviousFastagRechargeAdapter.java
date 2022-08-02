package com.vakrangee.mobilerecharge.fastag.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vakrangee.mobilerecharge.R;
import com.vakrangee.mobilerecharge.fastag.models.PreviousFasTagRechargeModel;

import java.util.List;

public class PreviousFastagRechargeAdapter extends RecyclerView.Adapter<PreviousFastagRechargeAdapter.MyViewHolder> {
    private List<PreviousFasTagRechargeModel> bankList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bankName;
        public TextView bankNumber;
        public TextView amount;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            bankName = view.findViewById(R.id.bankName);
            img = view.findViewById(R.id.bankimg);
            bankNumber = view.findViewById(R.id.bankNumber);
            amount = view.findViewById(R.id.balance);
        }
    }


    public PreviousFastagRechargeAdapter(List<PreviousFasTagRechargeModel> planList, Context ctx) {
        this.bankList = planList;
    }


    @Override
    public PreviousFastagRechargeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_fastag_recharge, parent, false);
        return new PreviousFastagRechargeAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(PreviousFastagRechargeAdapter.MyViewHolder holder, int position) {
        PreviousFasTagRechargeModel plans = bankList.get(position);
        holder.bankName.setText(plans.bankName);
        holder.bankNumber.setText(plans.bankNumber);
        holder.amount.setText(plans.balance);
        Picasso.get().load(R.drawable.location_icon).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return bankList.size();
    }
}
