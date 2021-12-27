package ru.geekbrains.lesson2_2_homework;

import java.util.Arrays;

public class HomeWorkApp2_2 {
    public static void main(String[] args) {
        String[][] array = {{"0", "1", "2", "3" }, {"0", "1", "2", "3" }, {"0", "1", "2", "3" }, {"0", "1", "2", "3" }};
        try {
            System.out.println("Array elements sum: " + sumArray(array));
        } catch (MyArraySizeException exception) {
            System.out.println(exception.getMessage());

        } catch (MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        Integer[][] intArray = new Integer[4][4];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length > 4 || array.length > 4) {
                throw new MyArraySizeException("Array size is incorrect");
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(array[i][j]);
                    sum = sum + intArray[i][j];
                } catch (RuntimeException exception) {
                    throw new MyArrayDataException("Not a number: " + array[i][j] + " on index: " + i + " " + j);
                }
            }

        }
        return sum;
    }
}
