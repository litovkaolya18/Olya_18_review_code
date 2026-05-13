package ru.litovka.geometry;

/**
 * Точка в трёхмерном пространстве (3D).
 * Наследует двумерную точку Point.
 */
public class Point3D extends Point {
    /** Координата Z. */
    protected double z;

    /** Создаёт точку (0,0,0). */
    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата X
     * @param y координата Y
     * @param z координата Z
     */
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    /**
     * Вычисляет расстояние между двумя 3D‑точками.
     *
     * @param other другая точка
     * @return расстояние
     */
    public double distance(Point3D other) {
        //FIX_ME: нет проверки на null — вызовет ошибку при other == null.
        if (other == null) {
            throw new IllegalArgumentException("Точка other не может быть null");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
