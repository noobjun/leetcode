import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jun on 3/8/16.
 * 305. Number of Islands II
 */
public class P305 {
    private int islands = 0;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new LinkedList<>();
        Map<Point, Point> map = new HashMap<>(); // map that stores coordinate and its parent, a parent of null means it's the root

        for (int[] coordinates : positions) {
            Point current = new Point(coordinates[0], coordinates[1]);
            map.put(current, current);
            islands++;

            checkNeighbor(map, current, new Point(current.x - 1, current.y), m, n);
            checkNeighbor(map, current, new Point(current.x, current.y - 1), m, n);
            checkNeighbor(map, current, new Point(current.x + 1, current.y), m, n);
            checkNeighbor(map, current, new Point(current.x, current.y + 1), m, n);

            result.add(islands);
        }

        return result;
    }

    public void checkNeighbor(Map<Point, Point> map, Point current, Point neighbor, int m, int n) {
        if (map.containsKey(neighbor)) {
            while (!map.get(neighbor).equals(neighbor))
                neighbor = map.get(neighbor);
            // neighbor is the now the root of neighboring set

            while (!map.get(current).equals(current))
                current = map.get(current);
            // current is now the root of its set

            if (!current.equals(neighbor)) {  // if they are not the same set, merge them
                map.put(current, neighbor);
                islands--;
            }

        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }


}
