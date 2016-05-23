/**
 * Created by jun on 5/22/16.
 */

import java.util.*;

public class P212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();

        int r = board.length;
        if (r == 0)
            return result;
        int c = board[0].length;
        if (c == 0)
            return result;

        Trie trie = new Trie();
        for (String word : words)
            trie.addWord(word);

        boolean[][] visited = new boolean[r][c];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                dfs(board, trie, i, j, r, c, visited, "", set);

        result.addAll(set);
        return result;
    }

    private void dfs(char[][] board, Trie trie, int x, int y, int r, int c, boolean[][] visited, String str, Set<String> result) {
        if (x < 0 || x == r || y < 0 || y == c || visited[x][y])
            return;

        str += board[x][y];
        if (trie.hasWord(str))
            result.add(str);
        else if (!trie.hasPrefix(str))
            return;

        visited[x][y] = true;
        dfs(board, trie, x - 1, y, r, c, visited, str, result);
        dfs(board, trie, x + 1, y, r, c, visited, str, result);
        dfs(board, trie, x, y - 1, r, c, visited, str, result);
        dfs(board, trie, x, y + 1, r, c, visited, str, result);
        visited[x][y] = false;
    }

    public static class Trie {
        Node root = new Node();

        public void addWord(String word) {
            Node start = root;
            for (char ch : word.toCharArray()) {
                if (start.next[ch-'a']==null)
                    start.next[ch-'a'] = new Node();
                start = start.next[ch-'a'];
            }
            start.isWord = true;
        }

        public boolean hasPrefix(String word) {
            Node start = root;
            for (char ch : word.toCharArray()) {
                if (start.next[ch-'a']!=null)
                    start = start.next[ch-'a'];
                else
                    return false;
            }
            return true;
        }

        public boolean hasWord(String word) {
            Node start = root;
            for (char ch : word.toCharArray()) {
                if (start.next[ch-'a']!=null)
                    start = start.next[ch-'a'];
                else
                    return false;
            }

            return start.isWord;
        }

    }

    public static class Node {
        Node[] next;
        boolean isWord;

        public Node() {
            next = new Node[26];
            isWord = false;
        }
    }
}
