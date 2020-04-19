/*
 * April, 2020
 */
package com.scheduleproject.exceptions;

import com.scheduleproject.beans.Contact;

/**
 *
 * @author Noemy Roberta
 */

public class ContactExistent extends Exception {
    
    private Contact contact;
    
    public ContactExistent(Contact contact) {
        this.contact = contact;
    }
    
    @Override
    public String getMessage() {
        return "This contact already exist: \n"+contact.toString()+ "\n";
    }
    
}
