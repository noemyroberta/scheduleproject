/*
 * April, 2020
 */
package com.scheduleproject.beans;

import java.util.Objects;

/**
 * This class {@link Contact} represents a Contact in the Schedule.
 * @author Noemy Roberta
 */
public class Contact {
    
    private int id;
    private String name;
    private String cellphone;
    private static int cont = 0;
    
    public Contact(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;

        /** Id attribute it's a auto-generate int. */
        cont++;
        this.id = cont;
    }
    
    public Contact() {
        
    }

    /**
     * @returns the Contact's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @returns the Contact's cellphone number.
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @returns the Contact's ID auto-generate.
     */
    public int getId() {
        return id;
    }

    /**
     * Update the Contact's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Update the Contact's cellphone number.
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
    @Override
    public String toString() {
        return "\n" +
               "NAME: "+ name +";\n " +
               "CELLPHONE: "+ cellphone +";\n "+
               "ID: "+ id +"." +
               "\n";
    }

    /**
     * Rewritten methods of the Object class to compare Contact objects
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;

        return getName().equals(contact.getName()) &&
                Objects.equals(getCellphone(), contact.getCellphone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCellphone());
    }
}
