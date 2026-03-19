import java.util.HashMap;

public class Word_Pattern_Leetcode_290 {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] arr = s.split("\\s+");
            if (arr.length != pattern.length()) {
                return false;
            }
            return isPatternString(pattern, arr);

        }

        public static boolean isPatternString(String pattern, String[] arr) {

            HashMap<Character, String> map1 = new HashMap<>();
            HashMap<String, Character> map2 = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {

                char ch = pattern.charAt(i);
                String s = arr[i];

                // For map1
                if (map1.containsKey(ch)) {
                    if (!map1.get(ch).equals(s)) {
                        return false;
                    }
                } else {
                    map1.put(ch, s);
                }

                // For map2
                if (map2.containsKey(s)) {
                    if (!map2.get(s).equals(ch)) {
                        return false;
                    }
                } else {
                    map2.put(s, ch);
                }
            }

            return true;

        }

    }
}
