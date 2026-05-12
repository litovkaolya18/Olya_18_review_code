package ru.litovka.birds;

/**
 * Базовый класс для всех птиц.
 * Каждая птица имеет название и реализует собственный способ пения.
 */
public abstract class Bird {

    /** Название вида птицы. */
    protected String name; // название вида

    /**
     * Создаёт птицу с указанным названием.
     *
     * @param name название вида
     */
    public Bird(String name) {
        //FIX_ME: нет проверки на пустое имя — можно создать птицу без названия.
        //this.name = name;
        this.name = (name == null || name.isBlank()) ? "Неизвестная птица" : name;
    }

    /**
     * @return название вида птицы
     */
    public String getName() {
        return name;
    }

    /** Метод пения — каждая птица реализует по-своему */
    public abstract void sing();

    /**
     * @return строковое описание птицы
     */
    @Override
    public String toString() {
        return String.format("Птица: %s", name);
    }
}
