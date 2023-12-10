import java.util.AbstractList;
import java.util.Comparator;

public class EmplayeeSalaryComparator implements Comparator<Employee> {

    /// Реализовываем компаратор
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}

