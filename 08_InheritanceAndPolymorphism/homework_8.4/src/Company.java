import javax.lang.model.type.NullType;
import java.text.DecimalFormat;
import java.util.*;

public class Company {

    /**
     * Цель задания
     * <p>
     * Научиться работать с интерфейсами, абстрактными классами и взаимодействием классов.
     * <p>
     * Что нужно сделать
     * <p>
     * создать новый проект в папке 08_InheritanceAndPolymorphism/homework_8.4 и написать все требуемые классы
     * 1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
     * <p>
     * найм одного сотрудника — hire(),
     * найм списка сотрудников – hireAll(),
     * увольнение сотрудника – fire(),
     * получение значения дохода компании – getIncome().
     * Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.
     * <p>
     * 2. Создайте два метода, возвращающие список указанной длины (count).
     * Они должны содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
     * <p>
     * List<Employee> getTopSalaryStaff(int count),
     * List<Employee> getLowestSalaryStaff(int count).
     * 3. Создайте классы сотрудников с информацией о зарплатах и условиями начисления зарплаты:
     * <p>
     * Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
     * Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
     * TopManager — зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы,
     * если доход компании более 10 млн рублей.
     * Operator — зарплата складывается только из фиксированной части.
     * Каждый класс сотрудника должен имплементировать интерфейс Employee.
     * В интерфейсе Employee должен быть объявлен метод, возвращающий зарплату сотрудника:
     * <p>
     * getMonthSalary()
     * Аргументы и возвращаемое значение метода выберите в соответствии с логикой начисления зарплат.
     * В интерфейсе при необходимости объявляйте необходимые методы.
     * <p>
     * <p>
     * Для демонстрации и тестирования работы ваших классов:
     * <p>
     * Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager,
     * 10 топ-менеджеров TopManager.
     * Распечатайте список из 10–15 самых высоких зарплат в компании.
     * Распечатайте список из 30 самых низких зарплат в компании.
     * Увольте 50% сотрудников.
     * Распечатайте список из 10–15 самых высоких зарплат в компании.
     * Распечатайте список из 30 самых низких зарплат в компании.
     * <p>
     * Примеры вывода списка зарплат
     * <p>
     * Список из пяти зарплат по убыванию:
     * <p>
     * 230 000 руб.
     * 178 000 руб.
     * 165 870 руб.
     * 123 000 руб.
     * 117 900 руб.
     * <p>
     * <p>
     * <p>
     * Рекомендации
     * <p>
     * Сделайте возможным создавать разные экземпляры компании со своим списком сотрудников и доходом.
     * Чтобы получить данные компании внутри класса сотрудника, настройте хранение ссылки на Company и передавайте объект Company с помощью конструктора или сеттера.
     * Учтите, в методы получения списков зарплат могут передаваться значения count, превышающие количество сотрудников в компании, или отрицательные.
     * <p>
     * ----- Ничего не понял из вышеописанного!!! Зачем получать данные компании внутри класса сотрудника?
     * ----- Зачем настраивать хранение ссылки на Company и передавать объект Company с помощью конструктора или сеттера?
     * ----- Каким образом должны передаваться параметры count если предполагается, что они жестко защиты в программе? (Нужно сделать отдельный интерфейс ввода?)
     * ----- Туманно, сделал так, как понял...
     * <p>
     * Критерии оценки
     * <p>
     * «Зачёт» — программа выполняет все требования.
     * «Незачёт» — задание не выполнено.
     ***/

//    public static final int COUNTOFOPERTOTRS = 180;
//    public static final int COUNTOFMANAGERS = 80;
//    public static final int COUNTOFTOPMANAGERS = 10;

    private static final int limitOfExtraBonus = 10000000;

    public List<Employee> listOfEmployee = new ArrayList<>();

    private double componyIncome;
    private String nameOfCompony;

    ////
    public Company(String name) {

        ///// Название компании в конструкторе компании
        this.nameOfCompony = name;
        //// Доход компании получаем в конструкторе компании
        this.componyIncome = generateCompanytIncome();

    }


    public String getNameOfCompony() {
        return nameOfCompony;
    }

    public void hire(Employee currentEmployee, Company company) {

        double currentEmpMonthSalary = currentEmployee.getMonthSalary();
        double currentCompanyIncome = company.getComponyIncome();

        DecimalFormat dF = new DecimalFormat( "#.#" );

        if (currentEmployee.getName().matches( "Operator" )) {

            double salary = Double.parseDouble( dF.format( currentEmpMonthSalary ) );

            currentEmployee.setCompany( company );
            currentEmployee.setSalary( salary );
            System.out.println( "Нанимаем работника на должность " + currentEmployee.getName() + " в команию " + company.getNameOfCompony() + " с зарплатой " + salary + " руб." );

        } else if (currentEmployee.getName().matches( "Manager" )) {

            double salary = (currentEmpMonthSalary * 1.05);

            salary = Double.parseDouble( dF.format( salary ) );

            currentEmployee.setCompany( company );
            currentEmployee.setSalary( salary );
            System.out.println( "Нанимаем сотрудника на должность " + currentEmployee.getName() + " в команию " + company.getNameOfCompony() + " с зарплатой " + salary + " руб." );

        } else if (currentEmployee.getName().matches( "TopManager" )) {

            double salary;

            if (currentCompanyIncome > limitOfExtraBonus) {
                salary = (currentEmpMonthSalary + ((currentEmpMonthSalary * 150) / 100));
            } else {
                salary = (currentEmpMonthSalary);
            }

            double salaryFormatted = Double.parseDouble( dF.format( salary ) );

            currentEmployee.setCompany( company );
            currentEmployee.setSalary( salaryFormatted );
            System.out.println( "Нанимаем " + currentEmployee.getName() + " в команию " + company.getNameOfCompony() + " с зарплатой " + salaryFormatted + " руб." );

        }
    }

