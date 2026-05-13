package ru.litovka.basic;

import ru.litovka.main.Check;
import java.util.Scanner;

/**
 * Представляет сотрудника, который имеет имя и принадлежит отделу.
 */
public class Employees {

    /** Имя сотрудника. */
    private final String name;
    /** Отдел, в котором работает сотрудник. */
    private Department department;

    /**
     * Конструктор для создания сотрудника с готовыми данными.
     * ВАЖНО: сотрудник НЕ добавляет себя в отдел — это делает сам отдел.
     *
     * @param name имя сотрудника
     */
    public Employees(String name) {
        this.name = name;
    }

    /**
     * Конструктор для ввода имени сотрудника с клавиатуры.
     * Использует класс Check для валидации.
     */
    public Employees() {
        Scanner scanner = new Scanner(System.in);
        Check validator = new Check();

        String inputName;

        //FIX_ME: дублирование логики проверки имени — лучше вынести в отдельный метод readValidName()
        // while (true) {
        //   System.out.print("Введите имя сотрудника: ");
        //   inputName = scanner.nextLine().trim();
        //
        //   if (!inputName.isEmpty() && validator.checkLetters(inputName)) {
        //     break;
        //   } else {
        //     System.out.println("Ошибка: имя должно содержать только буквы!");
        //   }
        // }
        inputName = readValidName(scanner, validator);

        this.name = inputName;
    }

    //FIX_ME: Добавлена проверка в отдельный метод
    /**
     * Читает корректное имя сотрудника.
     *
     * @param scanner Scanner для ввода
     * @param validator валидатор Check
     * @return корректное имя
     */
    private String readValidName(Scanner scanner, Check validator) {
        while (true) {
            System.out.print("Введите имя сотрудника: ");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && validator.checkLetters(input)) {
                return input;
            }

            System.out.println("Ошибка: имя должно содержать только буквы!");
        }
    }

    /**
     * @return имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * @return отдел, в котором работает сотрудник
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает отдел сотруднику.
     * Используется ТОЛЬКО из Department.addEmployee().
     *
     * @param department отдел
     */
    public void setDepartment(Department department) {
        //FIX_ME: нет проверки на повторное назначение того же отдела
        // this.department = department;
        if (this.department != department) {
            this.department = department;
        }
    }

    /**
     * Возвращает строковое описание сотрудника.
     */
    @Override
    public String toString() {
        if (department == null) {
            return name + " (не состоит ни в одном отделе)";
        }

        Employees dir = department.getDirector();

        if (dir == this) {
            return name + " — начальник отдела " + department.getName();
        }

        String directorName = (dir != null ? dir.getName() : "не назначен");

        return name + " работает в отделе " + department.getName() +
                ", начальник: " + directorName;
    }
}
