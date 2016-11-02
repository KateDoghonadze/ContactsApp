package com.example.zvio.contact_recycler.api.ui.models;

/**
 * Created by ZVIO on 11/3/2016.
 */

public class Contact {
    String Name;
    String PhoneNumber;

    public Contact(String phoneNumber, String name) {
        PhoneNumber = phoneNumber;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
