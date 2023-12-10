import java.util.HashMap;

public class Loader {

    public static void main(String[] args) throws InterruptedException {

        /** Цель задания Научиться работать с synchronized блоками и избегать ситуации deadlock.

         Условие задания

         Проект Transactions в директории модуля Multithreading.

         В банке (класс Bank) есть счета (класс Account) с двумя полями — money и accNumber.
         Все счета хранятся внутри банка. Множество клиентов банка могут одновременно переводить деньги
         между счетами и запрашивать баланс по своему счёту. Всё происходит в highly concurrent (многопоточной) среде.
         При этом транзакции на суммы > 50000 отправляются на проверку в службу безопасности.
         Можно считать, что таких транзакций не более 5% от всех.
         За проверку отвечает отдельный и уже реализованный метод Bank.isFraud().
         Служба безопасности не может обрабатывать более одной транзакции одновременно. Проверка занимает 1000 мс.
         Если служба безопасности обнаружила мошенничество, необходимо заблокировать оба счёта,
         то есть запретить любые изменения остатков в дальнейшем.

         Что нужно сделать
         Создайте метод transfer() класса Bank, который переводит деньги с одного счёта на другой.
         Если сумма транзакции > 50000 — транзакция отправляется на проверку службе безопасности: вызывается метод isFraud().
         Если возвращается true, то счета блокируются (как – на ваше усмотрение).
         Создайте метод getBalance класса Bank, который возвращает остаток на счёте по переданной строке номера аккаунта.

         Рекомендации
         Для решения задачи вы можете дорабатывать классы Account и Bank как угодно.
         Дополнительно создайте тест (или набор тестов) для эмуляции реальной работы этих двух классов и проверки системы.
         Проверяйте сумму на банковских счетах до запуска транзакций и после завершения — сумма в банке не должна измениться.
         Удостоверьтесь, что ваша программа работает в многопоточном режиме. Для этого можете использовать утилиту visualVM. **/

        Account account1 = new Account();
        account1.setAccNumber("acc_1");
        account1.setMoney(10000);


        Account account2 = new Account();
        ;
        account2.setAccNumber("acc_2");
        account2.setMoney(20000);


        Bank currentBank = new Bank();
        System.out.println("**************************************");
        System.out.println("Остатки на счете на начало периода, $");
        System.out.println("Счет №" + account1.getAccNumber() + ": " + currentBank.getBalance(account1));
        System.out.println("Счет №" + account2.getAccNumber() + ": " + currentBank.getBalance(account2));

        // Map curMap;
        String Account1ID = account1.getAccNumber();
        String Account2ID = account2.getAccNumber();

        HashMap curMap = new HashMap();
        curMap.put(Account1ID, account1);
        curMap.put(Account2ID, account2);
        currentBank.setAccountsMap(curMap);

        currentBank.getAccountsMap();

        /**  Павел Лебедев

        1) Если запустить программу на 2 аккаунтах и нескольких потоках, то скорее всего будет работать)
         Но если на 100+ потоках и 10000 аккаунтах, то врядли) А именно, узкое место у нас сейчас метод трансфер.
         Нужно придумать, как сделать синхронизацию. Чтобы несколько потоков не могли одновременно изменить
         один объект аккаунта. Нужно придумать, как можем синхронизировать
         2 объекта аккаунта: c которого переводим и на который переводим.
             https://javarush.ru/groups/posts/1422-vzaimnaja-blokirovkadeadlock-v-java-i-metodih-borjhbih-s-ney - очень похожий пример тут.
        2) Тут нам тесты не нужны, можно прямо в мейне.
         Предлагаю в цикле создать около 1000
         аккаунтов и переводы делать так же между ними какой-то промежуток времени,
         либо пока все не заблочатся. Так сможем сделать тестовую нагрузку.
         Главное, чтобы сумма в банке до и после совпали).

         С уважением, Павел  **/

        currentBank.transfer(Account1ID, Account2ID, 10);
        currentBank.transfer(Account1ID, Account2ID, 20);
        currentBank.transfer(Account2ID, Account1ID, 7000);
        currentBank.transfer(Account2ID, Account1ID, 40);
        System.out.println("Сумма на всех счетах Банка: "+currentBank.getSumAllAccounts());

        /**
         Методы класса Thread
         Наиболее часто используемые методы класса Thread для управления потоками :

         long getId() - получение идентификатора потока;
         String getName() - получение имени потока;
         int getPriority() - получение приоритета потока;
         State getState() - определение состояния потока;
         void interrupt() - прерывание выполнения потока;
         boolean isAlive() - проверка, выполняется ли поток;
         boolean isDaemon() - проверка, является ли поток «daemon»;
         void join() - ожидание завершения потока;
         void join(millis) - ожидание millis милисекунд завершения потока;
         void notify() - «пробуждение» отдельного потока, ожидающего «сигнала»;
         void notifyAll() - «пробуждение» всех потоков, ожидающих «сигнала»;
         void run() - запуск потока, если поток был создан с использованием интерфейса Runnable;
         void setDaemon(bool) - определение «daemon» потока;
         void setPriority(int) - определение приоритета потока;
         void sleep(int) - приостановка потока на заданное время;
         void start() - запуск потока.
         void wait() - приостановка потока, пока другой поток не вызовет метод notify();
         void wait(millis) - приостановка потока на millis милисекунд или пока другой поток не вызовет метод notify();

         */

    }
}
