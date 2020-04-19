/*
 * April, 2020
 */
package com.scheduleproject.beans;

import com.scheduleproject.exceptions.ContactExistent;
import com.scheduleproject.exceptions.ContactNotExistent;
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
        boolean checkExistence = checkContactExistence(contact);
        boolean checkVetorSpace = checkVetorSpace(this.totalContacts);

        if(checkExistence != false) {
            throw new ContactExistent(contact);
        } else if (checkVetorSpace != true) {
            throw new NoSpace(this.totalContacts);
        } else {
            this.contacts[totalContacts] = contact;
            totalContacts++;

            return true;
        }
    }

    public String getAll() { return Arrays.toString(contacts); }


    public String getByName(String name) throws Exception {
        Contact foundContact = new Contact();

        for(int i = 0; i < this.totalContacts; i++) {
            if(checkString(name) != false) {
                if(this.contacts[i].equals(name)) 
                    foundContact = this.contacts[i];
                else 
                    throw new ContactNotExistent(name);
            }

        }
        return foundContact.toString();
    }

    private boolean checkString(String name) {
        return !StringUtils.isNumeric(name) ? true : false;
    }

    private boolean checkContactExistence(Contact contact) {
        for(int i = 0; i < this.totalContacts; i++) {
            if(contact.equals(this.contacts[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVetorSpace(int totalContacts) {
        return totalContacts == 5 ? false : true;
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
