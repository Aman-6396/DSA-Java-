import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Clone_Graph_Leetcode_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            HashMap<Node, Node> map = new HashMap<>();
            return DFS(node, map);
        }

        public Node DFS(Node node, HashMap<Node, Node> map) {

            if (node == null) {
                return node;
            }

            if (map.containsKey(node)) {
                return map.get(node);
            }

            // clone node when not in map
            Node clone = new Node(node.val);
            map.put(node, clone);
            for (Node neighNode : node.neighbors) {
                clone.neighbors.add(DFS(neighNode, map));
            }

            return clone;

        }
    }

}
