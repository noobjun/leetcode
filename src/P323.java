import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by jun on 3/22/16.
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * This problem can be solved with Union-Find or DFS, I will use union-find for additional practice.
 * <p>
 * Key for union find: quick union is to implement a find function to retrieve the root parent of a node so we can use it
 * while determining whether two nodes are in the same set already as well as assigning one's parent as the other's.
 * <p>
 * One thing I would do better is to use array instead of map, because we have size n.
 */
public class P323 {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Integer> parent = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            parent.putIfAbsent(a, a);
            parent.putIfAbsent(b, b);

            int pa = find(parent, a);
            int pb = find(parent, b);

            if (pb != pa) {
                parent.put(pa, pb); // this is the KEY!! always union the parents
                n--;
            }
        }

        return n;
    }

    // find parent
    public int find(Map<Integer, Integer> map, int a) {
        while (map.get(a) != a) {
            a = map.get(a);
        }
        return a;
    }
}
