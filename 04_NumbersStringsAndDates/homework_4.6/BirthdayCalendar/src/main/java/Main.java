/**
 *
 * Цель заданий
 *
 * Научиться работать с датой, используя класс Calendar.
 *
 * Что нужно сделать
 *
 * Выполните задание в классе Main 04_NumbersStringsAndDates/homework_4.6/BirthdayCalendar
 * Реализуйте метод
 *
 *  String collectBirthdays(int year, int month, int day),
 *  который вернёт строки, содержащие все прошедшие дни вашего рождения от нуля лет до текущей даты в требуемом формате.
 *
 * Дата рождения передаётся в метод тремя числами.
 *
 *
 *
 * Формат требуемого вывода:
 *
 *     0 - 31.12.1990 - Mon
 *
 *     1 - 31.12.1991 - Tue
 *
 *     …
 *
 * Рекомендация:
 *
  * Для переноса текста на новую строку используйте символ переноса строки, который вызывается методом  System.lineSeparator()
 *
 * String text = "Первая строка" + System.lineSeparator() + "Вторая строка";
 * System.out.println(text);
 * Вывод:
 *
 * Первая строка
 * Вторая строка
 *
 * Особенность метода - использует системный перенос строки, то есть тот который используется у вас в операционной системе по умолчанию
 *
 * для Windows это \r\n
 * для macOS\Linux это \n
 *
 *
 * Дополнительный материал:
 *
 * Документация класса Calendar JDK11
 * Документация класса SimpleDateFormat JDK7
 * Пример работы с Calendar
 * Пример использования Locale, для выбора формата вывода даты
 *
 *
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int day = 15;
        int month = 4;
        int year = 1979;

       System.out.println(collectBirthdays(year, month, day));

    }

    /**
     *
     * @param year int
     * @param month int
     * @param day int
     *
     * @return String Some string with Linear separators
     *
     *
     * target
     *
     *   TODO реализуйте метод для построения строки в следующем виде
     *   0 - 31.12.1990 - Mon
     *   1 - 31.12.1991 - Tue
     *
     */
    public static String collectBirthdays(int year, int month, int day) {

        ///// Создаем массив для корректной контроллируемой конкатенации строк
        ArrayList<String> arrayListAfterProcessing = new ArrayList<>();

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 12);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy - EE", Locale.ENGLISH);

        Integer StrNumber = 0;

        Calendar todayDate = Calendar.getInstance();

//        Calendar futureDate = Calendar.getInstance();
//        futureDate.add(Calendar.MONTH, 2);// прибавляем нужные нам количество месяцев к дате

        //// Если нужно выводить данные и сравнивать с будущей датой
        //// тогда просто ставим вместо todayDate futureDate
        while(calendar.before(todayDate)) {

            String currentBirthdayDate = StrNumber+" - "+formatter.format(calendar.getTime());
            arrayListAfterProcessing.add(currentBirthdayDate);

            calendar.add(Calendar.YEAR, 1);
            StrNumber++;
        }

        String resultString = concatinateIntoString(arrayListAfterProcessing);

        return resultString;
    }

    private static String concatinateIntoString(ArrayList<String> arrayListAfterProcessing) {

        ///// Иннициализируем билдер для скорости чтения и записи строк
        StringBuilder stringBuilder = new StringBuilder();

        //// Читаем переданный массив данных
        for (String currentStringPart : arrayListAfterProcessing) {

            if (!currentStringPart.isEmpty()) {
                stringBuilder.append(currentStringPart + System.lineSeparator());
            }
        }

        return stringBuilder.toString();

    }
}


