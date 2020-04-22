package com.scheduleproject.exceptions;

public class IsNotStringType extends Exception{

    private String text;

    public IsNotStringType(String text) {
        this.text = text;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();

        builder.append(text);
        builder.append(" is not a String. Try again.");

        return builder.toString();
    }

}
