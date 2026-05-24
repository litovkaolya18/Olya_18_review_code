/**
 * Класс Department представляет сущность отдела.
 * Отдел имеет название, начальника и список сотрудников.
 */
public class Department {
    /** Название отдела */
    private final String name;
    /** Начальник отдела. */
    private Employees  director;
    /** Массив сотрудников. */
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

        /* массив на 100 сотрудников */
        this.employees = new Employees[100];
        this.count = 0;
    }

    public  String getName() {
        return  name;
    }

    public Employees getDirector() {
        return director;
    }

    /**
     * Устанавливает начальника отдела.
     *
     * @param director сотрудник-начальник
     */
    public  void setDirector(Employees director) {

        this.director = director;
    }

    /**
     * Добавляет сотрудника в отдел.
     *
     * @param employee сотрудник для добавления
     */
    public void addEmployee(Employees employee) {
        //FIX_ME: нет проверки на null
        //старый код: employees[count] = employee;
        //
        //новый код:
        if (employee == null) {
            return;
        }

        if (count < employees.length) {
            /* Проверяем, нет ли уже такого сотрудника в отделе */
            for (int i = 0; i < count; i++) {
                if (employees[i] == employee) {
                    /* Сотрудник уже есть */
                    return;
                }
            }
            /* Добавляем сотрудника */
            employees[count] = employee;
            count++;
        }
    }


    /**
     * Возвращает список всех сотрудников отдела в текстовой форме.
     */
    public String getAllEmployeesList() {
        if (count == 0) {
            return "В отделе" + name + " нет сотрудников";
        }

        //FIX_ME: конкатенация строк через '+' в цикле — неэффективно и нарушает стиль
        StringBuilder res = new StringBuilder("Сотрудники отдела " + name + ":\n");

        for (int i = 0; i < count; i++) {
            Employees employee = employees[i];

            if (employee == director) {
                res.append(employee.getName()).append(" (начальник)\n");
            } else {
                res.append(employee.getName()).append("\n");
            }
        }
        return res.toString();
    }

    /**
     * Возвращает количество сотрудников в отделе.
     */
    public int getEmployeeCount() {
        return count;
    }

    /**
     * Возвращает сотрудника по индексу.
     *
     * @param index индекс сотрудника
     * @return сотрудник
     */
    public Employees getEmployee(int index) {
        if (index >= 0 && index < count) {
            return employees[index];
        }
        return null;
    }
}
