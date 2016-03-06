package tcs.assignment4.Inheritance.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class SavingAccount extends Account {

    public double deposit(double money){
        this.setBalance(this.getBalance() + money);
        return this.getBalance();
    }

    public double withdraw(double money) {
        this.setBalance(this.getBalance() - money);
        return this.getBalance();
    }

}
