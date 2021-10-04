package ru.geekbrains.lesson3_homework;

import java.util.Arrays;

public class HomeWorkApp3 {

    public static void main(String[] args) {
        arraySwap();
        System.out.println();
        arrayFill();
        System.out.println();
        arrayMultiplication();
        System.out.println();
        arrayFillDiagonal();
        System.out.println();
        System.out.println(Arrays.toString(returnArray(56, 33)));
        System.out.println();
        arrayMinMax();
        System.out.println();
        int[] array = {3, 1, 2, 6, 2, 1, 15, 1}; // массив для заданий 7 и 8
        System.out.println(arraySumOfElements(array)); // вывод метода arraySumOfElements
        System.out.println();
        arrayShift(5, array);
    }

    public static void arraySwap() {
        int[] array = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            //      System.out.print(array[i] + " ");  // вывод в консоль массива для проверки.
        }

    }

    public static void arrayFill() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            //           System.out.print(array[i] + " "); // вывод в консоль массива для проверки.
        }
    }

    public static void arrayMultiplication() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
//     System.out.print(array[i] + " ");   // вывод в консоль массива для проверки.
        }
    }

    public static void arrayFillDiagonal() {
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                array[i][array[i].length - 1 - i] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] returnArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;


    }

    public static void arrayMinMax() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, -5, 8, 9, 3};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }

            System.out.print(array[i] + " ");  // вывод в консоль массива для проверки.
        }
        System.out.println("\nмаксимальный элемент массива - " + max);
        System.out.println("минимальный элемент массива - " + min);
    }

    public static boolean arraySumOfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return (sum % 2 == 0);
    }

    public static void arrayShift(int n, int[] array) {
        if (n >= array.length) {
            System.out.println("смещение больше длины массива"); // в условиях задачи не описана проверка в данном случае
        }
        if (n > 0) {
            for (int i = 0; i < n; i++) {

                int temp = array[0];
                array[0] = array[array.length - 1];


                for (int j = 1; j < array.length - 1; j++) {
                    array[array.length - j] = array[array.length - j - 1];
                }
                array[1] = temp;
            }

        } else {
            for (int i = 0; i > n; i--) {

                int temp = array[array.length - 1];
                array[array.length - 1] = array[0];


                for (int j = 1; j < array.length - 1; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 2] = temp;

            }
        }

        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " "); // вывод сдвинутого массива

        }
    }
}

