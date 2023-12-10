import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Программа должна запускать бесконечный цикл, в котором:
 * <p>
 * Выводится в консоль номер пользователя, которого нужно отобразить на главной странице.
 * В одном из 10 случаев случайный пользователь оплачивает услугу, в консоль выводится его номер.
 * Программа ждёт 1 секунду, и цикл начинается заново.
 **/

public class Redis_MeetingsTest {

    // Для теста будем считать неактивными пользователей, которые не заходили 2 секунды
    private static final int DELETE_SECONDS_AGO = 2;

    // Допустим пользователи делают 500 запросов к сайту в секунду
    private static final int RPS = 500;

    // И всего на сайт заходило 1000 различных пользователей
    private static final int USERS = 1000;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 1000; // 10 сек

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    //
    private static void logEnter(int user_id) {
        String log1 = String.format(" [%s] На сайт зашел пользователь c номером: [%d] ", DF.format(new Date()), user_id);
        out.println(log1);
    }

    private static void logPay(int user_id) {
        String log2 = String.format(" [%s] И так же этот пользователь c номером: [%d] оплатил услугу! ", DF.format(new Date()), user_id);
        out.println(log2);
    }

    private static void logLucky(int nomber) {
        String log2 = String.format(" Порядковый номер счастливчика! [%d]", nomber);
        out.println(log2);
    }

    public static void main(String[] args) throws InterruptedException {

        Redis_LogicalStorage redis = new Redis_LogicalStorage();
        redis.init();

        while (true) {

            //// Узнаем, какой будет из номеров счастливым из 10ти через рандом...
            int min = 1;
            int max = 10;

            int randomNumber = new Random().nextInt(max - min) + min;
            logLucky(randomNumber);

            //out.println("=======================================");
            int counter = 1;
            for (int i = 0; i < 10; i++) {

                //// Генерируем произвольный номер пользователя и выводим его в консоль
                //// имитируем появление пользователя на сайте и регистрируем каждого пользователя в хранилище
                int user_id = new Random().nextInt(USERS);
                logEnter(user_id);
                redis.logPageVisit(user_id);

                if (counter == randomNumber) {
                    logPay(user_id);
                }
                if (counter == 10) {
                    Thread.sleep(SLEEP);
                    out.println("=======================================");
                }

                counter++;

            }

            int currentQttOfUsers = redis.calculateUsersNumber();
            if (currentQttOfUsers > 100) {

                out.println("Количество пользователей достаточно для корректного теста, прерываем цикл!");

                redis.shutdown();

                out.println("Выключили соединение с REDIS!");

                break;
            }
        }
    }
}





