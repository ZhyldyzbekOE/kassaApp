package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.CategoryDB;
import kg.megacom.kassaapp.models.Category;

import java.sql.SQLException;
import java.util.List;


public class CategoryService {

    private CategoryDB categoryDB = CategoryDB.getINSTANCE();

    private static CategoryService INSTANCE;

    public static CategoryService getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new CategoryService();
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
