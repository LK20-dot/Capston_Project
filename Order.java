package Model;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private int orderId;
    private int userId;
    private Map<ProductDetails, Integer> items;
    private double totalAmount;
    private LocalDateTime orderDate;


    public Order(int orderId, int userId, Map<ProductDetails, Integer>items, double totalAmount, LocalDateTime orderDate){
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<ProductDetails, Integer> getItems() {
        return items;
    }

    public void setItems(Map<ProductDetails, Integer> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Order Id: ").append(orderId)
                .append("userId: ").append(userId)
                .append("Date: ").append(orderDate)
                .append("Items:");

        for (Map.Entry<ProductDetails, Integer> entry: items.entrySet()) {
            builder.append("_")
                    .append(entry.getKey().getName())
                    .append("| Qty: ").append(entry.getValue())
                    .append("|Price: ").append(entry.getKey().getPrice())
                    .append("\n");
        }

        builder.append("Total Amount: ").append(totalAmount);
        return builder.toString();
    }
}

//class orderTest{
//    public static void main(String[] args) {
//        ProductDetails p1 = new ProductDetails(1, "Laptop", 50000, 10);
//        ProductDetails p2 = new ProductDetails(2, "Books", 300, 5);
//
//        Map<ProductDetails, Integer>cartItems = new HashMap<>();
//
//        cartItems.put(p1, 1);
//        cartItems.put(p2, 2);
//
//        double total = cartItems.entrySet().stream()
//                .mapToDouble(entry -> entry.getKey().getPrice()*entry.getValue()).sum();
//
//        Order order = new Order(1001, 101, cartItems, total, LocalDateTime.now());
//
//        System.out.println(order);
//    }
//}

