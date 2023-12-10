
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * Задание №2
 *
 * Задание выполняйте в проекте
 *
 * 05_ArraysAndCollections/homework_5.1/Hospital.
 *
 *
 * Что нужно сделать
 *
 * Напишите код метода generatePatientsTemperatures(), который должен сгенерировать массив float,
 * содержащий значения температур пациентов от 32 до 40 градусов.
 * В методе getReport()вам требуется составить строку с отчётом по значениям температур в массиве с пациентами:
 * - Соберите в строку список температур пациентов.
 *
 * - Рассчитайте среднее арифметическое значение температуры.
 *
 * - Посчитайте количество здоровых пациентов с температурой от 36,2 до 36,9 градусов.
 *
 * Проверьте свой код с помощью тестов.
 *
 *
 */

public class Hospital {

    private static final double MINHEALTHBORDER = 36.2;
    private static final double MAXEALTHBORDER = 36.9;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        // Код генерации массивов поциентов

        float[] newArrayTemperature = new float[patientsCount];

        ///generatePatientsTemperatures

        for (int i = 0; i < newArrayTemperature.length; i++) {

            double currentTremperature = 32 + (8. * Math.random());

            currentTremperature = new BigDecimal(currentTremperature).setScale(1, RoundingMode.UP).doubleValue();

            newArrayTemperature[i] = (float) currentTremperature;
            System.out.println(currentTremperature);

        }

        return newArrayTemperature;

    }

    public static String getReport(float[] temperatureData) {

        //  String currentTemperatureList = temperatureData;

        int qttOfHealthyPaciants = 0;
        float avarageTemperature = 0;
        float currentQttOfPacients = temperatureData.length;

        for (float curretnTmp : temperatureData) {

            avarageTemperature = avarageTemperature + curretnTmp;

            if ((curretnTmp >= (float) MINHEALTHBORDER) && (curretnTmp <= (float) MAXEALTHBORDER)) {
                qttOfHealthyPaciants++;
            }
        }

        avarageTemperature = avarageTemperature / currentQttOfPacients;

        //  avarageTemperature = (float) new BigDecimal(avarageTemperature).setScale(2, RoundingMode.UP).doubleValue();

        avarageTemperature = (float) roundAvoid(avarageTemperature, 2);

        String report =
                "Температуры пациентов: " + arrayToString(temperatureData) +
                        "\nСредняя температура: " + avarageTemperature +
                        "\nКоличество здоровых: " + qttOfHealthyPaciants;

        return report;
    }

    private static String arrayToString(float[] someArray) {

        ///// Иннициализируем билдер для скорости чтения и записи строк
        StringBuilder stringBuilder = new StringBuilder();

        //// Читаем массив данных
        for (int i = 0; i < someArray.length; i++) {

            float currentClearedStr = someArray[i];

            stringBuilder.append(currentClearedStr + " ");
        }

        //// Убираем последнюю строку и наслаждаемся результатом :-)
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();

    }

    public static double roundAvoid(double value, int places) {

        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }


}

