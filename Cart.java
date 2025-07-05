import java.util.ArrayList;

/**
 * Cart - repersents the cart that collect items
 */
public class Cart {
    private ArrayList<Product> product_arr = new ArrayList<>();
    private ArrayList<Integer> quantity_arr = new ArrayList<>();
    private int size = 0;

    public int getSize() {
        return size;
    }

    public ArrayList<Product> getProduct_arr() {
        return product_arr;
    }

    public ArrayList<Integer> getQuantity_arr() {
        return quantity_arr;
    }

    /**
     * add - add quantitiy of produt to the cart
     * @param product
     * @param quantity
     * @return true if the required quantity available false otherwise
     */
    public boolean add(Product product, int quantity){
        if(product.getQuantity() >= quantity){
            product_arr.add(product);
            quantity_arr.add(quantity);
            ++size;
            return true;
        }else{
            return false;
        }
    }
}
