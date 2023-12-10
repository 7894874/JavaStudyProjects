import java.util.Map;
import java.util.Random;

public class Bank extends Thread {

    private Map<String, Account> accountsMap;
    private final Random random = new Random();
    private final static long limitOfSumToFraud = 50000;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {

        System.out.println("Сумма " + amount + " поступившая c " + fromAccountNum + " проверяется сумма в службе безопасности!");
        System.out.println("");

        Thread.sleep(1000);
        boolean currentBoolean = random.nextBoolean();

        if (currentBoolean) {
            System.out.println("Поздравляем! Проверка службой безопасности успешно пройдена!");
            System.out.println("");
        } else {
            System.out.println("Сумма " + amount +" не будет доставлена на счет "+toAccountNum+" по причине блокировки!");
            System.out.println("");
        }

        return currentBoolean;

    }

    public void setAccountsMap(Map<String, Account> accountsMap) {
        this.accountsMap = accountsMap;
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount)  throws InterruptedException {

        boolean passed;

        Account fromAccount = accountsMap.get(fromAccountNum);
        Account toAccount = accountsMap.get(toAccountNum);

        fromAccount.setQttOfTransfer(1);

        if (amount > limitOfSumToFraud) {
            passed = isFraud(fromAccountNum, toAccountNum, amount);

        } else passed = true;

      //  ReentrantLock lock = new ReentrantLock();
        if (!passed) {
            System.out.println("Служба безопасности не пропустила эту сумму, т.к." +
                            "транзакция оказалась подозрительной!");

     //       lock.lock();

        } else {

            System.out.println("Перевод с " + fromAccountNum + " на " + toAccountNum + " сумма " + amount);

            fromAccount.setMoney(-amount);
            toAccount.setMoney(amount);
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(Account accountObj) {
        return accountObj.getMoney();
    }

    public synchronized long getSumAllAccounts() {

        System.out.println("********************************************");

        System.out.println("Сумма остатков на счете на конец периода, $");
        long sumOfAllAccounts = 0;

        for (Map.Entry<String, Account> entry : accountsMap.entrySet()) {
            Account currentAccount = entry.getValue();

            sumOfAllAccounts = sumOfAllAccounts + currentAccount.getMoney();
            System.out.println("Количество операций по счету всего: " + currentAccount.getQttOfTransfer());
            System.out.println("Счет №" + entry.getKey() + " Сумма: " + currentAccount.getMoney());
        }

        return sumOfAllAccounts;

    }

    public Map<String, Account> getAccountsMap() {
        return accountsMap;
    }

    @Override
    public void run() {






    }
}
