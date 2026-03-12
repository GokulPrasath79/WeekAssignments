import java.util.*;

public class Problem9 {

    public static void findTwoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + nums[i]);
            }

            map.put(nums[i], i);
        }
    }

    public static void detectDuplicates(int[] amounts) {

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int a : amounts) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for (int key : count.keySet()) {
            if (count.get(key) > 1) {
                System.out.println("Duplicate transaction amount: " + key);
            }
        }
    }

    public static void main(String[] args) {

        int[] transactions = {500, 300, 200, 500};

        findTwoSum(transactions, 500);

        detectDuplicates(transactions);
    }
}