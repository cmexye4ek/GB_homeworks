package ru.geekbrains.lesson7_homework;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int food) {
        this.food -= food;
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("В тарелку добавили " + food + " еды");
    }

    public void info() {
        System.out.println("В тарелке осталось " + food + " еды");
    }

    public int getFood() {
        return food;
    }
}
