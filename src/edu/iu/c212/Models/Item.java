package edu.iu.c212.models;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private int aisleNum;

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAisleNum() {
        return aisleNum;
    }

    public void setAisleNum(int aisleNum) {
        this.aisleNum = aisleNum;
    }

    public Item(String name, double price, int quantity, int aisleNum){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.aisleNum = aisleNum;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAisle(){
        return aisleNum;
    }
}
