import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import static java.lang.Thread.sleep;

public class BasicWebCrawlerProcessor extends RecursiveTask<List<String>> {

    private int count = 0;

    private HashSet<String> links;

    ///// Рассуждаем
    /// В этом пути будет храниться
    private final String url;
    private final String fileName;

    public BasicWebCrawlerProcessor(String url, String fileName) {

        this.url = url;
        this.fileName = fileName;

        links = new HashSet<String>();

    }

    @Override
    protected List<String> compute() {

        // Список ссылок для сохранения ссылок в файле...
        List<String> list = new ArrayList<String>();

        list.add(url);

        ////Задачи обработки ссылок для хранения
        List<BasicWebCrawlerProcessor> tasks = new ArrayList<BasicWebCrawlerProcessor>();

        // Получаем собственно сам HTML код по текущему пути к странице
        Document document = null;
        try {
            sleep(100);
            document = Jsoup.connect(this.url).get();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Парсим HTML код, чтобы достать необходимые нам ссылки на странички
        Elements linksOnPage = document.select("a[href]");
        // Перебираем получившиеся ссылки
        for (Element page : linksOnPage) {

            String currentPageAbsLink = page.attr("abs:href");
            boolean currentLink = currentPageAbsLink.contains("https://lenta.ru/");
            boolean containsSpecSymbol = currentPageAbsLink.contains("#");
            boolean containsSpecPdf = currentPageAbsLink.contains(".pdf");
            boolean currentPagerRss = currentPageAbsLink.contains("rss");
            if (currentPageAbsLink.equals("https://lenta.ru/")) {
                continue;
            }

            if ((currentLink) && (!containsSpecSymbol) && (!containsSpecPdf) && (!currentPagerRss)) {
                // getPageLinks(page.attr("abs:href"));
                //// Добавляем получившиеся ссылки в список ссылок
                list.add(page.attr("abs:href"));
            }

            if (!links.contains(this.url)) {

                for (String str : list) {

                    BasicWebCrawlerProcessor task = new BasicWebCrawlerProcessor(str, this.fileName);

                    task.fork();
                    tasks.add(task);


                }
            }
        }

        //If the list of the FolderProcessor subtasks has more than 50 elements,
        //write a message to the console to indicate this circumstance.
        // В случае, если в списке процессоров подзадач имеется более 50 элементов
        // записываем об этом сообщение в консоль
        if (tasks.size() > 50) {
            System.out.printf("%s: %d tasks ran.\n", fileName, tasks.size());
        }
        //add to the list of files the results returned by the subtasks launched by this task.
        //  addResultsFromTasks(list, tasks);

        writeToTheFiles(list, tasks);

        addResultsFromTasks(list, tasks);

        return list;
    }

    private void addResultsFromTasks(List<String> list, List<BasicWebCrawlerProcessor> tasks) {

        for (BasicWebCrawlerProcessor item : tasks) {
            list.addAll(item.join());
        }
    }

    private void writeToTheFiles(List<String> list, List<BasicWebCrawlerProcessor> tasks) {

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);

            for (String currentStr : list) {
                System.out.println(currentStr);

                long countOfSlashes = currentStr.codePoints().filter(ch -> ch == '/').count();
                System.out.println("countOfSlashes = " + countOfSlashes);

                count++;
                byte[] strToBytes = currentStr.getBytes();

                /**                    ' '      space
                 '\t'     horizontal tab
                 '\n'     newline
                 '\v'     vertical tab
                 '\f'     form feed
                 '\r'     carriage return */

                outputStream.write('\n');
                if (count > 1) {
                    for (int i = 3; i <= countOfSlashes; i++) {
                        // outputStream.write('\t');
                        outputStream.write(' ');
                    }
                }

                outputStream.write(strToBytes);
            }

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


