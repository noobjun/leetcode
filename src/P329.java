import java.util.Arrays;

/**
 * Created by jun on 4/25/16.
 * 329. Longest Increasing Path in a Matrix
 */
public class P329 {
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;
        if (c == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result = Math.max(result, dfs(matrix, i, j, r, c, new int[r][c]));

        return result;
    }

    public int dfs(int[][] matrix, int i, int j, int r, int c, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];

        int result = 1;
        int current = matrix[i][j];
        if (i - 1 >= 0 && matrix[i - 1][j] > current)
            result = Math.max(result, dfs(matrix, i - 1, j, r, c, memo) + 1);

        if (i + 1 < r && matrix[i + 1][j] > current)
            result = Math.max(result, dfs(matrix, i + 1, j, r, c, memo) + 1);

        if (j - 1 >= 0 && matrix[i][j - 1] > current)
            result = Math.max(result, dfs(matrix, i, j - 1, r, c, memo) + 1);

        if (j + 1 < c && matrix[i][j + 1] > current)
            result = Math.max(result, dfs(matrix, i, j + 1, r, c, memo) + 1);

        memo[i][j] = result;
        return result;
    }
}
