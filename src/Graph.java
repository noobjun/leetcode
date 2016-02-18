import java.util.*;

/**
 * Created by jun on 2/15/16.
 */
public class Graph<T> {
    private Map<T, Set<T>> graph;
    private Set<T> visited;
    private Set<T> recursionStack; // This is used to track what is on the recursion recursionStack
    private Deque<T> deque; // This tracks topological sort order
    private boolean hasCycle;

    public Graph() {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();
        this.recursionStack = new HashSet<>();
        this.deque = new ArrayDeque<>();
        this.hasCycle = false;
    }

    public void addEdge(T a, T b) {
        if (!graph.containsKey(a)) {
            graph.put(a, new HashSet<T>());
        }
        graph.get(a).add(b);
    }

    public void dfs() {
        for (T vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex);
            }
        }
    }

    public void dfs(T source) {
        // System.out.println(source.toString());
        visited.add(source);
        recursionStack.add(source);

        if (graph.containsKey(source)) {
            for (T vertex : graph.get(source))
                if (!visited.contains(vertex)) {
                    dfs(vertex);
                } else if (recursionStack.contains(vertex)) { // recursion recursionStack can only contain vertex if it is already in the visited set, so this condition comes after "if !visited"
                    this.hasCycle = true;
                }
        }

        recursionStack.remove(source);
        deque.add(source); // this serves as a stack by adding vertex after recursive calls, this generate topological sort order
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }

    public List<T> topologicalSort() {
        List<T> list = new LinkedList<>();
        Iterator<T> iterator = this.deque.descendingIterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
