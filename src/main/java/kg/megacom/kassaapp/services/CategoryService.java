package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {

    void save(Category category) throws SQLException;

    List<Category> getCategories();

    void delete(Integer id);

}
