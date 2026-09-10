import java.util.HashMap;

public class Verifying_an_Alien_Dictionary_Leetcode_953 {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            if (words.length == 1) {
                return true;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                map.put(order.charAt(i), i);
            }

            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                int j = 0;
                int k = 0;
                for (; j < word1.length() && k < word2.length(); j++, k++) {
                    if (map.get(word1.charAt(j)) > map.get(word2.charAt(k))) {
                        return false;
                    } else if (map.get(word1.charAt(j)) == map.get(word2.charAt(k))) {
                        continue;
                    } else { // map.get(word1.charAt(i)) < map.get(word2.charAt(j))
                        break;
                    }
                }
                if (word1.length() > j && word2.length() == k) {
                    return false;
                }
            }
            return true;
        }
    }
}
