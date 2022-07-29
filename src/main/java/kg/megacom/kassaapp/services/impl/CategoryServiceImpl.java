package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.CategoryDB;
import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.services.CategoryService;

import java.sql.SQLException;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    public void save(Category category) throws SQLException {
        if (category.getId() == null)
            CategoryDB.INSTANCE.insert(category);
        else
            CategoryDB.INSTANCE.update(category);

    }

    public List<Category> getCategories() {
        return CategoryDB.INSTANCE.findAll();
    }

    public void delete(Integer id) {
        try {
            CategoryDB.INSTANCE.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
