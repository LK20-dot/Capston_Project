package Services;

import Model.ProductDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceTest implements ProductService {
    private List<ProductDetails> productList = new ArrayList<>();

    @Override
    public void addProduct(ProductDetails product){
        productList.add(product);
        System.out.println(product.getName());
    }

    @Override
    public void removeProduct(int productId){
        productList.removeIf(p -> p.getProductId() == productId);
        System.out.println(productId);
    }

    @Override
    public List<ProductDetails> getAllProducts(){
        return productList;
    }

    @Override
    public ProductDetails getProductById(int productId){
        return productList.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ProductDetails> searchProduct(String keyword){
        return productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProductStock(int productId, int newStock){
        ProductDetails product = getProductById(productId);
        if (product != null){
            product.setStock(newStock);
            System.out.println(product.getName() + ":" + newStock);
        }else {
            System.out.println(productId);
        }
    }
}

//class ProductServiceTest {
//    public static void main(String[] args) {
//        ProductService productService = new ProductServiceImpl();
//
//        // Add products
//        productService.addProduct(new ProductDetails(1, "Laptop", 50000, 10));
//        productService.addProduct(new ProductDetails(2, "Book", 300, 50));
//
//        // Display all products
//        System.out.println("\n All Products:");
//        productService.getAllProducts().forEach(System.out::println);
//
//        // Search products
//        System.out.println("\n Search Results for 'book':");
//        productService.searchProduct("book").forEach(System.out::println);
//
//        // Update stock
//        productService.updateProductStock(1, 8);
//
//        // Remove a product
//        productService.removeProduct(2);
//
//        // Display final list
//        System.out.println("\n Final Products:");
//        productService.getAllProducts().forEach(System.out::println);
//    }
//}

