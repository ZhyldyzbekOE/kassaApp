package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import kg.megacom.kassaapp.models.User;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private MenuItem mnItemDelete;

    @FXML
    private TableView<User> tbUsers;

    @FXML
    private TableColumn<String, User> tbUserName;

    @FXML
    private TableColumn<String, User> tbUserLogin;

    @FXML
    private TableColumn<String, User> tbUserPosition;

    @FXML
    void onMenuItemClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}

