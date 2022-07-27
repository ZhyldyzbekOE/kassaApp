package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private static UserDB INSTANCE;

    public static UserDB getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserDB();
        }
        return INSTANCE;
    }

    public boolean insert(User user) {
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

            int countUpdRows = ps.executeUpdate();

            ConnectionDB.close(connection);

            return countUpdRows >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
        return false;
    }

    public boolean update(User user) {
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

            int countUpdRow = ps.executeUpdate();
            ConnectionDB.close(connection);
            return countUpdRow >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
        return false;
    }

    public User getUserById(int id) {
        Connection connection = null;

        User user = null;
        try {
            connection = ConnectionDB.getConnection();
            String query = "select us.id, us.name, us.login, us.password, p.id, p.name from users us join position p" +
                    " on us.position_id = p.id where us.id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            user = new User();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setLogin(rs.getString(3));
            user.setPassword(rs.getString(4));
            int positionId = rs.getInt(5);
            String posName = rs.getString(6);
            user.setPosition(new Position(positionId, posName));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
        return user;
    }



    public List<User> getAllUsersFromDb() {
        Connection connection = null;
        List<User> userList = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            String query = "select us.id, us.name, us.login, us.password, p.id, p.name from users us join position p" +
                    " on us.position_id = p.id";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLogin(rs.getString(3));
                user.setPassword(rs.getString(4));
                int positionId = rs.getInt(5);
                String posName = rs.getString(6);
                user.setPosition(new Position(positionId, posName));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
        return userList;
    }

}
