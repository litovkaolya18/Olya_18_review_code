import java.util.Scanner;

/**
 * Класс Check — универсальный валидатор ввода.
 * Содержит методы проверки чисел, букв и безопасного чтения данных.
 */
public class Check {
    private Scanner scanner;

    public Check() {
        this.scanner = new Scanner(System.in);
    }

    public Check(Scanner scanner) {
        this.scanner = scanner;
    }
    /**
     * Проверяет, что число является положительным.
     *
     * @param num число для проверки
     * @return положительное число
     */
    public static int getCheckNum(int num) {
        Scanner scanner = new Scanner(System.in);

        while (num < 1) {
            System.out.print("Введите положительное число: ");
            num = scanner.nextInt();
        }
        return num;
    }

    /**
    * Проверяет, что строка содержит только буквы (включая английские)
     * @param input строка для проверки
     * @return true если строка содержит только буквы или пустая, иначе false
     */
    public boolean checkLetters(String input) {
        if (input == null) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                    (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') ||
                    c == 'ё' || c == 'Ё' || c == ' ' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, что строка содержит только цифры
     * @param input строка для проверки
     * @return true если строка содержит только цифры, иначе false
     */
    public boolean checkNum(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод для ввода чисел и проверки цифр
     * @param val сообщение для пользователя
     * @return проверенное число
     */
    public int getNumInput(String val) {
        while (true) {
            System.out.print(val);
            String input = scanner.nextLine().trim();
            if (checkNum(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Ошибка: введите только цифры!");
            }
        }
    }


    /**
     * Универсальный метод для ввода букв с сообщением.

     * @param prompt сообщение для пользователя
     * @param allowEmpty разрешить пустые значения
     * @return проверенная строка
     */
    public String getLettersInput(String prompt, boolean allowEmpty) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if ((allowEmpty && input.isEmpty()) || checkLetters(input)) {
                return input;
            } else {
                System.out.println("Ошибка: должно содержать только буквы!");
            }
        }
    }
}

