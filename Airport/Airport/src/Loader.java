import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static int counter;

    public static void main(String[] args) {

        ///// Получаем список самолетов
        Airport airport = Airport.getInstance();
        List<Aircraft> airportList = airport.getAllAircrafts();

        //// Перебираем список самолетов
        for (int i = 0; i < airportList.size(); i++)
        {
            System.out.println(airportList.get(i));
            counter++;
        }
        System.out.println("У нас во всех аэропортах: "+counter+" самолетов!");

        List<Terminal> terminalsList = airport.getTerminals();
        for (int i = 0; i < terminalsList.size(); i++)
        {
            Terminal terminal = terminalsList.get(i);
            System.out.println("============ A I R P O R T <<"+terminal.getName()+">> =====================================");
            System.out.println("В аэропорту приземлись самолеты:");

            List<Aircraft> parkedAircraftsList = terminal.getParkedAircrafts();

            for(Aircraft element : parkedAircraftsList) {
                System.out.println(element.getModel());
            }
        }
        System.out.println("======================================================================");
    }
}



