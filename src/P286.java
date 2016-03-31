import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun on 3/31/16.
 * 286. Walls and Gates
 */
public class P286 {
    public void wallsAndGates(int[][] rooms) {
        int r = rooms.length;
        if (r == 0)
            return;
        int c = rooms[0].length;

        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (rooms[i][j] == 0)
                    queue.offer(new Location(i, j));

        while (!queue.isEmpty()) {
            Location l = queue.poll();
            expand(rooms, l.x, l.y, queue, r, c);
        }

    }

    public void expand(int[][] rooms, int i, int j, Queue<Location> queue, int r, int c) {
        int curr = rooms[i][j];

        if (i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
            rooms[i - 1][j] = curr + 1;
            queue.offer(new Location(i - 1, j));
        }

        if (i + 1 < r && rooms[i + 1][j] == Integer.MAX_VALUE) {
            rooms[i + 1][j] = curr + 1;
            queue.offer(new Location(i + 1, j));
        }
        if (j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
            rooms[i][j - 1] = curr + 1;
            queue.offer(new Location(i, j - 1));
        }

        if (j + 1 < c && rooms[i][j + 1] == Integer.MAX_VALUE) {
            rooms[i][j + 1] = curr + 1;
            queue.offer(new Location(i, j + 1));
        }
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
