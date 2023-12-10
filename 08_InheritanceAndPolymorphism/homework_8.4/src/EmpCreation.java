import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class EmpCreation {

    public List<Employee> listOfEmployee = new ArrayList<>();

    public List<Employee> CreateNewEmployee(int qttOfOperators,
                                            int qttOfManagers,
                                            int qttOfTopManagers) {

        for (int i = 0; i < qttOfOperators; i++) {

            Operators currentEmpl = new Operators();

            listOfEmployee.add( currentEmpl );
        }

        for (int i = 0; i < qttOfManagers; i++) {
            Managers managers = new Managers( "Manager" );

            listOfEmployee.add( managers );
        }

        for (int i = 0; i < qttOfTopManagers; i++) {
            //  TopManagers topManagers = new TopManagers("TopManager", companyIncome);
            TopManagers topManagers = new TopManagers( "TopManager" );
            //   topManagers.CreateNewEmployee(  );

            listOfEmployee.add( topManagers );
        }

        return listOfEmployee;

    }

    public List<Employee> getListOfEmp() {

        return listOfEmployee;

    }


}
