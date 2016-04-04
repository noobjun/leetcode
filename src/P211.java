import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 4/3/16.
 * 211. Add and Search Word - Data structure design
 */
public class P211 {
    public class WordDictionary {
        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            trie.add(word);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return trie.find(word, trie.root);
        }
    }

      class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            Node start = root;
            for (char c : word.toCharArray()) {
                Node next = new Node();
                start.map.putIfAbsent(c, next);
                start = start.map.get(c);
            }
            start.isWord = true;
        }

        public boolean find(String word, Node curr) {
            if (word.isEmpty())
                return curr.isWord;

            char c = word.charAt(0);
            if (c == '.') {
                for (char guess : curr.map.keySet()) {
                    if (find(word.substring(1), curr.map.get(guess)))
                        return true;
                }
                return false;
            } else {
                if (!curr.map.containsKey(c))
                    return false;
                else
                    return find(word.substring(1), curr.map.get(c));
            }
        }

        public class Node {
            private Map<Character, Node> map;
            private boolean isWord;

            public Node() {
                map = new HashMap<>();
                isWord = false;
            }
        }
    }
}
