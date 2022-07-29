package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBImpl implements ConnectionDB {

    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\products-db.db");
        return connection;
    }

    public void close(Connection connection) {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
