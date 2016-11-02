package com.example.zvio.contact_recycler.api.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zvio.contact_recycler.R;
import com.example.zvio.contact_recycler.api.ui.components.RecyclerItemClickListener;
import com.example.zvio.contact_recycler.api.ui.models.Contact;

import java.util.ArrayList;

/**
 * Created by ZVIO on 11/3/2016.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    ArrayList<Contact> contacts;
    RecyclerItemClickListener listener;
    Context context;

    public ContactsAdapter(ArrayList<Contact> contacts, RecyclerItemClickListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(contacts.get(position).getName());
        holder.phoneNumber.setText(contacts.get(position).getPhoneNumber());
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public Contact getItem(int pos) {
        return contacts.get(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView name, phoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.contact_image);
            name = (TextView) itemView.findViewById(R.id.contact_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.contact_phone_number);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onItemClick(contacts.get(getAdapterPosition()));
            }
        }
    }
}