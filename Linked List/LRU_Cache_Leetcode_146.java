import java.util.HashMap;

public class LRU_Cache_Leetcode_146 {
    class LRUCache {
        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head;
        Node tail;
        int length;
        HashMap<Integer, Node> map;

        public void deleteNode(Node curr) {
            Node prevNode = curr.prev;
            Node nextNode = curr.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        public void addNodeAfterHead(Node curr) {
            Node nextNode = head.next;
            head.next = curr;
            curr.next = nextNode;
            nextNode.prev = curr;
            curr.prev = head;
        }

        public LRUCache(int capacity) {
            map = new HashMap<>();
            length = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node nn = map.get(key);
                deleteNode(nn);
                addNodeAfterHead(nn);
                return nn.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node nn = map.get(key);
                nn.val = value; // upadte new value
                deleteNode(nn);
                addNodeAfterHead(nn);
            } else {
                if (map.size() == length) {
                    map.remove(tail.prev.key); // remove Least Recently Used key
                    deleteNode(tail.prev);
                }
                Node nn = new Node(key, value);
                map.put(key, nn);
                addNodeAfterHead(nn);
            }
        }
    }
}
