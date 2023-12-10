
import jdk.internal.org.jline.utils.Log;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * 3.1. Рекурсивное действие – пример
 * В приведенном ниже примере единица работы, подлежащая обработке,
 * представлена строкой, называемой рабочая нагрузка .
 * Для демонстрационных целей эта задача бессмысленна: она просто вводит данные в верхний регистр и регистрирует их.
 * <p>
 * Чтобы продемонстрировать поведение разветвления фреймворка,
 * пример разбивает задачу, если рабочая нагрузка .length() превышает заданный порог |
 * с помощью метода createSubtask () .
 * <p>
 * Строка рекурсивно разделяется на подстроки,
 * создавая Пользовательские экземпляры RecursiveTask, основанные на этих подстроках.
 * <p>
 * В результате метод возвращает List RecursiveAction>. RecursiveAction>.
 * <p>
 * Список передается в ForkJoinPool с помощью метода invokeAll() :
 */

public class CustomRecursiveAction extends RecursiveAction {

    private long startTime;
    private int NumberOfRegions;
    private static final int THRESHOLD = 8;

    private static Logger logger = Logger.getAnonymousLogger();

    public CustomRecursiveAction(int NumberOfRegions, long startTime) {
        this.NumberOfRegions = NumberOfRegions;
        this.startTime = startTime;
    }

    @Override
    protected void compute() {
        if (NumberOfRegions > THRESHOLD) {
            System.out.println("Making Subtasks of Fork Join Pool");
            //ForkJoinTask.invokeAll(createSubtasks());
            //ForkJoinTask.invokeAll(createSubtasks());

            ExecutorService executorService = Executors.newFixedThreadPool(64);
            // executorService.submit(createSubtasks());    //// 183,5 секунды
             executorService.execute(createSubtasks());   //// 183,989 секунды
            // executorService.submit(createSubtasks());    //// 193,905 секунды

            executorService.shutdown();

        } else {
            try {
                processing(NumberOfRegions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable createSubtasks() {

        List subtasks = new ArrayList<>();
        for (int numbderOfRegion = 1; numbderOfRegion <= NumberOfRegions; numbderOfRegion++) {
            try {
                subtasks.add(processing(numbderOfRegion));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return (Runnable) subtasks;
    }

    public Object processing(int numOfRegion) throws Exception {

        try {
            processForGenerationCarsNumbers(numOfRegion, startTime);
            //   result = true;
        } catch (Exception e) {
            //  result = false;
            e.printStackTrace();
        }

        logger.info("This result - was processed by " + Thread.currentThread().getName());

        return null;
    }

    public void processForGenerationCarsNumbers(int numberOfRegion, long startTime) throws Exception {

        /** numberOfRegion - номер региона                    **/
        /** qttOfNumbers - количество номеров для машин всего **/

        try {

            //  wait();

            int qttOfNumbers = 1000;

            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

            String regionCodeStr = Integer.toString(numberOfRegion);
            String currentPathNumber = "src/result/numbers" + regionCodeStr + ".txt";

            PrintWriter writer = null;
            try {
                writer = new PrintWriter(currentPathNumber);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            StringBuilder builder = new StringBuilder();

            for (int number = 1; number < qttOfNumbers; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {

                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(numberOfRegion, 2));
                            builder.append("\n");

                        }
                    }
                }
            }

            writer.write(builder.toString());

            writer.flush();
            writer.close();

            System.out.println("Finished after start:" + (System.currentTimeMillis() - startTime) + " ms");

        } catch (Exception e) {

            e.printStackTrace();

            Log.warn("Failed to generate car number for " + numberOfRegion + ", skipping! Sorry! (" + "reason is:" + e.getMessage() + ")");

        }
    }

    private static String padNumber(int number, int numberLength) {

        // StringBuilder builder2 = new StringBuilder();
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            //// builder2.append(0);
            //// builder2.append(numberStr);
            numberStr = '0' + numberStr;
            ////   numberStr = builder2.toString();
        }
        return numberStr;
    }
}

