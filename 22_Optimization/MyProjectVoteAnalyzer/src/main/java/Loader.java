

/** Методы оптимизации чтения xml файлов
 *
 * Речь пойдет метод объект класса DOM используется для того, чтобы прочитать файл xml
 *
 * Файл читается в объект DOM Model
 * Можно брать какой нибудь его узел и объектная модель позволяет ходить по документу
 * брать родительские элементы и корневые элементы
 * Если Java машине установить лимит к примеру 18 мегабайт в опциях виртуальной машины
 * установить параметр. Установив 50 мг, в памяти, нельзя будет прочитать 18 мегобайтный xml файл
 *
 *  Параметры используемой памяти в java машине можно установить в опциях Run--> Edit Configurations
 *  в ячейке Vm Options Пример: -Xmx500M
 *  Для того, чтобы хватало оперативной памяти, нужно правильно её задействовать.
 *
 * Для xml файлов есть 2 типа парсеров
 * DOM и SAX (Simple API for xml).
 * Для того, чтобы правильно читать файл, лучше это делать частями, чтобы не забивалась память
 *
 * Реализуем новый механизм чтения xml файла
 *
 * */

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
         String fileName = "res/data-0.2M.xml";

        /** Уберем предыдущий механизм и задействуем новый
         *
         * Будем задействовать SAX механизм чтения xml файлов
         * Для этого создадим фабрику SAXpareser класс
         *
         * **/

        //// Создаем наш экземпляр фабрики sax парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        /// создаем сам парсер из фабрики как обхъект
        SAXParser parser = factory.newSAXParser();
        /// Создаем handler
        XMLHandler handler = new XMLHandler();
        //// И парсеру передадим наш файл с handler ом
        parser.parse(new File(fileName), handler);
        /// Чтобы убедиться, что 18 мегабайтный файл будет влезать в нашу память сделаем параметры виртуальной памяти для java машины
        /// не более 50 мегабайт
        /// Вызываем печать из хендлера
        handler.printDuplicatedVoters();


        //        parseFile(fileName);
//
//        //Printing results
//        System.out.println("Voting station work times: ");
//        for (Integer votingStation : voteStationWorkTimes.keySet()) {
//            WorkTime workTime = voteStationWorkTimes.get(votingStation);
//            System.out.println("\t" + votingStation + " - " + workTime);
//        }
//
//        System.out.println("Duplicated voters: ");
//        for (Voter voter : voterCounts.keySet()) {
//            Integer count = voterCounts.get(voter);
//            if (count > 1) {
//                System.out.println("\t" + voter + " - " + count);
//            }
//        }

    }




//    private static void parseFile(String fileName) throws Exception {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new File(fileName));
//
//        findEqualVoters(doc);
//        fixWorkTimes(doc);
//    }

//    private static void findEqualVoters(Document doc) throws Exception {
//        NodeList voters = doc.getElementsByTagName("voter");
//        int votersCount = voters.getLength();
//        for (int i = 0; i < votersCount; i++) {
//            Node node = voters.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            String name = attributes.getNamedItem("name").getNodeValue();
//            Date birthDay = birthDayFormat
//                .parse(attributes.getNamedItem("birthDay").getNodeValue());
//
//            Voter voter = new Voter(name, birthDay);
//            Integer count = voterCounts.get(voter);
//            voterCounts.put(voter, count == null ? 1 : count + 1);
//        }
//    }
//
//    private static void fixWorkTimes(Document doc) throws Exception {
//        NodeList visits = doc.getElementsByTagName("visit");
//        int visitCount = visits.getLength();
//        for (int i = 0; i < visitCount; i++) {
//            Node node = visits.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
//            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
//            WorkTime workTime = voteStationWorkTimes.get(station);
//            if (workTime == null) {
//                workTime = new WorkTime();
//                voteStationWorkTimes.put(station, workTime);
//            }
//            workTime.addVisitTime(time.getTime());
//        }
//    }
}