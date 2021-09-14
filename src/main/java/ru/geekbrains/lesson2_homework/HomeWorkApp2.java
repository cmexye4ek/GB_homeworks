package ru.geekbrains.lesson2_homework;

import java.util.Scanner;

public class HomeWorkApp2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = (int) (Math.random() * 30);
        int number2 = (int) (Math.random() * 10);
        int number3 = -10;
        int number4 = 10;
        int number5 = (int) (Math.random() * 10);
        String somestring = "Если вы видите эту строку " + number5 + " раз(а), значит метод работает";
        System.out.println("первое число a = " + number1);
        System.out.println("второе число b = " + number2);
        System.out.println("сумма чисел a и b лежит в диапазоне от 10 до 20 включительно = " + checkSum(number1, number2));
        isNegative(number3);
        System.out.println("Число " + number4 + " положительное = " + isNegative2(number4));
        printString(somestring, number5);
        System.out.println("Введите год");
        int year = scanner.nextInt();
        System.out.println(year + " год високосный = " + isYearLeap(year));
        scanner.close();


    }

    public static boolean checkSum(int number1, int number2) {
        return (number1 + number2) >= 10 && (number1 + number2) <= 20;
    }

    public static void isNegative(int number3) {
        if (number3 >= 0) {
            System.out.println("Число " + number3 + " положительное");
        } else {
            System.out.println("Число " + number3 + " отрицательное");
        }
    }

    public static boolean isNegative2(int number4) {
        return (number4 >= 0);
    }

    public static void printString(String somestring, int number5) {
        for (; number5 > 0; number5--) {
            System.out.println(somestring);
        }
    }

    public static boolean isYearLeap(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));

    }
}




