package ru.litovka.main;

import ru.litovka.basic.Department;
import ru.litovka.basic.Employees;
import ru.litovka.basic.Node;
import ru.litovka.basic.Time;
import ru.litovka.geometry.Point3D;
import ru.litovka.birds.Bird;
import ru.litovka.birds.Cuckoo;
import ru.litovka.birds.Parrot;
import ru.litovka.birds.Sparrow;
import ru.litovka.birds.BirdMarket;
import ru.litovka.geometry.Point;

import java.util.Scanner;
import java.lang.*;

/**
 * Главный класс ru.litovka.main.Main - лабораторная номер 2
 */
public class Main {
    public static void main(String[] args) {
        //FIX_ME: Scanner создаётся внутри цикла — это утечка ресурсов.
        // while (true) {
        //   Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Check validator = new Check(); //для проверок
        int number;

        while (true) {
            System.out.print("\n" + "Здравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Время от начала суток\n" +
                    "2 - Начальник отдела\n" +
                    "3 - Бинарное дерево\n" +
                    "4 - Трехмерная точка\n" +
                    "5 - Птицы\n" +
                    "6 - Птичий рынок\n" +
                    "7 - Сравнение точек\n" +
                    "0 - Выход\n"
            );

            number = validator.getNumInput("Введите номер задания: ");

            switch (number) {
                case 1: {
                    System.out.println("\nПримеры из условия задачи");

                    // Примеры корректной работы нормализации
                    Time t1 = new Time(90000);          // 90000 сек → 01:00:00
                    Time t2 = new Time(25, 10, 5);      // 25 часов → 01:10:05
                    Time t3 = new Time(-10);            // отрицательное → 23:59:50
                    Time t4 = new Time(0, 0, 3661);     // 3661 сек → 01:01:01

                    System.out.println("1. " + t1);
                    System.out.println("2. " + t2);
                    System.out.println("3. " + t3);
                    System.out.println("4. " + t4 + "\n");

                    int count = validator.getNumInput("Сколько объектов ru.litovka.basic.Time вы хотите создать: ");

                    //FIX_ME: вызов статического метода, который мы сделали нестатическим
                    //count = Check.getCheckNum(count);
                    count = validator.getCheckNum(count);

                    String allTimes = "";
                    for (int i = 0; i < count; i++) {
                        System.out.println("\nСоздание " + (i + 1) + " времени");

                        System.out.println("Выберите способ создания:");
                        System.out.println("1 — Ввести количество секунд");
                        System.out.println("2 — Ввести часы, минуты и секунды");

                        int type = validator.getNumInput("Ваш выбор: ");

                        Time userTime;

                        if (type == 1) {
                            int sec = validator.getNumInput("Введите количество секунд: ");
                            userTime = new Time(sec);
                        } else {
                            int h = validator.getNumInput("Введите часы: ");
                            int m = validator.getNumInput("Введите минуты: ");
                            int s = validator.getNumInput("Введите секунды: ");
                            userTime = new Time(h, m, s);
                        }

                        allTimes += (i + 1) + ". " + userTime.toString() + "\n";
                    }

                    System.out.println("\nСозданные объекты:");
                    System.out.print(allTimes);
                    break;
                }

                case 2: {
                    System.out.println("\nЗадание: Начальник отдела");

                    System.out.print("Введите название отдела: ");
                    String depName = scanner.nextLine().trim();

                    Department dep = new Department(depName);

                    int empCount = validator.getNumInput("Сколько сотрудников создать: ");

                    //FIX_ME: вызов статического метода, который мы сделали нестатическим
                    //empCount = Check.getCheckNum(empCount);
                    empCount = validator.getCheckNum(empCount);

                    Employees[] created = new Employees[empCount];

                    for (int i = 0; i < empCount; i++) {
                        System.out.println("\nСоздание сотрудника №" + (i + 1));
                        Employees emp = new Employees(); // ввод имени
                        dep.addEmployee(emp);
                        created[i] = emp;
                    }

                    System.out.println("\nВыберите директора отдела:");
                    for (int i = 0; i < empCount; i++) {
                        System.out.println((i + 1) + " — " + created[i].getName());
                    }

                    int dirIndex = validator.getNumInput("Введите номер директора: ") - 1;
                    dirIndex = Math.max(0, Math.min(dirIndex, empCount - 1));

                    dep.setDirector(created[dirIndex]);

                    System.out.println("\nРезультат:");
                    System.out.println(dep.getAllEmployeesList());
                    break;
                }

                case 3: {
                    System.out.println("\nЗадание 3: Бинарное дерево");

                    Node root = new Node();
                    int[] values = {3, 5, 4, 7, 1, 2};

                    for (int v : values) {
                        root.add(v);
                    }

                    System.out.println("Левосторонний обход дерева:");
                    System.out.println(root);

                    break;
                }


                case 4: {
                    System.out.println("\nЗадание: Трехмерная точка (ru.litovka.geometry.Point3D)");

                    System.out.println("\nСоздание точки A:");
                    double ax = validator.getDoubleInput("Введите X: ");
                    double ay = validator.getDoubleInput("Введите Y: ");
                    double az = validator.getDoubleInput("Введите Z: ");
                    Point3D a = new Point3D(ax, ay, az);

                    System.out.println("\nСоздание точки B:");
                    double bx = validator.getDoubleInput("Введите X: ");
                    double by = validator.getDoubleInput("Введите Y: ");
                    double bz = validator.getDoubleInput("Введите Z: ");
                    Point3D b = new Point3D(bx, by, bz);

                    System.out.println("\nТочка A: " + a);
                    System.out.println("Точка B: " + b);

                    double dist = a.distance(b);
                    System.out.println("Расстояние между A и B = " + dist);

                    break;
                }

                case 5: {
                    System.out.println("\nЗадание: Птицы");

                    Bird[] birds = new Bird[3];
                    birds[0] = new Sparrow();
                    birds[1] = new Cuckoo();
                    birds[2] = new Parrot("Привет, я умный попугай!");

                    System.out.println("\nДемонстрация пения птиц:\n");

                    for (Bird b : birds) {
                        System.out.println(b.getName() + " поёт:");
                        b.sing();
                        System.out.println();
                    }

                    break;
                }

                case 6: {
                    System.out.println("\nЗадание: Птичий рынок");

                    // создаём набор птиц
                    Bird[] birds = new Bird[] {
                            new Sparrow(),
                            new Sparrow(),
                            new Cuckoo(),
                            new Cuckoo(),
                            new Parrot("Попугай Кеша любит семечки"),
                            new Parrot("Я повторяю всё, что слышу!")
                    };

                    System.out.println("\nПтицы на рынке поют:\n");

                    // вызываем метод, который поёт все птицы
                    BirdMarket.makeAllBirdsSing(birds);

                    break;
                }
                case 7: {
                    System.out.println("\nЗадание: Сравнение точек (num3.Point)");

                    System.out.println("\nСоздание точки A:");
                    double ax = validator.getDoubleInput("Введите X: ");
                    double ay = validator.getDoubleInput("Введите Y: ");
                    Point a = new Point(ax, ay);

                    System.out.println("\nСоздание точки B:");
                    double bx = validator.getDoubleInput("Введите X: ");
                    double by = validator.getDoubleInput("Введите Y: ");
                    Point b = new Point(bx, by);

                    System.out.println("\nТочка A: " + a);
                    System.out.println("Точка B: " + b);

                    if (a.equals(b)) {
                        System.out.println("Результат: точки равны (имеют одинаковые координаты).");
                    } else {
                        System.out.println("Результат: точки НЕ равны.");
                    }

                    break;
                }

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Ошибка: такого задания нет.");
            }
        }
    }
}
