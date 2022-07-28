package com.vakrangee.mobilerecharge.MobileRecharge.models;

import java.util.List;

public class Contacts {
    public static Object ContactList;

    public List<ContactList> contactList;

    public List<Contacts.ContactList> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contacts.ContactList> contactList) {
        this.contactList = contactList;
    }

    public static class ContactList {
        String name;
        String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
