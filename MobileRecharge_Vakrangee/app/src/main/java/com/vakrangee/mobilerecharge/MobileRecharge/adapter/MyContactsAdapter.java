package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.MobileBillPayment.Constant;
import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.List;

public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.Holder> implements Filterable {
    private List<Contacts.ContactList> mContactLists = new ArrayList<>();
    private List<Contacts.ContactList> mFilterContactLists = new ArrayList<>();
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
        mFilterContactLists.addAll(ContactLists);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyContactsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_adapter, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactsAdapter.Holder holder, int position) {
        if (mFilterContactLists != null && mFilterContactLists.size()>0){

            if (mKey.equals(Constant.key_operator)){
                holder.card_operator.setVisibility(View.VISIBLE);
            }else {
                holder.card_operator.setVisibility(View.GONE);
            }

            Contacts.ContactList item = mFilterContactLists.get(position);
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
        //return Math.min(mContactLists.size(), 50);
        return mFilterContactLists.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilterContactLists = mContactLists;
                } else {
                    List<Contacts.ContactList> filteredList = new ArrayList<>();
                    for (Contacts.ContactList row : mContactLists) {

                        Log.d("TAG","Filter--->"+charString);
                        if (row.getNumber().contains(charString.toString()) ) {
                            filteredList.add(row);
                        }
                    }

                    mFilterContactLists = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilterContactLists;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilterContactLists = (ArrayList<Contacts.ContactList>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
