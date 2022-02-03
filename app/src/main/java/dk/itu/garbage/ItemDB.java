package dk.itu.garbage;

import java.util.ArrayList;
import java.util.List;


public class ItemDB {
    private List<Item> ItemsDB= new ArrayList<>();

    public ItemDB() {

    }

    // listItems modified to take input from TextEdit
    public String listItems(String input) {
        String r = "";
        for(Item i: ItemsDB) {
            if (input.equals(i.getWhat())) {
               r = i.toString();
            }
        }

        if (r.equals("")) {
            r = input + " should be placed in: not found";
        }

        return r;
    }

    public void addItem(String what, String where) {
        ItemsDB.add(new Item(what, where));
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("coffee", "Bio"));
        ItemsDB.add(new Item("carrots", "Bio"));
        ItemsDB.add(new Item("milk carton", "Residual Waste"));
        ItemsDB.add(new Item("bread", "Bio"));
        ItemsDB.add(new Item("butter", "Bio"));

        ItemsDB.add(new Item("peanut butter", "Bio"));
        ItemsDB.add(new Item("phone", "Electronic Waste"));
    }

}
