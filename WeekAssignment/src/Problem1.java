import java.util.*;

public class Problem1 {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    static {
        users.put("john_doe", 101);
        users.put("admin", 1);
    }

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public static String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for (String user : attempts.keySet()) {
            if (attempts.get(user) > max) {
                max = attempts.get(user);
                maxUser = user;
            }
        }

        return maxUser + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));
        System.out.println(suggestAlternatives("john_doe"));
        System.out.println(getMostAttempted());
    }
}