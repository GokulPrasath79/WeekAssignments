import java.util.*;

public class Problem4 {

    static HashMap<String, Set<String>> ngramMap = new HashMap<>();

    public static List<String> generateNgrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            String gram = "";

            for (int j = 0; j < n; j++) {
                gram += words[i + j] + " ";
            }

            grams.add(gram.trim());
        }

        return grams;
    }

    public static void addDocument(String docId, String text) {

        List<String> grams = generateNgrams(text, 5);

        for (String gram : grams) {

            ngramMap.putIfAbsent(gram, new HashSet<>());
            ngramMap.get(gram).add(docId);
        }
    }

    public static void checkDocument(String docId, String text) {

        List<String> grams = generateNgrams(text, 5);
        HashMap<String, Integer> matchCount = new HashMap<>();

        for (String gram : grams) {

            if (ngramMap.containsKey(gram)) {

                for (String doc : ngramMap.get(gram)) {

                    matchCount.put(doc, matchCount.getOrDefault(doc, 0) + 1);
                }
            }
        }

        for (String doc : matchCount.keySet()) {

            double similarity = (matchCount.get(doc) * 100.0) / grams.size();

            System.out.println("Similarity with " + doc + ": " + similarity + "%");
        }
    }
}