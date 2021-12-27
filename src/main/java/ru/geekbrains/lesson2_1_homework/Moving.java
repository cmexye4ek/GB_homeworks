package ru.geekbrains.lesson2_1_homework;

public interface Moving {
    void run(RunningTrack runningTrack);

    void jump(Wall wall);

    int getRunLength();

    int getJumpHeight();

    String getName();

    boolean getSuccess();

}
