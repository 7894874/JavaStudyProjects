import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Перевел и получил результат! ;-)
 * Взято с сайта поваренной книги Джсоупа https://jsoup.org/cookbook ))
 * Полнвый путь до документации по извлечению значений аттрибутов по его свойствам
 * https://jsoup.org/cookbook/extracting-data/attributes-text-html
 * <p>
 * Extract attributes, text, and HTML from elements
 * Problem
 * After parsing a document, and finding some elements, you'll want to get at the data inside those elements.
 * <p>
 * Solution
 * To get the value of an attribute, use the Node.attr(String key) method
 * For the text on an element (and its combined children), use Element.text()
 * For HTML, use Element.html(), or Node.outerHtml() as appropriate
 * For example:
 * <p>
 * String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
 * Document doc = Jsoup.parse(html);
 * Element link = doc.select("a").first();
 * <p>
 * String text = doc.body().text(); // "An example link"
 * String linkHref = link.attr("href"); // "http://example.com/"
 * String linkText = link.text(); // "example""
 * <p>
 * String linkOuterH = link.outerHtml();
 * // "<a href="http://example.com"><b>example</b></a>"
 * String linkInnerH = link.html(); // "<b>example</b>"
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //// Подключаемся к Jsoap
        Document document = Jsoup.connect( "https://lenta.ru" ).get();

        //// Ищем все тэги, которые содержат img и в которых есть ссылка на файл jpg
        ArrayList arraylstExt = new ArrayList();
        arraylstExt.add( "img[src$=.jpg]" );
        arraylstExt.add( "img[src$=.png]" );

        arraylstExt.stream().forEach( sExtensionsQuery -> {

            Elements elements = document.select( sExtensionsQuery.toString() );

            elements.forEach( element_link -> {

                String currentLinkForPicture = element_link.attr( "src" );
                System.out.println( currentLinkForPicture );

                // Image loadImage(String URL, String fileName);
                String currentFileName = currentLinkForPicture.substring( currentLinkForPicture.lastIndexOf( "/" ) + 1 );
                String finalFileName = "H:\\JAVASTUDY\\Skillbox\\Repository\\java_basics\\ParseDocFromLentaSite\\images\\" + currentFileName;
                loadImage( currentLinkForPicture, finalFileName );

            } );
        } );
    }

    private static void loadImage(String URL, String fileName) {
        try {

            String formatExtention = fileName.substring( fileName.lastIndexOf( "." ) );
            BufferedImage img = ImageIO.read( new URL( URL ) );
            File file = new File( fileName );
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write( img, formatExtention, file );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
