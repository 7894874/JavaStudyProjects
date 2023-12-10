
import org.imgscalr.Scalr;
import org.jline.utils.Log;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class NewImageResizer {

    public NewImageResizer process(File[] files, int newWidth, String destinationPath, long startTime) throws Exception {

        try {

            for (File currentfile : files) {
                BufferedImage image = ImageIO.read(currentfile);
                if (image == null) {
                    continue;
                }

                //// Рассчитываем новую высоту исходя из ширины получаем округленное значение
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));

                //// Задействуем более продвинутые функции этой компонненты
                BufferedImage scaledImage = Scalr.resize(
                        image,
                        Scalr.Method.ULTRA_QUALITY,
                        Scalr.Mode.AUTOMATIC,
                        newWidth,
                        newHeight,
                        Scalr.OP_ANTIALIAS);

                //// После этого создаем новый файл в папочке dst и туда его сохраняем
                //// в формате jpg
                File newFile = new File(destinationPath + "/" + currentfile.getName());
                ImageIO.write(scaledImage, "png", newFile);
            }
        } catch (Exception ex) {

            ex.printStackTrace();

            Log.warn(
                    "Failed to convert "
                            + destinationPath + ", skipping - sorry submitter! ("
                            + "reason is:" + ex.getMessage()
                            + ")");

        }

        System.out.println("Finished after start:"+ (System.currentTimeMillis() - startTime) + " ms");

        return null;

    }

}
