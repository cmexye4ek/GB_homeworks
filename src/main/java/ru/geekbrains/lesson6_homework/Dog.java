package ru.geekbrains.lesson6_homework;

public class Dog extends Animal {
    private int runLength = 500;
    private boolean canSwim = true;
    private int swimLength = 10;

    public Dog() {
        super();
    }

    public Dog(int runLength, boolean canSwim, int swimLength) {
        this.runLength = runLength;
        this.canSwim = canSwim;
        this.swimLength = swimLength;
    }

    @Override
    public void animalRun(int length) {
        if (length < runLength) {
            System.out.println("Собака пробежала " + length + " м.");
        } else {
            System.out.println("Слишком большая дистанция для собаки");
        }
    }

    @Override
    public void animalSwim(int length) {
        if (canSwim) {
            if (length < swimLength) {
                System.out.println("Собака проплыла " + length + " м.");
            } else {
                System.out.println("Слишком большая дистанция для собаки");
            }
        } else {
            System.out.println("Эта собака не умеет плавать");
        }

    }
}
