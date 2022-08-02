package com.vakrangee.mobilerecharge.fastag.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.vakrangee.mobilerecharge.R;
import com.vakrangee.mobilerecharge.fastag.models.AmountListModel;

import java.util.ArrayList;
import java.util.List;

public class FastagRechargeEntryActivity extends AppCompatActivity {

    private RecyclerView amountListRecycle;
    private AmountListAdapter amountListAdapter;
    private ArrayList<AmountListModel> amountListModels;
    EditText etAmount;
    TextView proceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastag_recharge_entry);

        amountListRecycle = (RecyclerView) findViewById(R.id.amountlistRecycle);
        etAmount = (EditText) findViewById(R.id.etamount);
        proceedBtn = (TextView) findViewById(R.id.proceed_btn);
        amountListModels = new ArrayList<AmountListModel>();
        amountListModels.add(new AmountListModel("₹100"));
        amountListModels.add(new AmountListModel("₹500"));
        amountListModels.add(new AmountListModel("₹100"));
        amountListModels.add(new AmountListModel("₹1000"));
        amountListAdapter = new AmountListAdapter(amountListModels,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        amountListRecycle.setLayoutManager(layoutManager);
        amountListRecycle.setAdapter(amountListAdapter);

    }
    public class AmountListAdapter extends RecyclerView.Adapter<AmountListAdapter.MyViewHolder> {
        private List<AmountListModel> amountListModels;
        private Context context;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView amount;

            public MyViewHolder(View view) {
                super(view);
                amount = view.findViewById(R.id.amounttext);
            }
        }


        public AmountListAdapter(List<AmountListModel> planList, Context ctx) {
            this.amountListModels = planList;
        }


        @Override
        public AmountListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.amount_list_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(AmountListAdapter.MyViewHolder holder, int position) {
            AmountListModel plans = amountListModels.get(position);
            holder.amount.setText(plans.amount);
            holder.amount.setOnClickListener(view -> {
                etAmount.setText(plans.getAmount());
                proceedBtn.setText("Proceed " + plans.getAmount());
            });
        }


        @Override
        public int getItemCount() {
            return amountListModels.size();
        }
    }


}