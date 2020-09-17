package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Class responsible for the action of adding a new contact.
 */
public class AddContactActivity extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private ContactList contact_list = new ContactList();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list.loadContacts(context);
    }

    public void saveContact(View view) {
        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")) {
            email.setError("Please enter a valid email address");
            return;
        }

        if (!contact_list.isUsernameAvailable(username_str)) {
            username.setError("Username already taken!");
            return;
        }

        Contact contact = new Contact(username_str, email_str, null);
        contact_list.addContact(contact);
        contact_list.saveContacts(context);

        // Finish AddContactActivity.
        finish();
    }
}