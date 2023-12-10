public class Operators implements Employee {

    private Company company;

    private double salary;
    private String name;


    public Operators() {

        this.name = "Operator";
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

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


