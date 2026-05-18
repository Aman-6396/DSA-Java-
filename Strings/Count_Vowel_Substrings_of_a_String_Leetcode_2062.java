public class Count_Vowel_Substrings_of_a_String_Leetcode_2062 {
    class Solution {
        public int countVowelSubstrings(String word) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                int counta = 0;
                int counte = 0;
                int counti = 0;
                int counto = 0;
                int countu = 0;
                for (int j = i; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if (ch == 'a') {
                        counta++;
                    } else if (ch == 'e') {
                        counte++;
                    } else if (ch == 'i') {
                        counti++;
                    } else if (ch == 'o') {
                        counto++;
                    } else if (ch == 'u') {
                        countu++;
                    } else {
                        break;
                    }

                    if (counta > 0 && counte > 0 && counti > 0 && counto > 0 && countu > 0) {
                        count++;
                    }

                }
            }
            return count;
        }
    }
}
