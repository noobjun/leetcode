import java.util.*;

/**
 * Created by jun on 3/20/16.
 * 332. Reconstruct Itinerary
 */
public class P332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", map, result);
        return result;
    }

    public void dfs(String from, Map<String, PriorityQueue<String>> map, LinkedList<String> result) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty()) {
            dfs(tos.remove(), map, result);
        }
        result.addFirst(from);
    }

}
