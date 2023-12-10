/**

 Задание выполняйте в проекте

 12_ExceptionsDebuggingAndTesting/homework_12.1/ConsoleCustomerList

 Пропишите в проекте ConsoleCustomerList в классе CustomerStorage все возможные варианты защиты от
 некорректных данных и преждевременного завершения метода добавления addCustomer().
 Программа должна выбрасывать исключения (Exception) при неверном:
 количестве компонентов в переданной строке с данными,
 формате номера телефона,
 формате email.

 **/

import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            try {
                if (tokens[0].equals( "add" )) {
                    executor.addCustomer( tokens[1] );
                } else if (tokens[0].equals( "list" )) {
                    executor.listCustomers();
                } else if (tokens[0].equals( "remove" )) {
                    executor.removeCustomer( tokens[1] );
                } else if (tokens[0].equals( "count" )) {
                    System.out.println( "There are " + executor.getCount() + " customers" );
                } else if (tokens[0].equals( "help" )) {
                    System.out.println( helpText );
                } else {
                    System.out.println( COMMAND_ERROR );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
