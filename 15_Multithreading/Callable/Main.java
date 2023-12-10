import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    //* Семейство интерфейсов и классов с помощью которых можно получать результат выполнения потоков
    public static void main(String[] args) {

        /// Реализуем интерфейс Callable
        Callable callable = () -> {

            double sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += Math.random();
            }
            if (sum/1000 < 0.6) {
                throw new IllegalArgumentException("WARNING!!! Digit less than 0.6");
            }
            return sum / 1000;
        };

        //// Запускаем Callble с помощью FutureTask
        FutureTask<Double> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();


        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            //// Так же внутри этого интерфейса написана сигнатура throws (Исключения)
            //// таким образом можно напечатать свое сообщение
            System.out.println("Exeption: "+ e.getMessage());
        }
    }
}





