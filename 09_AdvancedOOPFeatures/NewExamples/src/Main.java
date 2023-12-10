import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ///// Вот примеры статических методов интерфейсов
        /// Компаратор - это статический метода интерфейса
        //// их нельзя создавать
        Comparator.reverseOrder();
        ////
        TreeSet<String> list = new TreeSet<>(Comparator.reverseOrder());


        //// У стрима есть статический метод of который позволяет
        //// создать стрим не создавая никаких объектов
        //// это все статичесие методы интерфейсов их нельзя переопределять
        //// но можно создавать так называемые дефолтные методы
        //// переопределять которые можно

        Stream.of(1, 2, 3, 4).forEach( System.out::println );
        list.add( Stream.of(1, 2, 3, 4).toString() );
        list.forEach( System.out::println );


    }
}
