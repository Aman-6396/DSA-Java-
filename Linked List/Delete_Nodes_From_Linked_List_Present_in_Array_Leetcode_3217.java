import java.util.HashSet;

public class Delete_Nodes_From_Linked_List_Present_in_Array_Leetcode_3217 {
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
        public ListNode modifiedList(int[] nums, ListNode head) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            ListNode prev = new ListNode();
            ListNode temp = prev;
            prev.next = head;
            while (head != null) {
                if (set.contains(head.val)) {
                    prev.next = head.next;
                    head.next = null;
                    head = prev.next;
                } else {
                    prev = head;
                    head = head.next;
                }
            }
            return temp.next;
        }
    }

}
