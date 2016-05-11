package airbnb;


import java.util.*;

/**
 * Created by jun on 5/10/16.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Set<Character> possibleLetters = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray())
                possibleLetters.add(ch);

            if (possibleLetters.size() == 26)
                break;
        }

        Graph graph = new Graph();
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            for (int j = 0; j < Math.min(prev.length(), curr.length()); j++) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    graph.addEdge(prev.charAt(j), curr.charAt(j));
                    break;
                }
            }
        }

        for (char start : graph.map.keySet())
            graph.dfs(start);

        String result = "";

        if (graph.hasCycle)
            return result;

        for (char ch : graph.topological()) {
            result += ch;
            possibleLetters.remove(ch);
        }

        for (char ch : possibleLetters)
            result += ch;

        return result;
    }

    class Graph {
        Map<Character, Set<Character>> map = new HashMap<>();
        boolean hasCycle = false;
        Set<Character> visited = new HashSet<>();
        Set<Character> stack = new HashSet<>();
        LinkedList<Character> topoOrder = new LinkedList<>();

        public void addEdge(Character a, Character b) {
            map.putIfAbsent(a, new HashSet<>());
            map.get(a).add(b);
        }

        public void dfs(Character node) {
            if (stack.contains(node))
                hasCycle = true;

            if (visited.contains(node))
                return;

            stack.add(node);
            visited.add(node);

            if (map.containsKey(node)) { // make sure to check if the node has any edges, it could only have in-degrees but no out-degrees
                for (Character ch : map.get(node))
                    dfs(ch);
            }

            topoOrder.addFirst(node);
            stack.remove(node);
        }

        public boolean isHasCycle() {
            return hasCycle;
        }

        public List<Character> topological() {
            return topoOrder;
        }
    }
}
