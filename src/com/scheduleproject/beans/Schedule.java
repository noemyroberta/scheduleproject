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
 * This class {@link Schedule} represents a Schedule. Receives objects from class {@link Contact}
 * @author Noemy Roberta
 */
public class Schedule {

    private Contact[] contacts = new Contact[5];
    private static int totalContacts = 0;

    public Schedule() {

    }

    /**
     *
     * @param contact, the Contact to be add to the Schedule
     * @return true - contact added - or one of those exceptions
     * @throws Exception ContactExistent when the Contact's information already exists
     * @throws  Exception NoSpace when there is no space in the Schedule
     */
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

    /**
     * Method to show up all Contacts of the Schedule
     * @return all contacts from the Schedule
     */
    public String getAll() { return Arrays.toString(contacts); }

    /**
     * Method to show the Contact by the send name
     * @param name, the Contact's name
     * @return the Contact's information or null if there's no contact in the Schedule
     * @throws Exception ContactNotExistent if the name was not found
     * @throws Exception IsNotStringType if the name it's numeric
     */
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

    /**
     * Method called by addContact(), checks the contact existence in the Schedule
     * @param contact, the Contact's information
     * @return null if this Contact not exist in the Schedule; Contact object if there is one
     */
    private Contact checkContactExistence(Contact contact) {
        for(int i = 0; i < this.totalContacts; i++) {
            if(contact.equals(this.contacts[i])) {
                contact = this.contacts[i];
                return contact;
            }
        }
        return null;
    }

    /**
     * Method called by addContact() to check the Schedule space
     * @param totalContacts the quantity of contacts already existent
     * @return true if there's space, false if there's no
     */
    private boolean checkVetorSpace(int totalContacts) {
        return totalContacts == 5 ? false : true;
    }

    /**
     * Method called by getByName() to check if the name's sent it's a string type
     * @param string, the string to be checked
     * @return true if it's a string, false if it's numeric
     */
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
