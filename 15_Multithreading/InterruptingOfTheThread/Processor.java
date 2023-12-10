public class Processor extends Thread {

    ///// Создадим несколько потоков
    //// Прерывать поток можно только через метод Interupted
    @Override
    public void run() {
        double sum = 0;
        for (;;) {
            if (isInterrupted()) {
                System.out.println(sum);
                break;
            }
            sum += Math.random();
        }
    }
}
