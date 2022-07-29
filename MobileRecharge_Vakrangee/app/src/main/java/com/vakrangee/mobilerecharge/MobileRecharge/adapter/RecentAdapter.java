package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.MobileBillPayment.Constant;
import com.vakrangee.mobilerecharge.R;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.Holder> {
    String mKey;
    public RecentAdapter(Context applicationContext, String key) {
        mKey = key;
    }
    @NonNull
    @Override
    public RecentAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_adapter, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentAdapter.Holder holder, int position) {
        if (mKey.equals(Constant.key_operator)){
            holder.card_operator.setVisibility(View.VISIBLE);
        }else {
            holder.card_operator.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txt_label,txt_name,txt_contact;
        CardView card_view,card_operator;
        public Holder(@NonNull View itemView) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            card_operator = itemView.findViewById(R.id.card_operator);
            txt_label = itemView.findViewById(R.id.txt_label);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_contact = itemView.findViewById(R.id.txt_contact);
        }
    }
}
