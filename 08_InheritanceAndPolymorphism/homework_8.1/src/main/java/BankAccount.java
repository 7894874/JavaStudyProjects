import antlr.collections.List;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * Что нужно сделать
 * <p>
 * Выполните задание в проекте
 * <p>
 * 08_InheritanceAndPolymorphism/homework_8.1
 * <p>
 * В проекте найдите класс BankAccount и унаследованные от него классы CardAccount и DepositAccount.
 * <p>
 * Реализуйте методы классов, при необходимости переопределите методы в наследниках так,
 * чтобы выполнялись условия пополнения и снятия:
 * <p>
 * BankAccount — пополнение и списание происходит без комиссии.
 * Если передать в метод пополнения отрицательное значение, сумма на счёте не должна измениться.
 * При попытке снять большую сумму, чем есть на счёте, сумма не списывается со счёта, сумма на счёте не изменяется.
 * <p>
 * CardAccount — карточный счёт, в дополнение к условиям BankAccount — при
 * снятии денег должна взиматься комиссия 1% от суммы списания.
 * Пример: при попытке снять со счёта 100 рублей должен списаться 101 рубль.
 * <p>
 * DepositAccount — депозитный расчётный счёт,
 * в дополнение к условиям BankAccount — нельзя снимать деньги в течение одного месяца после последнего пополнения.
 * Переменную, в которой хранится дата последнего внесения, назовите lastIncome.
 * Тип переменной используйте Calendar или LocalDate.
 **/

public class BankAccount {

    private boolean successTransfer;

    private double bankAccount;
    private double myCardAccount;

    public BankAccount() {

    }

    public double getAmount() {
        return this.bankAccount;
    }

    public double getAmountOfMyNewAccount() {
        return this.myCardAccount;
    }

    public void put(double amountToPut) {

        if (amountToPut > 0) {
            this.bankAccount += amountToPut;
        }
    }

    public void take(double amountToTake) {

        if (this.bankAccount >= amountToTake) {
            this.bankAccount -= amountToTake;
        } else {

            System.out.println("Недостаточно средств!!!");

        }
    }

    boolean send(BankAccount receiver, double amount) {

        if (this.bankAccount >= amount) {
           // this.bankAccount = this.bankAccount - amount;
            take(amount);

            receiver.myCardAccount += amount;

            successTransfer = true;

        } else {

            System.out.println("Недостаточно средств для перевода!");

        }
        return successTransfer;
    }

    public boolean findNotDigitsFromString(String currentInputStr) {

        boolean restrictedSynbolsExists = false;

        try {
            ///// Используем регулярные выражения для поиска символьных значений в строке
            //// Используем конструкцию Try Catch
            Pattern pattern = Pattern.compile("[^0-9.]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(currentInputStr);
            while (matcher.find()) {
                restrictedSynbolsExists = true;
            }

            if (restrictedSynbolsExists) {
                System.out.println("В строке может быть введены только числовые значения!");
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Вы ввели некорректный символ!!");
            //System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return restrictedSynbolsExists;
    }
}


