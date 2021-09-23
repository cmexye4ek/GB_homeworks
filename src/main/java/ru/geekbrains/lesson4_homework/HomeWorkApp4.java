package ru.geekbrains.lesson4_homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    private static char[][] map;
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static final char EMPTY_DOT = '•';
    private static final int MAP_SIZE = 5;
    private static final int WIN_CONDITION = 4;
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {


        initMap();
        printMap();

        while (true) {
            humanTurn();
            if (isWin(X_DOT)) {
                System.out.println("YOU WIN");
                break;
            }
            if (isDraw()) {
                break;
            }

            computerTurn();
            printMap();
            if (isWin(O_DOT)) {
                System.out.println("YOU LOSE");
                break;
            }
            if (isDraw()) {
                break;
            }
        }

    }


    private static boolean isWin(char dot) {
        int n = 0;

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length - (WIN_CONDITION - 1); col++) {
                while (map[row][col] == dot) {
                    col++;
                    n++;
                    if (n == WIN_CONDITION) {
                        return true;
                    }
                }
                n = 0;
            }
        }

        for (int col = 0; col < map.length; col++) {
            for (int row = 0; row < map[col].length - (WIN_CONDITION - 1); row++) {
                while (map[row][col] == dot) {
                    row++;
                    n++;
                    if (n == WIN_CONDITION) {
                        return true;
                    }
                }
                n = 0;
            }
        }
        for (int col = 0; col < map.length - (WIN_CONDITION - 1); col++) {
            for (int row = 0; row < map[col].length - (WIN_CONDITION - 1); row++) {
                while (map[row][col] == dot) {
                    row++;
                    col++;
                    n++;
                    if (n == WIN_CONDITION) {
                        return true;
                    }
                }
                n = 0;
            }
        }
        for (int col = MAP_SIZE - 1; col > (WIN_CONDITION - 2); col--) {
            for (int row = 0; row < map[col].length - (WIN_CONDITION - 1); row++) {
                while (map[row][col] == dot) {
                    row++;
                    col--;
                    n++;
                    if (n == WIN_CONDITION) {
                        return true;
                    }
                }
                n = 0;
            }
        }

        return false;
    }

//        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot){
//            return true;
//        }
//        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot){
//            return true;
//        }
//        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot){
//            return true;
//        }
//
//        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot){
//            return true;
//        }
//        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot){
//            return true;
//        }
//        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot){
//            return true;
//        }
//
//        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot){
//            return true;
//        }
//        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot){
//            return true;
//        }


    private static void humanTurn() {
        int xCoordinate;
        int yCoordinate;
        System.out.println("Введите координаты в формате \"x пробел y\"");
        do {
            xCoordinate = -1;
            yCoordinate = -1;

            if (SC.hasNextInt()) {
                xCoordinate = SC.nextInt();
            }
            if (SC.hasNextInt()) {
                yCoordinate = SC.nextInt();
            }
            SC.nextLine();
        } while (!isValidHumanTurn(xCoordinate, yCoordinate));
    }

    private static void computerTurn() {
        int xCoordinate = 0;
        int yCoordinate = 0;
        boolean idiotSwitch = false;
        boolean idiotSwitch2 = false;
        Random random = new Random();

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    map[i][j] = X_DOT;
                    if (isWin(X_DOT)) {
                        xCoordinate = i;
                        yCoordinate = j;

                        idiotSwitch = true;

                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    map[i][j] = O_DOT;
                    if (isWin(O_DOT)) {
                        xCoordinate = i;
                        yCoordinate = j;

                        idiotSwitch2 = true;

                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        if (!idiotSwitch && !idiotSwitch2) {


            do {
                xCoordinate = random.nextInt(MAP_SIZE);
                yCoordinate = random.nextInt(MAP_SIZE);
            } while (!isValidComputerTurn(xCoordinate, yCoordinate));
        }
        map[xCoordinate][yCoordinate] = O_DOT;
    }

    private static boolean isValidHumanTurn(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 1 || yCoordinate < 1 ||
                xCoordinate > MAP_SIZE || yCoordinate > MAP_SIZE) {
            System.out.println("Вы ввели неправильные координаты. Введите координаты в формате \"x пробел y\"");
            return false;
        }
        if (map[xCoordinate - 1][yCoordinate - 1] == X_DOT || map[xCoordinate - 1][yCoordinate - 1] == O_DOT) {
            System.out.println("Поле с введенными координатами уже занято. Введите координаты в формате \"x пробел y\"");
            return false;
        }

        if (map[xCoordinate - 1][yCoordinate - 1] == EMPTY_DOT) {
            map[xCoordinate - 1][yCoordinate - 1] = X_DOT;
            return true;
        }

        return false;
    }

    private static boolean isValidComputerTurn(int xCoordinate, int yCoordinate) {
        if (map[xCoordinate][yCoordinate] == EMPTY_DOT) {
            map[xCoordinate][yCoordinate] = O_DOT;
            return true;
        }
        return false;
    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            Arrays.fill(map[i], EMPTY_DOT);
        }
    }

    private static boolean isDraw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        System.out.println("DRAW");
        return true;
    }
}