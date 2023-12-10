

/**
 * Дополнительное задание
 * <p>
 * Цель задания
 * Закрепить навыки работы с регулярными выражениями.
 * <p>
 * Что нужно сделать
 * <p>
 * Выполните задание в классе Main 04_NumbersStringsAndDates/homework_4.5/MaskingInformationReqExp
 * <p>
 * Реализовать метод
 * <p>
 * String searchAndReplaceDiamonds(String text, String placeholder),
 * <p>
 * который будет заменять в переданной строке String text всё содержимое скобок <>
 * и сами скобки на переданную строку в String placeholder, используя регулярные выражения.
 * Учтите вариант, когда необходимо заменить несколько замен <> в переданной строке.
 **/

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_MASK2_DOUBLEARROWS = "[<<]";
    private static final String REGEX_MASK2_SPACE = "[ ]";
    private static final String REGEX_MASK3_ARROWLEFTRIGT = "[<>]";

    private static final String REGEX_MATCH_MASK1_PASSPORT1 = ".*паспорта <<.*";
    private static final String REGEX_MATCH_MASK2_CREDITCARD = ".*кредитной карты <.*";

    private static final String REGEX_MATCH_MASK5_REPLACE = "<(.*.)>"; //// <2343>

    public static void main(String[] args) {

    }

    // План действий такой:
    // Определяем для вывода те строки, которые должны выходить целиком как есть
    // Разбиваем с помощью метода split на массив подстрок то, что нужно
    //  Пробегаемся по строкам массива и заменяем то, что нужно и оставляем то, что не будем заменять c помощью регулярки
    //  Конкатенируем строки в конечную строку из массива получившихся подстрок, получаем искомый результат
    // наслаждаемся результатом :-)
    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        ArrayList<String> arrayListAfterProcessing = new ArrayList<>();

        String textAfterReplacementString;

        if (!text.isEmpty()) {

            if (matchesSymbolsFromPatternRx(text, REGEX_MATCH_MASK1_PASSPORT1)) {

                return text;

            }

            if (matchesSymbolsFromPatternRx(text, REGEX_MATCH_MASK2_CREDITCARD) && (text.length() > 43)) {

                String[] splittedText = text.split(REGEX_MASK2_SPACE);
                for (String currentStringPart : splittedText) {

                    String stringAfterProcessing = currentStringPart.replaceAll(REGEX_MATCH_MASK5_REPLACE, placeholder);
                    arrayListAfterProcessing.add(stringAfterProcessing);
                }

                /// Прежде чем получить то, что хотим, нужно конкатенировать строки из массива в одну
                String resultString = concatinateIntoString(arrayListAfterProcessing).trim();

                return resultString;

            } else {

                if (findSymbolsFromPatternRx(text, REGEX_MASK3_ARROWLEFTRIGT)) {

                    textAfterReplacementString = text.replaceAll(REGEX_MATCH_MASK5_REPLACE, placeholder);

                    return textAfterReplacementString;

                }
            }

        } else {

            return "";

        }

        return text;

    }

    public static boolean findSymbolsFromPatternRx(String currentTextInput, String currentMask) {

        boolean symbolesExists = false;

        Pattern pattern = Pattern.compile(currentMask);
        Matcher matcher = pattern.matcher(currentTextInput);

        if (matcher.find()) {

            symbolesExists = true;

        }

        return symbolesExists;

    }

    public static boolean matchesSymbolsFromPatternRx(String currentTextInput, String currentMask) {

        boolean matches = currentTextInput.matches(currentMask);

        return matches;

    }

    private static String concatinateIntoString(ArrayList<String> somestr) {

        ///// Иннициализируем билдер для скорости чтения и записи строк
        StringBuilder stringBuilder = new StringBuilder();

        //// Читаем массив данных
        for (String currentStringPart : somestr) {

            if (!currentStringPart.isEmpty()) {
                stringBuilder.append(currentStringPart + "\u0020");
            }
        }

        return stringBuilder.toString();

    }
}