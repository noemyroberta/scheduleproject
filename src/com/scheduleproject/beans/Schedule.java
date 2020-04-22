/*
 * April, 2020
 */
package com.scheduleproject.beans;

import com.scheduleproject.exceptions.ContactExistent;
import com.scheduleproject.exceptions.ContactNotExistent;
import com.scheduleproject.exceptions.IsNotStringType;
import com.scheduleproject.exceptions.NoSpace;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 *
 * @author Noemy Roberta
 */
public class Schedule {

    private Contact[] contacts = new Contact[5];
    private static int totalContacts = 0;

    public Schedule() {

    }

    public boolean addContact(Contact contact) throws Exception {
        boolean vetorSpace = checkVetorSpace(this.totalContacts);
        Contact existentContact = checkContactExistence(contact);

        if(existentContact != null) {
            throw new ContactExistent(existentContact);
        } else if (vetorSpace != true) {
            throw new NoSpace(this.totalContacts);
        } else {
            this.contacts[totalContacts] = contact;
            totalContacts++;

            return true;
        }
    }

    public String getAll() { return Arrays.toString(contacts); }

    public String getByName(String name) throws Exception {
        Contact foundContact;

        for(int i = 0; i < this.contacts.length; i++) {
            if(checkString(name) != false) {
                if(this.contacts[i].getName().equalsIgnoreCase(name)) {
                    foundContact = this.contacts[i];
                    return foundContact.toString();
                } else {
                    throw new ContactNotExistent(name);
                }
            } else {
                throw new IsNotStringType(name);
            }
        }
        return null;
    }

    private Contact checkContactExistence(Contact contact) {
        for(int i = 0; i < this.totalContacts; i++) {
            if(contact.equals(this.contacts[i])) {
                contact = this.contacts[i];
                return contact;
            }
        }
        return null;
    }

    private boolean checkVetorSpace(int totalContacts) {
        return totalContacts == 5 ? false : true;
    }

    private boolean checkString(String string) {
        return string.matches("[A-Z a-z Çç]{"+string.length()+"}");
    }

    @Override
    public String toString() {
        if(this.totalContacts == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(int i = 0; i < this.totalContacts - 1; i++) {
            builder.append(contacts[i]);
            builder.append(",");
        }

        builder.append(contacts[totalContacts - 1]);
        builder.append("]");

        return builder.toString();
    }
}
