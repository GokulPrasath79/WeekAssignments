import java.util.*;

public class Problem7 {

    static HashMap<String, Integer> queries = new HashMap<>();

    static {
        queries.put("java tutorial", 1234567);
        queries.put("javascript", 987654);
        queries.put("java download", 456789);
    }

    public static List<String> search(String prefix) {

        List<Map.Entry<String, Integer>> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : queries.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                list.add(entry);
            }
        }

        list.sort((a, b) -> b.getValue() - a.getValue());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            result.add(list.get(i).getKey() + " (" + list.get(i).getValue() + ")");
        }

        return result;
    }

    public static void updateFrequency(String query) {
        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public static void main(String[] args) {

        System.out.println(search("jav"));

        updateFrequency("java 21 features");

        System.out.println(search("java"));
    }
}
