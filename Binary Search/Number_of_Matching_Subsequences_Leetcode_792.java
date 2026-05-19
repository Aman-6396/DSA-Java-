import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Number_of_Matching_Subsequences_Leetcode_792 {
    // Brute Force Approach with Time Complexity is O(N * K) which gives TLE
    // class Solution {
    // public int numMatchingSubseq(String s, String[] words) {
    // int count = 0;
    // for (int i = 0; i < words.length; i++) {

    // if (isSubsequence(s, words[i])) {
    // count++;
    // }
    // }
    // return count;
    // }

    // public static boolean isSubsequence(String s, String str) {
    // int i = 0;
    // int j = 0;
    // while (i < s.length() && j < str.length()) {
    // if (s.charAt(i) == str.charAt(j)) {
    // i++;
    // j++;
    // } else {
    // i++;
    // }
    // }

    // return j == str.length();
    // }
    // }

    // Using hashmap and binary search with Time Complexity O(N + W * L * logN)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            HashMap<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    List<Integer> ll = map.get(ch);
                    ll.add(i);
                    map.put(ch, ll);
                } else {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(i);
                    map.put(ch, ll);
                }
            }

            return numsOfMatches(s, words, map);
        }

        public static int numsOfMatches(String s, String[] words, HashMap<Character, List<Integer>> map) {

            int count = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean isFound = true;
                int prev = -1;

                for (int j = 0; j < word.length(); j++) {
                    if (map.containsKey(word.charAt(j))) {
                        List<Integer> ll = map.get(word.charAt(j));
                        int idx = prev;
                        int left = 0;
                        int right = ll.size() - 1;

                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (ll.get(mid) > prev) {
                                idx = ll.get(mid);
                                right = mid - 1;
                            } else {
                                left = mid + 1;
                            }
                        }

                        if (prev == idx) { // means no idx found which is greater than prev
                            isFound = false;
                            break;
                        }

                        prev = idx;

                    } else {
                        isFound = false;
                        break;
                    }
                }

                if (isFound) {
                    count++;

                }
            }
            return count;
        }
    }

}
