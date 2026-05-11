import java.util.HashMap;

public class Custom_Sort_String_Leetcode_791 {
    class Solution {
        public String customSortString(String order, String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            // add characters of string s according to string order
            for (int i = 0; i < order.length(); i++) {
                if (map.containsKey(order.charAt(i))) {
                    int freq = map.get(order.charAt(i));

                    for (int j = 0; j < freq; j++) {
                        sb.append(order.charAt(i));
                    }

                    map.remove(order.charAt(i));
                }
            }

            // add remaining characters of string s
            for (Character v : map.keySet()) {
                int freq = map.get(v);
                for (int j = 0; j < freq; j++) {
                    sb.append(v);
                }
            }

            return sb.toString();
        }
    }
}
