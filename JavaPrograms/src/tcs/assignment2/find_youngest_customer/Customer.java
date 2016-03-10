package tcs.assignment2.find_youngest_customer;

/**
 * Created by Araja Jyothi Babu on 11-Mar-16.
 */
public class Customer {

    private int custId;
    private char gender;
    private String name;
    private double age;

    public Customer(int custId, char gender, String name, double age) {
        this.custId = custId;
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
