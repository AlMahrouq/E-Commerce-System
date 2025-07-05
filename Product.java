/**
 * Product - represents the product and its attributes (name, price,...)
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean canExpire;
    private boolean requireShipping;
    private double weight;
    
    // constructor if no weight
    public Product(String name, double price, int quantity, boolean canExpire, boolean requireShipping){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.canExpire = canExpire;
        this.requireShipping = requireShipping;
    }

    // constructor if there is a weight
    public Product(String name, double price, int quantity, boolean canExpire, boolean requireShipping, double weight){
        this(name, price, quantity, canExpire, requireShipping);
        this.weight = weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean CanExpire(){
        return canExpire;
    }

    public boolean RequireShipping(){
        return requireShipping;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
