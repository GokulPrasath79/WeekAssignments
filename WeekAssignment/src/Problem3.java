import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiry;
    }
}

public class Problem3 {

    static HashMap<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0;
    static int misses = 0;

    public static String resolve(String domain) {

        if (cache.containsKey(domain) && !cache.get(domain).isExpired()) {
            hits++;
            return "Cache HIT → " + cache.get(domain).ip;
        }

        misses++;

        String newIp = "172.217.14." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(newIp, 300));

        return "Cache MISS → " + newIp;
    }

    public static void getStats() {

        int total = hits + misses;
        double hitRate = (hits * 100.0) / total;

        System.out.println("Hit Rate: " + hitRate + "%");
    }

    public static void main(String[] args) {

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        getStats();
    }
}