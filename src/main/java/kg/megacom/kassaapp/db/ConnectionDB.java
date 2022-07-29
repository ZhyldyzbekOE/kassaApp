package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.ConnectionDBImpl;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDB {

    ConnectionDB INSTANCE = new ConnectionDBImpl();
    Connection getConnection() throws SQLException;

    void close(Connection connection);

}
