/**
 * Задание №3
 * Что нужно сделать
 * * Выполните задание в классе Main проекта 04_NumbersStringsAndDates/homework_4.4/FullNameFormatter
 * Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
 * (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
 * <p>
 * Фамилия: Иванов
 * <p>
 * Имя: Сергей
 * <p>
 * Отчество: Петрович
 * <p>
 * * Валидная строка от пользователя, которую мы можем интерпретировать как Ф. И. О.,
 * должна содержать три слова, состоящих из символов кириллицы, разделённых пробелом,
 * может содержать дефис. Если строка не соответствует формату, то вывести в консоль:
 * Введенная строка не является ФИО
 * <p>
 * Использование регулярных выражений в данном задании не допускается.
 * <p>
 * Строго соблюдайте формат вывода результата.
 */

import java.util.Scanner;

public class Main {

    //// intprivate static Integer hardSpacesQtt = 0;
  //  private static boolean theDigitExistsInString;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            int hardSpacesQtt = 0;
            boolean theDigitExistsInString = false;

            ///// Перебираем символы строки и определяем нужные нам значения
            for (int i = 0; i < input.length(); i++) {

                char currentSymbol = input.charAt(i);
                 if (Character.toString(currentSymbol).equals(" ")) {
                    hardSpacesQtt++;
                }
                 /// Проверяем на наличие числовых значений в строке
                //// Читаем значение символов через метод charAt попутно получаем значение из char
                //// используем метод isDigit для определения числового символа в строке
                boolean isDigit = Character.isDigit(currentSymbol);
                if (isDigit) {
                    theDigitExistsInString = true;
                }
            }

            if ((hardSpacesQtt != 2) || (theDigitExistsInString)) {
                System.out.println("Введенная строка не является ФИО");
            } else {
                System.out.println(writeFIO(input));
            }
        }
    }

    public static String writeFIO(String currentStringFIO) {

        String sirName = currentStringFIO.substring(0, currentStringFIO.indexOf(" "));
        String firstName = currentStringFIO.substring(sirName.length() + 1, currentStringFIO.lastIndexOf(" "));


        int indexOfNames = sirName.length() + firstName.length() + 2;
        String secondName = currentStringFIO.substring(indexOfNames);

        return "Фамилия: " + sirName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + secondName + "\n";

    }
}
