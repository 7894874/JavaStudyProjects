import java.util.Properties;
import java.util.Set;

public class USSCapitals {

    public static void main(String[] args) {

        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтона", "Олимпия");
        capitals.put("Калифорнии", "Сакраменто");
        capitals.put("Индианы", "Индианаполис");

        // Показывает все штаты и столицы в хэш-таблицы.
        states = capitals.keySet();   // Получить набор ключей

        for (Object state : states) {
            str = (String) state;
            System.out.println("Столицей " + str + " является " +
                    capitals.getProperty(str) + ".");
        }
        System.out.println();

        // При нахождении штата вне списка –– указать значение по умолчания.
        str = capitals.getProperty("Флорида", "Не Найдена");
        System.out.println("Столица Флориды " + str + ".");
    }

}
