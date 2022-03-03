import org.davidmoten.text.utils.WordWrap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Парсим сайт ru.investing.com/news/latest-news/
 */

///// Через мавен полностью заливаем Jsoup себе в проект
public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect( "https://ru.investing.com/news/latest-news" ).get();

        //  Elements elements = document.select( "        " +
        Elements elements = document.select( "article.js-article-item.articleItem" );
        StringBuilder builder = new StringBuilder();
        elements.forEach( element -> {
            String[] lines = element.text().split( "\\.\n " );
            String currentStr = parseText( lines );
            builder.append( "\n" + currentStr + "\n" );

        } );

        Sender sender = new Sender( "supervisor2004@gmail.com", "fmqvleqwoozoqpzy" );
        sender.send( "Top news from Investments.Com", builder.toString(),  "svr15616@yandex.ru" );
        sender.send( "Top news from Investments.Com", builder.toString(),  "supervisor2004@gmail.com" );
        sender.send( "Top news from Investments.Com", builder.toString(),  "kovalchuk_anna81@mail.ru" );

    }

    //// Пропускаем сайт через обрезчик, предварительно подключив компонненту через Maven зависимости)
    private static String parseText(String[] currentText) {

        try {
            for (String s : currentText) {

                String wrapped =
                        WordWrap.from( s )
                                .maxWidth( 100 )
                                .insertHyphens( true ) // true is the default
                                .wrap();

                System.out.println( wrapped + "\n" );

                return wrapped;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
