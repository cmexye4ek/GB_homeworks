package ru.geekbrains.lesson2_3_homework;

import java.util.*;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("One");
        array.add("Two");
        array.add("Three");
        array.add("Book");
        array.add("Lion");
        array.add("One");
        array.add("Two");
        array.add("Island");
        array.add("Word");
        array.add("Lion");
        array.add("Two");
        System.out.println(array); // вывод всего массива слов
        HashSet<String> hashSet = new HashSet<>(array);

        for (String str : hashSet) {
            System.out.println(str + " - " + Collections.frequency(array, str)); //подсчет количества одинаковых слов в первоначальном массиве
        }

        System.out.println(hashSet); //вывод уникальных слов


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "123123");
        phoneBook.add("Ivanov", "234234");
        phoneBook.add("Petrov", "123321");
        phoneBook.add("Sidorov", "234432");

        phoneBook.get("Ivanov");
    }

}





