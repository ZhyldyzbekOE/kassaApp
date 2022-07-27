package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.User;

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

    }

    @FXML
    void initialize() {

    }
}
