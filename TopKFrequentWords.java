import java.util.*;

public class TopKFrequentWords {
    
    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        List<String> unique = new ArrayList<>(freq.keySet());
        unique.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb) {
                return Integer.compare(fb, fa);
            }
            return a.compareTo(b);
        });

        return unique.subList(0, Math.min(k, unique.size()));
    }

    public static void main(String[] args) {
        String[] words = {"java", "python", "java", "golang", "java", "python"};
        int k = 2;
        List<String> result = topKFrequent(words, k);
        System.out.println(result); // Output: [java, python]
    }
}
