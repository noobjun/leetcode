package airbnb;

import java.util.*;

/**
 * Created by jun on 5/8/16.
 * K Edit Distance
 * Given a list of word and a target word, output all the words for each the edit distance with the target no greater than k.
 * e.g. [abc, abd, abcd, adc], target "ac", k = 1,
 * output = [abc, adc]
 */

public class KEditDistance {
    public static void main(String[] args) {
        KEditDistance solution = new KEditDistance();
        List<String> words = solution.findKEditDistance("cake", Arrays.asList("cak", "asdfvvcb", "cake", "cab", "cake12", "cake123"), 0);
        for (String word : words)
            System.out.println(word);
    }

    public List<String> findKEditDistance(String target, List<String> words, int k) {
        Trie trie = new Trie();
        for (String word : words)
            trie.addWord(word);
        List<String> result = new LinkedList<>();

        LinkedList<LinkedList<Integer>> dp = new LinkedList<>();
        LinkedList<Integer> firstRow = new LinkedList<>();
        for (int i = 0; i <= target.length(); i++) {
            firstRow.add(i);
        }
        dp.add(firstRow);

        helper(trie.root, target, "", k, dp, result);
        return result;
    }

    public void helper(Node node, String target, String current, int k, LinkedList<LinkedList<Integer>> dp, List<String> result) {
        if (node.isWord && dp.getLast().getLast() <= k)
            result.add(current);
        else if (current.length() >= target.length() && dp.getLast().getLast() > k)
            return;

        for (char ch : node.map.keySet()) {
            LinkedList<Integer> newRow = new LinkedList<>();
            newRow.add(current.length() + 1);
            for (int j = 1; j <= target.length(); j++) {
                if (target.charAt(j - 1) == ch) {
                    newRow.add(dp.getLast().get(j - 1));
                } else {
                    newRow.add(Math.min(dp.getLast().get(j - 1), Math.min(dp.getLast().get(j), newRow.get(j - 1))) + 1);
                }
            }

            dp.add(newRow);
            helper(node.map.get(ch), target, current + ch, k, dp, result);
            dp.removeLast();
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void addWord(String word) {
            Node start = root;

            for (char ch : word.toCharArray()) {
                start.map.putIfAbsent(ch, new Node());
                start = start.map.get(ch);
            }

            start.isWord = true;
        }
    }

    class Node {
        boolean isWord;
        Map<Character, Node> map;

        public Node() {
            isWord = false;
            map = new HashMap<>();
        }
    }

//
//    public List<String> findKEditDistance(String target, List<String> words, int k) {
//        Trie trie = new Trie();
//        for (String word : words)
//            trie.addWord(word);
//
//        Node root = trie.root;
//        List<String> result = new LinkedList<>();
//        LinkedList<ArrayList<Integer>> dp = new LinkedList<>();
//        ArrayList<Integer> initialize = new ArrayList<>();
//        for (int i = 0; i <= target.length(); i++) // there are target len + 1 columns
//            initialize.add(i);
//
//        dp.add(initialize);
//        helper(root, result, "", dp, k, target);
//        return result;
//    }
//
//    public void helper(Node node, List<String> result, String current, LinkedList<ArrayList<Integer>> dp, int k, String target) {
//        if (node.isWord && dp.getLast().get(target.length()) <= k)
//            result.add(current);
//        else if (dp.getLast().get(target.length()) > k && current.length() >= target.length()) {
//            return;
//        }
//
//        for (char key : node.map.keySet()) {
//            ArrayList<Integer> newRow = new ArrayList<>();
//            newRow.add(target.length());
//            for (int i = 1; i <= target.length(); i++) {
//                if (key == target.charAt(i - 1))
//                    newRow.add(dp.getLast().get(i - 1));
//                else
//                    newRow.add(Math.min(dp.getLast().get(i - 1), Math.min(dp.getLast().get(i), newRow.get(newRow.size() - 1))) + 1);
//            }
//            dp.add(newRow);
//            helper(node.map.get(key), result, current + key, dp, k, target);
//            dp.removeLast();
//        }
//    }
//
//    class Trie {
//        Node root;
//
//        public Trie() {
//            root = new Node();
//        }
//
//        public void addWord(String word) {
//            Node start = root;
//            for (char ch : word.toCharArray()) {
//                if (!start.map.containsKey(ch)) {
//                    start.map.put(ch, new Node());
//                }
//                start = start.map.get(ch);
//            }
//            start.isWord = true;
//        }
//    }
//
//    class Node {
//        Map<Character, Node> map;
//        boolean isWord;
//
//        public Node() {
//            this.map = new HashMap<>();
//            this.isWord = false;
//        }
//    }
}
