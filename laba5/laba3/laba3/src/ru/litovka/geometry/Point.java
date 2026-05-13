package ru.litovka.geometry;

/**
 * Двумерная точка с координатами X и Y.
 */
public class Point {
    /** Координата X. */
    protected double x;
    /** Координата Y. */
    protected double y;

    /** Создаёт точку в начале координат. */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    /**
     * Вычисляет расстояние между двумя точками.
     *
     * @param other другая точка
     * @return расстояние
     */
    public double distance(Point other) {
        //FIX_ME: нет проверки на null — вызовет ошибку при other == null.
        if (other == null) {
            throw new IllegalArgumentException("Точка other не может быть null");
        }

        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** Переопределение equals: точки равны, если равны их координаты */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;          // одна и та же ссылка
        if (obj == null) return false;         // null не равен
        if (getClass() != obj.getClass()) return false; // разные классы

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }


    /**
     * Хеш‑код точки.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

    /**
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
