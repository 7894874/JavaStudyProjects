import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static int newWidth = 120;

    public static void main(String[] args) {
        String srcFolder = "c:\\tmp1";
        String dstFolder = "c:\\tmp2";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        //// Получаем количество процессоров
        int qttOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Текущее количество процессоров: "+qttOfProcessors);

        //   int middle = files.length / qttOfProcessors;

//        ///// .arraycopy
//        ///// Copies an array from the specified source array, beginning at the specified position,
//        ///// to the specified position of the destination array
//        File[] files1 = new File[middle];
//        System.arraycopy(files, 0, files1, 0, files1.length);
//        ImageResizer imageResizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
//        imageResizer1.start();
//
//        File[] files2 = new File[files.length - middle];
//        System.arraycopy(files, middle, files2, 0, files2.length);
//        ImageResizer imageResizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
//        imageResizer2.start();

        int fileLenth = files.length;
        if (fileLenth > 0) {

            if (fileLenth / qttOfProcessors <= 1) {
                qttOfProcessors = fileLenth;
            }

            int currentQttOfFilesPassed = 0;
            for (int i = 1; i <= qttOfProcessors; i++) {

                System.out.println("Загружаем процессор потоком №: "+i);
                //// Передаем в конструктор данные
                Distortion currentDistorion = new Distortion(files.length, qttOfProcessors, i, currentQttOfFilesPassed);
                //// Получаем результат количество расчетных файлов
                int calculatedFilesForThread = currentDistorion.getResultFilesPart();
              //  int calculatedFilesForThread = currentDistorion.getcalculatePostionOfFiles();

                //// Создаем новый ограниченный массив из количества файлов
                File[] curFiles = new File[calculatedFilesForThread];

                //// Копируем из основного массива данные по файлам по позициям
                //// в данном случае позиция - это количество файлов, которая будет использоваться в
                //// параметре int srcPos метода arraycopy, по сути это начальная позиция из массива источника
                //// То место, с которого начинаем копировать данные в другой массив
                //// Немного о параметрах этого метода

                //  src – the source array. (Массив Источник копирования)
                //  srcPos – starting position in the source array. (Начальная позиция из массива источника)
                //  dest – the destination array. (Массив приемник копирования)
                //  destPos – starting position in the destination data. (Начальная позиция в данных приемника)
                //  length – the number of array elements to be copied (Количество элементов массива для копирования
                //  по сути это длинна массива)

                System.arraycopy(files, currentQttOfFilesPassed, curFiles, 0, curFiles.length);

                new ImageResizer(curFiles, newWidth, dstFolder, start).start();
                currentQttOfFilesPassed = (int) (currentQttOfFilesPassed + calculatedFilesForThread);

            }
        }

//        //// Реализация интерфейсов Runnble
//        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
//            System.out.println("Waiting for LiftOff...");
//        }

    }
}
