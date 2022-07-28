package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.List;

public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.Holder> {
    private List<Contacts.ContactList> mContactLists;
    private Context mContext;
    public MyContactsAdapter(Context applicationContext) {
        mContext = applicationContext;
        mContactLists = new ArrayList<>();
    }


    public void addItem(Contacts.ContactList item) {
        if (item != null){
            mContactLists.add(item);
            notifyDataSetChanged();
        }
    }
    @NonNull
    @Override
    public MyContactsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_adapter, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactsAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }



    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
