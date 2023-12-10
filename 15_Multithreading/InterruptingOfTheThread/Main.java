public class Main {

    public static void main(String[] args) {


        ///// Прерывание.
        //// Если поток не знает, какой был объем у вашей задачи, мог бы прервать выполнение одного из потоков
        /// Создадим 2 потока 1) Processor - это поток, который выплняет какую либо задачу
        ///                   2) Interrupter - этот поток прерывает некий поток. Он передает через параметр
        //// поток и его прерывает

        Thread thread = new Processor();
        Thread interrupter = new Thread(new Interrupter(thread));

        thread.start();
        interrupter.start();

        //// Другой вариант, с помощью метода
        Thread thread1 = new Timer();
        thread1.start();
        interrupter.start();


    }


}
