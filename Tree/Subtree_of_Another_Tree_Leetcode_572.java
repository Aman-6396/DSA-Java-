public class Subtree_of_Another_Tree_Leetcode_572 {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return subTree(root, subRoot);
        }

        public static boolean subTree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }

            if (root.val == subRoot.val) {
                boolean isIdentical = checkIdentical(root, subRoot);
                if (isIdentical) {
                    return true;
                }
            }

            boolean left = subTree(root.left, subRoot);
            boolean right = subTree(root.right, subRoot);
            return left || right;
        }

        public static boolean checkIdentical(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (root.val != subRoot.val) {
                return false;
            }
            boolean left = checkIdentical(root.left, subRoot.left);
            boolean right = checkIdentical(root.right, subRoot.right);
            return left && right;
        }
    }
}
