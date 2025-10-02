package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<ProductDetails, Integer> items;

    public Cart(){
        this.items = new HashMap<>();
    }

    public void addItem(ProductDetails productDetails, int quantity){
        if (items.containsKey(productDetails)){
            items.put(productDetails, items.get(productDetails) + quantity);
        }
        else {
            items.put(productDetails, quantity);
        }
    }

    public void removeItem(ProductDetails productDetails){
        items.remove(productDetails);
    }

    public double calculateTotal(){
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice()*entry.getValue()).sum();
    }

    public void showCart(){
        System.out.println("Cart Content: ");
        if (items.isEmpty()){
            System.out.println("Cart is empty: ");
        }

        items.forEach((productDetails, quantity) ->{
            System.out.println(productDetails.getName() + "|Qty: " + quantity + "|Price: " + productDetails.getPrice()
            + "|Subtotal " + (productDetails.getPrice()*quantity));
        } );

        System.out.println("Total: " + calculateTotal());
    }

    public Map<ProductDetails, Integer> getItems(){
        return items;
    }

    public void clearCart(){
        items.clear();
    }
}

//class CartTest {
//    public static void main(String[] args) {
//        ProductDetails p1 = new ProductDetails(1, "Laptop", 50000, 2);
//        ProductDetails p2 = new ProductDetails(2, "Book", 300, 5);
//
//        Cart cart = new Cart();
//
//        cart.addItem(p1, 1); // add 1 Laptop
//        cart.addItem(p2, 2); // add 2 Books
//
//        cart.showCart();
//
//        cart.removeItem(p1); // remove Laptop
//
//        System.out.println("\nAfter removing Laptop:");
//        cart.showCart();
//    }
//}