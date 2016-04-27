package google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by jun on 4/26/16.
 */
public class StockSystem {
    public static void main(String[] args) {
        StockSystem stock = new StockSystem();
        stock.add(1, 4);
        System.out.println(stock.getMax() + " " + stock.getMin() + " " + stock.getRecent());
        stock.add(4, 7);
        System.out.println(stock.getMax() + " " + stock.getMin() + " " + stock.getRecent());
        stock.add(2, 5);
        System.out.println(stock.getMax() + " " + stock.getMin() + " " + stock.getRecent());
        stock.remove(4);
        System.out.println(stock.getMax() + " " + stock.getMin() + " " + stock.getRecent());
        stock.add(4, 1);
        System.out.println(stock.getMax() + " " + stock.getMin() + " " + stock.getRecent());
    }

    SortedMap<Integer, Set<Long>> priceToTime;
    SortedMap<Long, Integer> timeToPrice;

    public StockSystem() {
        priceToTime = new TreeMap<>();
        timeToPrice = new TreeMap<>();
    }

    public int getMax() {
        return priceToTime.lastKey();
    }

    public int getMin() {
        return priceToTime.firstKey();
    }

    public int getRecent() {
        return timeToPrice.get(timeToPrice.lastKey());
    }

    public void add(long timestamp, int price) {
        priceToTime.putIfAbsent(price, new HashSet<Long>());
        priceToTime.get(price).add(timestamp);
        timeToPrice.put(timestamp, price);
    }

    public void update(long timestamp, int price) {
        priceToTime.get(price).remove(timestamp);
        priceToTime.get(price).add(timestamp);
        timeToPrice.put(timestamp, price);
    }

    public void remove(long timestamp) {
        int price = timeToPrice.get(timestamp);
        timeToPrice.remove(timestamp);
        priceToTime.get(price).remove(timestamp);
        if (priceToTime.get(price).isEmpty())
            priceToTime.remove(price);
    }

}
