package com.example.zvio.contact_recycler.api.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zvio.contact_recycler.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_add_contact;
    private static final Integer AddContactActivity=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_add_contact = (Button)findViewById(R.id.button_add_contact);
        button_add_contact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_add_contact:
                startActivityForResult(new Intent(this,AddContactActivity.class),AddContactActivity);
                break;
        }
    }
}
