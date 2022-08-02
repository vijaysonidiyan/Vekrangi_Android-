package com.vakrangee.mobilerecharge.electricityBill.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vakrangee.mobilerecharge.R;
import com.vakrangee.mobilerecharge.electricityBill.FAQAcitivity;
import com.vakrangee.mobilerecharge.electricityBill.models.BoardListModel;

import java.util.ArrayList;
import java.util.List;

public class ElectricityBillActivity extends AppCompatActivity {

//    ActivityElectricityBillBinding binding;
    RelativeLayout selectType;
    LinearLayout expandView;
    ImageView arrow;
    TextView selectedText;
    private RadioGroup radioGroup;
    private RadioButton electricityBoard;
    private RadioButton apartments;
    private BoardListAdapter boardAdapter;
    private ArrayList<BoardListModel> boardModel;
    private RecyclerView boardRecycle;
    RelativeLayout selectBoard;
    ImageView board_arrow;
    LinearLayout expandDistrictView;
    ImageView district_arrow;
    RelativeLayout selectDistrict;
    TextView proceed;
    ImageView help_support;
    TextView selectBoardText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill);


//        binding = ActivityElectricityBillBinding.inflate(getLayoutInflater());
//        setContentView(binding.root);
//
//        binding.onclickSelectType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(binding.expandView.getVisibility() == View.VISIBLE) {
//                    binding.expandView.setVisibility(View.GONE);
//                }else{
//                    binding.expandView.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        expandView = findViewById(R.id.expandView);
        selectType = findViewById(R.id.onclickSelectType);
        arrow = findViewById(R.id.arrow);
        selectedText  = findViewById(R.id.selectTypeOptionText);
        radioGroup = (RadioGroup) findViewById(R.id.selectTypeGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        electricityBoard = (RadioButton) findViewById(R.id.elctricityBoardType);
        apartments = (RadioButton) findViewById(R.id.apartmentsType);
        boardRecycle = (RecyclerView) findViewById(R.id.recyclerBoard);
        selectBoard = (RelativeLayout) findViewById(R.id.onclickSelectBoard);
        board_arrow = (ImageView) findViewById(R.id.board_arrow);
        selectDistrict = (RelativeLayout) findViewById(R.id.onclickSelectDistrict);
        district_arrow = (ImageView) findViewById(R.id.district_arrow);
        expandDistrictView = (LinearLayout) findViewById(R.id.expandDistrictView);
        proceed = (TextView) findViewById(R.id.proceed_btn);
        selectBoardText = (TextView) findViewById(R.id.selectBoardOptionText);
        help_support = (ImageView) findViewById(R.id.viewHelp);
        help_support.setOnClickListener(view -> {
            Intent intent = new Intent(ElectricityBillActivity.this, FAQAcitivity.class);
            startActivity(intent);
        });

        boardModel = new ArrayList<BoardListModel>();
        boardModel.add(new BoardListModel("BSES Rajdhani - Delhi",R.drawable.location_icon));
        boardModel.add(new BoardListModel("BSES Yamuna Delhi",R.drawable.location_icon));
        boardModel.add(new BoardListModel("New Delhi Municipal Council (NDMC)",R.drawable.location_icon));
        boardModel.add(new BoardListModel("Tata Power",R.drawable.location_icon));
        boardAdapter = new BoardListAdapter(boardModel,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        boardRecycle.setLayoutManager(layoutManager);
        boardRecycle.setAdapter(boardAdapter);

        selectType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expandView.getVisibility() == View.VISIBLE){
                    expandView.setVisibility(View.GONE);
                    arrow.setImageDrawable(getDrawable(R.drawable.ic_top_arrow));
                }else {
                    expandView.setVisibility(View.VISIBLE);
                    arrow.setImageDrawable(getDrawable(R.drawable.ic_down_arrow));
                }
            }
        });

        selectDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expandDistrictView.getVisibility() == View.VISIBLE){
                    expandDistrictView.setVisibility(View.GONE);
                    district_arrow.setImageDrawable(getDrawable(R.drawable.ic_top_arrow));
                }else {
                    expandDistrictView.setVisibility(View.VISIBLE);
                    district_arrow.setImageDrawable(getDrawable(R.drawable.ic_down_arrow));
                }
            }
        });


        selectBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boardRecycle.getVisibility() == View.VISIBLE){
                    boardRecycle.setVisibility(View.GONE);
                    board_arrow.setImageDrawable(getDrawable(R.drawable.ic_top_arrow));
                }else {
                    boardRecycle.setVisibility(View.VISIBLE);
                    board_arrow.setImageDrawable(getDrawable(R.drawable.ic_down_arrow));
                }
            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
            String text = radioButton.getText().toString();
            selectedText.setText(text);
        });
        proceed.setOnClickListener(view -> {
            Intent intent = new Intent(ElectricityBillActivity.this,ElectricityBillDetailsActivity.class);
            startActivity(intent);
        });
    }
    public class BoardListAdapter extends RecyclerView.Adapter<BoardListAdapter.MyViewHolder> {
        private List<BoardListModel> boardList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView boardname;
            public ImageView img;
            public LinearLayout expandBoard;

            public MyViewHolder(View view) {
                super(view);
                boardname = view.findViewById(R.id.boarditemtext);
                img = view.findViewById(R.id.imageView1);
                expandBoard = view.findViewById(R.id.expandBoardView);
            }
        }


        public BoardListAdapter(List<BoardListModel> planList, Context ctx) {
            this.boardList = planList;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_board_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            BoardListModel plans = boardList.get(position);
            holder.boardname.setText(plans.boardName);
            Picasso.get().load(R.drawable.location_icon).into(holder.img);
            holder.expandBoard.setOnClickListener(view -> {
                selectBoardText.setText(plans.boardName);
                boardRecycle.setVisibility(View.GONE);
            });
        }


        @Override
        public int getItemCount() {
            return boardList.size();
        }
    }

}