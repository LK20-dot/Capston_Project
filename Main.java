package Main;

import Database.DB;
import Model.ProductDetails;
import Services.ProductService;
import Services.ProductServiceTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceTest();

        ProductDetails p1 = new ProductDetails(1, "Laptop", 45000, 10);
        productService.addProduct(p1);

        List<ProductDetails> products = productService.getAllProducts();
        products.forEach(p -> System.out.println(p.getProductId() + " " + p.getName()));
    }

    public ProductDetails getProductById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ProductDetails(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductDetails> getAllProducts() {
        List<ProductDetails> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                products.add(new ProductDetails(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
