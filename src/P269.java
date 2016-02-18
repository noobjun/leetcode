import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jun on 2/15/16.
 * 269. Alien Dictionary
 */
public class P269 {
    public String alienOrder(String[] words) {
        String result = "";

        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (charSet.contains(c))
                    continue;
                else
                    charSet.add(c);
            }

            if (charSet.size() == 26)
                break;
        }

        Graph<Character> graph = new Graph<>();
        for (int i = 0; i < words.length - 1; i++) {
            processWords(graph, words[i], words[i + 1]);
        }

        graph.dfs(); // HAHAHA MOTHERFUCKER, THIS LINE IS VERY IMPORTANT, DON'T FORGET TO CALL IT

        if (!graph.hasCycle()) {
            List<Character> topologicalOrder = graph.topologicalSort();
            for (char c : topologicalOrder) {
                result += c;
                if (charSet.contains(c))
                    charSet.remove(c);
            }

            for (char c : charSet)
                result += c;
        }

        return result;
    }

    public void processWords(Graph<Character> graph, String w1, String w2) {
        if (w1.equals(w2))
            return;

        for (int i = 0; i < w1.length() && i < w2.length(); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                graph.addEdge(c1, c2);
                break;
            }
        }
    }
}

