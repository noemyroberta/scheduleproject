/*
 * April, 2020
 */
package com.scheduleproject.exceptions;

/**
 *
 * @author Noemy Roberta 
 */
public class ContactNotExistent extends Exception {
    
    private String nameContact;
    
    public ContactNotExistent(String nameContact) {
        this.nameContact = nameContact;
    }
    
    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("This contact by name ");
        builder.append(nameContact);
        builder.append(" no exist in the Schedule.");
        
        return builder.toString();
    }
}
