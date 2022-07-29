package kg.megacom.kassaapp.controllers;

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
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.services.ProductService;
import kg.megacom.kassaapp.services.impl.ProductServiceImpl;

import java.io.IOException;

public class ProductsController {

    @FXML
    private TableView<Product> tbProducts;

    @FXML
    private TableColumn<String, Product> colmAmount;

    @FXML
    private TableColumn<String, Product>  colmBarcode;

    @FXML
    private TableColumn<String, Product>  colmCategory;

    @FXML
    private TableColumn<String, Product>  colmDiscount;

    @FXML
    private TableColumn<String, Product>  colmName;

    @FXML
    private TableColumn<String, Product>  colmPrice;

    @FXML
    private TableColumn<String, Product>  colmUnit;

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemDelete;

    @FXML
    private MenuItem mnItemEdit;



    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(mnItemAdd)){
            addProduct();
        }else if (event.getSource().equals(mnItemEdit)){
            editProduct();
        }
    }

    private void showForm(Product product){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("productEditForm.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            ProductEditController controller = loader.getController();
            controller.setProduct(product);

            stage.showAndWait();

            refreshTable();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct() {
        showForm(tbProducts.getSelectionModel().getSelectedItem());


    }

    private void addProduct() {
        showForm(new Product());
    }

    @FXML
    void initialize() {

        colmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colmAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colmBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colmCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colmDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colmUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        refreshTable();


    }

    private void refreshTable() {
        tbProducts.setItems(FXCollections.observableList(ProductService.INSTANCE.getProducts()));
    }

}
