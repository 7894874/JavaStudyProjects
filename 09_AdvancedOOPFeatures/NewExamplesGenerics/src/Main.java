import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static final String STAFF_TXT = "H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\09_AdvancedOOPFeatures\\NewExamplesGenerics\\data\\staff.txt";


    public static void main(String[] args) {

        //     ArrayList<Employee> staff = Employee.loadStaffFromFile( STAFF_TXT );
      //  sortBySalaryAndAlphabet( staff );

        //// Получаем список сотрудников из файла
        ArrayList<Employee> staff = (ArrayList<Employee>) Employee.loadStaffFromFile( STAFF_TXT );
        //// Находим с помощью стримов и их методов сотрудника с максимальной заработной платой
     //   Employee employeeMaxSalary = findEmployeeWithHighestSalary( staff, 2017 );

        LRUCash<Employee> cache = new LRUCash<>( 3 );
        for (Employee employee : staff ) {
            cache.addElement( employee );
        }

        //  () -> cache.addElement( Employee : staff );

      cache.getAllElements().forEach( System.out::println );

    //    SortByMyMethod();


     //   new Thread(() -> System.out.println("Hello world!")).start();


     }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {

        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        //// Способ сортировки с лямбда выражением (1)
        staff.sort( Comparator.comparing( Employee::getSalary ).thenComparing( Employee::getName ) );
        //// Способ сортировки с лямбда выражением (2)
        staff.sort( Comparator.comparing( (Employee o) -> o.getSalary() ).thenComparing( (Employee p) -> p.getName() ) );
        //// Вывод на печать с помощью оператора forEach
        staff.forEach( System.out::println );

      //  System.out.println( staff.toString() );

        SortByMyMethod currentSorting = new SortByMyMethod();
        currentSorting.SortByMyMethod();
        currentSorting.getArrayAfterSorting();


    }
}