import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "sa";
    private static String dbPass = "@Superx15616729";

    private static StringBuilder inserQueryVoters = new StringBuilder();
    private static StringBuilder inserQueryVisits = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://192.168.2.77:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void createTablesAndConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://192.168.2.77:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id), " +
                        "UNIQUE KEY name_date(name(50), birthDate), " +   //// Добавлени уникального ключа в качестве индекса для более быстрого поиска данных (3)
                        "KEY(name(50)))");   //// Оптимизация (4) - Добавление индекса полю 'name'

                connection.createStatement().execute("DROP TABLE IF EXISTS visits_count");
                connection.createStatement().execute("CREATE TABLE visits_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "station TINYTEXT NOT NULL, " +
                        "dateOfVisit DATETIME NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id), " +
                        "KEY(station(3)))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //// Оптимизация...2 с помощью MultyInsert - добавляем множественные значения команды INSERT в запрос
    public static void executeMultyInsert(String typeOfTheQerry) throws SQLException {

        if (typeOfTheQerry.equals("voters")) {
            DBConnection.getConnection().createStatement().execute(prepareForMultyInsertQuery("voters"));
        } else if (typeOfTheQerry.equals("visits")) {
            DBConnection.getConnection().createStatement().execute(prepareForMultyInsertQuery("visits"));
        }

    }

    public static String prepareForMultyInsertQuery(String typeOfTheQuery) {

        String sqlQuery = "";
        if (typeOfTheQuery.equals("voters")) {
            sqlQuery = "INSERT INTO voter_count(name, birthdate, `count`)" +
                    "VALUES" + inserQueryVoters.toString() +
                    "ON DUPLICATE KEY UPDATE `count` = `count` + 1";

        } else if (typeOfTheQuery.equals("visits")) {
            sqlQuery = "INSERT INTO visits_count(station, dateOfVisit, `count`)" +
                    "VALUES" + inserQueryVisits.toString() +
                    "ON DUPLICATE KEY UPDATE `count` = `count` + 1";
        } else {
            sqlQuery = "Did't find parametr of the querry builder";
        }

        return sqlQuery;

    }

    public static void clearStringBuilder(String typeOfTheQuery) {

        if (typeOfTheQuery.equals("voters")) {
            inserQueryVoters.setLength(0);
        } else if (typeOfTheQuery.equals("visits")) {
            inserQueryVisits.setLength(0);
        }

    }

    public static void countVoter(String name, String birthDay) throws SQLException {

        birthDay = birthDay.replace('.', '-');

        //// Оптимизация...2 с помощью MultyInsert
        //// Здесь добавляем значения для VALUES в Builder
        inserQueryVoters.append((inserQueryVoters.length() == 0 ? "" : ", ") + "('" + name + "', '" + birthDay + "', 1)");

    }

    public static void countVisit(String station, String dateOfVisit) throws SQLException {

        dateOfVisit = dateOfVisit.replace('.', '-');

        //// Оптимизация...2 с помощью MultyInsert
        //// Здесь добавляем значения для VALUES в Builder
        inserQueryVisits.append((inserQueryVisits.length() == 0 ? "" : ", ") + "('" + station + "', '" + dateOfVisit + "', 1)");

    }

    public static void printVoterCounts() throws SQLException {

        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
        rs.close();
    }
}
