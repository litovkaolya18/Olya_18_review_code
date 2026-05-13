package ru.litovka.birds;

import java.util.Random;

/**
 * Кукушка — поёт "ку-ку" случайное количество раз.
 */
public class Cuckoo extends Bird {

    /** Генератор случайных чисел. */
    private final Random random = new Random();
    /** Создаёт кукушку. */
    public Cuckoo() {
        super("Кукушка");
    }

    /**
     * Поёт "ку-ку" случайное количество раз.
     */
    @Override
    public void sing() {
        //FIX_ME:  число 10 — непонятно, что оно означает
        //FIX_ME: нет проверки на отрицательные значения
        // int count = random.nextInt(10) + 1; // 1..10
        //for (int i = 0; i < count; i++) {
        //    System.out.println("ку-ку");
        //}
        final int maxCalls = 10;
        int count = random.nextInt(maxCalls) + 1;
        for (int i = 0; i < Math.max(count, 1); i++) {
            System.out.println("ку-ку");
        }
    }
}
