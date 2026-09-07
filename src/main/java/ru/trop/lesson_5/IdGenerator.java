package ru.trop.lesson_5;

public class IdGenerator {

    private static final IdGenerator instance = new IdGenerator();
    private int counter = 1;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return instance;
    }

    public int getNextId() {
        return counter++;
    }
}
