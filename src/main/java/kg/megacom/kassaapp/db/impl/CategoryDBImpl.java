package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.CategoryDB;
import kg.megacom.kassaapp.db.ConnectionDB;
import kg.megacom.kassaapp.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDBImpl implements CategoryDB {


    public void insert(Category category) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into categories(name) values(?)");
            ps.setString(1, category.getName());
            ps.executeUpdate();
        }finally {
            ConnectionDB.INSTANCE.close(connection);
        }
    }

    public void update(Category category) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("update categories set name = ? where id = ?");
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        }finally {
            ConnectionDB.INSTANCE.close(connection);
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from categories where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }finally {
            ConnectionDB.INSTANCE.close(connection);
        }
    }

    public List<Category> findAll() {
        Connection connection  = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from categories");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                categories.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDB.INSTANCE.close(connection);
            return categories;
        }
    }
}
