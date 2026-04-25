package Leetcode_004_April_2026;

import java.util.ArrayList;
import java.util.List;

public class Words_Within_Two_Edits_of_Dictionary_Leetcode_2452 {
    class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> ll = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                String word1 = queries[i];
                for (int j = 0; j < dictionary.length; j++) {
                    String word2 = dictionary[j];
                    int diff = 0;
                    for (int idx = 0; idx < word1.length(); idx++) {
                        if (word1.charAt(idx) != word2.charAt(idx)) {
                            diff++;
                            if (diff > 2) {
                                break;
                            }
                        }
                    }
                    if (diff <= 2) {
                        ll.add(word1);
                        break;
                    }
                }
            }
            return ll;
        }
    }
}
