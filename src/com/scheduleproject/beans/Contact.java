/*
 * April, 2020
 */
package com.scheduleproject.beans;

import java.util.Objects;

/**
 *
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
        cont++;
        this.id = cont;
    }
    
    public Contact() {
        
    }
    
    public String getName() {
        return name;
    }
    
    public String getCellphone() {
        return cellphone;
    }
    
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
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
