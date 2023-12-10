import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


   // private dateTime dateNow


    public static void main(String[] args) {

        LocalDateTime dateNow = LocalDateTime.now();

        Airport airport = Airport.getInstance();

        System.out.println( airport.getAllAircrafts() );

        ///// Передрал и частично улучшил)

        //     public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {


        //// Получаем терминал со всеми самолетами
        airport.getTerminals().stream()
                //// Получаем этим методом поле date в объекте (только так можно его получить date)
                .flatMap( terminal -> terminal.getFlights().stream() )

                //// Проверяем получившийся стрим
                .peek( terminal -> System.out.format( "terminal  %s%n", terminal.getDate() +" "+terminal.getAircraft()+" "+terminal.getType() ) )

                //// Получаем Тип рейса, в даном случае надо найти те, которые подготовлены к вылету
                //// Для этого используем метод getType() из Объекта flight класса Flight
                //// вызываем метод сравнения данных equals(...) типа рейса с перечислением из класса (Flight)
                //// и отбираем в потоке только те, которые с этим условием
                .filter( flight -> flight.getType().equals( Flight.Type.DEPARTURE ) )

                //// Проверяем то что получилось
                .peek( flight -> System.out.format( "after filter: %s%n", flight.getDate() +" "+flight.getAircraft()+" "+flight.getType() ) )

                //// Далее в потоке сравниваем преобразованную дату из объекта ( которая у нас получилась)
                //// с текущей датой

                .filter( flight -> modifiedDate( flight ).isAfter( dateNow ) && modifiedDate( flight ).isBefore( dateNow.plusHours( 2 ) ) )
                //// Далее просто собираем все данные из плоской мэпы в коллекцию в список для последующего вывода
                //// и возврата конкретных значений
                .collect( Collectors.toList() )
                /// Теперь печатаем данные  flight stream через лямбду
                .forEach( System.out::println );

        //// Все тоже самое делаем, но в методе

        //// Тесты после прочтения...постарался понять и запомнить что прочел)
        IntStream.range(5, 30)
                .limit(12)
                .skip(3)
                .limit(6)
                .skip(2)
                .forEach(System.out::println);
        //   }

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        LocalDateTime dateNow = LocalDateTime.now();

        return   airport.getTerminals().stream()
                .flatMap( terminal -> terminal.getFlights().stream() )
                .peek( terminal -> System.out.format( "terminal  %s%n", terminal.getDate() +" "+terminal.getAircraft()+" "+terminal.getType() ) )
                .filter( flight -> flight.getType().equals( Flight.Type.DEPARTURE ) )
                //// Проверяем то что получилось
                .peek( flight -> System.out.format( "after filter: %s%n", flight.getDate() +" "+flight.getAircraft()+" "+flight.getType() ) )
                //// Далее в потоке сравниваем преобразованную дату из объекта ( которая у нас получилась)
                //// с текущей датой
                .filter( flight -> modifiedDate( flight ).isAfter( dateNow ) && modifiedDate( flight ).isBefore( dateNow.plusHours( 2 ) ) )
                //// Далее просто собираем все данные из плоской мэпы в коллекцию в список для последующего вывода
                //// и возврата конкретных значений
                .collect( Collectors.toList() );

    }

    public static LocalDateTime modifiedDate(Flight date) {

        //// После того, как сделали объект flight плоским с помощью метода flatMap,
        //// Теперь можно оперировать его полями так как мы хотим, в данном случае это date
        //// поле объекта flight класса Flight

        //        Используем Метод ofInstant () класса LocalTime используется для получения экземпляра LocalTime
        //        из Instant и идентификатора зоны, переданного в качестве параметров.
        //        В этом методе Во-первых, смещение от UTC / Гринвич получается с использованием
        //        идентификатора зоны и instant. Затем местное время рассчитывается по моменту и смещению.

        /// В результате получим преобразованную локальную дату, с которой уже реально
        //// можно сравнивать данные
        return LocalDateTime.ofInstant( date.getDate().toInstant(), ZoneId.systemDefault() );

    }


}