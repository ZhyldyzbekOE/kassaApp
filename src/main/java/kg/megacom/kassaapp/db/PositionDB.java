package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PositionDB {

    private static PositionDB INSTANCE;

    public static PositionDB getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new PositionDB();
        }

        return INSTANCE;
    }

    public void insert(Position position){
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "insert into position(name)" +
                    "values(?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, position.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
        }

    }

    public void update(Position position) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "update position set name = ? where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, position.getName());
            ps.setInt(5, position.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
        }
    }
}
