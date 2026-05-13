package ru.litovka.birds;

/**
 * Класс BirdMarket предоставляет утилитный метод
 * для одновременного "пения" всех птиц.
 */
public class BirdMarket {

    /**
     * Вызывает метод sing() у каждой птицы в массиве.
     *
     * @param birds массив птиц
     */
    public static void makeAllBirdsSing(Bird[] birds) {
        //FIX_ME: нет проверки на null массива — вызовет ошибку при birds == null
        // for (Bird b : birds) {
        //   System.out.println(b.getName() + " поёт:");
        //   b.sing();
        //   System.out.println();
        // }

        if (birds == null || birds.length == 0) {
            System.out.println("Нет птиц для демонстрации.");
            return;
        }

        for (Bird b : birds) {

            //FIX_ME: нет проверки на null элемента массива
            // System.out.println(b.getName() + " поёт:");
            // b.sing();

            if (b == null) {
                System.out.println("Неизвестная птица (null) — пропуск.");
                continue;
            }

            System.out.println(b.getName() + " поёт:");
            b.sing();
            System.out.println();
        }
    }
}

