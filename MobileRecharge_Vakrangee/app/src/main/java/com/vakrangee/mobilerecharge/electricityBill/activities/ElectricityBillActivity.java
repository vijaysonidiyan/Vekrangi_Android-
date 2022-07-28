package com.vakrangee.mobilerecharge.electricityBill.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vakrangee.mobilerecharge.R;

public class ElectricityBillActivity extends AppCompatActivity {

//    ActivityElectricityBillBinding binding;
    RelativeLayout selectType;
    LinearLayout expandView;
    ImageView arrow;
    TextView selectedText;
    private RadioGroup radioGroup;
    private RadioButton electricityBoard;
    private RadioButton apartments;

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

        electricityBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedText.setText("");
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                electricityBoard = findViewById(selectedRadioButtonId);
                String selectedRbText = electricityBoard.getText().toString();
                selectedText.setText(selectedRbText);
            }
        });
        apartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedText.setText("");
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                apartments = (RadioButton) findViewById(selectedId);
                String selectedRbText = electricityBoard.getText().toString();
                selectedText.setText(selectedRbText);
            }
        });
    }
}