package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.CategoryDBImpl;
import kg.megacom.kassaapp.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDB {

    CategoryDB INSTANCE = new CategoryDBImpl();
    void insert(Category category) throws SQLException;

    void update(Category category) throws SQLException;

    void delete(Integer id) throws SQLException;

    List<Category> findAll();
}
