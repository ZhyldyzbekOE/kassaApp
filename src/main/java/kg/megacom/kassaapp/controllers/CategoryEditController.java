package kg.megacom.kassaapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.services.CategoryService;
import kg.megacom.kassaapp.services.impl.CategoryServiceImpl;

import java.sql.SQLException;

public class CategoryEditController {

    //private CategoryServiceImpl categoryService = CategoryServiceImpl.getINSTANCE();
    private Category category;


    public void setCategory(Category category){
        this.category = category;

        if (category != null){
            txtCategoryName.setText(category.getName());
        }
    }

    @FXML
    private TextField txtCategoryName;

    @FXML
    void onCancelClicked(ActionEvent event) {

    }

    @FXML
    void onSaveClicked(ActionEvent event) {
        String categoryName = txtCategoryName.getText();

        category.setName(categoryName);

        String result = "Успешно!";
        Alert.AlertType alertType = Alert.AlertType.INFORMATION;

        try {
            CategoryService.INSTANCE.save(category);
            txtCategoryName.getScene().getWindow().hide();

        } catch (SQLException e ) {
            e.printStackTrace();

            switch (e.getErrorCode()){
                case 19:
                    result = "Название должно быть уникальным";
                    break;
                case 0:
                    result = "Ошибка подключения к базе данных";
                    break;
                default:
                    result = "Системная ошибка!";
            }

            alertType = Alert.AlertType.ERROR;

        }finally {
            Alert alert = new Alert(alertType,result, ButtonType.OK);
            alert.showAndWait();
        }


    }

}
