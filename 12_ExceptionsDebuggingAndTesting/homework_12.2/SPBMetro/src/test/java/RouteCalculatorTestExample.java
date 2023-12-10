
import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class RouteCalculatorTestExample extends TestCase {

    Line center = new Line(1, "Центральная");
    Line over = new Line(2, "Верхняя");
    Line down = new Line(3, "Нижняя");

    //      Северная(0)              Зимняя(1)                                              OVER
    //просто схема    //                  Мидгард(2), Средиземье(3), Темнолесье(4), Хэллхоум(5)               CENTER
    //                                                               Летняя(6)   Южная(7)   DOWN

    ArrayList<Station> justRoute;
    ArrayList<Station> stationList;

    StationIndex stin = new StationIndex();
    RouteCalculator rc;


    @Override
    protected void setUp() throws Exception {

        stationList = new ArrayList<>();
        stationList.add(new Station("Северная", over)); // 0
        stationList.add(new Station("Зимняя", over)); // 1
        stationList.add(new Station("Мидгард", center)); // 2
        stationList.add(new Station("Средиземье", center)); // 3
        stationList.add(new Station("Темнолесье", center)); // 4      -    СОЗДАЛ СТАНЦИИ
        stationList.add(new Station("Хэллхоум", center)); // 5
        stationList.add(new Station("Летняя", down)); // 6
        stationList.add(new Station("Южная", down)); // 7

        over.addStation(stationList.get(0));
        over.addStation(stationList.get(1));
        center.addStation(stationList.get(2));
        center.addStation(stationList.get(3));
        center.addStation(stationList.get(4));              //           -      ДОБАВИЛ СТАНЦИИ НА ЛИНИИ
        center.addStation(stationList.get(5));
        down.addStation(stationList.get(6));
        down.addStation(stationList.get(7));

        ArrayList<Station> trns1 = new ArrayList<>();
        ArrayList<Station> trns2 = new ArrayList<>();
        trns1.add(stationList.get(1));
        trns1.add(stationList.get(3));                    //         -      ДВА СПИСКА С ПЕРЕСАДКАМИ
        trns2.add(stationList.get(5));
        trns2.add(stationList.get(6));

        for(Station st : stationList) {
            stin.addStation(st);
        }
        stin.addLine(center);
        stin.addLine(over);                              //        -       СХЕМА МЕТРО В ОБЪЕКТЕ
        stin.addLine(down);
        stin.addConnection(trns1);
        stin.addConnection(trns2);

        rc = new RouteCalculator(stin);

        justRoute = new ArrayList<>(); // маршрут для теста времени
        justRoute.add(stationList.get(7));
        justRoute.add(stationList.get(6));
        justRoute.add(stationList.get(5));
        justRoute.add(stationList.get(4));

    }


    public void testCalculateDuration() {
        double expected = 8.5;
        double actual = RouteCalculator.calculateDuration(justRoute);

        assertEquals(expected, actual);
    }


    public void testGetRouteOnTheLine() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationList.get(2));
        expected.add(stationList.get(3));
        expected.add(stationList.get(4));

        List<Station> actual = rc.getShortestRoute(stationList.get(2), stationList.get(4));

        assertEquals(expected, actual);
    }


    public void testGetRouteWithOneConnection() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationList.get(1));
        expected.add(stationList.get(3));
        expected.add(stationList.get(4));

        List<Station> actual = rc.getShortestRoute(stationList.get(1), stationList.get(4));

        assertEquals(expected, actual);
    }


    public void testGetRouteWithTwoConnections() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationList.get(1));
        expected.add(stationList.get(3));
        expected.add(stationList.get(4));
        expected.add(stationList.get(5));
        expected.add(stationList.get(6));

        List<Station> actual = rc.getShortestRoute(stationList.get(1), stationList.get(6));

        assertEquals(expected, actual);
    }

}