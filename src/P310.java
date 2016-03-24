import java.util.*;

/**
 * Created by jun on 3/23/16.
 * 310. Minimum Height Trees
 */
public class P310 {
    public static void main(String[] args) {
        int a[][] = new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {1, 5}, {1, 6}, {4, 7}, {0, 8}, {3, 9}, {6, 10}, {0, 11}, {11, 12}, {3, 13}, {9, 14}, {3, 15}, {12, 16}, {16, 17}, {4, 18}, {17, 19}
        };

        P310 p = new P310();
        List<Integer> r1 = p.findMinHeightTrees(20, a);

        for (int i : r1)
            System.out.println(i);


    }

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
