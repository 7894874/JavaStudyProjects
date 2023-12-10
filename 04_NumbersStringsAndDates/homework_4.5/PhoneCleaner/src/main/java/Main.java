

/**
 * Что нужно сделать
 * <p>
 * Выполните задание в классе Main 04_NumbersStringsAndDates/homework_4.5/PhoneCleaner
 * Реализуйте удаление лишних символов при вводе номера телефона в консоли и проверку
 * соответствия номера формату мобильных номеров России.
 * Если введённую строку нельзя привести к формату
 * мобильного номера — выводите сообщение о неверном вводе.
 * Телефон может быть введён не только в формате 79091234567,
 * но и с лишними символами.
 * <p>
 * Пример ввода номеров и результата вывода программы
 * <p>
 * Ввод пользователя
 * Вывод программы в консоль	Примечание
 * +7 909 123-45-67	79091234567	Символов 11 в номере, код страны 7 — номер верный.
 * +7 (909) 1234567	79091234567	Символов 11 в номере, код страны 7 — номер верный.
 * 8-905-1234567	79051234567	Символов 11 в номере, первый символ 8 (код выхода на мобильный номер) заменяем на код страны 7 — номер верный.
 * 9-453-1234567	Неверный формат номера	Символов 11 в номере, первый символ после очистки 9, это не 7 и не 8 — формат номера неверный.
 * 8-905-123	Неверный формат номера	Символов 7 в номере — номер неверный.
 * 905-1234567	79051234567	Количество символов 10 после очистки — значит, приводим к формату номера с 7.
 * 8-905-12345672342	Неверный формат номера	Символов в номере больше чем 11 — номер неверный.
 **/

import java.util.Scanner;

public class Main {

    public static final String REGEX_MASK_DIGITS = "[0-9]";
    public static final int QTTYOFPHONEDIGITS = 11;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String stringAfterClear = extractAndReplaceDigitsFromString(input);
            Character firstSimbl = stringAfterClear.charAt(0);
            System.out.println(checkAndWriteTFN(stringAfterClear, firstSimbl));

        }
    }

    public static String extractAndReplaceDigitsFromString(String currentStringBeforeExt) {

        String stringAfterClearing = currentStringBeforeExt.replace(" ", "")
                .replace("+", "")
                .replace("-", "")
                .replace("(", "")
                .replace(")", "")
                .replace(REGEX_MASK_DIGITS, "");

        Character firstSimbl = stringAfterClearing.charAt(0);

        if (firstSimbl.equals('8')) {
            stringAfterClearing = stringAfterClearing.replace("8", "7");
        }

        return stringAfterClearing;

    }

    public static String checkAndWriteTFN(String currentStringAfterClearing, Character firsSimbolOfString) {

        if (currentStringAfterClearing.length() == 10) {
            //   System.out.println("Количество символов 10 после очистки — значит, приводим к формату номера с 7");
            currentStringAfterClearing = "7" + currentStringAfterClearing;

        } else {
            //   System.out.println("Количество символов < 10 или больше 11 значит это Неверный формат номера");
            if ((currentStringAfterClearing.length() < 10) || (currentStringAfterClearing.length() > QTTYOFPHONEDIGITS)) {
                currentStringAfterClearing = "Неверный формат номера";
            }

            if (currentStringAfterClearing.length() == QTTYOFPHONEDIGITS) {

                if (!firsSimbolOfString.equals('7') && (!firsSimbolOfString.equals('8'))) {
                    //    * 9-453-1234567	Неверный формат номера	Символов 11 в номере, первый символ после очистки 9, это не 7 и не 8 — формат номера неверный.
                    currentStringAfterClearing = "Неверный формат номера";
                }
            }
        }

        return currentStringAfterClearing;

    }
}
