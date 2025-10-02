package Services;

import Model.ProductDetails;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDetails product);
    void removeProduct(int productId);
    List<ProductDetails> getAllProducts();
    ProductDetails getProductById(int productId);
    List<ProductDetails> searchProduct(String keyword);
    void updateProductStock(int productId, int newstock);
}
