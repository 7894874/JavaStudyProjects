import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;

import static java.lang.System.out;

public class Redis_LogicalStorage {

    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeys;

    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> newsiteusers;

    // Название ключа
    private final static String KEY = "NEW_USERS_OF_SITE";

    /// Получаем тут TimeStamp
    private double getTs() {
        return new Date().getTime() / 1000;
    }

    //// Инициализация хранилища с Субд Redis
    void init() {

        /// Конфигурируем подключение к базе Redis
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.2.77:6379");
        config.useSingleServer().setPassword("!Superx15616729");

        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }

        //// Задействуем классы работы с Redis
        rKeys = redisson.getKeys();
        /// Находим всех пользователей по ключу в SorterSet
        newsiteusers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void logPageVisit(int user_id) {
        this.newsiteusers.add(this.getTs(), String.valueOf(user_id));
    }

    int calculateUsersNumber()
    {
        //ZCOUNT ONLINE_USERS
        return newsiteusers.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }

    //// Завершение работы с Redis
    void shutdown() {
        redisson.shutdown();
    }
}
