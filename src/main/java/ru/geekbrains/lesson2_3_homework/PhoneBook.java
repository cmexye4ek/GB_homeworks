package ru.geekbrains.lesson2_3_homework;


import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();

    }

    public void add(String surname, String phoneNumber) {
        ArrayList<String> phoneNumbers = book.get(surname);
        if (phoneNumbers != null) {
            phoneNumbers.add(phoneNumber);
        } else {
            phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            book.put(surname, phoneNumbers);
        }
    }

    public void get(String surname) {
        System.out.println(surname + " phone numbers - " + book.get(surname).toString());

    }

}

