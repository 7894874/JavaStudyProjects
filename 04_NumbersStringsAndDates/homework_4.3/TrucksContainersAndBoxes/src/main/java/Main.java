/**
 * Что нужно сделать
 * <p>
 * Вы доставляете гуманитарную помощь в ящиках одинакового размера.
 * У вас есть грузовики и контейнеры.
 * каждый грузовик помещается максимум 12 контейнеров.
 * В каждый контейнер — не более 27 ящиков.
 * Ящики, контейнеры и грузовики пронумерованы.
 * <p>
 * Напишите программу, которая распределит ящики по контейнерам и грузовикам
 * в зависимости от их количества. Программа должна выводить необходимое для
 * этого число грузовиков и контейнеров.
 *
 * @@@@@@@@@@@@@@@@ Принцип работы программы
 * Пользователь вводит количество ящиков, программа печатает результат в виде текста,
 * пример результата для двух ящиков:
 * <p>
 * Грузовик: 1
 * Контейнер: 1
 * Ящик: 1
 * Ящик: 2
 * <p>
 * Необходимо:
 * грузовиков - 1 шт.
 * контейнеров - 1 шт.
 * <p>
 * Рекомендации:
 * Для добавления отступа в строке вы можете использовать символ табуляции «\t».
 * Используйте для переноса  System.lineSeparator()
 * это вызовет системный перенос строки (перенос той операционной системы,
 * на которой запущена приложение),
 * так как в mac/win/linux используются разные символы переноса,
 * для Windows это \r\n, macOS\Linux это \n
 * <p>
 * Обратите внимание на арифметическую операцию «Остаток от деления»
 * System.out.println(45 % 10) = вывод будет 5
 * <p>
 * // пример вывода при вводе 2
 * // для отступа используйте табуляцию - \t
 * <p>
 * <p>
//                "Грузовик: 1",
//                        "\tКонтейнер: 1",
//                        "\t\tЯщик: 1",
//                        "\t\tЯщик: 2",
//                        "Необходимо:",
//                        "грузовиков - 1 шт.",
//                        "контейнеров - 1 шт."
 **/

import java.util.Scanner;

public class Main {

    public static final int MAX_CONTAINERS = 12; //   каждый грузовик помещается максимум 12 контейнеров.
    public static final int MAX_BOXES = 27;      //  каждый контейнер — не более 27 ящиков.

    private static int currentNumberOfBoxes;

    public static void main(String[] args) {

        System.out.println("Сколько ящиков будем перевозить?");

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        currentNumberOfBoxes = getCount(boxes);

        System.out.println("Количество ящиков равно "+toString(currentNumberOfBoxes));

        if (currentNumberOfBoxes > 0) {

            int countnomberOfBoxes = 0;
            int countOfTracks = 1;
            int countnomberOfContainers = 1;

            System.out.println("Грузовик: " + toString(countOfTracks));
            System.out.println("\tКонтейнер: " + toString(countnomberOfContainers));

            for (int k = 1; k <= currentNumberOfBoxes; k++) {
                countnomberOfBoxes++;

                System.out.println("\t\tЯщик: " + toString(countnomberOfBoxes));

                int countOfBoxesForTracks = MAX_CONTAINERS * MAX_BOXES;
                if (countnomberOfBoxes % countOfBoxesForTracks == 0) {
                    countOfTracks++;
                    System.out.println("Грузовик: " + toString(countOfTracks));
                }

                if (countnomberOfBoxes % MAX_BOXES == 0) {
                    countnomberOfContainers++;
                    System.out.println("\tКонтейнер: " + toString(countnomberOfContainers));
                }
            }

            //// После всех расчетов, получаем итоги
            System.out.println("Необходимо: " + System.lineSeparator() + " грузовиков - "
                    + toString(countOfTracks) + " шт." + System.lineSeparator() +
                    " контейнеров - " + toString(countnomberOfContainers) + " шт.");

        } else {

            //// После всех расчетов, получаем итоги
            System.out.println("Необходимо: " + System.lineSeparator() + " грузовиков - "
                    + toString(0) + " шт." + System.lineSeparator() +
                    " контейнеров - " + toString(0) + " шт.");

        }
    }

    public static int getCount(String boxes) {

        //// Получаем числовое значение Строки количество ящиков
        try {
            // именно здесь String преобразуется в int
            currentNumberOfBoxes = Integer.parseInt(boxes.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        return currentNumberOfBoxes;

    }

    public static String toString(int someIntDigit) {
        return Integer.toString(someIntDigit);
    }

}

