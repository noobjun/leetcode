/**
 * Created by jun on 3/31/16.
 * 221. Maximal Square
 */
public class P221 {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    int upLeft = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                    int left = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int up = j - 1 >= 0 ? dp[i][j - 1] : 0;

                    dp[i][j] = Math.min(upLeft, Math.min(up, left)) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }
}
