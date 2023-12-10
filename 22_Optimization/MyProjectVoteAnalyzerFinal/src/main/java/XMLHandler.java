import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * По сути этот метод, когда ему встречается на пути тэг, он вызывает метод startElement
 * когда идет дальше вызывается и в конце вызывается метод endElement
 **/

public class XMLHandler extends DefaultHandler {

    /**
     * У этого родительского класса есть несколько методов (можно вызвать просто набрав слово start) в тексте кода
     **/

    int totalLimit = 5000_000;
    int limit = 1000_000;

    int totalNumber = 0;
    int numberOfVisits = 0;
    int numberOfVoters = 0;

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    /// Далее напишем файл основной загрузочных LoaderToSQL с классом main чтобы загружались и обрабатывались
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        /// Этот метод срабатывает, когда парсер натыкается на какой-либо элемент начала или конечный с целью прочтения тэга

        if (totalNumber <= totalLimit) {

            try {

                //// Набираем записи в пакет для MultiInserts, как набрали выполняем его далее и обнуляем счетчик
                //// и сопутствующие StringBuilder s
                if (qName.equals("voter") && voter == null) { ///// проходим тег "voter"

                    totalNumber++;

                    Date birthday = birthDayFormat.parse(attributes.getValue("birthDay"));
                    /// Для разнообразия используем объект, хотя можно было обойтись без него :-)
                    voter = new Voter(attributes.getValue("name"), birthday);
                    /// Добавляем необходимые значения в String Builder для ввода в запрос
                    DBConnection.countVoter(voter.getName(), voter.getFormatedDate());

                    numberOfVoters++;
                    if (numberOfVoters >= limit) {
                        DBConnection.executeMultyInsert("voters");
                        DBConnection.clearStringBuilder("voters");
                        numberOfVoters = 0;
                    }
                }
                if (qName.equals("visit") && voter != null) {   /// Проходим тег "visit"

                    totalNumber++;

                    Integer station = Integer.parseInt(attributes.getValue("station"));
                    Date time = visitDateFormat.parse(attributes.getValue("time"));
                    String timeString = visitDateFormat.format(time);
                    /// Добавляем необходимые значения в String Buider для ввода в запрос
                    DBConnection.countVisit(String.valueOf(station), timeString);

                    numberOfVisits++;
                    if (numberOfVisits >= limit) {
                        DBConnection.executeMultyInsert("visits");
                        DBConnection.clearStringBuilder("visits");
                        numberOfVisits = 0;
                    }

                }

                /** При достижении лимита на количество записей (1 млн. записей),
                 очищаем StringBuider и выполняем мульти-инсерт и
                 обнуляем счетчик записей одновременно **/



                //   }
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("voter")) {
            voter = null;
        }

    }
}
