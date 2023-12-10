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

    int totalLimit = 3_000;
    int totalNumber = 0;
    int limit = 1_000;
    int number = 0;

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    /// Для того, чтобы подсчитать, сколько людей проголосовали, сделаем HashMap

    /// в случае 50 Мб, этот метод прекрасно сработает, но есть файл будет больше чем 150 гб не фига не сработает
    /// так как будет выдаваться ошибка "Exception in thread "main" java.lang.OutOfMemoryError: Java heap space"
    /// Почему это происходит, потому, что у нас есть переменная
    private HashMap<Voter, Integer> voterCounts;
    /// voterCounts - и она накапливает в себе избирателей и объем избирателей становиться больше чем 50 МБ
    /// как результат выдается ошибка, соответственно здесь логично использовать другое хранилище, например, базу данных
    /// Если не хватает оперативной памяти как раз и используются базы данных.
    /// Далее напишем файл основной загрузочных LoaderToSQL с классом main чтобы загружались и обрабатывались
    // файлы более чем 50 мб из xml файла...

    public XMLHandler() {
        voterCounts = new HashMap<>();
    }

    /// набрал просто слово start и все получилось
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        /// этот метод срабатывает, когда парсер натыкается на какой-либо элемент начала или конечный с целью прочтения
        try {

            if (totalNumber <= totalLimit) {
                if (qName.equals("voter") && voter == null) {
                    Date birthday = birthDayFormat.parse(attributes.getValue("birthDay"));
                    voter = new Voter(attributes.getValue("name"), birthday);
                    try {
                        /// Добавляем необходимые значения в String Buider для ввода в запрос
                        DBConnection.countVoter(voter.getName(), birthDayFormat.format(voter.getBirthDay()));

                        //// При достижении лимита на количество записей (1 млн. записей),
                        //// очищаем StringBuider и выполняем мульти-инсерт и обнуляем счетчик записей
                        if (number >= limit) {
                            DBConnection.executeMultyInsert();
                            DBConnection.clearStringBuilder();
                            number = 0;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    //      } else if (qName.equals("visit") && voter != null) {
                    //        int count = voterCounts.getOrDefault(voter, 0);
                    //        voterCounts.put(voter, count + 1);

                    number++;
                    totalNumber++;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("voter")) {
            voter = null;
        }
    }

    //// Выводим на печать голосовавших людей на избирательном участке
    //// из нашего HashMap
    public void printDuplicatedVoters() {
        for (Voter voter : voterCounts.keySet()) {
            {
                int count = voterCounts.get(voter);
                if (count > 1) {
                    System.out.println(voter.toString() + " - " + count);
                }
            }
        }
    }
}
