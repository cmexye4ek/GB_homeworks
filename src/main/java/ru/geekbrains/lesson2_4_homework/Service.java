package ru.geekbrains.lesson2_4_homework;

import java.util.List;

public class Service {
    public int searchIndex (int number, List <Integer> list, SearchIndex searchIndex) {
        return searchIndex.searchIndex(number, list);
    }
    public int maxNumber (List <Integer> list, FindMaxNumber findMaxNumber) {
        return findMaxNumber.maxNumber(list);
    }
    public String reverseString (StringBuilder string, ReverseString reverseString) {
        return reverseString.reverseString(string);
    }
    public Double findAverageNumber (List <Integer> list, FindAverageNumber findAverageNumber) {
        return findAverageNumber.findAverageNumber(list);
    }
    public List<String> findString (List<String> list, FindString findString) {
        return findString.findString(list);
    }
}
