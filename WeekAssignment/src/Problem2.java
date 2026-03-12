import java.util.*;

public class Problem2 {

    static HashMap<String, Integer> stock = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    static {
        stock.put("IPHONE15_256GB", 100);
    }

    public static synchronized String purchaseItem(String productId, int userId) {

        int available = stock.getOrDefault(productId, 0);

        if (available > 0) {
            stock.put(productId, available - 1);
            return "Success, " + (available - 1) + " units remaining";
        } else {
            waitingList.add(userId);
            return "Added to waiting list, position #" + waitingList.size();
        }
    }

    public static int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static void main(String[] args) {

        System.out.println(checkStock("IPHONE15_256GB"));
        System.out.println(purchaseItem("IPHONE15_256GB", 12345));
        System.out.println(purchaseItem("IPHONE15_256GB", 67890));
    }
}