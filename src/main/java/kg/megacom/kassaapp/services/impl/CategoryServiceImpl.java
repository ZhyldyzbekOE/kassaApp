package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.CategoryDB;
import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.services.CategoryService;

import java.sql.SQLException;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    private CategoryDB categoryDB = CategoryDB.getINSTANCE();

    private static CategoryServiceImpl INSTANCE;

    public static CategoryServiceImpl getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new CategoryServiceImpl();
        }
        return INSTANCE;
    }


    public void save(Category category) throws SQLException {
        if (category.getId() == null)
            categoryDB.insert(category);
        else
            categoryDB.update(category);

    }

    public List<Category> getCategories() {
        return categoryDB.findAll();
    }

    public void delete(Integer id) {
        try {
            categoryDB.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
