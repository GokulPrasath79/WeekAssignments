import java.util.*;

public class Problem5 {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    static HashMap<String, Integer> sources = new HashMap<>();

    public static void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public static void getDashboard() {

        System.out.println("Top Pages:");

        pageViews.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(e -> {
                    String page = e.getKey();
                    int views = e.getValue();
                    int unique = uniqueVisitors.get(page).size();

                    System.out.println(page + " - " + views + " views (" + unique + " unique)");
                });

        System.out.println("\nTraffic Sources:");

        for (String src : sources.keySet()) {
            System.out.println(src + ": " + sources.get(src));
        }
    }

    public static void main(String[] args) {

        processEvent("/article/breaking-news", "user123", "google");
        processEvent("/article/breaking-news", "user456", "facebook");
        processEvent("/sports/championship", "user789", "direct");

        getDashboard();
    }
}