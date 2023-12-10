

/**
 * Методы оптимизации чтения xml файлов
 * <p>
 * Речь пойдет метод объект класса DOM используется для того, чтобы прочитать файл xml
 * <p>
 * Файл читается в объект DOM Model
 * Можно брать какой нибудь его узел и объектная модель позволяет ходить по документу
 * брать родительские элементы и корневые элементы
 * Если Java машине установить лимит к примеру 18 мегабайт в опциях виртуальной машины
 * установить параметр. Установив 50 мг, в памяти, нельзя будет прочитать 18 мегобайтный xml файл
 * <p>
 * Параметры используемой памяти в java машине можно установить в опциях Run--> Edit Configurations
 * в ячейке Vm Options Пример: -Xmx500M
 * Для того, чтобы хватало оперативной памяти, нужно правильно её задействовать.
 * <p>
 * Для xml файлов есть 2 типа парсеров
 * DOM и SAX (Simple API for xml).
 * Для того, чтобы правильно читать файл, лучше это делать частями, чтобы не забивалась память
 * <p>
 * Реализуем новый механизм чтения xml файла
 */

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;


public class LoaderToSQL {

    public static void main(String[] args) throws Exception {

        String fileName = "res/data-1572M.xml";

         /** Уберем предыдущий механизм DOM чтения файла xml и задействуем новый механизм
         * Будем задействовать SAX механизм чтения xml файлов
         * Для этого создадим фабрику SAXpareser класс
         * **/

        long start = System.currentTimeMillis();

        /// Подготавливаем таблицы в базе данных
        DBConnection.createTablesAndConnection();

        //// Создаем наш экземпляр фабрики sax парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        /// создаем сам парсер из фабрики как объект
        SAXParser parser = factory.newSAXParser();
        /// Создаем handler
        XMLHandler handler = new XMLHandler();
        //// И парсеру передадим наш файл с handler ом
        parser.parse(new File(fileName), handler);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Parsing duraton: " + (System.currentTimeMillis() - start) + " ms");

        DBConnection.printVoterCounts();

    }
}
