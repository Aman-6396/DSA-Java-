public class Copy_List_with_Random_Pointer_Leetcode_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node temp = head;
            // Add copy node in between two nodes of original list
            while (temp != null) {
                Node ahead = temp.next;
                temp.next = new Node(temp.val);
                temp.next.next = ahead;
                temp = ahead;
            }
            // Points random
            Node temp2 = head;
            while (temp2 != null) {
                Node rn = temp2.random;
                if (rn == null) {
                    temp2.next.random = null;
                } else { // rn != null
                    temp2.next.random = rn.next;
                }
                temp2 = temp2.next.next;
            }
            // Create next link for final copy list
            Node dummy = head.next; // head of copied list
            Node temp3 = dummy; // for copied list
            Node tmp = head; // for original list
            while (tmp != null) {
                Node nextone = temp3.next;
                tmp.next = nextone;
                if (nextone == null) {
                    temp3.next = null;
                } else {
                    temp3.next = nextone.next;
                }
                temp3 = temp3.next;
                tmp = tmp.next;
            }
            return dummy;
        }
    }
}
