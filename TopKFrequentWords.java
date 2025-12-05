import java.util.*;

public class TopKFrequentWords {

    /**
     * Mengembalikan k kata paling sering muncul dari array words.
     * Urutan: frekuensi (tinggi -> rendah), jika frekuensi sama urut alfabetis.
     */
    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return Collections.emptyList();
        }

        // Hitung frekuensi tiap kata
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Ambil daftar kata unik dan sortir sesuai aturan
        List<String> unique = new ArrayList<>(freq.keySet());
        unique.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb) {
                return Integer.compare(fb, fa); // frekuensi descending
            }
            return a.compareTo(b); // alfabetis ascending
        });

        // Kembalikan k pertama (jika k lebih besar dari jumlah unik, kembalikan semua)
        return unique.subList(0, Math.min(k, unique.size()));
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        String[] words = {"java", "python", "java", "golang", "java", "python"};
        int k = 2;
        List<String> result = topKFrequent(words, k);
        System.out.println(result); // Output yang diharapkan: [java, python]

        // Contoh lain
        String[] words2 = {"a", "b", "a", "c", "b", "b"};
        System.out.println(topKFrequent(words2, 3)); // [b, a, c]
    }
}