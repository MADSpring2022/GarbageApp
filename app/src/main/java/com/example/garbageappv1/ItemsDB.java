package com.example.garbageappv1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {
    private static List<Item> itemsList;
    private static ItemsDB itemsDB;


    // in singleton pattern,
    // we want to have a single instance of the class.
    // we make class constructor private so noOne can construct 'second' object of the class
    // and to create an instance of this class we provide us with 'ItemsDB get(Context context)' method.
    // this method returns existing instance of the class only if it exists(not null)
    // and it creates new instance if the instance didn't exists.
    public static ItemsDB get(Context context) {
        if (itemsDB == null) itemsDB = new ItemsDB(context);
        return itemsDB;
    }


    private ItemsDB(Context context) { itemsList = new ArrayList<>(); }


    //returns kind of the sorting container


    public String matcher(String itemName) {

        String result= "not found";
        //for each Item i from the database ItemDB check if itemName exist
        //and if exist break the loop and return it's 'sort'
        for (Item i: itemsList
        ) {

            //check if searched name exists on item list
            if(itemName.equals(i.getName())){
                //name have been found
                // change the result
                result = i.getSort();
            }

        }
        return result;
    }

    public String listItems() {

        String r= "";
        for(Item i: itemsList)
            r= r+"\n Place " + i.toString();

        return r;
    }

    public void addItem(String name, String sort){
        itemsList.add(new Item(name, sort));
    }

    public void fillItemsDB() {
        itemsList.add(new Item("milk", "food"));
        itemsList.add(new Item("coffee", "food"));
        itemsList.add(new Item("bag", "plastic"));
        itemsList.add(new Item("paper", "pap"));
        itemsList.add(new Item("newspaper", "pap"));
    }

}

