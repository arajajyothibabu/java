package tcs.assignment5.Exception_Handling.com;

/**
 * Created by Araja Jyothi Babu on 06-Mar-16.
 */
public class PizzaKing {

    public static void makeOrder(String order1, String order2) throws DuplicateException {
        if(order1.toLowerCase().equals(order2.toLowerCase()))
            throw new DuplicateException();
    }

    public int performPizzaKingOperations(String order1, String order2){
        try{
            makeOrder(order1, order2);
            return 0; //successful order
        }catch (DuplicateException de){
            return -1; //duplicate order
        }catch (Exception e){
            return -2; //other exceptions
        }
    }

    public static void main(String args[]){
        PizzaKing pizzaKing = new PizzaKing();
        pizzaKing.performPizzaKingOperations("Tomato", "Chicken");
        pizzaKing.performPizzaKingOperations("paneer", "Paneer");
    }

}
