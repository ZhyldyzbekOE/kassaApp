package kg.megacom.kassaapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kg.megacom.kassaapp.Main;
import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.UserService;

import java.net.URL;
import java.util.ResourceBundle;

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
        Alert alert;
        if ((txtLoginField.getText().trim().isEmpty() && txtPassField.getText().trim().isEmpty())) {
            alert = new Alert(Alert.AlertType.ERROR, "Введите поля!");
            alert.show();
            return;
        }

        User user = UserService.INSTANCE.findUserByLoginAndPassword(txtLoginField.getText().trim(), txtPassField.getText().trim());
        if (user == null) {
            alert = new Alert(Alert.AlertType.WARNING, "Пользователь не найден!");
            alert.show();
            return;
        }

        if (user.getLogin().equals(txtLoginField.getText().trim()) && user.getPassword().equals(txtPassField.getText().trim())) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("mainForm.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                MainController controller = loader.getController();
                controller.setData(user);
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            alert = new Alert(Alert.AlertType.WARNING, "Неверные данные!");
            alert.show();
            return;
        }

    }

    @FXML
    void initialize() {

    }
}
