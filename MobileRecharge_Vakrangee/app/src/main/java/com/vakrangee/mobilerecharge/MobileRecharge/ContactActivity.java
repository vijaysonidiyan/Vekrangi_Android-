package com.vakrangee.mobilerecharge.MobileRecharge;
import androidx.annotation.NonNull;
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
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.MyContactsAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.adapter.RecentAdapter;
import com.vakrangee.mobilerecharge.MobileRecharge.models.Contacts;
import com.vakrangee.mobilerecharge.R;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.READ_CONTACTS;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 200;
    private RecyclerView recyclerRecent,recyclerContacts;
    private RecyclerView.LayoutManager layoutManagerRecent,layoutManagerContact;
    private RecentAdapter mRecentAdapter;
    private MyContactsAdapter myContactsAdapter;
    private Cursor cursor;
    private List<Contacts.ContactList> mContactLists;
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

        recyclerRecent = findViewById(R.id.recycle_recent);
        recyclerContacts = findViewById(R.id.recycle_contacts);

        mRecentAdapter = new RecentAdapter(getApplicationContext());
        myContactsAdapter = new MyContactsAdapter(getApplicationContext());

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
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if ((cursor != null ? cursor.getCount() : 0) > 0) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Contacts.ContactList item = new Contacts.ContactList();
                item.setName(name);
                item.setNumber(phoneNumber);
                myContactsAdapter.addItem(item);

                Log.d("TAG","Name--->"+name);
                Log.d("TAG","phoneNumber--->"+phoneNumber);
            }
        }
        if(cursor!=null){
            cursor.close();
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
        new AlertDialog.Builder(ContactActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
