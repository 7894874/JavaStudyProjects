


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//         String text = getText("InputText.txt", " ");
//         String text = readUsingBufferedReader("H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\04_NumbersStringsAndDates\\homework_4.5\\SplitText\\src\\test\\resources\\InputText.txt");
//         splitTextIntoWords(text);

    }

    public static String splitTextIntoWords(String text) {

        if (!text.isEmpty()) {

            ///// Засовываем в массив строк и сплитом строки дописываем использую Regular Expressions (regex)
            String[] splatTexArray = text.split("[ -]");
            System.out.println(Arrays.toString(splatTexArray)); //// -- для проверки

            return readUsingBstingBuilder(splatTexArray);

        } else {

            return "";

        }
    }

    private static String readUsingBstingBuilder(String[] somestr) {

        ///// Иннициализируем билдер для скорости чтения и записи строк
        StringBuilder stringBuilder = new StringBuilder();

        //// Читаем массив данных
        for (int i = 0; i < somestr.length; i++) {

            String currentEarning = somestr[i];

            if (!currentEarning.isEmpty()) {
                //// Отсекаем все лишнее сонгласно заданию и требованям тестов
                ///  используем регламент разработки для красоты кода
                String currentClearedStr = currentEarning.replace(".", "")
                        .replace(";", "")
                        .replace(",", "")
                        .replaceAll("[0-9]", "");
                if (!currentClearedStr.isEmpty()) {
                    stringBuilder.append(currentClearedStr + "\n");
                }
            }
        }

        //// Убираем последнюю строку и наслаждаемся результатом :-)
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();

    }
}

