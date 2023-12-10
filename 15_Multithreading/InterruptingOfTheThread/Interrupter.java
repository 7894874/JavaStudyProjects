public class Interrupter implements Runnable {


    //// Передаем поток в качестве параметра и издеваемся над ним
    private Thread thread;

    public Interrupter(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run()
    {
        try {
            thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
