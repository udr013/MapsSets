package com.udr.sortedsetandmap;


import java.util.Collections; //interface
import java.util.HashMap;
import java.util.LinkedHashMap; //actual class
import java.util.Map; //interface

/**
 * Created by udr013 on 8-4-2016.
 */
public class StockList {
    private final Map<String, StockItem> list;

    /**
     * LinkedHashMap will iterate in the order in which the entries were put into the map .
     *
     * TreeMap will iterate according to the "natural ordering" of the keys
     * according to their compareTo() method (or an externally supplied Comparator).
     * Additionally, it implements the SortedMap interface, which
     * contains methods that depend on this sort order.
      */
    public StockList() {
        //this.list = new HashMap(); //items are unsorted
        this.list = new LinkedHashMap<>();

    }

    public StockList(Map<String, StockItem> list) {
        this.list = list;
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if stock if already have quantities of this item
            //getOrDefault(getTheInfoFromStock, (or) addToStockWithDefaultValue)
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //StockItem inStock = list.get(item.getName());
            //if(inStock!= null){
            if (inStock != item) {
                //if there are already quantities of this stock adjust quantity
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0; // to indicate there is no stock movement
    }

    public int sellStock(String item, int quantity) {
        //key is item, defaultValue is null because we only want to know about the item if exists , not add one to list
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity != 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }else{
            System.out.println("only "+ inStock.quantityInStock()+" "+inStock.getName()+ " left.. adjust your order!");
            return 0;
        }
         //to indicate nothing happend
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    /**    copied from Collections.java also see lecture 107
     * Returns an unmodifiable view of the specified map.  This method
     * allows modules to provide users with "read-only" access to internal
     * maps.  Query operations on the returned map "read through"
     * to the specified map, and attempts to modify the returned
     * map, whether direct or via its collection views, result in an
     * <tt>UnsupportedOperationException</tt>.<p>
     *
     * The returned map will be serializable if the specified map
     * is serializable.
     *
     * @param \<K> the class of the map keys
     * @param \<V> the class of the map values
     * @param \ m the map for which an unmodifiable view is to be returned.
     * @return an unmodifiable view of the specified map.
     */
    public Map<String, StockItem> getItemsList() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> getPriceList() {
        Map<String,Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item : list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    //override the toString() for Stocklist class
    public String toString() {
        String s = "\nStock list\n";
        double totalCost = 0.0;
        //we iterate through the whole list, item of type, in list.entrySet()
        // look at Map.java
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s += stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: "
                    + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value: " + String.format("%.2f",totalCost);
    }
}

