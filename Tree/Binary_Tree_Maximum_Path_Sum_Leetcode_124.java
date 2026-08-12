public class Binary_Tree_Maximum_Path_Sum_Leetcode_124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] max = new int[1]; // rather than creating global variable we create an array of size 1
            max[0] = Integer.MIN_VALUE;
            maximumPathSum(root, max);
            return max[0];
        }

        public static int maximumPathSum(TreeNode root, int[] max) {
            if (root == null) {
                return 0;
            }

            int left = Math.max(0, maximumPathSum(root.left, max)); // Kadane's don't consider -ive path
            int right = Math.max(0, maximumPathSum(root.right, max)); // if path is -ive it becomes 0
            max[0] = Math.max(max[0], left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
}
