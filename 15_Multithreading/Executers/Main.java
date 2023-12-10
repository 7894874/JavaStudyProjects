import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ///// Пулы потоков, нужны они для того, чтобы не было чрезмерного
        ///// бесконтрольного создания потоков которые могут сильно влиять
        ///// на производительность системы.
        //// Мы можем создавать специальные пулы потоков, которые могут заранее делать
        //// ограниченное количество потоков
        /// Пример, задача, которая печатает случайные числа
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Double> future = service.submit(
                () -> {
                    double sum = 0;
                    for (int i = 0; i < 100000; i++) {
                        sum += Math.random();
                    }
                    return sum;
                }
        );

        try {
            System.out.println(future.get());
            //// ExecuterService не знавешается, если их спциально не завершить,
            //// Чтобы программа завершилась, нужно чтобы сервис завершился специальной командой
            //// .shutdown
            service.shutdown(); /// Именно в этом случае произойдет завершения сервиса executer

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

