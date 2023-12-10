import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {

   ////  Thread Pool Executer - это расширяемый пул потоков со множеством параметров
   ////  с помощью которых можно регулировать этот пул потоков.
        //// Создадим его
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        //// Зададим то количество потоков, которое по умолчанию в этом экзекутере содержится.
        executor.setCorePoolSize(5);
        /// Помимо этого у этого КорПулЭкзекутера, есть много полезных методов
        /// к примеру
        System.out.println(executor.getActiveCount());  /// Распечатывает количество активных потоков


        /**

         // executor.setKeepAliveTime();

         Sets the thread keep-alive time, which is the amount of time that threads may remain
         idle before being terminated. Threads that wait this amount of time without processing
         a task will be terminated if there are more than the core number of threads currently
         in the pool, or if this pool allows core thread timeout. This overrides any value set in the constructor.

         Устанавливает время сохранения потока, которое является количеством времени, в течение которого потоки моих остатков
         простаивает перед завершением работы. Потоки, которые ожидают это количество времени без обработки
         задачи, будут завершены, если в данный момент в пуле больше основного количества потоков
         или если этот пул allowcorethreadtimeout.
         Это переопределяет любое значение, заданное в конструкторе.
         Т.е. это количество времени ожидания бездействия потоков...

         */

    }

}
