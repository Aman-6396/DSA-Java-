public class Remove_Nodes_From_Linked_List_Leetcode_2487 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // class Solution {
    // public ListNode removeNodes(ListNode head) {
    // ListNode prev = new ListNode();
    // ListNode temp = prev;
    // prev.next = head;
    // nodesRemoval(head, prev);
    // return temp.next;
    // }

    // public static int nodesRemoval(ListNode curr, ListNode prev) {
    // if (curr.next == null) {
    // return curr.val;
    // }

    // int max = nodesRemoval(curr.next, curr);

    // if (curr.val < max) {
    // prev.next = curr.next;
    // curr.next = null;
    // } else {
    // max = Math.max(max, curr.val);
    // }
    // return max;
    // }
    // }

    // Without using prev node
    class Solution {
        public ListNode removeNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }

            head.next = removeNodes(head.next);

            if (head.val < head.next.val) {
                return head.next;
            }
            return head;
        }
    }
}
