package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.services.impl.CategoryServiceImpl;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {

    CategoryService INSTANCE = new CategoryServiceImpl();
    void save(Category category) throws SQLException;

    List<Category> getCategories();

    void delete(Integer id);

}
