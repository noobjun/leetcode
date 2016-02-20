import java.util.*;

/**
 * Created by jun on 12/31/15.
 */
public class TopologicalSort {

    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public void setup() {
        HashSet set2 = new HashSet();
        set2.add(2);
        graph.put(1, set2);

        HashSet set34 = new HashSet();
        set34.add(3);
        set34.add(4);

        HashSet set5 = new HashSet();
        set5.add(5);
        HashSet set6 = new HashSet();
        set6.add(6);

        graph.put(1, set2);
        graph.put(2, set34);
        graph.put(3, set5);
        graph.put(4, set5);
        graph.put(5, set6);
    }

    public static void main(String[] args) {
        TopologicalSort topSort = new TopologicalSort();
        topSort.sort();


        /*
         * 1 - 2 3 4 5 6
         */
    }

    public void sort() {
        setup();

        for (Integer i : graph.keySet()) {
            topologicalSort(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void topologicalSort(Integer integer) {
        if (visited.contains(integer))
            return;

        visited.add(integer);

        if (graph.containsKey(integer)) {
            for (Integer b : graph.get(integer)) {
                topologicalSort(b);
            }
        }

        stack.add(integer);
    }
}
