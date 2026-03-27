import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Search_II_Leetcode_212 {
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> ll = new ArrayList<>();
            Trie tt = new Trie();

            // Add each word in trie
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                tt.insert(w);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (tt.getRoot().child.containsKey(board[i][j])) {
                        found(board, tt.getRoot(), new StringBuilder(), i, j, ll);
                    }
                }
            }

            return ll;

        }

        public static void found(char[][] board, Trie.Node curr, StringBuilder ans, int cr, int cc, List<String> ll) {

            char ch = board[cr][cc];

            if (!curr.child.containsKey(ch)) {
                return;
            }
            Trie.Node next = curr.child.get(ch);
            ans.append(ch);
            if (next.isTerminal == true) {
                ll.add(ans.toString());
                next.isTerminal = false; // avoid duplicates
            }

            board[cr][cc] = '#'; // mark visited

            // down
            if (cr < board.length - 1 && board[cr + 1][cc] != '#') {
                found(board, next, ans, cr + 1, cc, ll);
            }

            // right
            if (cc < board[0].length - 1 && board[cr][cc + 1] != '#') {
                found(board, next, ans, cr, cc + 1, ll);
            }

            // up
            if (cr > 0 && board[cr - 1][cc] != '#') {
                found(board, next, ans, cr - 1, cc, ll);
            }

            // left
            if (cc > 0 && board[cr][cc - 1] != '#') {
                found(board, next, ans, cr, cc - 1, ll);
            }

            board[cr][cc] = ch; // Backtrack
            ans.deleteCharAt(ans.length() - 1); // Backtrack
        }
    }

    class Trie {
        class Node {
            char ch;
            boolean isTerminal;
            HashMap<Character, Node> child = new HashMap<>();

            public Node(char ch) {
                this.ch = ch;
            }
        }

        public Node root;

        public Trie() {
            root = new Node('*');
        }

        public Node getRoot() {
            return root;
        }

        public void insert(String s) {

            Node curr = root;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                } else {
                    Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }

            }
            curr.isTerminal = true;

        } // insert method end

    } // Trie class end
}
