package Leetcode_003_March_2026;

public class Delete_the_Middle_Node_of_a_Linked_List_Leetcode_2095 {
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

    class Solution {
        public ListNode deleteMiddle(ListNode head) {

            if (head.next == null) {
                return null;
            }

            ListNode prev = null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = slow.next; // make new connection
            slow.next = null; // break connection of middle node

            return head;
        }
    }
}
