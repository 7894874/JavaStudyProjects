import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * //Сформируйте схему метро (StationIndex) в тестовом классе, в которой можно построить хотя бы один маршрут с двумя пересадками.
 * // Делайте небольшую схему, чтобы легче ориентироваться в ней.
 * // Чтобы протестировать приватные методы класса RouteCalculator, используйте различные аргументы метода getShortestRoute()
 * // для вызова методов без пересадок, с одной и двумя пересадками.
 * // Code Coverage — инструмент в IDEA, определяющий уровень покрытия тестами классов, методов и строк.
 * // Чтобы запустить тесты с проверкой покрытия, надо нажать правой кнопкой мыши по классу
 * // директории с тестами и выбрать Run All tests with Coverage.
 * // Желательно добиться 100%-ного покрытия методов класса RouteCalculator.
 **/

public class RouteCalculatorTest extends TestCase {

    List<Station> route;

    List<Station> route2;

//    private Station stationFrom;
//    private Station stationTo;

    StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() throws Exception {

//        route = new ArrayList<>();
//
//        Line line1 = new Line( 1, "Первая" );
//        Line line2 = new Line( 2, "Вторая" );
//
//        route.add( new Station( "Петровская", line1 ) );
//        route.add( new Station( "Горьковская ", line1 ) );
//        route.add( new Station( "Яблочная", line2 ) );
//        route.add( new Station( "Приморская", line2 ) );
//
//        /// Не понимаю где ошибка и какая, не могу её воспроизвести...
//        /// На каком этапе ошибка получается, пустое значение линии?
//        route2 = new ArrayList<>();
//
//        Line line3 = new Line( 3, "Третья" );
//        Line line4 = new Line( 4, "Четвертая" );
//        Line line5 = new Line( 5, "" );
//
//        //// Пытаюсь воспроизвести ошибку и вставить пустое значение описания станции...
//        route2.add( new Station( "Петровская", line3 ) );
//        route2.add( new Station( "Горьковская ", line3 ) );
//        route2.add( new Station( "Яблочная", line4 ) );
//        route2.add( new Station( "", line5 ));
//
//        // 2,5 + 3,5 + 3,5 =  9,5


        //// Пытаемся создать некую схему метро самостоятельно чтобы использовать её в дальнейшем

        //// Создаем объект stationIndex для последующего его использования
        // StationIndex stationIndex = new StationIndex();

        //// Небольшая схема метро

        //// Маршрут на ветках №1-№2
        route = new ArrayList<>();

        Line line1 = new Line( 1, "Первая" );
        Line line2 = new Line( 2, "Вторая" );

        route.add( new Station( "Петровская", line1 ) );
        route.add( new Station( "Горьковская ", line1 ) );
        route.add( new Station( "Яблочная", line2 ) );
        route.add( new Station( "Приморская", line2 ) );


        //// Теперь пытаемся добавить в ветку станции уже с двумя пересадками
        Line line3 = new Line( 3, "Третья" );
        Line line4 = new Line( 4, "Четвертая" );
        Line line5 = new Line( 5, "Пятая" );
        Line line6 = new Line( 6, "Шестая" );

        route.add( new Station( "Сенная Площадь", line4 ) );
        route.add( new Station( "Спасская", line5 ) );
        route.add( new Station( "Садовая", line6 ) );

        //// Ветка 1 добавлена
        stationIndex.addConnection( route );

        stationIndex.addStation( new Station( "Кировский завод", line3 ) );
        stationIndex.addStation( new Station( "Нарвская", line3 ) );
        stationIndex.addStation( new Station( "Балтийская", line3 ) );
        stationIndex.addStation( new Station( "Пушкинская", line3 ) );
        stationIndex.addStation( new Station( "Технологический институт", line4 ) );
        stationIndex.addStation( new Station( "Фрунзенская", line4 ) );
        stationIndex.addStation( new Station( "Московские ворота", line4 ) );
        stationIndex.addStation( new Station( "Спасская", line5 ) );

        //// Теперь добавим в массив линий станции, чтобы определить к какой линии относится каждая
        //// для точности расчетов это станции с одно пересадкой
        line3.addStation( stationIndex.getStation( "Кировский завод" ) );
        line3.addStation( stationIndex.getStation( "Нарвская" ) );
        line3.addStation( stationIndex.getStation( "Балтийская" ) );
        line3.addStation( stationIndex.getStation( "Пушкинская" ) );
        line4.addStation( stationIndex.getStation( "Фрунзенская" ) );
        line4.addStation( stationIndex.getStation( "Московские ворота" ) );

        route2 = new ArrayList<>();

        route2.add( new Station( "Кировский завод", line3 ) );
        route2.add( new Station( "Нарвская", line3 ) );
        route2.add( new Station( "Балтийская", line3 ) );
        route2.add( new Station( "Пушкинская", line3 ) );
        route2.add( new Station( "Технологический институт", line4 ) );
        route2.add( new Station( "Фрунзенская", line4 ) );
        route2.add( new Station( "Московские ворота", line4 ) );

        //// Добавляем станции на линии для последующего теста
        //// Эти станции у нас уже есть...не добавляем, добавляем только переходные для контроля
        //       stationIndex.addStation( new Station( "Фрунзенская", line4 ) );
        //       stationIndex.addStation( new Station( "Технологический институт", line4 ) );

        stationIndex.addStation( new Station( "Сенная Площадь", line4 ) );
        stationIndex.addStation( new Station( "Спасская", line5 ) );
        stationIndex.addStation( new Station( "Садовая", line6 ) );

        line4.addStation( stationIndex.getStation( "Сенная Площадь" ) );
        line5.addStation( stationIndex.getStation( "Спасская" ) );
        line6.addStation( stationIndex.getStation( "Садовая" ) );

        route2.add( new Station( "Сенная Площадь", line4 ) );
        route2.add( new Station( "Спасская", line5 ) );
        route2.add( new Station( "Садовая", line6 ) );

        //// Ветка 2 добавлена
        stationIndex.addConnection( route2 );

    }

