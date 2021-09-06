package ru.geekbrains.lesson1_homework;

import java.util.Scanner;

public class HomeWorkApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int exitcode = choiceMenu();
        while (exitcode != 0) {
            choiceMenu();
            exitcode = choiceMenu();
        }
        scanner.close();
    }

    public static int choiceMenu() {
        System.out.println("Выберите подпрогамму");
        System.out.println("0. Выход");
        System.out.println("1. Вывод слов в консоль");
        System.out.println("2. Проверка суммы");
        System.out.println("3. Вывод цвета");
        System.out.println("4. Сравнение чисел");
        int choice = userInputCheck();

        switch (choice) {
            case 1:
                printThreeWords();
                break;
            case 2:
                checkSumSign();
                break;
            case 3:
                printColor();
                break;
            case 4:
                compareNumbers();
                break;
        }

        return choice;
    }
    public static int userInputCheck() {
        while (!scanner.hasNextInt()) {
            System.out.println("Ввод не распознан, используйте цифры 0-4");
            scanner.next();

        }
        int input = scanner.nextInt();
        while (input < 0 || input > 4) {
            System.out.println("Ввод не распознан, используйте цифры 0-4");
            input = scanner.nextInt();

        }
        return input;
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }
    public static void checkSumSign() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * -10);
        System.out.println("a="+ a);
        System.out.println("b="+ b);
        if ((a + b) >= 0 ) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = (int) (Math.random() * 200);
        System.out.println("Число " + value);
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        System.out.println("a="+ a);
        System.out.println("b="+ b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}


