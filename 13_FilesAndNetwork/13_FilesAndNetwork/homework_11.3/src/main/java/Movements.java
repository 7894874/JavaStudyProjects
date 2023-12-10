import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public ArrayList<StatementOfExpensesAndIncome> account = new ArrayList<>();

    public Movements(String pathMovementsCsv) {

        String dateFormat = "dd.MM.yyyy";

        try {

            List<String> lines = Files.readAllLines( Paths.get( pathMovementsCsv ) );

            int nomberOfLine = 0;
            for (String line : lines) {

                nomberOfLine++;
                if (nomberOfLine == 1) continue;

                String[] fragments = line.split( (",") );
                System.out.println( "Линия " + line );

                if (fragments.length == 9) {
                    if (fragments[5].contains( "income" )) {
                        account.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                                new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                                fragments[4], fragments[5],
                                Double.parseDouble( fragments[6].replace( "\"", "" ) + "." + fragments[7].replace( "\"", "" ) ),
                                0.0, fragments[5].split( "    " )[1] ) );
                    } else {
                        account.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                                new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                                fragments[4], fragments[5], 0.0, Double.parseDouble( fragments[7].replace( "\"", "" ) + "." + fragments[8].replace( "\"", "" ) )
                                , fragments[5].split( "    " )[1] ) );
                    }
                } else {
                    account.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                            new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                            fragments[4], fragments[5],
                            Double.parseDouble( fragments[6].replace( "\"", "" ) ),
                            Double.parseDouble( fragments[7].replace( "\"", "" ) ), fragments[5].split( "    " )[1] ) );
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StatementOfExpensesAndIncome> getListOfFile() {

        return this.account;
    }

    public double getExpenseSum() {

        double sumOfExpence = account.stream()
                .filter( o -> o.getExpense() > 0 )                       //// фильтр по положительным расходным данным
                .mapToDouble( StatementOfExpensesAndIncome::getExpense ) //// выводим в Мапу данные Double для последующего суммирования
                .sum();

        System.out.println( sumOfExpence );
        return sumOfExpence;

    }

    public double getIncomeSum() {

        double sumOfIncome = account.stream()
                .filter( o -> o.getIncome() > 0 )
                .mapToDouble( o -> o.getIncome() )
                .sum();

        System.out.println( sumOfIncome );
        return sumOfIncome;
    }
}

