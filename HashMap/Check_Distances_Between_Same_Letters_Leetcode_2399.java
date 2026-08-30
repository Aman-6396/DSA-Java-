import java.util.HashMap;

public class Check_Distances_Between_Same_Letters_Leetcode_2399 {
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!map.containsKey(ch)) {
                    map.put(ch, i);
                } else { // map has char ch
                    if (i - map.get(ch) - 1 != distance[ch - 97]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
