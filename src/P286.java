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
            expand(rooms, queue.poll(), queue, r, c);
        }
    }

    public void expand(int[][] rooms, Location l, Queue<Location> queue, int r, int c) {
        int x = l.x;
        int y = l.y;
        int curr = rooms[x][y];
        int[] deltaX = new int[]{-1, 0, 1, 0};
        int[] deltaY = new int[]{0, -1, 0, 1};

        for (int i = 0; i < deltaX.length; i++) {
            int nextX = x + deltaX[i];
            int nextY = y + deltaY[i];
            if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && rooms[nextX][nextY] == Integer.MAX_VALUE){
                rooms[nextX][nextY] = curr + 1;
                queue.offer(new Location(nextX, nextY));
            }
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
