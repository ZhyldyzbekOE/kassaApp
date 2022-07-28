package kg.megacom.kassaapp.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kg.megacom.kassaapp.Main;
import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.UserService;
import kg.megacom.kassaapp.services.impl.UserServiceImpl;

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
        if (event.getSource().equals(mnItemAdd)) {
            userAdd();
        } else if (event.getSource().equals(mnItemEdit)) {
            userEdit();
        } else if (mnItemDelete.equals(event.getSource())) {
            deleteUser(tbUsers.getSelectionModel().getSelectedItem());
        } else {
            throw new RuntimeException("Ошибка при заргузке окна!");
        }
    }

    private void deleteUser(User selectedItem) {
        System.out.println("LOG -- " + selectedItem.getId());
        UserServiceImpl.getINSTANCE().deleteUser(selectedItem.getId());
        refreshTableUsers();
    }

    private void userEdit() {
        showForm(tbUsers.getSelectionModel().getSelectedItem());
    }

    private void userAdd() {
        showForm(new User());
    }

    private void showForm(User user) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("usersAddForm.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            UserFormController controller = loader.getController();
            controller.setUser(user);

            stage.showAndWait();

            refreshTableUsers();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {
        tbUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbUserLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        tbUserPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        refreshTableUsers();
    }

    private void refreshTableUsers(){
        tbUsers.setItems(FXCollections.observableList(UserService.INSTANCE.findAllUsers()));
    }
}

