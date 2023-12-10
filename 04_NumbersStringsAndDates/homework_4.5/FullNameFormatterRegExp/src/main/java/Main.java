import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEXRULLES_ONLYDUGITS = "[0-9]";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String[] stringsArray = input.split(" ");

            if (!operationIsPermitted(stringsArray).isEmpty()) {
                System.out.println("Введенная строка не является ФИО");
                return;
            } else {
                System.out.println(writeFIO(stringsArray));
            }
        }
    }

    public static String writeFIO(String[] currentStringsArray) {

        String sirName = currentStringsArray[0];
        String firstName = currentStringsArray[1];
        String secondName = currentStringsArray[2];

        Properties fio = new Properties();

        fio.put("Фамилия", sirName);
        fio.put("Имя", firstName);
        fio.put("Отчество", secondName);

        return "Фамилия: " + fio.getProperty("Фамилия", "Фамилия не указана!") + "\n" +
                "Имя: " + fio.getProperty("Имя", "Имя не указано!") + "\n" +
                "Отчество: " + secondName + "\n";

    }

    public static ArrayList<String> operationIsPermitted(String[] currentStringsArray) {

        boolean theDigitExistsInString = false;

        ArrayList<String> errorsArrayList = new ArrayList<>();

        ///// Пробегаемся по строкам массива
        for (String currentStringPart : currentStringsArray) {

            ///// Используем регулярные выражения для поиска числовых значений в строке
            Pattern pattern = Pattern.compile(REGEXRULLES_ONLYDUGITS);
            Matcher matcher = pattern.matcher(currentStringPart);
            while (matcher.find()) {
                // System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
                theDigitExistsInString = true;
            }
        }

        if ((currentStringsArray.length != 3)) {
            errorsArrayList.add("Ошибка!! Пробелы в ФИО не соответсвуют заданному формату!!!");
        }
        if (theDigitExistsInString) {
            errorsArrayList.add("Ошибка! В ФИО содежатся цифровые значения!");
        }

        return errorsArrayList;

    }
}





