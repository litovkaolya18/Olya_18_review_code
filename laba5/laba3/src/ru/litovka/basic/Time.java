package ru.litovka.basic;

/**
 * Представляет время, прошедшее с начала суток.
 * Всегда хранит корректное значение от 0 до 86399 секунд.
 */
public class Time {

    /** Количество секунд с начала суток (0–86399). */
    private final int seconds;

    /**
     * Создаёт объект времени из количества секунд.
     * Значение автоматически нормализуется в диапазон суток.
     *
     * @param seconds количество секунд (может быть любым числом)
     */
    public Time(int seconds) {
        this.seconds = normalize(seconds);
    }

    /**
     * Создаёт объект времени из часов, минут и секунд.
     * Значение автоматически нормализуется в диапазон суток.
     *
     * @param hours часы
     * @param minutes минуты
     * @param seconds секунды
     */
    public Time(int hours, int minutes, int seconds) {
        int total = hours * 3600 + minutes * 60 + seconds;
        this.seconds = normalize(total);
    }

    /**
     * Приводит любое число секунд к диапазону 0–86399.
     *
     * @param sec входное значение секунд
     * @return нормализованное значение
     */
    private int normalize(int sec) {
        //FIX_ME: магическое число 24 * 3600 лучше вынести в константу
        //переменная не соответствует стилю Google Stile Java
        // int day = 24 * 3600;
        final int secondsInDay = 24 * 3600;
        sec = sec % secondsInDay;
        if (sec < 0) sec += secondsInDay; // на случай отрицательных значений
        return sec;
    }

    /**
     * @return количество секунд с начала суток.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @return часы (0–23).
     */
    public int getHours() {
        return seconds / 3600;
    }

    /**
     * @return минуты (0–59).
     */
    public int getMinutes() {
        return (seconds % 3600) / 60;
    }

    /**
     * @return секунды (0–59).
     */
    public int getSecondsFromMinute() {
        return seconds % 60;
    }

    /**
     * @return строковое представление времени в формате ЧЧ:ММ:СС.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",
                getHours(), getMinutes(), getSecondsFromMinute());
    }
}
