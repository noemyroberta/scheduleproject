/*
 * April, 2020
 */
package com.scheduleproject.domain;

import com.scheduleproject.beans.Contact;
import com.scheduleproject.beans.Schedule;

import java.util.Scanner;

/**
 * @author Noemy Roberta
 */
public class Start {

    private static Schedule schedule = new Schedule();

    public static void main(String[] args) throws Exception {

        do {
            showMenu();

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch (option) {
                case 1:
                    showCreateContact();
                    break;

                case 2:
                    showSearchContact();
                    break;

                case 3:
                    showAllContacts();
                    break;

                default:
                    System.err.println("That's not a valid option. Try again.");
            }
        } while (true);
    }

    private static void showMenu() throws Exception {
        System.out.println("---------------------------------------------");
        System.out.println("Hey, you! Welcome to your Schedule.");
        System.out.println("1. Create a new contact;");
        System.out.println("2. Search for a contact;");
        System.out.println("3. See all contacts;");
        System.out.println("---------------------------------------------");
        System.out.print("Type your desired option: ");
    }

    private static void showCreateContact() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------Creating a Contact--------------");
        System.out.print("Type the name: ");
        String name = input.nextLine();
        System.out.print("Type the cellphone number: ");
        String cellphone = input.nextLine();

        Contact contact = new Contact(name, cellphone);
        boolean result = schedule.addContact(contact);

        if(result) {
            System.out.println("Contact was registered!");
            System.out.println("");
        }
    }

    private static void showSearchContact() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("------------Searching a Contact--------------");
        System.out.print("Type the name: ");
        String name = input.nextLine();

        System.out.println(schedule.getByName(name));
    }

    private static void showAllContacts() {
        System.out.println("------------Showing all Contacts--------------");

        System.out.println(schedule.getAll());
    }
}
