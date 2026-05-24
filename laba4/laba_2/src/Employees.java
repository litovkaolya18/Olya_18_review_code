import java.util.Scanner;

/**
 * Класс Employee представляет сущность сотрудника.
 * Сотрудник описывается именем и отделом, в котором работает
 */
public class Employees {
    /**  Имя сотрудника */
    private final String name;
    /** Отдел, в котором работает */
    private Department department;

    /**
     * Конструктор для создания сотрудника с готовыми данными
     *
     * @param name имя сотрудника
     * @param department отдел сотрудника
     */
    public Employees(String name, Department department) {
        this.name = name;

        this.department = department;
        // автоматически добавляем сотрудника в отдел

        //FIX_ME: отдел может быть nul
        if (department != null) {
            department.addEmployee(this);
        }
    }

    /**
     * Конструктор для ввода имени сотрудника с клавиатуры.
     *
     * @param department отдел сотрудника
     */
    public Employees(Department department) {
        Scanner scanner = new Scanner(System.in);
        Check validator = new Check();

        while (true) {
            System.out.print("Введите имя сотрудника: ");
            String inputName = scanner.nextLine().trim();

            if (inputName.isEmpty() || validator.checkLetters(inputName)) {
                this.name = inputName;
                break;
            } else {
                System.out.println("Error: имя должно содержать только буквы!");
            }
        }
        this.department = department;
        //
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    /**
     * Возвращает список всех сотрудников отдела.
     */
    public String getDepartmentEmployees() {
        return department.getAllEmployeesList();
    }

    /**
     * Преобразует сотрудника к текстовой форме.
     */
    @Override
    public String toString() {
        //FIX_ME: возможен NPE, если директор не назначен
        if (department.getDirector() == this) {
            return name + " начальник отдела " + department.getName();
        }

        Employees dir = department.getDirector();
        String directorName = (dir == null ? "не назначен" : dir.getName());

        return name + " работает в отделе " + department.getName()
                + ", начальник которого " + directorName;
    }
}
