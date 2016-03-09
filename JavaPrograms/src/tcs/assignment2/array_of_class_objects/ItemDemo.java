package tcs.assignment2.array_of_class_objects;

/**
 * Created by Araja Jyothi Babu on 07-Mar-16.
 */
public class ItemDemo {

    public static void main(String args[]) throws Exception {

        Item item1 = new Item(123, "Tomato", 12.5, 2);
        Item item2 = new Item(124, "Potato", 23.0, 3);
        Item item3 = new Item(125, "Onion", 18.5, 6);
        Item item4 = new Item(126, "Beans", 25, 4);
        Item item5 = new Item(127, "Brinjal", 10.5, 1.5);

        Item[] items = {item1, item2, item3, item4, item5};
        System.out.println("Item with least price: " + getLeastPriceItem(items).getItemName());

    }

    public static Item getLeastPriceItem(Item[] items) {
        if(items != null && items.length > 0){
            Item leastPriceItem = items[0];
            double actualPrice = leastPriceItem.getItemPrice() - leastPriceItem.getItemDiscount();
            for(Item item : items){
                if(actualPrice > (item.getItemPrice() - item.getItemDiscount())) {
                    actualPrice = item.getItemPrice() - item.getItemDiscount();
                    leastPriceItem = item;
                }
            }
            return leastPriceItem;
        }
        else{
            return null;
        }
    }

}
