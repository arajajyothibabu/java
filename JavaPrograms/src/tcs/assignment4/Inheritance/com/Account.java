package tcs.assignment4.Inheritance.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public abstract class Account {

    private int accountId;
    private String CustomerId;
    private double balance;

    public Account() {

    }

    public Account(String customerId, int accountId, double balance) {
        CustomerId = customerId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    abstract double deposit(double money);

    abstract double withdraw(double money);

}
