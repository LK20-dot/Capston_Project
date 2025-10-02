package Database;

import Model.ProductDetails;
import Services.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducetServiceImpl implements ProductService {

    public void addProduct(ProductDetails product) {
        String sql = "INSERT INTO products (id, name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            stmt.executeUpdate();
            System.out.println(" Product added: " + product.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(int productId) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Product removed: ID " + productId);
            } else {
                System.out.println("No product found with ID " + productId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public List<ProductDetails> searchProduct(String keyword) {
        List<ProductDetails> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

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

    public void updateProductStock(int productId, int newStock) {
        String sql = "UPDATE products SET stock = ? WHERE id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newStock);
            stmt.setInt(2, productId);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Stock updated for ID " + productId + "New stock: " + newStock);
            } else {
                System.out.println("No product found with ID " + productId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
