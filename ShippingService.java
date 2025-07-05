import java.util.ArrayList;

interface Service {
    String getName();
    double getWeight();
}
/**
 * ShippingService - the service that takes the products that want to be shipping
 */
public class ShippingService implements Service {
    ArrayList<Product> products;
    int ind = 0; // index of item to return it's name and weight

    public ShippingService(ArrayList<Product> products){
        this.products = products;
    }

    @Override
    public String getName(){
        return products.get(ind).getName();
    }

    @Override
    public double getWeight(){
        return products.get(ind).getWeight();
    }
}
