package tcs.assignment4.Inheritance.com;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class Bank {

    ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank() {

    }

    public boolean addAccount(Account newAccount) {
        for(Account account : this.accounts)
            if(account.getAccountId() == newAccount.getAccountId())
                return false;
        this.accounts.add(newAccount);
        return true;
    }

    public double deposit(int accountId, double money) {
        for(Account account : this.accounts)
            if(account.getAccountId() == accountId)
                return account.deposit(money);
        return -1; //FIXME: What about if balance after deposit is -1 ?
    }

    public double withdraw(int accountId, double money){
        for(Account account : this.accounts)
            if(account.getAccountId() == accountId){
                if(account.getBalance() >= money)
                    return account.withdraw(money);
                else
                    return -1;
            }
        return -1;
    }

}