    public double getComponyIncome() {
        return componyIncome;
    }

    //// Нанимаем сотрудников в команию и доабвлем их в её список
    public void hireAll(List<Employee> currentListOfEmployee, Company currentCompony) {

        System.out.println( "**************** Нанимаем работников! *********************" );

        for (Employee strCurrentEmployee : currentListOfEmployee) {

            hire( strCurrentEmployee, currentCompony );
        }
    }

    //// Увольяем сотрудников используем переданное значение процента сотрудников к увольнению через параметр
    public void fire(List<Employee> currentListOfEmployee, int percents, String nameOfCompony, boolean removeFromList) {
//        System.out.println( "********************* Firing of " + percents + "% of Employee ********************** " );
//
        int qttOfFireEmployee = currentListOfEmployee.size() * percents / 100;
//
        for (int i = 0; i < qttOfFireEmployee; i++) {
            Employee currentEmp = currentListOfEmployee.get( i );
            //  RemoveFromList( currentEmp );
            System.out.println( "Увольняем из компании " + nameOfCompony + " " + currentListOfEmployee.get( i ).getName() );
            // currentListOfEmployee.remove( currentEmp );

            //// Увольнением считаем отсутствие ссылки на объект Company в списке сотрудников
            currentEmp.setCompany( new Company( "" ) );
            currentEmp.setSalary( 0 );
            if (removeFromList) {
                currentListOfEmployee.remove( currentEmp );
            }


        }
    }


    protected double generateCompanytIncome() {
        return (int) (9000000 + 2000000. * Math.random());
    }

    public List<Employee> getLowestSalaryStaff(List<Employee> currentListOfEmployee, int count, String company) {

        List<Employee> list2 = new ArrayList<>();

        Comparator employeeSalaryComparator = new EmplayeeSalaryComparator();
        Collections.sort( currentListOfEmployee, employeeSalaryComparator );

        for (int i = 0; i < count; i++) {
            Employee lowSalaryList = currentListOfEmployee.get( i );
            list2.add( lowSalaryList );
        }

        PrintCurrentList( list2, false, company );

        return (list2);

    }

    public List<Employee> getTopSalaryStaff(List<Employee> currentListOfEmployee, int count, String companyName) {

        List<Employee> list2 = new ArrayList<>();

        if (componyIncome < limitOfExtraBonus) {
            System.out.println( "Компания заработала мало денег, ТОП менеджеры не получат своих бонусов!" );
        } else {
            System.out.println( "ТОП менеджеры на коне, они получат больше всех денег!" );
        }
        // System.out.println("Несортированные значения зарплат работников!" );
        for (int i = 0; i < currentListOfEmployee.size(); i++) {
            Collections.sort( currentListOfEmployee, new SortBySalaryTopBefore() );
        }

        for (int i = 0; i < count; i++) {
            Employee topSalaryList = currentListOfEmployee.get( i );
            list2.add( topSalaryList );
        }

        PrintCurrentList( list2, true, companyName );

        return (list2);

    }

    public void PrintCurrentList(List<Employee> list2, boolean highSalary, String companyName) {

        int place = 1;
        if (highSalary) {

            System.out.println( "**************** TOP " + list2.size() + " highest salaries! ********************" );

            for (Employee current : list2) {
                System.out.println( "Место №" + place++ + " по зарплате в компании " + companyName + " у работника в должности:" + current.getName() + " " + current.getSalary() + " руб." );
            }
        } else {

            System.out.println( "**************** TOP " + list2.size() + " lowest salaries! ********************" );

            for (Employee current : list2) {
                System.out.println( "Одна из самых низких зарплат у:" + current.getName() + " " + current.getSalary() + " руб." );
            }
        }
    }

    public void TotalEmployeeInCompany(List<Employee> currentListOfEmployee, String nameOfCompony) {

        System.out.println( "***************************************************************************************" );
        System.out.println( "На данный момент численность работников в компании " + nameOfCompony + " составляет: " + currentListOfEmployee.size() + " человек." );
        System.out.println( "***************************************************************************************" );
    }

    //// Делаем сортировку через компаратор, для этого импрементируем интерфейс компаратора в класс сортировки
    class SortBySalaryTopBefore implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return (int) (b.getSalary() - a.getSalary());
        }
    }

    class SortBySalaryLowestSalary implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return (int) (a.getSalary() - b.getSalary());
        }


    }

}
