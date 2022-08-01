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
import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.List;

public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.Holder> {
    private List<Contacts.ContactList> mContactLists = new ArrayList<>();
    private Context mContext;
    private String mKey;
    public MyContactsAdapter(Context applicationContext, String key) {
        mContext = applicationContext;
        mKey = key;

    }


    public void addItem(Contacts.ContactList item) {
        if (item != null){
            mContactLists.add(item);
            notifyDataSetChanged();
        }
    }

    public void addList(List<Contacts.ContactList> ContactLists) {
        mContactLists.addAll(ContactLists);
        //notifyDataSetChanged();
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

            if (mKey.equals(Constant.key_operator)){
                holder.card_operator.setVisibility(View.VISIBLE);
            }else {
                holder.card_operator.setVisibility(View.GONE);
            }

            Contacts.ContactList item = mContactLists.get(position);
            holder.txt_label.setText(item.getName().substring(0,1));
            holder.txt_name.setText(item.getName());
            holder.txt_contact.setText(item.getNumber());
            holder.card_view.setCardBackgroundColor(item.getColor());
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
