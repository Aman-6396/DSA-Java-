public class Can_Place_Flowers_Leetcode_605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int zeroCount = 1;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    if ((zeroCount & 1) == 1) { // means odd
                        n -= (zeroCount / 2);
                    } else { // means even
                        n -= (zeroCount / 2) - 1;
                    }
                    if (n <= 0) {
                        return true;
                    }
                    zeroCount = 0; // set zerocount again at 0
                } else { // flowerbed[i] == 0
                    zeroCount++;
                }
            }

            zeroCount++; // for last zero case
            if ((zeroCount & 1) == 1) { // means odd
                n -= (zeroCount / 2);
            } else { // means even
                n -= (zeroCount / 2) - 1;
            }
            return n <= 0 ? true : false;
        }
    }

}
