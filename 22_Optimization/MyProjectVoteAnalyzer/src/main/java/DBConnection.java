import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "sa";
    private static String dbPass = "@Superx15616729";

    private static StringBuilder inserQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://192.168.2.77:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
//                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
//                connection.createStatement().execute("CREATE TABLE voter_count(" +
//                    "id INT NOT NULL AUTO_INCREMENT, " +
//                    "name TINYTEXT NOT NULL, " +
//                    "birthDate DATE NOT NULL, " +
//                    "`count` INT NOT NULL, " +
//                    "PRIMARY KEY(id), " +
//                    "UNIQUE KEY name_date(name(50), birthDate), " +   //// (3)
//                    "KEY(name(50)))");   //// Оптимизация (4) - Добавление индекса полю 'name'
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
                        "UNIQUE KEY name_date(name(50), birthDate), " +   //// (3)
                        "KEY(name(50)))");   //// Оптимизация (4) - Добавление индекса полю 'name'
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //// Оптимизация...2 с помощью MultyInsert - добавляем множественные значения команды INSERT в запрос
    public static void executeMultyInsert() throws SQLException
    {
        String sql = "INSERT INTO voter_count(name, birthdate, `count`)" +
                "VALUES" + inserQuery.toString()
         +
                "ON DUPLICATE KEY UPDATE `count` = `count` + 1";
      //  DBConnection.getConnection().createStatement().execute(sql);
        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void clearStringBuilder() {
        inserQuery.setLength(0);
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');

//        /// Оптимизация...1
//        String sql = "INSERT INTO voter_count(name, birthdate, `count`)" +
//                                  "VALUES('"+ name + "','" + birthDay +  "', 1)" +   // (1)
//                "ON DUPLICATE KEY UPDATE `count` = `count` + 1";
//        /// (С помощью метода уникального индекса можно подсчитать, сколько
//        // у нас задвоенностей существует по записям с одними и теме же фамилиями, т.е. количество избирателей)
//        // которые больше 2-х в базе
//        // По сути с помощью этого метода ("ON DUPLICATE KEY UPDATE `count` = `count` + 1";) здесь пишется операция
//        // которая должна произойти при дубликате записи... в данном случае это count + 1
//        /// чтобы 2 поля name и birthDay были уникальным индексом, нужно их будет создать в описаниях таблицы см. (3)

        //// Оптимизация...2 с помощью MultyInsert
      //// Здесь добавляем значения для VALUES в Builder
        inserQuery.append((inserQuery.length() == 0 ? "" : ", " ) + "('" + name + "', '" + birthDay + "', 1)"); /// Оптимизация (3)
      ////  DBConnection.getConnection().createStatement().execute(sql);  /// Оптимизация (1)

//        String sql =
//            "SELECT id FROM voter_count WHERE birthDate='" + birthDay + "' AND name='" + name + "'";
//        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
//        if (!rs.next()) {
//            DBConnection.getConnection().createStatement()
//                .execute("INSERT INTO voter_count(name, birthDate, `count`) VALUES('" +
//                    name + "', '" + birthDay + "', 1)");
//        } else {
//            Integer id = rs.getInt("id");
//            DBConnection.getConnection().createStatement()
//                .execute("UPDATE voter_count SET `count`=`count`+1 WHERE id=" + id);
//        }
//        rs.close();


    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }


}
