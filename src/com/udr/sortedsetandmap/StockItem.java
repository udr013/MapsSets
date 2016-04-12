package com.udr.sortedsetandmap;

/**
 * Created by udr013 on 6-4-2016.
 *
 * Note: Comparable takes <Stockitem> otherwise it takes Object!!!
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock;
    private  int availableStock;
    private int reserved;


    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.reserved=0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int reserveStock(int quantity) {
        if(quantity<=availableQuantity()){

            reserved = reserved + quantity;
        return quantity;
        }return 0;
    }

    public int unreserveStock(int quantity){
        if (quantity<=reserved){
            reserved-=quantity;
            return quantity;
        }return 0;
    }
     public int finaliseStock(int quantity){
         if (quantity<=reserved){
             quantityInStock-=quantity;
             reserved-=quantity;
             return quantity;
         }
            return 0;

     }
    @Override
    public boolean equals(Object o) {
        System.out.println("Entering stock.equals");
        if (o==this) {
            return true;
        }
        if (o == null || getClass() != this.getClass()){
            return false;
        }
        String stockItem = ((StockItem) o).getName();
        return this.name.equals(stockItem);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o){
            return 0;
        }
        if(o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + ": price=" + String.format("%.2f",price)+". Reserved"+ this.reserved;
    }
}
