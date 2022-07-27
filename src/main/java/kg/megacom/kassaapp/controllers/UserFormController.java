package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private ComboBox<?> comBxPosition;

    @FXML
    void saveButtonEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
