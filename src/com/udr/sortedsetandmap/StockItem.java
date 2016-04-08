package com.udr.sortedsetandmap;

/**
 * Created by udr013 on 6-4-2016.
 *
 * Note: Comparable takes <Stockitem> otherwise it takes Object!!!
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
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
        return name + ": price=" + price;
    }
}
