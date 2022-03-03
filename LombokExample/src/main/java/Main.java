import java.util.Date;

public class Main {


    public static void main(String[] args) {

        Employee employee = new Employee( "Василий Петров", 7500, new Date() );
        System.out.println(employee);
       // System.out.println(employee.getName());
        //  employee.setName( null );
        //// Можно в самом сеттере сразу с помощью аннотации Lombok задать условие на исключение NullPointerExeption
        // employee.setSalary( null );
        System.out.println();
        /// Можно вместо конструктора которые описывали в классе, указать
        /// аннотацию @AllArgConstructor
        /// Пример в Main

        ///// Резюме:
        //// Lombok -  позволяет сильно упростить код т.е. его написание

    }
}
