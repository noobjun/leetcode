import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 4/6/16.
 * 210. Course Schedule II
 * <p>
 * We can improve the topologicalSort method by utilizing the return value, so that we know it has cycles or not.
 */
public class P210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            graph.put(i, new HashSet<>());

        for (int[] edge : prerequisites)
            graph.get(edge[1]).add(edge[0]);

        for (int node : graph.keySet())
            topologicalSort(node, graph, stack, visited, result);

        if (visited.contains(-1))
            return new int[]{};

        int[] order = new int[result.size()];
        int i = 0;
        for (int o : result)
            order[i++] = o;

        return order;
    }

    public void topologicalSort(int current, Map<Integer, Set<Integer>> graph, Set<Integer> stack, Set<Integer> visited, LinkedList<Integer> result) {
        if (stack.contains(current))
            visited.add(-1);

        if (visited.contains(current))
            return;

        stack.add(current);
        visited.add(current);

        for (int neighbor : graph.get(current))
            topologicalSort(neighbor, graph, stack, visited, result);

        result.addFirst(current);
        stack.remove(current);
    }
}
