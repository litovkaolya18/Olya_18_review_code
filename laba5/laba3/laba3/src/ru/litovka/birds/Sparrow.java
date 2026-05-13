package ru.litovka.birds;

/**
 * Воробей — умеет петь "чырык".
 */
public class Sparrow extends Bird {

    /** Создаёт воробья. */
    public Sparrow() {
        super("Воробей");
    }

    /**
     * Пение воробья.
     */
    @Override
    public void sing() {
        final String sound = "чырык";
        System.out.println(sound);
    }
}
