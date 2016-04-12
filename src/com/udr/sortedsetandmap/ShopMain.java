package com.udr.sortedsetandmap;

import java.util.Map;

/**
 * Created by udr013 on 8-4-2016.
 */
public class ShopMain {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 1.25, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 2.45,50);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.55, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        //overrides the old price and add items
        temp = new StockItem("cup", 0.45, 80);
        stockList.addStock(temp);


        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 2.45,50);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        //print list of items on  Map<String, StockItem) Collections.unmodifiableMap(list) key/value
        // which is a copy of underlying collection, in this case LinkedHashMap
        //stockList.getItemsList().keySet().forEach(System.out::println);
        //or
        for(String s : stockList.getItemsList().keySet()){
            System.out.println(s);
        }

        Basket  myBasket = new Basket("mine");
        /**
         * items get sorted alphabetical because of use TreeMap using the overriden compareTo() in StockItem
         * which compares by name
         * vs use of LinkedHashMap using the order in which they are added to the basket
         * or random order when using HashMap
         *
         * note: last two are faster as they don't need the compareTo method
         * */
        sellItem(myBasket,"vase",4);
        //System.out.println(myBasket);
        sellItem(myBasket,"car",6);
        //System.out.println(myBasket);
        sellItem(myBasket,"bike",3);
        //System.out.println(myBasket);
        sellItem(myBasket,"towel",7);
        //System.out.println(myBasket);
        sellItem(myBasket,"car",1);
        //System.out.println(myBasket);
        sellItem(myBasket,"cup",25);
        //System.out.println(myBasket);
        sellItem(myBasket,"cup",15);
        //System.out.println(myBasket);


        Basket customer = new Basket("customer");
        sellItem(customer,"cup",9);
        sellItem(customer,"bread",9);
        sellItem(customer,"juice",4);
        sellItem(customer, "car",1);
        removeItem(customer, "cup", 2);
        System.out.println(customer);

        removeItem(myBasket, "towel", 8);
        removeItem(myBasket, "bike", 2);
        System.out.println("removed towel from basket: "+ removeItem(myBasket,"car",2));
        System.out.println("\ndisplay stocklist befor and after checkout");
        System.out.println(myBasket);
        System.out.println(stockList);
        checkOut(myBasket);
        System.out.println(stockList);

//        temp = new StockItem("pen",.98);
//        stockList.getItemsList().put(temp.getName(),temp);
        StockItem car = stockList.get("car");
        if(car!=null){
            car.adjustStock(2000);
        }
        if(car!=null){
            car.adjustStock(-1000);
        }
//        stockList.getItemsList().get("car").adjustStock(2000);
//        stockList.getItemsList().get("car").adjustStock(-1000);
//        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);
        for(Map.Entry<String, Double> price : stockList.getPriceList().entrySet()){
            System.out.println(price.getKey() + " Cost: "+ price.getValue());
        }

    }

    public static int removeItem(Basket basket,String item,int quantity){
        //retreive item from stock
        StockItem stockItem = stockList.get(item);
        if(stockItem==null){
            System.out.println("we don't sell those");
            return 0; // we need to return an int, so...
        }
        if(basket.removeFromBasket(stockItem,quantity)==quantity){
            return stockList.unreserveStock(item,quantity);
        }
        return 0;
    }

    public static int sellItem(Basket basket,String item,int quantity){
        //retreive item from stock
        StockItem stockItem = stockList.get(item);
        if(stockItem==null){
            System.out.println("we don't sell those");
            return 0; // we need to return an int, so...
        }
        if(stockList.reservedStock(item,quantity)!=0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem,Integer> item: basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
