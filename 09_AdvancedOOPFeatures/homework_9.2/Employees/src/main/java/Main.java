import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

/**
 * Что нужно сделать
 * <p>
 * В классе Main реализуйте метод findEmployeeWithHighestSalary(), который должен выделить сотрудников,
 * пришедших в выбранном году, и среди них выявить сотрудника с
 * максимальным значением заработной платы, используя Stream API.
 * Проверьте ваш метод с помощью теста.
 */

public class Main {

    //private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) throws ParseException {

        //// Получаем список сотрудников из файла
        var filenamefirst_txt = "H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\09_AdvancedOOPFeatures\\homework_9.2\\Employees\\data\\staff.txt";
        List<Employee> staff = Employee.loadStaffFromFile( filenamefirst_txt );
        //// Находим с помощью стримов и их методов сотрудника с максимальной заработной платой
        Employee employeeMaxSalary = findEmployeeWithHighestSalary( staff, 2017 );
        //// Выводим на печать этого сотрудника
        System.out.println( "Сотрудник с максимальной заработной платой!" );
        System.out.println( employeeMaxSalary );

        //// Этот метода сделал специально для своих экспериментов на стримами и лямбдами
        MyCodeExec( 2017 );

        System.out.println("\nПарсинг JSON файла через подключенную библиотеку json-simple-1.1.1.jar\n");
        var filename_jsom = "H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\09_AdvancedOOPFeatures\\homework_9.2\\Employees\\data\\staff.json";
        String data = Employee.GetDataFromFile( filename_jsom );
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse( data );
        for (Object item : array) {
            JSONObject jsonObject = (JSONObject) item;
            System.out.println( jsonObject.get( "name" ) );

        }
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        Employee currentEmp = (Employee) MyCodeForTest( staff, year );
        System.out.println("Сотрудник с максимальной заработной платой:" +currentEmp);
        return currentEmp;

    }

    //// Этот метод для экспериментов над потоками)
    //// Не знаю как именно скрыть этот код для того, чтобы не показывать его
///////////////////////////////////////////////////////////////// Experiments
    public static void MyCodeExec(int year) {

        var filename = "H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\09_AdvancedOOPFeatures\\homework_9.2\\Employees\\data\\staff.txt";
        var pathToFile = String.valueOf( Paths.get( filename ) );
        List<Employee> staff2 = Employee.loadStaffFromFile( pathToFile );

      //  String dateFormat = "yyyy";
        SimpleDateFormat formatForDate = new SimpleDateFormat( "yyyy" );

        staff2.forEach( System.out::println );
        System.out.println( staff2.stream().filter( s -> Integer.parseInt( formatForDate.format( s.getWorkStart() ) ) == year )
                .max( Comparator.comparing( Employee::getSalary ) ).get() );

    }

    public static Object MyCodeForTest(List<Employee> staff, int year) {

        String dateFormat = "yyyy";
        SimpleDateFormat formatForDate = new SimpleDateFormat( dateFormat );

        ///// Выводим изначальный список сотрудников используя стрим и его метод foEach
        staff.forEach( System.out::println );

        //// С помощью потока и метода фильтра filter находим всех  людей, которые пришли на работу в 2017 году
        //// для условия используем лямбда выражение и вызываем метод, которые получает дату начала работу
        //// прямо в лямбда выражении (Метод в классе Employee)
        //// Не забываем приводить значение даты в числовое значение с помощью метода парсинга parseInt в клаccе Integer
        //// Для этого получаем в лямбда выражении нужное нам условие и сравниваем с переданным параметром получивщиеся
        //// значение
        //// Чтобы найти максимальное значение заработной платы, используем так же метод в стриме, уже после того,
        //// как использовали .filter с названием .max ну а дальше просто получаем нужный нам объект и выводим в возврат
        return staff.stream().filter( s -> Integer.parseInt( formatForDate.format( s.getWorkStart() ) ) == year )
                .max( (s1, s2) -> s1.getSalary().compareTo( s2.getSalary() ) ).get();

        // Как видите, я здесь использовал лямбда выражение с методом compareTo(), получилось довольно изящно)))
    }

}