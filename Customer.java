/**
 * Customer - The customer class has username and balance
 */
public class Customer {
    private String username;
    private double balance;

    public Customer(String username, double balance){
        this.username = username;
        this.balance = balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }
}
