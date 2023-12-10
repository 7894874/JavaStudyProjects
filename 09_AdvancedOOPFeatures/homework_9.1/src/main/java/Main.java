import java.util.Comparator;
import java.util.List;


public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {

        List<Employee> staff = Employee.loadStaffFromFile( STAFF_TXT );
        sortBySalaryAndAlphabet( staff );

    //    SortByMyMethod();


        new Thread(() -> System.out.println("Hello world!")).start();


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