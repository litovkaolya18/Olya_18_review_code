import java.util.Scanner;
/**
 * Класс Name представляет сущность 'Имя' с фамилией, именем и отчеством
 * Не заданные параметры не учитываются при приведении к текстовому виду
 */
public class Name {

    /** Поля */
    private String lastName;
    private String firstName;
    private String patronymic;

    /**
     * Конструктор по умолчанию
     * для ввода данных с клавиатуры
     */
    public Name() {
        Scanner scanner = new Scanner(System.in);

        //FIX_ME: повторяющийся код проверки — лучше вынести в отдельный метод
//        Check validator = new Check(scanner);
//        while (true) {
//            System.out.print("Введите фамилию: ");
//            this.lastName = scanner.nextLine().trim();
//            if (this.lastName.isEmpty() || validator.checkLetters(this.lastName)) {
//                break;
//            } else {
//                System.out.println("Error: фамилия должна содержать только буквы");
//            }
//        }
//
//        while (true) {
//            System.out.print("Введите имя: ");
//            this.firstName = scanner.nextLine().trim();
//            if (this.firstName.isEmpty() || validator.checkLetters(this.firstName)) {
//                break;
//            } else {
//                System.out.println("Error: имя должна содержать только буквы");
//            }
//        }
//
//        while (true) {
//            System.out.print("Введите отчество: ");
//            this.patronymic = scanner.nextLine().trim();
//            if (this.patronymic.isEmpty() || validator.checkLetters(this.patronymic)) {
//                break;
//            } else {
//                System.out.println("Error: отчество должна содержать только буквы");
//            }
//        }
        this.lastName = validateInput(scanner, "Введите фамилию (можно пропустить): ");
        this.firstName = validateInput(scanner, "Введите имя (можно пропустить): ");
        this.patronymic = validateInput(scanner, "Введите отчество (можно пропустить): ");
    }

    /**
     * Конструктор с параметрами
     *
     * @param lastName фамилия
     * @param firstName имя
     * @param patronymic отчество
     */
    public Name(String lastName, String firstName, String patronymic) {
        //FIX_ME: при null в параметрах поля становились null, а не пустыми строками
        //this.lastName = lastName;
        //this.firstName = firstName;
        //this.patronymic = patronymic;
        this.lastName = (lastName == null ? "" : lastName);
        this.firstName = (firstName == null ? "" : firstName);
        this.patronymic = (patronymic == null ? "" : patronymic);
    }

    /**
     * Валидация ввода: либо пусто, либо только буквы.
     */
    private String validateInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            //FIX_ME: раньше использовался внешний класс Check, завязка на лишнюю зависимость
            //if (this.lastName.isEmpty() || validator.checkLetters(this.lastName)) { ... }
            if (input.isEmpty() || input.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                return input;
            }

            System.out.println("Ошибка: допускаются только буквы или пустая строка.");
        }
    }

    //FIX_ME: в исходном коде не было сеттеров, а в задании сказано «должны присутствовать свойства»
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName == null ? "" : lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName == null ? "" : firstName);
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = (patronymic == null ? "" : patronymic);
    }

    /**
     * Преобразует имя к строковому виду.
     * @return строка в формате 'Фамилия Имя Отчество'
     */
    @Override
    public String toString() {

        //FIX_ME: старая реализация была громоздкой и нарушала Google Style
        // String res = "";
//
//        if (lastName != null && lastName.length() > 0) {
//            res = lastName;
//        }
//
//        if (firstName != null && firstName.length() > 0) {
//            if (res.length() > 0) {
//                res = res + " " + firstName;
//            } else {
//                res = firstName;
//            }
//        }
//
//        if (patronymic != null && patronymic.length() > 0) {
//            if (res.length() > 0) {
//                res= res + " " + patronymic;
//            } else {
//                res = patronymic;
//            }
//        }
//        return res;
//    }
        StringBuilder sb = new StringBuilder();

        if (!lastName.isEmpty()) {
            sb.append(lastName);
        }
        if (!firstName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }
        if (!patronymic.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(patronymic);
        }

        return sb.toString();
    }
//
}
