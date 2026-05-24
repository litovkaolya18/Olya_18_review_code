import java.util.Scanner;
import java.lang.*;
import java.text.DecimalFormat;
/**
 * Главный класс Main - лабораторная номер 2
 */
public class Main {
    public static void main(String[] args) {
        int number;
        Check validator = new Check(); //для проверок

        while (true) {
            System.out.print("\n" + "Здравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Создание ФИО\n" +
                    "2 - Создание Времени\n" +
                    "3 - Создание Сотрудников и их отделов\n");
            Scanner scanner = new Scanner(System.in);
            number = validator.getNumInput("Введите номер задания: ");

            switch (number) {
                case 1: {
                    System.out.println("\nПримеры из условия задачи");

                    Name num1 = new Name(null, "Клеопатра", null);
                    Name num2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name num3 = new Name("Маяковский", "Владимир", null);

                    //FIX_ME: лишний вызов toString()
                    //System.out.println("1. " + num1.toString());
                    System.out.println("1. " + num1);
                    System.out.println("2. " + num2);
                    System.out.println("3. " + num3 + "\n");

                    //FIX_ME: двойная проверка числа
                    //int count = validator.getNumInput(...);
                    //count = Check.getCheckNum(count);
                    int count = validator.getNumInput("Введите число сколько ФИО вы хотите создать: ");

                    //FIX_ME: конкатенация строк в цикле
                    //старый код: String allNames = "";
                    StringBuilder allNames = new StringBuilder();

                    for (int i = 0 ; i < count; i++) {
                        System.out.print("Создание " + (i+1) + " ФИО\n");
                        Name user = new Name();

                        //FIX_ME: += в цикле
                        //allNames += ...
                        allNames.append(i + 1).append(". ").append(user).append("\n");
                    }
                    System.out.print("Создано: \n");
                    System.out.print(allNames.toString());

                    break;
                }
                case 2: {
                    System.out.println("\nПримеры из условия задачи");
                    System.out.println("\nПримеры из 1-го задания:");

                    Time time1 = new Time(10);
                    Time time2 = new Time(10000);
                    Time time3 = new Time(100000);
                    Time time4 = new Time(91800);

                    //FIX_ME: лишний вызов toString()
                    //System.out.println("10 секунд: " + time1.toString());
                    System.out.println("10 секунд: " + time1);
                    System.out.println("10000 секунд: " + time2);
                    System.out.println("100000 секунд: " + time3);
                    System.out.println("91800 секунд: " + time4);

                    //для задания 5 (4.4)
                    System.out.println("\nПримеры из 2-го задания:");
                    Time time5 = new Time(2,3,5);

                    System.out.println("2 часа, 3 минуты, 5 секунд: " + time5);

                    //для задания 6 (5.4)
                    System.out.println("\nПримеры из 3-го задания:");
                    Time time6 = new Time(34056);
                    Time time7 = new Time(4532);
                    Time time8 = new Time(123);

                    //1. Какой сейчас час?
                    System.out.print("1. Время 34056 секунд:\n");
                    System.out.print("Часов: " + time6.getHours() + "\n");
                    System.out.print("Полное время: " + time6.toString() + "\n");

                    //2. Сколько минут прошло с начало текущего часа?
                    System.out.print("2. Время 4532 секунд:\n");
                    System.out.print("Минут с начала часа: " + time7.getMinutes() + "\n");
                    System.out.print("Полное время: " + time7.toString() + "\n");

                    //3. Сколько секунд прошло с начало текущей минуты?
                    System.out.print("2. Время 123 секунд:\n");
                    System.out.print("Секунды с начала минут: " + time8.getSecondsFromMinute() + "\n");
                    System.out.print("Полное время: " + time8.toString() + "\n");


                    System.out.println("\nСпособы создания времени:");
                    System.out.println("1 - из секунд");
                    System.out.println("2 - из часов, минут, секунд");
                    System.out.print("3 - Получение компонентов времени\n");

                    int choice = validator.getNumInput("Выберете цифру: ");

                    if (choice == 1) {
                        int user = validator.getNumInput("Введите количество секунд: ");

                        //FIX_ME: двойная проверка числа — дублирование
                        //FIX_ME: лишний вызов toString()
                        //user = Check.getCheckNum(user);
                        Time userTime1 = new Time(user);
                        System.out.print(userTime1);

                    } else if (choice == 2) {
                        int hours = validator.getNumInput("Введите часы: ");
                        int minutes = validator.getNumInput("Введите минуты: ");
                        int seconds = validator.getNumInput("Введите секунды: ");

                        Time userTime2 = new Time(hours, minutes, seconds);
                        System.out.println(userTime2);

                    } else if (choice == 3) {
                        int totalSeconds = validator.getNumInput("Введите общее количество секунд: ");
                        Time userTime3 = new Time(totalSeconds);

                        System.out.println("Компоненты времени " + totalSeconds + " секунд:");
                        System.out.println("Часов: " + userTime3.getHours());
                        System.out.println("Минут с начала часа: " + userTime3.getMinutes());
                        System.out.println("Секунд с начала минуты: " + userTime3.getSecondsFromMinute());

                        System.out.println("Полное время: " + userTime3);

                    } else {
                        System.out.println("Неверный выбор!");
                    }
                    break;

                }
                case 3: {
                    System.out.println("\nПримеры из условия задачи");

                    Department department = new Department("IT");
                    Employees employees1 = new Employees("Петров", department);
                    Employees employees2 = new Employees("Козлов", department);
                    Employees employees3 = new Employees("Сидоров", department);

                    System.out.print(department.getAllEmployeesList());
                    /* Назначаем начальника */
                    department.setDirector(employees2);

                    //FIX_ME: лишний вызов toString()
                    //System.out.print(employees1.toString() + "\n");
                    System.out.println(employees1);
                    System.out.println(employees2);
                    System.out.println(employees3);

                    System.out.print("\nИмея ссылку на сотрудника, можем узнать список всех сотрудников " +
                            "отдела\n");
                    System.out.print(employees1.getDepartmentEmployees());

                    /* Ввод названия отдела с проверкой */
                    String departmentName = validator.getLettersInput("\nВведите своё название отдела: ", true);
                    Department userDep = new Department(departmentName);

                    /* Ввод количества сотрудников */
                    int count = validator.getNumInput("\nСколько сотрудников вы хотите создать: ");

                    //FIX_ME: двойная проверка числа — дублирование логики
                    //count = Check.getCheckNum(count);

                    /* создание сотрудников */
                    Employees[] userEmployees = new Employees[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Сотрудник " + (i + 1) + ": ");
                        userEmployees[i] = new Employees(userDep);
                    }

                    /* создание начальника */
                    if (count > 0) {
                        int indexDep = validator.getNumInput("Введите номер начальника от 1 до " + count + ": ");

                        //FIX_ME: смешивание scanner.nextInt() и строкового ввода ломает ввод
                        while (indexDep < 1 || indexDep > count) {
                            //System.out.print("Неверно. Введите номер от 1 до " + count + ": ");
                            //indexDep = scanner.nextInt();
                            indexDep = validator.getNumInput(
                                    "Неверно. Введите номер от 1 до " + count + ": ");
                        }
                        userDep.setDirector(userEmployees[indexDep - 1]);
                    }

                    /* Вывод полного списка сотрудников */
                    System.out.println("\nПолный список сотрудников: ");
                    for (int i = 0; i < count; i++) {
                        //FIX_ME: лишний вызов toString()
                        //System.out.println(userEmployees[i].toString());
                        System.out.println(userEmployees[i]);
                    }

                    /* Просмотр списка отдела через конкретного сотрудника */
                    if (count > 0) {
                        int viewIndex = validator.getNumInput("Введите номер сотрудника, чтобы узнать список его отдела: ");

                        //FIX_ME: снова scanner.nextInt() вместо валидатора
                        while (viewIndex < 1 || viewIndex > count) {
                            //System.out.print("Неверно. Введите номер от 1 до " + count + ": ");
                            //viewIndex = scanner.nextInt();
                            viewIndex = validator.getNumInput(
                                    "Неверно. Введите номер от 1 до " + count + ": ");
                        }
                        System.out.println("\nСписок сотрудников отдела через " + userEmployees[viewIndex - 1].getName() + ":");
                        System.out.println(userEmployees[viewIndex - 1].getDepartmentEmployees());
                    }
                    break;
                }
                default:
                    System.out.print("Такого номера в списке нет\n");
                    break;
            }
        }
    }
}