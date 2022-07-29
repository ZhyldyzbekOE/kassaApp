package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.services.impl.ProductServiceImpl;

import java.util.List;

public interface ProductService {

    ProductService INSTANCE = new ProductServiceImpl();

    void save(Product product);

    Product findProductByBarcode(String barcode);

    List<Product> getProducts();
}
