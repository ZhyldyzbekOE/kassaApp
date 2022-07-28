package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.PositionService;
import kg.megacom.kassaapp.services.UserService;

public class UserFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserLogin;

    @FXML
    private TextField txtUserPassword;

    @FXML
    private ComboBox<Position> comBxPosition;

    private User user;

    public void setUser(User user) {
        System.out.println("LOG -- " + user);
        this.user = user;

        if (this.user.getId() != null) {
            txtUserName.setText(this.user.getName());
            txtUserLogin.setText(this.user.getLogin());
            txtUserPassword.setText(this.user.getPassword());

            comBxPosition.getSelectionModel().select(this.user.getPosition());
        }
    }

    @FXML
    void saveButtonEvent(ActionEvent event) {

        user.setLogin(txtUserLogin.getText().trim());
        user.setPassword(txtUserPassword.getText().trim());
        user.setName(txtUserName.getText().trim());
        user.setPosition(comBxPosition.getSelectionModel().getSelectedItem());

        boolean isResult = UserService.INSTANCE.addOrEditUser(user);

        if (isResult) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Пользователь сохранен!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Пользователь не сохранен!");
            alert.show();
        }
    }

    @FXML
    void initialize() {
        comBxPosition.setItems(FXCollections.observableList(PositionService.INSTANCE.findAllPostions()));
    }
}
