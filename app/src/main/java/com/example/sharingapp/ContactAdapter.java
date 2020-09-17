package com.example.sharingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter class responsible for displaying information in contact list ListView entries.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater inflater;
    private Context context;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // getItem(position) gets the contact at position in the contact list
        Contact contact = getItem(position);

        String username = "username: " + contact.getUserName();
        String email = "email: " + contact.getEmail();

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null ) {
            convertView = inflater . from ( context ).inflate(R.layout. contactlist_contact ,
                    parent, false );
        }
        TextView username_tv = (TextView) convertView.findViewById(R.id. username_tv );
        TextView email_tv = (TextView) convertView.findViewById(R.id. email_tv );
        ImageView photo = (ImageView)
                convertView.findViewById(R.id. contacts_image_view );
        photo.setImageResource(android.R.drawable. ic_menu_gallery );
        username_tv.setText(username);
        email_tv.setText(email);
        return convertView;
    }
}