    public void testcalculateDuration() {

        double actual = RouteCalculator.calculateDuration( route );
        double expected = 19;
        assertEquals( expected, actual );

//        double actual2 = RouteCalculator.calculateDuration( route2 );
//        double expected2 = 9.5;
//        assertEquals( expected2, actual2 );

    }

    public void testGetShortestRouteWithOneLine() {

        RouteCalculator calculator = new RouteCalculator( stationIndex );

        //// Выводим список того, что ожидаем
        List<Station> expectedRoute = List.of( stationIndex.getStation( "Кировский завод" ),
                stationIndex.getStation( "Нарвская" ),
                stationIndex.getStation( "Балтийская" ) );

        List<Station> actualRoute = calculator.getShortestRoute( stationIndex.getStation( "Кировский завод" ),
                stationIndex.getStation( "Балтийская" ) );

        assertEquals( expectedRoute, actualRoute );

    }

    public void testgetRouteOnTheLine() {

        RouteCalculator calculator = new RouteCalculator( stationIndex );

        List<Station> expectedRoute = List.of( stationIndex.getStation( "Кировский завод" ),
                stationIndex.getStation( "Нарвская" ),
                stationIndex.getStation( "Балтийская" ) );


        List<Station> actualRoute = calculator.getRouteOnTheLine( stationIndex.getStation( "Кировский завод" ),
                stationIndex.getStation( "Балтийская" ) );

        assertEquals( expectedRoute, actualRoute );

    }

    //// Пытаемся получить станции с одной пересадкой (1м соединением)
    public void testgetRouteWithOneConnection() {

        //// Добавляем в класс калькулятора station index с линиями
        RouteCalculator calculator = new RouteCalculator( stationIndex );

        List<Station> expectedRoute = List.of( stationIndex.getStation( "Балтийская" ), stationIndex.getStation( "Фрунзенская" ) );

        List<Station> actualRoute = calculator.getRouteWithOneConnection( stationIndex.getStation( "Балтийская" ),
                new Station( "", new Line( 4, "Четвертая" ) )  );

        assertEquals( expectedRoute, actualRoute );
    }

    public void testgetRouteWithTwoConnections() {
//        //// Создаем объект StationIndex для доступа к Map и трисетам
//        StationIndex stationIndex = new StationIndex();
//
//        //// Создаем объект Линии /// Line(int number, String name)
//        Line line1 = new Line( 1, "Первая" );
//        Line line2 = new Line( 2, "Вторая" );
//        Line line4 = new Line( 4, "Четвертая" );
//        Line line5 = new Line( 5, "Пятая" );
//
//        //// Добавляем станции на линии для последующего теста
//        stationIndex.addStation( new Station( "Фрунзенская", line2 ) );
//        stationIndex.addStation( new Station( "Технологический институт", line2 ) );
//        stationIndex.addStation( new Station( "Сенная Площадь", line2 ) );
//        stationIndex.addStation( new Station( "Спасская", line4 ) );
//        stationIndex.addStation( new Station( "Садовая", line5 ) );
//
//        line2.addStation( stationIndex.getStation( "Фрунзенская" ) );
//        line2.addStation( stationIndex.getStation( "Технологический институт" ) );
//        line2.addStation( stationIndex.getStation( "Сенная Площадь" ) );
//        line4.addStation( stationIndex.getStation( "Спасская" ) );
//        line5.addStation( stationIndex.getStation( "Садовая" ) );
//
//        //// обращаемся к объекту калькулятора station index с линиями
        RouteCalculator calculator = new RouteCalculator( stationIndex );
//
//        stationIndex.addConnection( List.of( stationIndex.getStation( "Спасская" ),
//                stationIndex.getStation( "Сенная Площадь" ),
//                stationIndex.getStat ion( "Садовая" ) ) );

        List<Station> expectedRoute = List.of( stationIndex.getStation( "Спасская" ) );

        List<Station> actualRoute = calculator.getRouteWithTwoConnections(
                stationIndex.getStation( "Сенная Площадь" ),
                stationIndex.getStation( "Садовая" ) );

        assertEquals( expectedRoute, actualRoute );

    }

    @Override
    protected void tearDown() throws Exception {


    }
}
