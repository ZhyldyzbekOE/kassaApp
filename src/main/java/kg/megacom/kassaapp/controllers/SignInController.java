package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLoginField;

    @FXML
    private PasswordField txtPassField;

    @FXML
    private Button btnSignIn;

    @FXML
    void signInAction(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
