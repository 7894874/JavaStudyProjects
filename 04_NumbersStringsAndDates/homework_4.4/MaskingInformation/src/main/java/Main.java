import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Дополнительное задание
 * <p>
 * Цель задания
 * <p>
 * Закрепить использование методов String совместно с ранее пройденными темами.
 * <p>
 * Что нужно сделать
 * Выполните задание в классе Main в методе searchAndReplaceDiamonds проекта
 * 04_NumbersStringsAndDates/homework_4.4/MaskingInformation
 * Пользователь вводит строку, в некоторой части которой содержится конфиденциальная
 * информация. Ваша задача изменить строку и скрыть информацию в < >.
 * Реализуйте метод String searchAndReplaceDiamonds(String text, String placeholder),
 * который будет заменять в переданной строке String text всё содержимое скобок <> (англ. diamonds)
 * и сами скобки на переданную строку в String placeholder.
 * <p>
 * Использование регулярных выражений в данном задании не допускается.
 * <p>
 * Пример работы
 * <p>
 * String safe = searchAndReplaceDiamonds(«Номер кредитной карты <4008 1234 5678> 8912», «***»);
 **/

public class Main {

    // public static final String EMPTY_STRING = "";
    //  public static final String PLACEHOLDER = "***";
    // public static final String PLACEHOLDERPLUS = "+++";

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        boolean itsPinCode = (text.contains("Пин код"));

        if ((text.indexOf("<") != -1) && (text.indexOf(">") != -1)) {
            if (((text.contains("Номер кредитной карты")) && (text.length() <= 43))
                    || (text.contains("Номер паспорта")) || itsPinCode) {

                int firstIndexOfSmb = text.indexOf("<");
                int lastIndOfSmb = text.lastIndexOf(">");

                String resultNomber = text.replaceAll(text.substring(firstIndexOfSmb, lastIndOfSmb + 1), placeholder);

                return resultNomber;

            } else if ((text.contains("Номер кредитной карты")) && (text.length() > 43)) {

                String resultNomber1 = text;

                for (int i = 0; i < 2; i++) {
                    int firstIndexOfSmb = resultNomber1.indexOf("<");
                    if (i == 0) {
                        resultNomber1 = resultNomber1.replaceAll(text.substring(firstIndexOfSmb, firstIndexOfSmb + 6), placeholder);
                    } else {
                        int lastIndOfSmb = resultNomber1.lastIndexOf(">");
                        resultNomber1 = resultNomber1.replaceAll(resultNomber1.substring(lastIndOfSmb - 5, lastIndOfSmb + 1), placeholder);
                    }

                }
                return resultNomber1;
            }
        }

        return text;
    }

}