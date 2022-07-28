package com.vakrangee.mobilerecharge.MobileRecharge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.vakrangee.mobilerecharge.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Confirm_OperatorActivity extends AppCompatActivity {
    private EditText EditNumber;
    private Spinner SpinnerJio;


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

//        if (!isValidPhone(EditNumber.getText().toString())) {
//            EditNumber.setError("Enter valid email");
//
//        }
    }


//    private boolean isValidPhone(String phone) {
//        Pattern pattern;
//        Matcher matcher;
//
//        final String PHONE_PATTERN= "[0-9]{10}";
//
//        pattern = Pattern.compile(PHONE_PATTERN);
//        matcher = pattern.matcher(phone);
//        return matcher.matches();
//
//    }
}