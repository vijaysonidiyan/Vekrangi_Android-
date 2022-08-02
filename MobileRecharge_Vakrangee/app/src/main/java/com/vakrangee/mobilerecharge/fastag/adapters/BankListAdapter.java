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
import com.vakrangee.mobilerecharge.fastag.models.BankListModel;

import java.util.List;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.MyViewHolder> {
    private List<BankListModel> bankList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bankName;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            bankName = view.findViewById(R.id.bankName);
            img = view.findViewById(R.id.bankimg);
        }
    }


    public BankListAdapter(List<BankListModel> planList, Context ctx) {
        this.bankList = planList;
    }


    @Override
    public BankListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banklist_item, parent, false);
        return new BankListAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(BankListAdapter.MyViewHolder holder, int position) {
        BankListModel plans = bankList.get(position);
        holder.bankName.setText(plans.bankName);
        Picasso.get().load(R.drawable.location_icon).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return bankList.size();
    }
}

