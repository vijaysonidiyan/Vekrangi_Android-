package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.R;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.Holder> {
    public RecentAdapter(Context applicationContext) {

    }
    @NonNull
    @Override
    public RecentAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_adapter, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
