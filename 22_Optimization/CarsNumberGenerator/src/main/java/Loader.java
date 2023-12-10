import java.util.concurrent.ForkJoinPool;

/**
 * Факторы производительности:
 * Решаемая задача
 * Используемый алгоритм (эффективен или нет)
 * Количество операций
 * Длительность операций
 * Принцип работы с памятью
 * Используемые типы данных (SSD или HDD)
 * Тип используемой памяти
 */

public class Loader {

    public static void main(String[] args) {

        // Измеряем длительность работы программы
        long start = System.currentTimeMillis();

        /**
         /// Чтобы оптимизировать программу можно определить как мы пишем данные в файл на жесткий диск
         /// для оптимизации, сделаем запись не одного побитового значения данных, а множества данных порциями
         /// для этого используем StringBuilder()

         /// Вместо FileOutputStream можно использовать PrintWriter для автоматического
         /// определения оптимального размера буфера StringBuilder
         /// Метод PrintWriter накапливает данные и скидывает их в файл когда достигается оптимальный размер буфера
         //  FileOutputStream writer = new FileOutputStream("res/numbers.txt");
         **/

        //// Рабочий вариант 1-2
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        CustomRecursiveAction ds = (CustomRecursiveAction) new CustomRecursiveAction(199, start).fork();
        try {
            ds.join();
        } catch (Exception e) {
            //  e.printStackTrace();
            // System.out.println("all done");
        }

        if (ds.isDone()) {
            System.out.println("all done");
        }
        pool.execute(ds);
        pool.shutdown();

        System.out.println((System.currentTimeMillis() - start) + " ms");

    }
}
