import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         Дополнительное задание*

         Цель задания
         Потренироваться в написании взаимодействия между классами.

         Что нужно сделать
         Напишите метод в классе BankAccount:

         boolean send(BankAccount receiver, double amount)
         для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.

         - 💡 вы можете добавить возврат boolena у метода take() для отслеживания
         , успешно ли списались деньги (true) или нет (false) **/

        ///// Создаем объект из класса
        BankAccount bankAccount = new BankAccount();


        Scanner scanner = new Scanner(System.in);

        //// Количество операций для определения верности количества переводов
        int qtOfOperations = 0;

        while (true) {

            System.out.println("Введите сумму пополнения:, $");
            String input1 = scanner.nextLine();

            qtOfOperations++;

            if (!bankAccount.findNotDigitsFromString(input1)) {

                //// Переводим строку которую ввели в double
                double currentAmountToPut = Double.parseDouble(input1);
                bankAccount.put(currentAmountToPut); /// Это в долларах)

            }

            System.out.println("Всего на депозитном счете:" + bankAccount.getAmount() + "$");

            System.out.println("Введите сумму перевода!");
            String input2 = scanner.nextLine();

            if (!bankAccount.findNotDigitsFromString(input2)) {

                double currentAmountTransfer = Double.parseDouble(input2);
                boolean successTransfer = bankAccount.send(bankAccount, currentAmountTransfer);
                if (successTransfer) {
                    System.out.println("Денежные средства в размере " + currentAmountTransfer + "$ успешно переведены!\n" +
                            "На вашем персональном счете:" + bankAccount.getAmountOfMyNewAccount() + "$\n" +
                            "Всего денежных средств на депозитарном счете осталось: " + bankAccount.getAmount() + "$\n");

                    if (qtOfOperations > 0) {
                        System.out.println("\t\t\t\tВыполнить еще одну операцию? \n(Type 'no' for break. Press 'Enter' button to continue.");

                        String input3 = scanner.nextLine();

                        if (input3.equals("no")) {
                            System.out.println("*************** See you next time... ********************************");
                            return;
                        }
                    }
                } else {
                    System.out.println("Денежные средства не переведены!");
                }
            }
        }
    }
}




