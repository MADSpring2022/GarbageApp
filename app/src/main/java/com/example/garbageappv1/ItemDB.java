package com.example.garbageappv1;

import java.util.ArrayList;
import java.util.List;

public class ItemDB {
    private List<Item>ItemsDB;

    public ItemDB(){
        ItemsDB = new ArrayList<>();
        //returns kind of the sorting container
    }
    public String matcher(String itemName) {

        String result= "not found";
        //for each Item i from the database ItemDB check if itemName exist
        //and if exist braek the loop and return it's 'sort'
        for (Item i: ItemsDB
        ) {

            //check if searched name exists on item list
            if(itemName.contains(i.getName())){
                //name have been found
                // change the result
                result = i.getSort();
            }

        }
        return result;
    }

    public void addItem(String name, String sort){
        ItemsDB.add(new Item(name, sort));
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("milk", "food"));
        ItemsDB.add(new Item("coffee", "food"));
        ItemsDB.add(new Item("bag", "plastic"));
        ItemsDB.add(new Item("paper", "pap"));
        ItemsDB.add(new Item("newspaper", "pap"));
    }

}
