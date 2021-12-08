package ru.geekbrains.lesson2_4_homework;

import java.util.List;

@FunctionalInterface
public interface SearchIndex {
    int searchIndex (int number, List <Integer> list);
}
