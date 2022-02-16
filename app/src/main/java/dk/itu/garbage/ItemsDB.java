package dk.itu.garbage;

import java.util.HashMap;
import java.util.Map;


public class ItemsDB {
    //a static factory method with the return type as an object of this singleton class
    private static ItemsDB sItemsDB;
    private Map<String, String> itemsDB = new HashMap<>();

    //declaring access modifier of constructor private
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
        if (itemsDB.containsKey(input.toLowerCase().trim())) {
           dbItem = input + " should be placed in: " + itemsDB.get(input);
           return dbItem;
        }

        return input + " not found";
    }

    public void addItem(String what, String where) {
        itemsDB.put(what, where);
    }

    private void fillItemsDB() {
        //get items and categories from file
        itemsDB.put("coffee", "Bio");
        itemsDB.put("carrots", "Bio");
        itemsDB.put("milk carton", "Residual Waste");
        itemsDB.put("bread", "Bio");
        itemsDB.put("butter", "Bio");
        itemsDB.put("peanut butter", "Bio");
        itemsDB.put("phone", "Electronic Waste");
    }

}
