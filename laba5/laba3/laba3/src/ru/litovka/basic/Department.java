package ru.litovka.basic;

/**
 * Представляет отдел, содержащий сотрудников и директора.
 * Гарантируется, что директор всегда работает в своём отделе.
 */
public class Department {

    //FIX_ME: 100 — лучше вынести в константу т.к не понятно откуда оно берётся
    //это нужно для понимания максимального числа сотрудников
    /** Максимальное количество сотрудников в отделе. */
    private static final int MAX_EMPLOYEES = 100;

    /** Название отдела. */
    private final String name;

    /** Директор отдела (всегда входит в список сотрудников). */
    private Employees director;

    /** Массив сотрудников отдела. */
    private final Employees[] employees;

    /** Текущее количество сотрудников. */
    private int count;

    /**
     * Конструктор для создания отдела.
     *
     * @param name название отдела
     */
    public Department(String name) {
        this.name = name;

        //FIX_ME: 100 — лучше вынести в константу
        // this.employees = new Employees[100];
        this.employees = new Employees[MAX_EMPLOYEES];
        this.count = 0;
    }

    /**
     * @return название отдела
     */
    public String getName() {
        return name;
    }

    /**
     * @return директор отдела
     */
    public Employees getDirector() {
        return director;
    }

    /**
     * Устанавливает директора отдела.
     * Если директор отсутствует в списке сотрудников — добавляет его.
     *
     * @param director сотрудник, назначаемый директором
     */
    public void setDirector(Employees director) {
        if (director == null) return;

        // Проверяем, есть ли директор среди сотрудников
        //FIX_ME: ручной поиск директора в массиве — дублирование логики.
        // boolean exists = false;
        // for (int i = 0; i < count; i++) {
        //   if (employees[i] == director) {
        //     exists = true;
        //     break;
        //   }
        // }
        boolean exists = containsEmployee(director);

        // Если директора нет в списке — добавляем
        if (!exists) {
            addEmployee(director);
        }

        this.director = director;
    }

    //FIX_ME: Добавлена проверка в отдельный метод
    /**
     * Проверяет, есть ли сотрудник в отделе.
     *
     * @param employee сотрудник
     * @return true, если сотрудник уже есть в массиве
     */
    private boolean containsEmployee(Employees employee) {
        for (int i = 0; i < count; i++) {
            if (employees[i] == employee) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет сотрудника в отдел.
     * Если сотрудник уже есть — ничего не делает.
     * При добавлении сотруднику автоматически назначается department.
     *
     * @param employee сотрудник
     */
    public void addEmployee(Employees employee) {
        if (employee == null) return;

        // Проверяем, есть ли уже такой сотрудник
        //FIX_ME: повторная логика проверки наличия сотрудника.
        //старый код:
        // for (int i = 0; i < count; i++) {
        //   if (employees[i] == employee) {
        //     return;
        //   }
        // }
        if (containsEmployee(employee)) {
            return;
        }

        // Добавляем сотрудника
        if (count < employees.length) {
            employees[count] = employee;
            count++;

            //Синхронизация: сотрудник теперь работает в этом отделе
            employee.setDepartment(this);
        }
    }

    /**
     * Возвращает список всех сотрудников отдела в текстовом виде.
     *
     * @return строка со списком сотрудников
     */
    public String getAllEmployeesList() {
        if (count == 0) {
            return "В отделе " + name + " нет сотрудников";
        }

        StringBuilder sb = new StringBuilder("Сотрудники отдела " + name + ":\n");
        for (int i = 0; i < count; i++) {
            Employees employee = employees[i];
            if (employee == director) {
                sb.append(employee.getName()).append(" (начальник)\n");
            } else {
                sb.append(employee.getName()).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * @return количество сотрудников в отделе
     */
    public int getEmployeeCount() {
        return count;
    }

    /**
     * Возвращает сотрудника по индексу.
     *
     * @param index индекс сотрудника
     * @return сотрудник или null, если индекс некорректен
     */
    public Employees getEmployee(int index) {
        if (index >= 0 && index < count) {
            return employees[index];
        }
        return null;
    }
}
