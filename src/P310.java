import java.util.*;

/**
 * Created by jun on 3/23/16.
 * 310. Minimum Height Trees
 */
public class P310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new LinkedList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> buffer = new LinkedList<>();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];

        for (int[] edge : edges) {
            int p = edge[0], q = edge[1];
            degree[p]++;
            degree[q]++;
            graph.putIfAbsent(p, new HashSet<Integer>());
            graph.putIfAbsent(q, new HashSet<Integer>());

            graph.get(p).add(q);
            graph.get(q).add(p);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1)
                queue.offer(i);
        }

        while (n > 2) {
            int qSize = queue.size(); // This is a smart way to ensure we peel one layer at a time!
            System.out.println(n);
            for (int i = 0; i < qSize; i++) {
                int node = queue.poll();
                n--;

                degree[node]--;
                for (int neighbor : graph.get(node)) { // this line is important, because there can be multiple neighbors, my previous assumption was that there should only be one neighbor from the leaf node, but the fact is that we didn't modify the graph, so the nodes that became on the 2nd+ iteration actually will have more than 1 neighbor
                    degree[neighbor]--;

                    if (degree[neighbor] == 1)
                        queue.offer(neighbor);
                }
            }
        }


        while (!queue.isEmpty())
            result.add(queue.poll());

        return result;
    }
}
