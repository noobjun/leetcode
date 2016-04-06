import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by jun on 4/5/16.
 * 133. Clone Graph
 */
public class P133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node, new HashMap<Integer, UndirectedGraphNode>());
    }

    public UndirectedGraphNode helper(UndirectedGraphNode current, Map<Integer, UndirectedGraphNode> graph) {
        if (current == null)
            return null;
        if (graph.containsKey(current.label))
            return graph.get(current.label);

        graph.put(current.label, new UndirectedGraphNode(current.label));

        for (UndirectedGraphNode neighbor : current.neighbors) {
            graph.get(current.label).neighbors.add(helper(neighbor, graph));
        }

        return graph.get(current.label);
    }


// Wicked way of doing it.
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node != null) {
//            Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
//            dfs(node, nodes, new HashSet<>());
//            for (UndirectedGraphNode v : nodes.values())
//                if (v.label == node.label)
//                    return v;
//        }
//        return null;
//    }
//
//    public void dfs(UndirectedGraphNode current, Map<Integer, UndirectedGraphNode> nodes, Set<Integer> visited) {
//        if (!visited.contains(current.label)) {
//            visited.add(current.label);
//            nodes.putIfAbsent(current.label, new UndirectedGraphNode(current.label));
//
//            for (UndirectedGraphNode neighbor : current.neighbors) {
//                connect(current, neighbor, nodes);
//                dfs(neighbor, nodes, visited);
//            }
//        }
//    }
//
//    public void connect(UndirectedGraphNode a, UndirectedGraphNode b, Map<Integer, UndirectedGraphNode> nodes) {
//            nodes.putIfAbsent(b.label, new UndirectedGraphNode(b.label));
//            nodes.get(a.label).neighbors.add(nodes.get(b.label));
//    }
}
