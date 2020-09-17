# SharingApp

![](2020-09-16-05-28-25.png)

Social Android application based on Coursera's OOD Design course hosted by University of Alberta.

## User Stories

### Basics

1. As an owner, I want to add a thing to my things. Each thing is created with title, maker, description, and dimensions (Length x Width x Height).
2. As an owner, I want to view one of my things, its title, maker, description, dimensions and status and if it is being borrowed, the borrower.
3. As an owner, I want to edit a thing in my things.
4. As an owner, I want to delete a thing in my things.

### Borrowing

1. As an owner, I want a thing to have a status of one of *Available* or *Borrowed*: I want to set a borrowed thing to be available once it's returned.

### Contacts

1. As an owner, I want to add a contact to my contacts.
2. As an owner, I want to be able to edit a contact in my contacts if that contact is not currently borrowing an item.
3. As an owner, I want to be able to delete a contact in my contacts if that is not currently borrowing an item.

## Glossary

- **user**: a person who uses or operates the app, users are owners
- **owner**: a user who owns the item
- **contact**: each contact has an email and a unique username associated with them, owners can add contacts to their contact list, owners can edit/delete
contacts from their contact list, a contact is a potential borrower
- **contacts**: a list of all contacts an owner has added into the app, these contacts are all potential borrowers
- **borrower**: a contact that borrows an item an eventually returns it to the item's owner