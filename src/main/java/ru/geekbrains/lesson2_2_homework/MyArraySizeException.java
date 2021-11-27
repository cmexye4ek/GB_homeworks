package ru.geekbrains.lesson2_2_homework;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();

    }

}
