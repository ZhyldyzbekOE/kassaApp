package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.models.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static ProductDB INSTANCE;

    public static ProductDB getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ProductDB();
        }

        return INSTANCE;
    }


    public void insert(Product product){
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "insert into products(name, price, barcode, discount, amount, category_id, unit_id)" +
                    "values(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getBarcode());
            ps.setInt(4, product.getDiscount());
            ps.setDouble(5, product.getAmount());
            ps.setInt(6, product.getCategory().getId());
            ps.setInt(7, product.getUnit().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
        }

    }

    public List<Product> selectProducts() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select p.id, p.name, category_id, price, unit_id, barcode, amount, discount, c.name, unit_name from products p\n" +
                    "join categories c\n" +
                    "on p.category_id = c.id\n" +
                    "join units u\n" +
                    "on p.unit_id = u.id");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(4));
                product.setBarcode(resultSet.getString(6));
                product.setAmount(resultSet.getDouble(7));
                product.setDiscount(resultSet.getInt(8));

                Category category = new Category();
                category.setId(resultSet.getInt(3));
                category.setName(resultSet.getString(9));

                product.setCategory(category);

                Unit unit = new Unit();
                unit.setId(resultSet.getInt(5));
                unit.setName(resultSet.getString(10));

                product.setUnit(unit);


                products.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
            return products;
        }
    }

    public void update(Product product) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "update products set name = ?, price = ?, barcode= ?, discount= ?, amount= ?, category_id= ?, unit_id= ? where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getBarcode());
            ps.setInt(4, product.getDiscount());
            ps.setDouble(5, product.getAmount());
            ps.setInt(6, product.getCategory().getId());
            ps.setInt(7, product.getUnit().getId());
            ps.setInt(8, product.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
        }
    }

    public Product findProductByBarcode(String barcode) {
        Connection connection = null;
        Product product = new Product();

        try {
            connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement("select p.id, p.name, p.category_id,p.price,p.unit_id, p.barcode,\n" +
                    "p.amount,p.discount, c.name, u.unit_name\n" +
                    "from products p join categories c  \n" +
                    "on p.category_id = c.id \n" +
                    "join units u\n" +
                    "on p.unit_id = u.id\n" +
                    " where barcode = ?");
            ps.setString(1, barcode);

            ResultSet resultSet = ps.executeQuery();


            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setBarcode(barcode);
            product.setDiscount(resultSet.getInt(8));
            product.setAmount(resultSet.getInt(7));
            product.setPrice(resultSet.getDouble(4));

            Category category = new Category();
            category.setId(resultSet.getInt(3));
            category.setName(resultSet.getString(9));

            product.setCategory(category);

            Unit unit = new Unit();
            unit.setId(resultSet.getInt(5));
            unit.setName(resultSet.getString(10));

            product.setUnit(unit);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.close(connection);
            return product;
        }
    }
}
