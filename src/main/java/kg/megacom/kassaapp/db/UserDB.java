package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDB {

    private static UserDB INSTANCE;

    public static UserDB getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserDB();
        }
        return INSTANCE;
    }

    public void insert(User user) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "insert into users(name, login, password, position.id)" +
                    "values(?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getPosition().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }

    }

    public void update(User user) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "update users set name = ?, login = ?, password = ?, position_id = ? where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getPosition().getId());
            ps.setString(5, user.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
    }


}
