import java.util.ArrayList;
import java.util.List;

public class Find_Words_Containing_Character_Leetcode_2942 {
    class Solution {
        public List<Integer> findWordsContaining(String[] words, char x) {

            List<Integer> ll = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {

                String s = words[i];

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == x) {
                        ll.add(i);
                        break;
                    }
                }

            }

            return ll;

        }
    }
}
