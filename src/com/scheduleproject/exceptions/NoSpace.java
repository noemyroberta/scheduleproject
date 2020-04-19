/*
 * April, 2020 
 */
package com.scheduleproject.exceptions;

/**
 *
 * @author Noemy Roberta
 */
public class NoSpace extends Exception {
    
    private int numberSpace;
    
    public NoSpace(int numberSpace) {
        this.numberSpace = numberSpace;
    }
    
    @Override 
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("This contact cannot be save, there are already ");
        builder.append(numberSpace);
        builder.append(" contacts in the Schedule.");
        
        return builder.toString();
    }
    
}
