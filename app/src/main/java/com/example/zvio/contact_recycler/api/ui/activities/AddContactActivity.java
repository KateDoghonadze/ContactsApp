package com.example.zvio.contact_recycler.api.ui.activities;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zvio.contact_recycler.R;
import com.example.zvio.contact_recycler.api.ui.adapters.ContactsAdapter;
import com.example.zvio.contact_recycler.api.ui.components.RecyclerItemClickListener;
import com.example.zvio.contact_recycler.api.ui.models.Contact;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final String[] PROJECTION =
            {
                    ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER,
            };


    RecyclerView recycler_view_all_contact;
    private static final Integer loader_id = 0;

    ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        getLoaderManager().initLoader(loader_id,null,this);
        recycler_view_all_contact = (RecyclerView)findViewById(R.id.recycler_view_all_contact);
        recycler_view_all_contact.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        if(id==loader_id){
            return new CursorLoader(AddContactActivity.this,ContactsContract.CommonDataKinds.Phone.CONTENT_URI,PROJECTION,
                    null,null,"display_name ASC");
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
data.moveToFirst();
        while(data.moveToNext()) {

            contacts.add(new Contact( data.getString((data.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))),
                    data.getString((data.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))));

        }

        recycler_view_all_contact.setAdapter(new ContactsAdapter(contacts,new RecyclerItemClickListener(){

            @Override
            public void onItemClick(Contact contact) {
            }
        }));
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
