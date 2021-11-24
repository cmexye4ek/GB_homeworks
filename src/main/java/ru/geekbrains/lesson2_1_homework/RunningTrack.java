package ru.geekbrains.lesson2_1_homework;

import java.util.Random;

public class RunningTrack extends Obstacle {
    Random random = new Random();
    private int trackLength = random.nextInt(300);

    public RunningTrack() {

    }


    public int getTrackLength() {
        return trackLength;
    }


}
