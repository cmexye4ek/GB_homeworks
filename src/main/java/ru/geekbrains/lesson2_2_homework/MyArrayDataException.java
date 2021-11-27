package ru.geekbrains.lesson2_2_homework;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();

    }

}
