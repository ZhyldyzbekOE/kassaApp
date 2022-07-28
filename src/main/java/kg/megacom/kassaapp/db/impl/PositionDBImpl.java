package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.ConnectionDB;
import kg.megacom.kassaapp.db.PositionDB;
import kg.megacom.kassaapp.models.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDBImpl implements PositionDB {

    private static PositionDBImpl INSTANCE;

    public static PositionDBImpl getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new PositionDBImpl();
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

    @Override
    public List<Position> finAllPostions() {
        Connection connection = null;
        List<Position> positionList = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            String query = "select * from position";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Position item = new Position();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                positionList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.close(connection);
        }
        return positionList;
    }
}
