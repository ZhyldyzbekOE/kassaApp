package kg.megacom.kassaapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\products-db.db");
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
