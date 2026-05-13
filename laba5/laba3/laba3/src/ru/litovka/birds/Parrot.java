package ru.litovka.birds;

import java.util.Random;

/**
 * Попугай — поёт первые N символов текста.
 */
public class Parrot extends Bird {

    /** Текст, который попугай может произнести. */
    private final String text;
    /** Генератор случайных чисел. */
    private final Random random = new Random();

    /**
     * Создаёт попугая с заданным текстом.
     *
     * @param text текст, который будет произносить попугай
     */
    public Parrot(String text) {
        super("Попугай");
        this.text = text;
    }

    /**
     * Попугай поёт первые N символов текста.
     */
    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1; // 1..len
        System.out.println("Попугай поёт (N = " + n + "):");
        System.out.println(text.substring(0, n));
    }

    /**
     * @return строковое описание попугая
     */
    @Override
    public String toString() {
        return "Попугай (текст: \"" + text + "\")";
    }
}
