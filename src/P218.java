import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jun on 4/29/16.
 * 218. The Skyline Problem
 */
public class P218 {
    public static void main(String[] args) {
        P218 p = new P218();
        List<int[]> result = p.getSkyline(new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}});//, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        for (int[] r : result)
            System.out.println(r[0] + " " + r[1]);

        // 1, 3   2, 6   4, 3,   5, 0
        // [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<Event> list = new LinkedList<>();

        for (int[] triplet : buildings) {
            list.add(new Event(triplet[0], triplet));
            list.add(new Event(triplet[1], triplet));
        }

        Collections.sort(list, (a, b) -> (Integer.compare(a.coordinate, b.coordinate)));

        PriorityQueue<int[]> heights = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        LinkedList<int[]> result = new LinkedList<>();
        for (Event event : list) {
            if (event.type == 'L') {
                heights.add(event.triplet);
            } else {
                heights.remove(event.triplet);
            }

            int[] point = new int[]{event.coordinate, heights.isEmpty() ? 0 : heights.peek()[2]};
            if (!result.isEmpty() && result.getLast()[0] == point[0]) {
                point[1] = event.type=='L'?Math.max(result.getLast()[1], point[1]): Math.min(result.getLast()[1], point[1]);
                result.removeLast();
            }
            if (result.isEmpty() || !result.isEmpty() && point[1] != result.getLast()[1])
                result.add(point);
        }

        return result;
    }

    public static class Event {
        int coordinate;
        int[] triplet;
        char type;

        public Event(int coordinate, int[] triplet) {
            this.coordinate = coordinate;
            this.triplet = triplet;
            this.type = coordinate == triplet[0] ? 'L' : 'R';
        }
    }

    public static class Height {
        int[] triplet;

        public Height(int[] triplet) {
            this.triplet = triplet;
        }
    }

}
