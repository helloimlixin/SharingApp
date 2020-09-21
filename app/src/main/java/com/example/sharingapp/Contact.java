package com.example.sharingapp;

import java.util.Objects;
import java.util.UUID;

public class Contact {

    private String username;
    private String email;
    private String id;

    public Contact() {}

    public Contact(String username, String email, String id) {
        this.username = username;
        this.email = email;
        if (id == null) {
            setId();
        } else {
            updateId(id);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public void updateId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(username, contact.username) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
