import java.util.ArrayList;

public class Main {
    /**
     * checkout - helper method to handel operation of checking out cart of items for some customer
     * Supposing that each item take 20 for Shipping
     * It handels printing kg if weight >= 1000 g
     * @param customer the customer that want to buy the items
     * @param cart the group of items for some customer
     */
    static void checkout(Customer customer, Cart cart){
        System.out.println("** Shipment notice **");
        ArrayList<Product> product = cart.getProduct_arr();
        ArrayList<Integer> quantity = cart.getQuantity_arr();

        // Looping over the cart items to sum it's subtotal, shipping, and weight to use them for checking errors
        double total_weight = 0, Subtotal = 0, Shipping = 0;
        boolean breakAvailable = false;
        for(int i = 0; i < cart.getSize(); ++i){
            if(quantity.get(i) > product.get(i).getQuantity()) breakAvailable = true;

            Subtotal += product.get(i).getPrice() * quantity.get(i);
            Shipping += 20 * quantity.get(i);

            System.err.print(quantity.get(i) + "x " + product.get(i).getName() + "        ");
            if(product.get(i).RequireShipping()){
                double weight = product.get(i).getWeight() * quantity.get(i);
                
                if(weight >= 1000) System.out.println((weight / 1000) + "kg");
                else System.out.println(weight + "g");

                total_weight += weight;
            }
            else
                System.out.println();
        }
        System.out.print("Total package weight ");
        if(total_weight >= 1000) System.out.println((total_weight/1000) + "kg");
        else System.out.println(total_weight + "g");

        System.out.println();

        // Handel Errors
        if(cart.getSize() == 0){
            System.out.println("Error: Cart is empty.");

        }else if(breakAvailable){
            System.out.println("Error: One product is out of stock or expired.");
        }
        else if(Subtotal + Shipping > customer.getBalance()){
            System.out.println("Error: Customer's balance is insufficient.");
        }else{ // No Error
            
            // Looping over cart to collect items and send them to the Shipping Service
            ArrayList<Product> shipping = new ArrayList<>();
            System.out.println("** Checkout receipt **");
            for(int i = 0; i < cart.getSize(); ++i){
                int old = product.get(i).getQuantity();
                int total = quantity.get(i);
                product.get(i).setQuantity(old - total);
                System.err.println(quantity.get(i) + "x " + product.get(i).getName() + "        " + product.get(i).getPrice() * quantity.get(i));

                // sending items to the shipping service
                shipping.add(new Product(product.get(i).getName(), product.get(i).getPrice(), total, product.get(i).CanExpire(), product.get(i).RequireShipping(), product.get(i).getWeight()));
                ShippingService service = new ShippingService(shipping);
            }
            customer.setBalance(customer.getBalance() - (Subtotal + Shipping));
            System.out.println("----------------------------");
            System.out.println("Subtotal        " + Subtotal);
            System.out.println("Shipping        " + Shipping);
            System.out.println("Amount        " + (Subtotal + Shipping));
            System.out.println("customer current balance is: " + customer.getBalance());
        }
        System.out.println("==============================================");
    }

    public static void main(String[] args) {
        Product Cheese = new Product("Cheese", 30, 4, true, true, 500);
        Product Biscuits = new Product("Biscuits", 20, 4, true, true, 200);
        Product Mobile = new Product("Mobile", 100, 2, false, true, 900);

        Customer ahmed = new Customer("ahmed", 420);
        Customer ali = new Customer("ali", 40);
        Customer gamal = new Customer("gamal", 180);

        Cart ahmedCart = new Cart();
        Cart aliCart = new Cart();
        Cart gamalCart = new Cart();
        
        ahmedCart.add(Cheese, 2);
        ahmedCart.add(Biscuits, 2);
        ahmedCart.add(Mobile, 2);

        aliCart.add(Cheese, 4);

        gamalCart.add(Cheese, 2);
        gamalCart.add(Biscuits, 2);

        checkout(ahmed, ahmedCart);
        checkout(ali, aliCart);
        checkout(gamal, gamalCart);
        
    }
}