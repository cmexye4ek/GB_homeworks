package ru.geekbrains.lesson6_homework;

public class Cat extends Animal {
    private int runLength = 200;
    private boolean canSwim = false;
    private int swimLength = 0;

    public Cat() {
        super();
    }

    public Cat(int runLength, boolean canSwim, int swimLength) {
        this.runLength = runLength;
        this.canSwim = canSwim;
        this.swimLength = swimLength;
    }

    @Override
    public void animalRun(int length) {
        if (length < runLength) {
            System.out.println("Кот пробежал " + length + " м.");
        } else {
            System.out.println("Слишком большое расстояние для кота");
        }
    }

    @Override
    public void animalSwim(int length) {
        if (canSwim) {
            if (length < swimLength) {
                System.out.println("Кот проплыл " + length + " м.");
            } else {
                System.out.println("Слишком большая дистанция для Кота");
            }
        } else {
            System.out.println("Этот Кот не умеет плавать");
        }

    }
}


