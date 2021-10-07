package ru.geekbrains.lesson7_homework;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {

            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println("Котик " + name + " съел " + appetite + " еды из тарелки, наелся и спит");

        } else {
            System.out.println("Котику " + name + " не хватило еды в тарелке и он громко орет прося добавки");

        }
    }

    public boolean isSatiety() {
        return satiety;
    }

}
