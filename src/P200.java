import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun on 3/7/16.
 * 200. Number of Islands
 * <p>
 * Note that we don't need to use the set structure, we can just loop through the array in one shot.
 */
public class P200 {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0)
            return 0;
        int c = grid[0].length;
        if (c == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == '1') {
                    expand(grid, r, c, i, j);
                    result++;
                }

        return result;
    }

    public void expand(char[][] grid, int r, int c, int x, int y) {
        grid[x][y] = '0';

        // up, down, left, right
        int[] xArr = new int[]{-1, 1, 0, 0};
        int[] yArr = new int[]{0, 0, -1, 1};

        for (int i = 0; i <= 3; i++) {
            int newX = x + xArr[i]; // don't forget the X part LOL
            int newY = y + yArr[i]; // don't forget the Y part LOL

            if (newX >= 0 && newX < r && newY >= 0 && newY < c && grid[newX][newY] == '1')
                expand(grid, r, c, newX, newY);
        }
    }

}
