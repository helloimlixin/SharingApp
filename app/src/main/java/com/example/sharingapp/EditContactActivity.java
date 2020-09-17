package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Class responsible for editing a pre-existing contact entry consists of deleting the old contact
 * and adding a new contact with the old contact's id.
 * NOTE: contacts of "active" borrowers are not available for editing.
 */
public class EditContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    private Contact contact;
    private EditText email;
    private EditText username;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        context = getApplicationContext();
        contact_list.loadContacts(context);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        contact = contact_list.getContact(pos);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        username.setText(contact.getUsername());
        email.setText(contact.getEmail());
    }

    public void saveContact(View view) {
        String email_str = email.getText().toString();

        if (email_str.equals("")) {
            email.setError("Email field cannot be empty!");
            return;
        }

        if (!email_str.contains("@")) {
            email.setError("Please enter a valid email address.");
            return;
        }

        String username_str = username.getText().toString();
        String id = contact.getId(); // reuse the contact id

        // Check that the username is unique AND changed (NOTE: if the username is not changed, then
        // this should be fine, because it was already unique.)
        if (!contact_list.isUsernameAvailable(username_str)
                && !(contact.getUsername().equals(username_str))) {
            username.setError("Username is already taken!");
            return;
        }

        Contact updated_contact = new Contact(username_str, email_str, id);

        contact_list.deleteContact(contact);
        contact_list.addContact(updated_contact);
        contact_list.saveContacts(context);

        finish(); // finish EditContactActivity
    }

    public void deleteContact(View view) {
        contact_list.deleteContact(contact);
        contact_list.saveContacts(context);
        finish(); // finish EditContactActivity
    }
}