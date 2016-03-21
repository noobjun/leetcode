import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jun on 3/21/16.
 * 261. Graph Valid Tree
 * <p>
 * This can also be solved with Union-Find algorithm, quick union is quite simple for example.
 */
public class P261 {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            map.putIfAbsent(p, new HashSet<Integer>());
            map.get(p).add(q);
            map.putIfAbsent(q, new HashSet<Integer>());
            map.get(q).add(p);
        }

        int numNodes = map.keySet().size();
        if (numNodes != n) {
            return n == 1; // nasty case that if there is one node, then there is no connectivity obviously
        } else {
            int start = map.keySet().iterator().next();
            Set<Integer> visited = new HashSet<>();
            return dfs(map, start, start, visited) && numNodes == visited.size();
        }
    }

    // returning true means it's valid without cycles, false means has cycles
    public boolean dfs(Map<Integer, Set<Integer>> map, int from, int prev, Set<Integer> visited) {
        if (visited.contains(from))
            return false;

        visited.add(from);

        for (int next : map.get(from))
            if (next != prev)
                if (!dfs(map, next, from, visited))
                    return false;

        return true;
    }
}
