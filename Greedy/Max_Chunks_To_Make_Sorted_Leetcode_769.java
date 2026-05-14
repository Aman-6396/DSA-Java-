public class Max_Chunks_To_Make_Sorted_Leetcode_769 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int maxIdx = -1;
            int chunk = 0;
            for (int i = 0; i < arr.length; i++) {
                maxIdx = Math.max(maxIdx, arr[i]);
                if (maxIdx == i) {
                    chunk++;
                }
            }
            return chunk;
        }
    }
}
