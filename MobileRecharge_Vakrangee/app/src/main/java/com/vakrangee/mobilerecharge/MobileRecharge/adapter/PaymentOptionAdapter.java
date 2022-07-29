package com.vakrangee.mobilerecharge.MobileRecharge.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vakrangee.mobilerecharge.MobileRecharge.models.Data;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.Holder> {
    List<Data.Option_List> mOption_lists;
    public PaymentOptionAdapter(Context applicationContext) {
        mOption_lists = new ArrayList<>();
    }

    public void addItem(Data.Option_List item) {
        if (item !=null){
            mOption_lists.add(item);
        }
    }
    @NonNull
    @Override
    public PaymentOptionAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_option_adapter, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionAdapter.Holder holder, @SuppressLint("RecyclerView") int position) {
        if (mOption_lists != null && mOption_lists.size()>0){

            Data.Option_List item = mOption_lists.get(position);

            boolean isExpandable = item.getSelected();
            holder.expandLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
            holder.relMain.setSelected(isExpandable);

            holder.relMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.isSelected()){
                        v.setSelected(false);
                    }else {
                        v.setSelected(true);
                    }

                    Log.d("TAG","is Selected--->"+v.isSelected());
                    holder.img_dwon_up.setSelected(v.isSelected());

                    item.setSelected(v.isSelected());
                    mOption_lists.set(position,item);
                    notifyDataSetChanged();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        if (mOption_lists == null){
            mOption_lists = new ArrayList<>();

        }
        return mOption_lists.size();
    }



    public class Holder extends RecyclerView.ViewHolder {

        private ImageView img_option_icon,img_dwon_up;
        private TextView txt_option;
        private RelativeLayout expandLayout,relMain;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img_option_icon=itemView.findViewById(R.id.img_option_icon);
            img_dwon_up=itemView.findViewById(R.id.img_dwon_up);
            txt_option=itemView.findViewById(R.id.txt_option);
            expandLayout=itemView.findViewById(R.id.expandLayout);
            relMain=itemView.findViewById(R.id.relMain);


        }
    }
}
