package com.udr.sortedsetandmap;

import sun.util.PreHashedMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by udr013 on 8-4-2016.
 */
public class Basket {
    private final String name;
    private final Map<StockItem ,Integer> list;

    public Basket(String name) {
        this.name = name;
        //this.list = new HashMap<>(); unsorted list
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if ((item!=null)&&quantity>0){
            int inBasket = list.getOrDefault(item,0);
            list.put(item,inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0) {
                list.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                list.remove(item);
                return quantity;
            }

    }
        return 0;
    }

    public void clearBasket(){
        this.list.clear();
    }

    public Map<StockItem,Integer> items(){
        return  Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s ="\nShoppingBasket "+ name+" contains "+ list.size()+ " items \n";
        double totalCost =0.0;
        for(Map.Entry<StockItem,Integer> item: list.entrySet()){
            s += item.getKey() + ". "+ item.getValue()+ " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "total cost: "+ String.format("%.2f",totalCost);
    }
}
