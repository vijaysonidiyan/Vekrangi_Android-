package com.vakrangee.mobilerecharge.MobileRecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vakrangee.mobilerecharge.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Confirm_OperatorActivity extends AppCompatActivity {
    private EditText EditNumber;
    private Spinner SpinnerJio;
    RelativeLayout selectType;
    LinearLayout expandView;
    ImageView arrow;
    TextView selectedText;
    private RadioGroup radioGroup;
    private RadioButton electricityBoard;
    private RadioButton apartments;
    LinearLayout linjio,linAirtel;
    TextView tvJio,tvAirtel;
    ImageView ivSelectedOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_operator);
        initialization();
    }

    private void initialization() {
        EditNumber = findViewById(R.id.EditNumber);
        SpinnerJio = findViewById(R.id.SpinnerJio);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdwon_jio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerJio.setAdapter(adapter);

        expandView = findViewById(R.id.expandView);
        selectType = findViewById(R.id.onclickSelectType);
        arrow = findViewById(R.id.arrow);
        selectedText  = findViewById(R.id.selectTypeOptionText);
        radioGroup = (RadioGroup) findViewById(R.id.selectTypeGroup);
        linjio =  findViewById(R.id.lin_jio);
        linAirtel = findViewById(R.id.lin_airtel);
        tvJio =  findViewById(R.id.tv_jio);
        tvAirtel =  findViewById(R.id.tv_airtel);
        ivSelectedOperator = findViewById(R.id.selected_operator);
//        int selectedId = radioGroup.getCheckedRadioButtonId();




        selectType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expandView.getVisibility() == View.VISIBLE){
                    expandView.setVisibility(View.GONE);
                    arrow.setImageDrawable(getDrawable(R.drawable.ic_down_arrow));
                }else {
                    expandView.setVisibility(View.VISIBLE);
                    arrow.setImageDrawable(getDrawable(R.drawable.ic_top_arrow));
                }
            }
        });
        linjio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedText.setText("");
                ivSelectedOperator.setVisibility(View.VISIBLE);
                Picasso.get().load(R.drawable.icon_jio).into(ivSelectedOperator);
                expandView.setVisibility(View.GONE);

                String selectedRbText = tvJio.getText().toString();
                selectedText.setText(selectedRbText);
            }
        });
        linAirtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedText.setText("");
                ivSelectedOperator.setVisibility(View.VISIBLE);
                Picasso.get().load(R.drawable.icon_jio).into(ivSelectedOperator);
                String selectedRbText = tvAirtel.getText().toString();
                selectedText.setText(selectedRbText);
                expandView.setVisibility(View.GONE);
            }
        });




    }



}