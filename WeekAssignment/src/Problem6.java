import java.util.*;

class TokenBucket {
    int tokens;
    int maxTokens;
    long lastRefillTime;
    int refillRate;

    TokenBucket(int maxTokens, int refillRate) {
        this.tokens = maxTokens;
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.lastRefillTime = System.currentTimeMillis();
    }

    void refill() {
        long now = System.currentTimeMillis();
        long seconds = (now - lastRefillTime) / 1000;
        int refillTokens = (int) (seconds * refillRate);

        if (refillTokens > 0) {
            tokens = Math.min(maxTokens, tokens + refillTokens);
            lastRefillTime = now;
        }
    }
}

public class Problem6 {

    static HashMap<String, TokenBucket> clients = new HashMap<>();

    public static String checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(1000, 1));
        TokenBucket bucket = clients.get(clientId);

        bucket.refill();

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return "Allowed (" + bucket.tokens + " requests remaining)";
        } else {
            return "Denied (Rate limit exceeded)";
        }
    }

    public static void main(String[] args) {

        System.out.println(checkRateLimit("abc123"));
        System.out.println(checkRateLimit("abc123"));
    }
}