import java.util.*;

public class Problem10 {

    static LinkedHashMap<String, String> L1 =
            new LinkedHashMap<>(10000, 0.75f, true);

    static HashMap<String, String> L2 = new HashMap<>();

    static HashMap<String, String> L3 = new HashMap<>();

    static {
        L3.put("video_123", "Video Data A");
        L3.put("video_999", "Video Data B");
    }

    public static String getVideo(String videoId) {

        if (L1.containsKey(videoId)) {
            return "L1 HIT → " + L1.get(videoId);
        }

        if (L2.containsKey(videoId)) {

            String data = L2.get(videoId);
            L1.put(videoId, data);

            return "L2 HIT → Promoted to L1";
        }

        if (L3.containsKey(videoId)) {

            String data = L3.get(videoId);
            L2.put(videoId, data);

            return "L3 HIT → Added to L2";
        }

        return "Video not found";
    }

    public static void main(String[] args) {

        System.out.println(getVideo("video_123"));
        System.out.println(getVideo("video_123"));
        System.out.println(getVideo("video_999"));
    }
}
