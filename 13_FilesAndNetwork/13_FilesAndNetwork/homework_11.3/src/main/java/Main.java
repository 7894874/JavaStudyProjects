import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Цель задания
 * <p>
 * Научиться читать файл CSV и анализировать его.
 * <p>
 * Что нужно сделать
 * <p>
 * Задание выполняйте в проекте
 * 13_FilesAndNetwork/homework_13.3
 * <p>
 * <p>
 * Напишите код, который будет читать файл csv банковской выписки movementsList.csv и парсить полученные строки.
 * Путь к файлу выписки храните в константе. Получение суммы расхода и дохода по всем операциями реализуйте
 * в классе Movements, в методах getExpenseSum() и getIncomeSum() соответственно.
 * Проверьте парсинг и получение сумм с помощью тестов.
 * Класс Movements можете дополнять необходимыми методами для реализации решения.
 * Код должен выводить сводную информацию по этой выписке: общий приход, общий расход и разбивку расходов.
 * Примеры работы программы
 * <p>
 * Сумма расходов: 398 563.39 руб.
 * Сумма доходов: 289 890.06 руб.
 * <p>
 * Суммы расходов по организациям:
 * RUSMOSKVA56  SHLOVE REPUBLIC        1 081.53 руб.
 * RUSMOSCOW42 SHCL ETOILE                     126.34 руб.
 * RUSPUSHKINO105ZOOMAGAZIN 4             217.65 руб.
 * <p>
 * <p>
 * Рекомендации
 * <p>
 * Попробуйте представить одну запись выписки как объект, опишите его класс.
 * При парсинге создавайте объекты из записи и работайте с ними.
 */


public class Main {

    private static double totalSumOfExpanse;

    public static void main(String[] args) {

        String CSV_FILENAME = String.valueOf( Path.of( Paths.get( "13_FilesAndNetwork/13_FilesAndNetwork/homework_11.3/src/main/files/movementList.csv" ).toAbsolutePath().toString() ) );

        /////////// Проверка алгоритма для тестов
        Movements movements = new Movements( CSV_FILENAME );
        double sumOfIncomeTest = movements.getIncomeSum();
        double sumOfExpencesTest = movements.getExpenseSum();
        System.out.println( "Сумма istOfFile " + sumOfIncomeTest + " " + " Сумма расходов " + sumOfExpencesTest );

        /////////// Помещаем все в List
        List<StatementOfExpensesAndIncome> currentAccountsLogList = StatementOfExpensesAndIncome.
                loadStatementOfExpensesAndIncome( CSV_FILENAME );

        HashMap<String, Double> dateIncomeExpense = StatementOfExpensesAndIncome.findStmWithIncomesAndExp( currentAccountsLogList );

        //// Для удобства вывода общих итогов задействуем HashMap
        Double sumOfIncome = dateIncomeExpense.get( "sumOfIncomeKey" );
        Double sumOfExpenceKey = dateIncomeExpense.get( "sumOfExpenseKey" );

        //// Выводим итоговые значения
        System.out.println( StatementOfExpensesAndIncome.toString( sumOfIncome, sumOfExpenceKey ) );

        //// Для группировки по организациям, задействуем TreeMap и HashMap, получаем
        // результирующий, для удобного вывода сгруппированных значений HashMap
        Map currentMap = StatementOfExpensesAndIncome.treeOfStatementOfExpensesAndIncome( currentAccountsLogList );

        currentMap.forEach( (keyOfHashMap, valueOfHashMap) -> {

            totalSumOfExpanse = totalSumOfExpanse + (Double) valueOfHashMap;
            String currentOrganozation = (String) keyOfHashMap;
            System.out.println( "Hash of organization is: " + keyOfHashMap.hashCode() + "; Organization: " + currentOrganozation + " sumOfExpanse: " + valueOfHashMap );

        } );

        ///// Наслаждаемся выводом значений из структур данных...
        System.out.println( "*****************************************************************" );
        System.out.println( "Final chek of Expanse Sum: " + totalSumOfExpanse );

    }
}



