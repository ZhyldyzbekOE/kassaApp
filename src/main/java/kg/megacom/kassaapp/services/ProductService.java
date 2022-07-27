package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.ProductDB;
import kg.megacom.kassaapp.models.Product;

import java.util.List;

public class ProductService {

    private static ProductService INSTANCE;

    public static ProductService getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ProductService();
        }
        return INSTANCE;
    }

    public void save(Product product) {
        if (product.getId() == null)
            ProductDB.getINSTANCE().insert(product);
        else
            ProductDB.getINSTANCE().update(product);
    }

    public Product findProductByBarcode(String barcode){
        return ProductDB.getINSTANCE().findProductByBarcode(barcode);
    }

    public List<Product> getProducts(){
        return ProductDB.getINSTANCE().selectProducts();
    }
}
