/**
 * Created by jun on 4/25/16.
 * 302. Smallest Rectangle Enclosing Black Pixels
 */
public class P302 {
    int up = Integer.MAX_VALUE;
    int down = Integer.MIN_VALUE;
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;

    public int minArea(char[][] image, int x, int y) {
        int r = image.length;
        if (r == 0)
            return 0;
        int c = image[0].length;
        if (c == 0)
            return 0;

        dfs(image, x, y, r, c);
        return (down - up + 1) * (right - left + 1);
    }

    public void dfs(char[][] image, int x, int y, int r, int c) {
        if (x < 0 || x == r || y < 0 || y == c)
            return;

        if (image[x][y] == '0')
            return;

        image[x][y] = '0';

        up = Math.min(up, x);
        down = Math.max(down, x);
        left = Math.min(left, y);
        right = Math.max(right, y);

        dfs(image, x - 1, y, r, c);
        dfs(image, x + 1, y, r, c);
        dfs(image, x, y - 1, r, c);
        dfs(image, x, y + 1, r, c);
    }
}
