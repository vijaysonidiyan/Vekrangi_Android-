package com.vakrangee.mobilerecharge.MobileBillPayment;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.vakrangee.mobilerecharge.MobileRecharge.adapter.MyContactsAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.RecentAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ContactOperatorActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;
    private RecyclerView recyclerRecent,recyclerContacts;
    private RecyclerView.LayoutManager layoutManagerRecent,layoutManagerContact;
    private RecentAdapter mRecentAdapter;
    private MyContactsAdapter myContactsAdapter;
    private Cursor cursor;
    private List<Contacts.ContactList> mContactLists;
    Random rnd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_operator);

        initialization();
    }

    private void initialization() {
        mContactLists = new ArrayList<>();


        layoutManagerRecent = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManagerContact = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerRecent = findViewById(R.id.recycle_recent);
        recyclerContacts = findViewById(R.id.recycle_contacts);

        mRecentAdapter = new RecentAdapter(getApplicationContext(), Constant.key_operator);
        myContactsAdapter = new MyContactsAdapter(getApplicationContext(), Constant.key_operator);

        recyclerRecent.setLayoutManager(layoutManagerRecent);
        recyclerContacts.setLayoutManager(layoutManagerContact);

        recyclerRecent.setAdapter(mRecentAdapter);
        recyclerContacts.setAdapter(myContactsAdapter);

        if (checkPermission()){
            getContacts();
        }else {
            requestPermission();
        }
    }

    private void getContacts() {
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
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean write = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean read = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (write && read) {
                        getContacts();
                    }else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_CONTACTS, READ_CONTACTS},
                                                            PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }
                break;
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

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ContactOperatorActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
}