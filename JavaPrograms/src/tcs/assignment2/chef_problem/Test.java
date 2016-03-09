package tcs.assignment2.chef_problem;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class Test {

    public static void main(String args[]) throws Exception {
        Chef chef1 = new Chef(123, "Chef1", 12000);
        Chef chef2 = new Chef(124, "Chef2", 10000);
        Chef chef3 = new Chef(125, "Chef3", 20000);
        Chef chef4 = new Chef(126, "Chef4", 30000);
        Chef chef5 = new Chef(127, "Chef5", 40000);
        Chef[] chefs = {chef1, chef2, chef3, chef4, chef5};
        ChefOperations chefOperations = new ChefOperations();

        System.out.println("Find Chef: " + chefOperations.findChef(125, chefs).getName());

        System.out.println("Search Chef with name: chef3 ::  " + chefOperations.searchChef("chef3", chefs));

        System.out.println("Highest Paid Chef :: " + chefOperations.getHighestPaidChef(chefs).getName());

    }

}
