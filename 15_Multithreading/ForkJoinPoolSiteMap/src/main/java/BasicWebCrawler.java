import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

/**
 * Цель задания
 * <p>
 * Научиться использовать ForkJoinPool для решения рекурсивных задач.
 * <p>
 * Что нужно сделать
 * <p>
 * Создайте новый проект в директории Multithreading и напишите приложение, которое в многопоточном
 * режиме сформирует карту заданного сайта (список ссылок), и запишите её в файл.
 * Ссылки на дочерние страницы должны располагаться в файле с отступами на одну табуляцию относительно родительских.
 * <p>
 * Пример
 * <p>
 * https://skillbox.ru/
 * <p>
 * https://skillbox.ru/media/
 * <p>
 * https://skillbox.ru/media/management/
 * <p>
 * https://skillbox.ru/media/management/kak_rat_podkhod/
 * <p>
 * <p>
 * <p>
 * Рекомендации
 * <p>
 * В файле должны быть ссылки на страницы, размещённые на том же домене (в примере — skillbox.ru).
 * В списке не должно быть:
 * ссылок на другие сайты и поддомены,
 * ссылок на внутренние элементы страниц (у таких ссылок есть символ # после адреса страницы).
 * При запросе страниц нужно выдерживать паузы (с помощью метода sleep() у потока),
 * чтобы сайт не заблокировал доступ вашего приложения. Используйте значения от 100 до 150 мс.
 * Для отладки программы выберите сайт с сотнями или тысячами страниц (например, http://www.lenta.ru/),
 * чтобы сервер вас не заблокировал.
 * Учитывайте что сайт имеет структуру графа, то есть страницы могут
 * содержать ссылки на главную, на страницы с которой вы пришли по ссылке.
 * Исключите возможность циклического перебора ссылок. Пример структуры и ссылок между страниц одного сайта:
 */

public class BasicWebCrawler {

    private FileOutputStream outputStream;
    private int count = 0;

    private HashSet<String> links;

    public BasicWebCrawler() {

        links = new HashSet<String>();

        String fileName = "C:\\tmp\\test.txt";

        try {
            outputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getPageLinks(String URL) {

        // Check if you have already crawled the URLs
        //// Проверим, выполнили ли мы уже обход URL-адресов

        if (!links.contains(URL)) {
            try {
                // (i) If not add it to the index
                // Добавляем ссылку на сайт в HashSet список
                if (links.add(URL)) {
                    System.out.println(URL);

                    long countOfSlashes = URL.codePoints().filter(ch -> ch == '/').count();
                    System.out.println("countOfSlashes = " + countOfSlashes);

                    count++;
                    byte[] strToBytes = URL.getBytes();

//                    ' '      space
//                    '\t'     horizontal tab
//                    '\n'     newline
//                    '\v'     vertical tab
//                    '\f'     form feed
//                    '\r'     carriage return

                    outputStream.write('\n');
                    if (count > 1) {
                        for (int i = 3; i <= countOfSlashes; i++) {
                            // outputStream.write('\t');
                            outputStream.write(' ');
                        }
                    }
                    outputStream.write(strToBytes);
                }

                if (count == 3000) {
                    URL = "";
                    outputStream.close();
                }

                // Fetch the HTML code
                // Получаем собственно сам HTML код по текущему пути к странице
                Document document = Jsoup.connect(URL).get();
                // Parse the HTML to extract links to other URLs
                // Парсим HTML код, чтобы достать необходимые нам ссылки на странички
                Elements linksOnPage = document.select("a[href]");
                // For each extracted URL... go back to Step
                // Перебираем получившиеся ссылки
                for (Element page : linksOnPage) {

                    String currentPageAbsLink = page.attr("abs:href");
                    boolean currentLink = currentPageAbsLink.contains("https://lenta.ru/");
                    boolean containsSpecSymbol = currentPageAbsLink.contains("#");
                    boolean containsSpecPdf = currentPageAbsLink.contains(".pdf");

                    if ((currentLink) && (!containsSpecSymbol) && (!containsSpecPdf)) {
                        getPageLinks(page.attr("abs:href"));
                    }
                }

            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

}