package ru.geekbrains.lesson2_1_homework;

import java.util.Random;

public class Wall extends Obstacle {
    Random random = new Random();
    private int wallHeight = random.nextInt(300);

    public Wall() {

    }


    public int getWallHeight() {
        return wallHeight;
    }


}
