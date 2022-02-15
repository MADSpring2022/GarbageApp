package com.example.garbageappv1;

public class Item {
    private String name;
    private String sort;

    public Item(String name, String sort){
        this.name = name;
        this.sort = sort;

    }

    @Override
    public String toString() { return oneLine(""," in: "); }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
    public String oneLine(String pre, String post) {
        return pre + name + post + sort;
    }
}
