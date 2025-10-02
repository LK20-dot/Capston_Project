package Model;

public class ProductDetails {
    private int productId;
    private String name;
    private double price;
    private int quantity;
    private int stock;

    public ProductDetails(int productId, String name, double price, int stock){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){

        return String.format( "%-4d %-20s ₹%-8.2f %-8d", productId, name, price, stock);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        ProductDetails productDetails = (ProductDetails) obj;
        return productId == productDetails.productId;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(productId);
    }

//    public static void main(String[] args) {
//        ProductDetails p1 = new ProductDetails(1, "Laptop", 50000, 2);
//        System.out.println(p1);
//
//        p1.setName("Monitor");
//        System.out.println(p1.getName());
//
//        p1.setQuantity(8);
//        System.out.println(p1.quantity);
//    }
}



