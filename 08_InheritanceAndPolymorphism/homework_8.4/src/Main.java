import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Для демонстрации и тестирования работы ваших классов:
     * Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager,
     * 10 топ-менеджеров TopManager.
     * Распечатайте список из 10–15 самых высоких зарплат в компании.
     * Распечатайте список из 30 самых низких зарплат в компании.
     * Увольте 50% сотрудников.
     * Распечатайте список из 10–15 самых высоких зарплат в компании.
     * Распечатайте список из 30 самых низких зарплат в компании.
     **/

    public static void main(String[] args) {

        //// Создаем некий список потенциальных сотрудников (с неизвестной еще компанией и неизвестной зарплатой в этой компании)
        EmpCreation newEmployee = new EmpCreation();
        //// Допустим будет требоваться какой либо компании в штат именно это количество сотрудников
        //// Создаем их в произвольном классе EmpCreation и помещаем в нужный нам список с указанными
        //// переменными класса (т.е. полями). Это: должность, имя компании, зарплата
        newEmployee.CreateNewEmployee( 180, 80, 10 );
        List<Employee> currentListOfEmployee = newEmployee.getListOfEmp();

        //// Создаем новую компанию, назовем ее "Atlas"
        //// в конструкторе указываем доход имя компании доход генерируем его автоматически
        Company companyAtlas = new Company( "Atlas" );
        //// После того, как создали компанию, передаем список потенциальных кандидатов сотрудников
        //// для приема на работу передаем ссылку на объект Company
        companyAtlas.hireAll( currentListOfEmployee, companyAtlas );

        //// Полная численность компании
        companyAtlas.TotalEmployeeInCompany( currentListOfEmployee, "Atlas" );

        //// Самые 10 топ по зарплатам
        companyAtlas.getTopSalaryStaff( currentListOfEmployee, 10, companyAtlas.getNameOfCompony() );
        //// Самые 30 должностей человек с низкими зарплатами
        companyAtlas.getLowestSalaryStaff( currentListOfEmployee, 30, companyAtlas.getNameOfCompony() );

        /**
         Павел, если удаляю из списка более 90 процентов сотрудников,
         тогда выдается ошибка выхода за границы индекса массива

         companyAtlas.fire(currentListOfEmployee, 90, "Atlas", true);

         at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
         **/

        //// Если не удаляю из списка или удаляю но только 50 процентов сотрудников, тогда все ок
        companyAtlas.fire( currentListOfEmployee, 50, "Atlas", false );

        //// Аналогично...
        String companyName1 = "Microsoft";
        Company companyMicrosoft = new Company( companyName1 );
        companyMicrosoft.hireAll( currentListOfEmployee, companyMicrosoft );
        companyMicrosoft.TotalEmployeeInCompany( currentListOfEmployee, companyName1 );
        companyMicrosoft.getTopSalaryStaff( currentListOfEmployee, 11, companyMicrosoft.getNameOfCompony() );
        companyMicrosoft.getLowestSalaryStaff( currentListOfEmployee, 33, companyMicrosoft.getNameOfCompony() );

        String companyName2 = "CCM";
        Company companyCCM = new Company( companyName2 );
        companyCCM.hireAll( currentListOfEmployee, companyCCM );
        companyCCM.TotalEmployeeInCompany( currentListOfEmployee, companyName2 );
        companyCCM.getTopSalaryStaff( currentListOfEmployee, 3, companyCCM.getNameOfCompony() );
        companyCCM.getLowestSalaryStaff( currentListOfEmployee, 7, companyCCM.getNameOfCompony() );


        //// А если хотим уволить более 90 процентов сотрудников, тогда выдается ошибка
        //  company.fire(90);

    }
}
