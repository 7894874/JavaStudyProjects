import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

////        Тип счёта,Номер счета,Валюта,Дата операции,Референс проводки,Описание операции,Приход,Расход
////        Текущий счёт,40817813206170024534,RUR,31.05.17,CRD_1U34U7,548673++++++1028    809216  /RU/CARD2CARD ALFA_MOBILE>MOSCOW          31.05.17 31.05.17 1500.00       RUR MCC6536,1500,0
////        Текущий счёт,40817813206170024534,RUR,31.05.17,CRD_5XK5TM,548673++++++1028    21708201\RUS\MOSCOW\Ryabin\KUSCHAVEL              31.05.17 29.05.17       300.00  RUR (Apple Pay-7666) MCC5814,0,300

public class StatementOfExpensesAndIncome {

    //// Создаем переменные класса
    private String accountsType;
    private String numberOfAccount;
    private String currency;
    private Date dateOfOperation;
    private String referenceOfTransaction;
    private String descriptionOfTransaction;
    private Double income;
    private Double expence;
    private String organization;

    //// Создаем конструктор объекта записи дохода или расхода
    public StatementOfExpensesAndIncome(String accountsType,
                                        String numberOfAccount,
                                        String currency,
                                        Date dateOfOperation,
                                        String referenceOfTransaction,
                                        String descriptionOfTransaction,
                                        Double income,
                                        Double expence,
                                        String organization) {

        this.accountsType = accountsType;
        this.numberOfAccount = numberOfAccount;
        this.currency = currency;
        this.dateOfOperation = dateOfOperation;
        this.referenceOfTransaction = referenceOfTransaction;
        this.descriptionOfTransaction = descriptionOfTransaction;
        this.income = income;
        this.expence = expence;
        this.organization = organization;
    }

    public Double getExpense() {
        return expence;
    }

    //// Создаем геттеры и сеттеры Alt+Insert (памятка для себя)
    public String getAccountsType() {
        return accountsType;
    }

    public String getOrganization() {
        return organization;
    }

    public void setAccountsType(String accountsType) {
        this.accountsType = accountsType;
    }

    public String getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(String numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public String getReferenceOfTransaction() {
        return referenceOfTransaction;
    }

    public void setReferenceOfTransaction(String referenceOfTransaction) {
        this.referenceOfTransaction = referenceOfTransaction;
    }

    public String getDescriptionOfTransaction() {
        return descriptionOfTransaction;
    }

    public void setDescriptionOfTransaction(String descriptionOfTransaction) {
        this.descriptionOfTransaction = descriptionOfTransaction;
    }

    public Double getIncome() {
        return this.income;
    }

    public static List<StatementOfExpensesAndIncome> loadStatementOfExpensesAndIncome(String path) {

        String dateFormat = "dd.MM.yyyy";
        List<StatementOfExpensesAndIncome> accountList = new ArrayList<>();

        try {

            List<String> lines = Files.readAllLines( Paths.get( path ) );

            int nomberOfLine = 0;
            for (String line : lines) {

                nomberOfLine++;
                if (nomberOfLine == 1) continue;

                String[] fragments = line.split( (",") );
                System.out.println( "Линия " + line );

                if (fragments.length == 9) {
                    if (fragments[5].contains( "income" )) {
                        accountList.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                                new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                                fragments[4], fragments[5],
                                Double.parseDouble( fragments[6].replace( "\"", "" ) + "." + fragments[7].replace( "\"", "" ) ),
                                0.0, fragments[5].split( "    " )[1] ) );
                    } else {
                        accountList.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                                new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                                fragments[4], fragments[5], 0.0, Double.parseDouble( fragments[7].replace( "\"", "" ) + "." + fragments[8].replace( "\"", "" ) )
                                , fragments[5].split( "    " )[1] ) );
                    }
                } else {
                    accountList.add( new StatementOfExpensesAndIncome( fragments[0], fragments[1], fragments[2],
                            new SimpleDateFormat( dateFormat ).parse( fragments[3] ),
                            fragments[4], fragments[5],
                            Double.parseDouble( fragments[6].replace( "\"", "" ) ),
                            Double.parseDouble( fragments[7].replace( "\"", "" ) ), fragments[5].split( "    " )[1] ) );
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return accountList;
    }

