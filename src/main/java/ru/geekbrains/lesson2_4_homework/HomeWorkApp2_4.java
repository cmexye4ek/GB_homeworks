package ru.geekbrains.lesson2_4_homework;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWorkApp2_4 {
    public static void main(String[] args) {

        int number = 5; // число индекс которого ищется в массиве
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(10));
        }
        Service service = new Service();
        System.out.println(list);
        System.out.println("First index of " + number + " is " + service.searchIndex(number, list, (num, arr) -> arr.indexOf(num)));
        StringBuilder stringBuilder = new StringBuilder("java interview");
        System.out.println("reverse of " + stringBuilder + " is " + service.reverseString(stringBuilder, (string) -> string.reverse().toString()));
        System.out.println("Max number in list: " + service.maxNumber(list, (num) -> Collections.max(num)));
        System.out.println("Average of numbers list: " + service.findAverageNumber(list, (arr) -> arr.stream().mapToInt(a -> a).average().orElse(0.0)));

        String symbol = ("a"); // символ с которого начинается строка для выборки
        int lengthOfString = 3; // минимальная длина строки для выборки
        List<String> stringList = new ArrayList<>();
        stringList.add("aba");
        stringList.add("One");
        stringList.add("Aab");
        stringList.add("Two");
        stringList.add("Book");
        stringList.add("Lion");
        stringList.add("arrow");
        stringList.add("abc");
        System.out.println("List of strings: " + stringList);
        System.out.println("Strings with first symbol " + symbol + " and length " + lengthOfString + " symbols: " + service.findString(stringList, (arr) -> arr.stream().filter(a -> a.length() == lengthOfString && a.startsWith(symbol)).collect(Collectors.toList())));
    }
}
