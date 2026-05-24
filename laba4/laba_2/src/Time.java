import java.util.Scanner;

/**
 * Класс Time представляет сущность 'Время' в 24-часовом формате.
 * Время описывается числом секунд, прошедшим с начала суток.
 * Поддерживает создание из секунд и из часов/минут/секунд.
 * Предоставляет методы для получения часов, минут и секунд.
 */
public class Time {

    /**
     * Свойства: количество секунд с начала.
     */
    private final int seconds;

    /**
     * Конструктор для ввода данных с клавиатуры.
     * Для 1 задания
     */
    public Time() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество секунд: ");

        //FIX_ME: отсутствовала проверка на нечисловой ввод
        //this.seconds = scanner.nextInt();
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите число секунд: ");
            scanner.next();
        }
        this.seconds = scanner.nextInt();
    }

    /**
     * Конструктор для создания времени из секунд.
     * Для 1 и 2 задания
     *
     * @param seconds количество секунд с начала суток
     */
    public Time(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Конструктор для создания времени из часов, минут и секунд.
     * Для 2 задания
     *
     * @param hours часы
     * @param minutes минуты
     * @param seconds секунды
     */
    public Time(int hours, int minutes, int seconds) {
        this.seconds = hours * 3600 + minutes * 60 + seconds;
    }

    /**
     * Возвращает общее количество секунд.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Возвращает текущий час (0-23)
     */
    public int getHours() {

        //FIX_ME: раньше часы считались напрямую → неверно при >24 часов
        //старый код:
        //return seconds / 3600;
        //
        //новый код:
        int sec = seconds % (24 * 3600);
        if (sec < 0) {
            sec += 24 * 3600;
        }
        return sec / 3600;
    }

    /**
     * Возвращает минуты с начала текущего часа (0-59)
     */
    public int getMinutes() {
        int sec = seconds % (24 * 3600);
        if (sec < 0) {
            sec += 24 * 3600;
        }
        return (sec % 3600) / 60;
    }

    /**
     * Возвращает секунды с начала текущей минуты (0-59)
     */
    public int getSecondsFromMinute() {
        int sec = seconds % (24 * 3600);
        if (sec < 0) {
            sec += 24 * 3600;
        }
        return sec % 60;
    }

    /**
     * Преобразует время в текстовую форму формата "ЧЧ:ММ:СС".
     * Если время превышает 24 часа, отображается время с начала последних суток.
     *
     * @return строковое представление времени
     */
    @Override
    public String toString() {

        //FIX_ME: ручная сборка строки нарушала Google Style
//        int hours = getHours();
//        int minutes = getMinutes();
//        int seconds = getSecondsFromMinute();
//
//       String res = hours + ":";
//
//       if (minutes < 10) {
//           res = res + "0" + minutes + ":";
//       } else {
//           res = res + minutes + ":";
//       }
//
//       if (seconds < 10) {
//           res = res + "0" + seconds;
//       } else {
//           res = res + seconds;
//       }
//        return res;
        return String.format(
                "%d:%02d:%02d",
                getHours(),
                getMinutes(),
                getSecondsFromMinute()
        );
    }
}