    //// Для удобства загоним все данные в структуру и далее будем с ней работать
    public static HashMap<String, Double> findStmWithIncomesAndExp(List<StatementOfExpensesAndIncome> currentAccountsLogList) {

        String dateFormat = "yyyy";
        SimpleDateFormat formatForDate = new SimpleDateFormat( dateFormat );

        currentAccountsLogList.stream()
                .filter( o -> o.getExpense() > 0 )
                .forEach( s -> System.out.println( s.getExpense() + " " + s.getAccountsType() + " " + s.getExpense() ) );

        double sumOfIncome = currentAccountsLogList.stream()
                .filter( o -> o.getIncome() > 0 )
                .mapToDouble( o -> o.getIncome() )
                .sum();

        double sumOfExpence = currentAccountsLogList.stream()
                .filter( o -> o.getExpense() > 0 )                       //// фильтр по положительным расходным данным
                .mapToDouble( StatementOfExpensesAndIncome::getExpense ) //// выводим в Мапу данные Double для последующего суммирования
                .sum();                                                  //// Суммируем данные

        HashMap<String, Double> sumsOfIncAndExpences = new HashMap<>();
        sumsOfIncAndExpences.put( "sumOfIncomeKey", sumOfIncome );
        sumsOfIncAndExpences.put( "sumOfExpenseKey", sumOfExpence );

        return sumsOfIncAndExpences;

    }

//    public static Map<String, Double> getFromOrganizationsExpense(List<StatementOfExpensesAndIncome> currentAccountsLogList) {
//
//        System.out.println( "==================================================================" );
//        System.out.println( "Разбивка по организациям" );
//        currentAccountsLogList.stream()
//                .filter( o -> o.getExpense() > 0 )
//                .forEach( s -> System.out.println( "Организация: " + s.getOrganization() + "                Расход: " + s.getExpense() ) );
//        System.out.println( "====================================================================" );
//
//        Map<String, Double> sumsExpencesOrgHashMap = new HashMap<>();
//
//        Double priviosMean = 0.0;
//        currentAccountsLogList.stream()
//                .filter( o -> o.getExpense() > 0 )
//                .forEach( s -> {
//                    if (sumsExpencesOrgHashMap.containsKey( s.getOrganization() )) {
//                        sumsExpencesOrgHashMap.put( s.getOrganization(), priviosMean + s.getExpense() );
//                    } else {
//                        sumsExpencesOrgHashMap.put( s.getOrganization(), s.getExpense() );
//                    }
//                } );
//
//        return sumsExpencesOrgHashMap;
//
//    }

    public static String toString(Double incomeSum, Double expencesSum) {

        String summOfIncomeStr = (incomeSum > 0) ? "Сумма доходов составила: " + incomeSum : "Сумма доходов не рассчитана";
        String summOfExpencesStr = (expencesSum > 0) ? "Сумма расходов составила: " + expencesSum : "Сумма расходов рассчитана";

        String resultString = "\n============- S u m m a r y -===============\n" + summOfIncomeStr + " \n" + summOfExpencesStr +" \n" +" ******************************************";

        return resultString;

    }

    public static HashMap<String, Double> treeOfStatementOfExpensesAndIncome(List<StatementOfExpensesAndIncome> currentAccountsLogList) {

        TreeMap<String, Double> treeMapOrganizations = new TreeMap<>();
        HashMap<String, Double> finalHashMap = new HashMap<>();

        /// Добавляем в тримэп значения ключей и значений, для того, чтобы сгруппировать их по организации
        /// (Используем свойство TreeMap)
        currentAccountsLogList.stream()
                .filter( o -> o.getExpense() > 0 )
                .forEach( s -> treeMapOrganizations.put( s.getOrganization(), s.getExpense() ) );

        //// Создаем итератор для подсчета значений по каждой организации
        //// Перебираем получившийся TreeMap
            Iterator<Map.Entry<String, Double>> entries = treeMapOrganizations.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Double> entry = entries.next();

            //// Считаем сумму затрат по каждой организации из treeMap Лямбдой выражением
            double sumOfExpanse = currentAccountsLogList.stream()
                    .filter( o -> o.getOrganization().equals( entry.getKey() ) )
                    .mapToDouble( o -> o.getExpense() )
                    .sum();

            //// Помещаем значения ключей и значений в окончательную HashMap
            finalHashMap.put( entry.getKey(), sumOfExpanse );

        }

        return finalHashMap;

    }
}






