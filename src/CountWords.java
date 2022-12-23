import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountWords {
    public static void main(String[] args) {
        String[] word1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] word2 = {"amazing", "leetcode", "is"};
        System.out.println(countWords(word1, word2));
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String word : words1) {
            map1.putIfAbsent(word, 0);
            map1.put(word, map1.get(word) + 1);
        }

        for (String word : words2) {
            map2.putIfAbsent(word, 0);
            map2.put(word, map2.get(word) + 1);
        }

        int count = 0;

        Iterator iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if (map2.containsKey(key) && map2.get(key) == 1 && map1.get(key) == 1) {
                count += 1;
            }
        }
        return count;
    }
}