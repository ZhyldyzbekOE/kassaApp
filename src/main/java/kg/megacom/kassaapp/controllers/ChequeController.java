package kg.megacom.kassaapp.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import kg.megacom.kassaapp.models.OperationProducts;

public class ChequeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<OperationProducts> chequeLV;

    @FXML
    private TextField txtChange;



    public void setData(double change, List<OperationProducts> operationProductsList) {
        txtChange.setText(String.valueOf(change));
        chequeLV.setItems(FXCollections.observableList(operationProductsList));

    }

    @FXML
    void initialize() {
    }
}
