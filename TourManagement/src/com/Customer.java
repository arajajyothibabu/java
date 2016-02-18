package com;

/**
 * Created by Araja Jyothi Babu on 18-02-2016.
 */
public class Customer {
    int customerId;
    String customerName;

    Customer(int id, String name){
        customerId = id;
        customerName = name;
    }

    int getCustomerId(){
        return this.customerId;
    }

    void setCustomerId(int id){
        this.customerId = id;
    }

    String getCustomerName(){
        return this.customerName;
    }

    void setCustomerName(String name){
        this.customerName = name;
    }

}
