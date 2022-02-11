package dk.itu.garbage;

import java.util.ArrayList;
import java.util.List;


public class ItemsDB {
    private static ItemsDB sItemsDB;
    private List<Item> ItemsDB= new ArrayList<>();

    private ItemsDB() {
        fillItemsDB();
    }

    public static void initialize() {
        if (sItemsDB == null) sItemsDB = new ItemsDB();
    }

    public static ItemsDB get() {
        if (sItemsDB == null) {
            throw new IllegalStateException("ItemsDB must be initialized");
        }
        return sItemsDB;
    }


    // takes input from TextEdit and searches Item object for equality
    public String searchItems(String input) {
        String dbItem = "";
        for(Item i: ItemsDB) {
            if (input.equals(i.getWhat())) {
               dbItem = i.toString();
            }
        }

        if (dbItem.equals("")) {
            dbItem = input + " should be placed in: not found";
        }

        return dbItem;
    }

    public void addItem(String what, String where) {
        ItemsDB.add(new Item(what, where));
    }

    private void fillItemsDB() {
        ItemsDB.add(new Item("coffee", "Bio"));
        ItemsDB.add(new Item("carrots", "Bio"));
        ItemsDB.add(new Item("milk carton", "Residual Waste"));
        ItemsDB.add(new Item("bread", "Bio"));
        ItemsDB.add(new Item("butter", "Bio"));

        ItemsDB.add(new Item("peanut butter", "Bio"));
        ItemsDB.add(new Item("phone", "Electronic Waste"));
    }

}
