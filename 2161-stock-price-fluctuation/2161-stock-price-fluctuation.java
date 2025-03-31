import java.util.Map;
import java.util.TreeMap;

class StockPrice {
    private TreeMap<Integer, Integer> prices;
    private TreeMap<Integer, Integer> count;
    private int maxTimestamp;
    
    public StockPrice() {
        prices = new TreeMap<>();
        count = new TreeMap<>();
        maxTimestamp = 0;
    }
    
    public void update(int timestamp, int price) {
        if (prices.containsKey(timestamp)) {
            int oldPrice = prices.get(timestamp);
            count.put(oldPrice, count.get(oldPrice) - 1);
            if (count.get(oldPrice) == 0) {
                count.remove(oldPrice);
            }
        }
        prices.put(timestamp, price);
        count.put(price, count.getOrDefault(price, 0) + 1);
        maxTimestamp = Math.max(maxTimestamp, timestamp);
    }
    
    public int current() {
        return prices.get(maxTimestamp);
    }

    public int maximum() {
        return count.lastKey();
    }

    public int minimum() {
        return count.firstKey();
    }
}