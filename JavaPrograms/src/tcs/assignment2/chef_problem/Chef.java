package tcs.assignment2.chef_problem;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class Chef {

    private int chefId;
    private String name;
    private double salary;

    public Chef(int chefId, String name, double salary) {
        this.chefId = chefId;
        this.name = name;
        this.salary = salary;
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
