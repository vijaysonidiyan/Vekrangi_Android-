package com.vakrangee.mobilerecharge.MobileRecharge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vakrangee.mobilerecharge.Interfaces.ClickEvent;
import com.vakrangee.mobilerecharge.MobileBillPayment.Constant;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.MyContactsAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.RecentAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.READ_CONTACTS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ContactActivity extends AppCompatActivity implements ClickEvent {
    private static final int PERMISSION_REQUEST_CODE = 200;
    ImageView imgHelp;
    RecyclerView recyclerRecent,recyclerContacts;
    RecyclerView.LayoutManager layoutManagerRecent,layoutManagerContact;
    ProgressBar mProgressBar;
    RecentAdapter mRecentAdapter;
    private MyContactsAdapter myContactsAdapter;
    Cursor cursor;
    List<Contacts.ContactList> mContactLists;
    Random rnd = new Random();
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initialization();
    }

    private void initialization() {
        mContactLists = new ArrayList<>();

        layoutManagerRecent = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManagerContact = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        layoutManagerRecent.setAutoMeasureEnabled(false);
        layoutManagerContact.setAutoMeasureEnabled(false);

        mRecentAdapter = new RecentAdapter(getApplicationContext(), Constant.key_contact);
        myContactsAdapter = new MyContactsAdapter(getApplicationContext(),Constant.key_contact);

        mProgressBar = findViewById(R.id.progress_circular);
        mProgressBar.setVisibility(View.GONE);

        recyclerRecent = findViewById(R.id.recycle_recent);
        recyclerContacts = findViewById(R.id.recycle_contacts);

        imgHelp = findViewById(R.id.imgHelp);
        imgHelp.setSelected(false);

        recyclerRecent.setLayoutManager(layoutManagerRecent);
        recyclerContacts.setLayoutManager(layoutManagerContact);

        recyclerRecent.setNestedScrollingEnabled(true);
        recyclerContacts.setNestedScrollingEnabled(true);

        recyclerRecent.setHasFixedSize(true);
        recyclerContacts.setHasFixedSize(true);

        recyclerRecent.setAdapter(mRecentAdapter);
        recyclerContacts.setAdapter(myContactsAdapter);


        if (checkPermission()){
            getContacts();
        }else {
            requestPermission();
        }

        //upDateUI(false);
    }



    private void getContacts() {

        //showProgressDialog();
        String[] projection = new String[] {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER,
                //plus any other properties you wish to query
        };

        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, null);
        } catch (SecurityException e) {
            //SecurityException can be thrown if we don't have the right permissions
        }

        if (cursor != null) {
            try {
                HashSet<String> normalizedNumbersAlreadyFound = new HashSet<>();
                int indexOfNormalizedNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER);
                int indexOfDisplayName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int indexOfDisplayNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                while (cursor.moveToNext()) {
                    String normalizedNumber = cursor.getString(indexOfNormalizedNumber);
                    if (normalizedNumbersAlreadyFound.add(normalizedNumber)) {
                        String displayName = cursor.getString(indexOfDisplayName);
                        String displayNumber = cursor.getString(indexOfDisplayNumber);

                        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                        Contacts.ContactList item = new Contacts.ContactList();
                        item.setName(displayName);
                        item.setNumber(displayNumber);
                        item.setColor(color);
                        //myContactsAdapter.addItem(item);
                        mContactLists.add(item);

                        //haven't seen this number yet: do something with this contact!
                    } else {
                        //don't do anything with this contact because we've already found this number
                    }
                }
            } finally {
               //upDateUI(false);
                if (mContactLists.size()>0){
                    myContactsAdapter.addList(mContactLists);
                    myContactsAdapter.notifyDataSetChanged();
                    //myContactsAdapter = new MyContactsAdapter(getApplicationContext(),Constant.key_contact,mContactLists);
                    //recyclerContacts.setAdapter(myContactsAdapter);
                }
               // dialog.dismiss();

                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                boolean write = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean read = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (write && read) {
                    getContacts();
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
                            showMessageOKCancel(
                                    (dialog, which) -> requestPermissions(new String[]{WRITE_CONTACTS, READ_CONTACTS},
                                            PERMISSION_REQUEST_CODE));
                        }
                    }

                }
            }
        }
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_CONTACTS);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{WRITE_CONTACTS, READ_CONTACTS}, PERMISSION_REQUEST_CODE);
    }

    private void showMessageOKCancel(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ContactActivity.this)
                .setMessage("You need to allow access to both the permissions")
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void upDateUI(boolean b) {

        Log.d("TAG","Update UI--->"+b);
        if (b){
            mProgressBar.setVisibility(View.VISIBLE);
            recyclerContacts.setVisibility(View.GONE);
        }else {
            mProgressBar.setVisibility(View.GONE);
            recyclerContacts.setVisibility(View.VISIBLE);
        }
    }

    /* On ClickEvent */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClickEvent(View view) {
        if (view.getId() == R.id.imgHelp) {
            view.setSelected(!view.isSelected());
            payments_dialog(view.isSelected());
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void payments_dialog(boolean b) {
        Dialog dialog = new Dialog(this, android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.setCancelable(true);

        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.dialog_payment, null);
        dialog.setContentView(view);

        ImageView img_payment;
        TextView txt_back,txt_title,txt_message,txt_action,txt_invoice;
        LinearLayout liner_transaction;

        txt_back = view.findViewById(R.id.txt_back);
        img_payment = view.findViewById(R.id.img_payment);
        txt_title = view.findViewById(R.id.txt_title);
        txt_message = view.findViewById(R.id.txt_message);
        txt_action = view.findViewById(R.id.txt_action);
        txt_invoice = view.findViewById(R.id.txt_invoice);
        liner_transaction = view.findViewById(R.id.lin_transaction);

        if (b){
            img_payment.setImageDrawable(getResources().getDrawable(R.drawable.icon_success));
            txt_title.setText(Constant.key_success);
            txt_message.setText(Constant.key_paid);
            txt_action.setText(Constant.key_okay);

        }else {
            img_payment.setImageDrawable(getResources().getDrawable(R.drawable.icon_unsuccess));
            txt_title.setText(Constant.key_un_success);
            txt_message.setText(Constant.key_try_again);
            txt_action.setText(Constant.key_retry);
            txt_invoice.setVisibility(View.INVISIBLE);
            liner_transaction.setVisibility(View.INVISIBLE);
        }

        txt_back.setOnClickListener(view1 -> dialog.dismiss());
        txt_action.setOnClickListener(view1 -> dialog.dismiss());


        dialog.show();
    }

   public void  showProgressDialog(){
       dialog = new ProgressDialog(this); // this = YourActivity
       dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       dialog.setTitle("Loading");
       dialog.setMessage("Loading. Please wait...");
       dialog.setIndeterminate(true);
       dialog.setCanceledOnTouchOutside(false);
       dialog.show();
    }


}
