package airbnb;


import java.util.*;

/**
 * Created by jun on 5/10/16.
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] strs = new String[]{"wrt","wrf","er","ett","rftt"};
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.alienOrder(strs);

    }

    public String alienOrder(String[] words) {

        Set<Character> allLetters = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray())
                allLetters.add(ch);
            if (allLetters.size() >= 26)
                break;
        }

        Graph graph = new Graph();
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph.addEdge(first.charAt(j), second.charAt(j));
                    break;
                }
            }
        }

        List<Character> order = graph.topologicalSort();
        if (graph.hasCycle())
            return "";

        String result = "";
        for (char ch : order) {
            result += ch;
            allLetters.remove(ch);
        }

        for (char ch : allLetters)
            result += ch;
        return result;

    }


    public static class Graph {
        Map<Character, Set<Character>> graph = new HashMap<>();

        Set<Character> visited = new HashSet<>();
        Set<Character> stack = new HashSet<>();
        LinkedList<Character> topo = new LinkedList<>();
        boolean hasCycle = false;

        public void addEdge(Character a, Character b) {
            graph.putIfAbsent(a, new HashSet<Character>());
            graph.get(a).add(b);
        }

        public void dfs(Character start) {
            if (stack.contains(start))
                hasCycle = true;

            if (visited.contains(start))
                return;

            stack.add(start);
            visited.add(start);

            if (graph.containsKey(start)) {
                for (char neighbor : graph.get(start))
                    dfs(neighbor);
            }

            topo.addFirst(start);
            stack.remove(start);
        }

        public List<Character> topologicalSort() {
            for (char ch : graph.keySet())
                dfs(ch);

            return topo;
        }

        public boolean hasCycle() {
            return hasCycle;
        }

    }


//    public String alienOrder(String[] words) {
//        Set<Character> possibleLetters = new HashSet<>();
//        for (String word : words) {
//            for (char ch : word.toCharArray())
//                possibleLetters.add(ch);
//
//            if (possibleLetters.size() == 26)
//                break;
//        }
//
//        Graph graph = new Graph();
//        for (int i = 1; i < words.length; i++) {
//            String prev = words[i - 1];
//            String curr = words[i];
//
//            for (int j = 0; j < Math.min(prev.length(), curr.length()); j++) {
//                if (prev.charAt(j) != curr.charAt(j)) {
//                    graph.addEdge(prev.charAt(j), curr.charAt(j));
//                    break;
//                }
//            }
//        }
//
//        for (char start : graph.map.keySet())
//            graph.dfs(start);
//
//        String result = "";
//
//        if (graph.hasCycle)
//            return result;
//
//        for (char ch : graph.topological()) {
//            result += ch;
//            possibleLetters.remove(ch);
//        }
//
//        for (char ch : possibleLetters)
//            result += ch;
//
//        return result;
//    }
//
//    class Graph {
//        Map<Character, Set<Character>> map = new HashMap<>();
//        boolean hasCycle = false;
//        Set<Character> visited = new HashSet<>();
//        Set<Character> stack = new HashSet<>();
//        LinkedList<Character> topoOrder = new LinkedList<>();
//
//        public void addEdge(Character a, Character b) {
//            map.putIfAbsent(a, new HashSet<>());
//            map.get(a).add(b);
//        }
//
//        public void dfs(Character node) {
//            if (stack.contains(node))
//                hasCycle = true;
//
//            if (visited.contains(node))
//                return;
//
//            stack.add(node);
//            visited.add(node);
//
//            if (map.containsKey(node)) { // make sure to check if the node has any edges, it could only have in-degrees but no out-degrees
//                for (Character ch : map.get(node))
//                    dfs(ch);
//            }
//
//            topoOrder.addFirst(node);
//            stack.remove(node);
//        }
//
//        public boolean isHasCycle() {
//            return hasCycle;
//        }
//
//        public List<Character> topological() {
//            return topoOrder;
//        }
//    }
}
