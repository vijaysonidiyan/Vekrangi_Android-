package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        if (mContactLists != null && mContactLists.size()>0){

            Contacts.ContactList item = mContactLists.get(position);
            holder.txt_label.setText(item.getName().substring(0,1));
            holder.txt_name.setText(item.getName());
            holder.txt_contact.setText(item.getNumber());
        }
    }

    @Override
    public int getItemCount() {
        if (mContactLists == null){
            mContactLists = new ArrayList<>();
        }
        return mContactLists.size();
    }
    public class Holder extends RecyclerView.ViewHolder {
        TextView txt_label,txt_name,txt_contact;
        public Holder(@NonNull View itemView) {
            super(itemView);

            txt_label = itemView.findViewById(R.id.txt_label);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_contact = itemView.findViewById(R.id.txt_contact);
        }
    }
}
