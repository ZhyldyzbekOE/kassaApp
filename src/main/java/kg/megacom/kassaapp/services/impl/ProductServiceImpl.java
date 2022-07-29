package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.ProductDB;
import kg.megacom.kassaapp.db.impl.ProductDBImpl;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {


    public void save(Product product) {
        if (product.getId() == null)
            ProductDB.INSTANCE.insert(product);
        else
            ProductDB.INSTANCE.update(product);
    }

    public Product findProductByBarcode(String barcode){
        return ProductDB.INSTANCE.findProductByBarcode(barcode);
    }

    public List<Product> getProducts(){
        return ProductDB.INSTANCE.selectProducts();
    }
}
