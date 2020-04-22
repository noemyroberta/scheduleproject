package com.scheduleproject.tests;

import com.scheduleproject.beans.Contact;
import com.scheduleproject.beans.Schedule;

import static org.junit.jupiter.api.Assertions.*;

import com.scheduleproject.exceptions.ContactExistent;
import com.scheduleproject.exceptions.ContactNotExistent;
import com.scheduleproject.exceptions.IsNotStringType;
import com.scheduleproject.exceptions.NoSpace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScheduleTest {

    Schedule schedule = new Schedule();

    /** Building Scenery */
    Contact c1 = new Contact("Noemy Roberta", "(82) 9 9982-1117");
    Contact c2 = new Contact("Maria Antonieta", "(13) 9 93455-1778");
    Contact c3 = new Contact("Maria Alice Teodoro", "(82) 9 99855-7548");
    Contact c4 = new Contact("Alanis Louise", "(82) 9 9934-1051");
    Contact c5 = new Contact("Joaquina Barbosa", "(11) 9 9925-3812");
    Contact c6 = new Contact("Maria Joana", "(22) 5647-2259");

    @Test
    void testAddContact() throws Exception {
        /** Running */
        boolean contact1 = schedule.addContact(c1);
        boolean contact2 = schedule.addContact(c2);
        boolean contact3 = schedule.addContact(c3);

        /** Checking */
        assertTrue(contact1);
        assertTrue(contact2);
        assertTrue(contact3);

        assertNotNull(schedule.getAll());
        System.out.println(schedule.getAll());
    }

    @Test
    void testAddContactExistent() throws Exception {
        /** Building Scenery */
        boolean addedContact = schedule.addContact(c1);

        /** Running and Checking */
        assertTrue(addedContact);

        ContactExistent thrown = assertThrows(ContactExistent.class,
                () -> schedule.addContact(c1),
                "Expected addContact() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("already exist"));
    }

    @Test
    void testGetByName() throws Exception {
        /** Building Scenery */
        schedule.addContact(c1);
        schedule.addContact(c2);

        /** Runing */
        String foundContact = schedule.getByName("Noemy Roberta");
        String actualContact = this.c1.toString();

        /** Checking */
        assertNotNull(foundContact);
        assertEquals(foundContact, actualContact);

        System.out.println(foundContact);
    }

    @Test
    void testGetByNameNotString() throws Exception {
        /** Building Scenery */
        schedule.addContact(c1);
        schedule.addContact(c2);
        schedule.addContact(c3);

        /** Running and Checking */
        IsNotStringType thrown = assertThrows(
                IsNotStringType.class,
                () -> schedule.getByName("1124442"),
                "Expected getByName() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("is not a String"));
    }

    @Test
    void testGetByNameNotFound() throws Exception {
        schedule.addContact(c1);
        schedule.addContact(c2);
        schedule.addContact(c3);

        /** Running and Checking */
        ContactNotExistent thrown = assertThrows(
                ContactNotExistent.class,
                () -> schedule.getByName("Joaquina Silva"),
                "Expected getByName() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("no exist"));
    }

    @Test
    void testScheduleNoSpace() throws Exception {
        /** Building Scenery */
        schedule.addContact(c1);
        schedule.addContact(c2);
        schedule.addContact(c3);

        boolean statusC4 = schedule.addContact(c4);
        boolean statusC5 = schedule.addContact(c5);

        /** Running and Checking */
        assertTrue(statusC4);
        assertTrue(statusC5);

        NoSpace thrown = assertThrows(
                NoSpace.class,
                () -> schedule.addContact(c6),
                "Expected addContact() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("cannot be save"));
    }
}