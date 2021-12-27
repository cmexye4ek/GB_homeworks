package ru.geekbrains.lesson2_1_homework;

import java.util.Random;

public class Cat implements Moving {
    Random random = new Random();
    private String name;
    private int runLength = random.nextInt(200);
    private int jumpHeight = random.nextInt(200);
    private boolean isSuccess = true;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(RunningTrack runningTrack) {
        System.out.println(name + " бежит");
        if (runLength > runningTrack.getTrackLength()) {
            System.out.println(name + " успешно пробегает дистанцию");
        } else {
            System.out.println(name + " выдохся и не смог пробежать дистанцию и выбывает из соревнований");
            isSuccess = false;
        }

    }

    @Override
    public void jump(Wall wall) {
        System.out.println(name + " прыгает");
        if (jumpHeight > wall.getWallHeight()) {
            System.out.println(name + " успешно перепрыгивает барьер");
        } else {
            System.out.println(name + " не смог перепрыгнуть барьер и выбывает из соревнований");
            isSuccess = false;
        }

    }

    @Override
    public int getRunLength() {
        return runLength;
    }

    @Override
    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getSuccess() {
        return isSuccess;
    }

}
