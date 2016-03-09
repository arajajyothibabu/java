package tcs.assignment2.chef_problem;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class ChefOperations {

    public static Chef findChef(int chefId, Chef[] chefs) {
        for(Chef chef : chefs)
            if(chef.getChefId() == chefId)
                return chef;
        return null;
    }

    public static boolean searchChef(String chefName, Chef[] chefs) {
        for(Chef chef : chefs){
            if(chef.getName().toLowerCase().equals(chefName.toLowerCase()))
                return true;
        }
        return false; //not found condition
    }

    public static Chef getHighestPaidChef(Chef[] chefs) {
        double highestSalary = 0;
        Chef highestPaidChef = null;
        for(Chef chef : chefs){
            if(chef.getSalary() > highestSalary){
                highestSalary = chef.getSalary();
                highestPaidChef = chef;
            }
        }
        return highestPaidChef;
    }

}
