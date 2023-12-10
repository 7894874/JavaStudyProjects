


public class Main {

    public static void main(String[] args) {

    }

    public static int calculateSalarySum(String text) {

        int totalEarnings = 0;

        //// Создаем массив строк методом сплит с регулярным выражением,
        // убирающим все символы кроме числовых [^0-9]
        String[] listOfTheEarnings = text.split(getString());

        //// Перебираем строки по цику попутно конвертируя нужные суммы в число
        //// используем класс Integer
        for (int i = 0; i < listOfTheEarnings.length; i++) {

            String currentEarning = listOfTheEarnings[i];

            if (!currentEarning.isEmpty()) {

                int currentEarningDigit = Integer.parseInt(currentEarning);
                //// Используем фишки Java ;) totalEarnings = totalEarnings +... не вспоминаем про 1С)
                totalEarnings += currentEarningDigit;

            }
        }

        return totalEarnings;

    }

    private static String getString() {
        return "[^0-9]";
    }
}