package tcs.assignment2.find_youngest_customer;

/**
 * Created by Araja Jyothi Babu on 11-Mar-16.
 */
public class CustomerDemo {

    public static String findYoungestCustomerName(Customer[] customers){
        if(customers != null && customers.length > 0){
            double leastAge = customers[0].getAge();
            Customer youngestCustomer = null;
            for(Customer customer : customers){
                if(customer.getAge() < leastAge){
                    leastAge = customer.getAge();
                    youngestCustomer = customer;
                }
            }
            return youngestCustomer.getName();
        }
        return "Invalid Data";
    }

    public static void main(String args[]) throws Exception {
        Customer c1 = new Customer(123, 'M', "Araja", 21);
        Customer c2 = new Customer(124, 'M', "Jyothi", 20.75);
        Customer c3 = new Customer(125, 'M', "Babu", 22);
        Customer[] customers = {c1, c2, c3};
        System.out.println("Youngest Customer: " + findYoungestCustomerName(customers));

    }
}
