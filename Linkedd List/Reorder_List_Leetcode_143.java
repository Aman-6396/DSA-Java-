// import java.util.ArrayList;
// import java.util.List;

public class Reorder_List_Leetcode_143 {
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

    // Method 1 using list with time complexity O(N) and space is also O(N)
    // class Solution {
    // public void reorderList(ListNode head) {
    // ListNode curr = head;
    // List<ListNode> ll = new ArrayList<>();

    // while (curr != null) {
    // ll.add(curr);
    // curr = curr.next;
    // }

    // int i = 0;
    // int j = ll.size() - 1;
    // while (i < j) {
    // ll.get(i).next = ll.get(j);
    // i++;

    // if (i == j) {
    // break;
    // }

    // ll.get(j).next = ll.get(i);
    // j--;
    // }

    // ll.get(i).next = null;// make last element's next = null
    // }
    // }

    // Without using any extra space with time complexity O(N)

    class Solution {
        public void reorderList(ListNode head) {

            // Step 1 => Find middle

            ListNode slow = head;
            ListNode fast = head;
            while (fast == null || fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2 => Reverse second half

            ListNode prev = null;
            ListNode curr = slow.next;
            slow.next = null; // break connection

            while (curr != null) {
                ListNode ahead = curr.next;

                curr.next = prev;
                prev = curr;
                curr = ahead;
            }

            // Step 3 => Merge LL

            ListNode curr1 = head;
            ListNode curr2 = prev;

            while (curr1 != null || curr2 != null) { // there is not need to check curr1 != null

                ListNode ahead1 = curr1.next;
                ListNode ahead2 = curr2.next;

                curr1.next = curr2;
                curr2.next = ahead1;

                curr1 = ahead1;
                curr2 = ahead2;
            }

        }
    }
}
