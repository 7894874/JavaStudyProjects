import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        ///// ScheduleExecuterService - это полезный класс, который может быть получен из класса Executors
        //// в нем можно ставить задачи через какоето время, в нем можно писать интерфейс Runnble
        //// который будет запускаться через какое-то время

        //// 5 потоков методом newScheduledThreadPool
        /// в нем можно ставить задачи через какоето время
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        //// Этот метод запускает через каждые 1000 милисекунд поток
       // service.schedule(()-> System.out.println("YES"), 1000, TimeUnit.MICROSECONDS);
        //// этот метода через каждые 2000 милисек. повторяет, причем этот период устанавливается от начала запуска
        //// задачи.
     //   service.scheduleAtFixedRate(()-> System.out.println("ТТТ"), 1000, 2000, TimeUnit.MICROSECONDS);
        /// это не всегда удобно, тогда применяют другой метод где задается время от конца задачи, т.е.
        /// задача завершилась и через некоторый параметр delay запускается эта же задача следующий раз
        service.scheduleWithFixedDelay(()-> System.out.println("ТТТ"), 1000, 10000, TimeUnit.MILLISECONDS);

    }
}
