import java.util.AbstractList;

public class TopManagers implements Employee {

    private double salary;

    private static final int limitOfExtraBonus = 10000000;

    String name;

    private Company company;


    public TopManagers(String name) {

        this.name = name;
        System.out.println( "Создаем " + this.name );

    }

    public int getMonthSalary() {
        return (int) (115000 + 140000 * Math.random());
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
