
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread{

    private  File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {

//        try {
//            for (File file : files) {
//                BufferedImage image = ImageIO.read(file);
//                if (image == null) {
//                    continue;
//                }
//
//                //// Рассчитываем новую высоту исходя из ширины получаем округленное значение
//                ///
//                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
//
////                //// Здесь создаем новую картинку с шириной и получившейся высотой
////                //// задаем её тип, TYPE_INT_RGB учитывающий значения каждого цевета
////                //// RGB
////                BufferedImage scaledImage = new BufferedImage(
////                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
////                );
////
////                //// Здесь берем шаг прорисовки пикселей
////                int widthStep = image.getWidth() / newWidth;
////                int heightStep = image.getHeight() / newHeight;
////
////                //// Мы берем эти пиксели и вставляем в изображение
////                /// и каждый десятый и двацатый пропорционально
////                for (int x = 0; x < newWidth; x++) {
////                    for (int y = 0; y < newHeight; y++) {
////                        int rgb = image.getRGB(x * widthStep, y * heightStep);
////                        scaledImage.setRGB(x, y, rgb);
////                    }
////                }
//
//                BufferedImage scaledImage = Scalr.resize(image, newWidth, newHeight);
//
//                //// После этого создаем новый файл в папочке dst и туда его сохраняем
//                //// в формате jpg
//                File newFile = new File(dstFolder + "/" + file.getName());
//                ImageIO.write(scaledImage, "jpg", newFile);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println("Finished after start:"+ (System.currentTimeMillis() - start) + " ms");
//

        NewImageResizer coolImageResizer = new NewImageResizer();
        try {
            coolImageResizer.process(files, newWidth, dstFolder, start);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
