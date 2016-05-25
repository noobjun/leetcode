package airbnb;

/**
 * Created by jun on 4/13/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;
        if (c == 0)
            return 0;

        int[][] dp = new int[r][c];
        int result = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1 : 0;

                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }


//    public int maximalSquare(char[][] matrix) {
//        int r = matrix.length;
//        if (r == 0)
//            return 0;
//
//        int c = matrix[0].length;
//        if (c == 0)
//            return 0;
//
//        int[][] dp = new int[r][c];
//        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
//        int result = dp[0][0];
//        for (int i = 1; i < c; i++){
//            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
//            result = Math.max(result, dp[0][i]);
//        }
//        for (int i = 1; i < r; i++){
//            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
//            result = Math.max(result, dp[i][0]);
//        }
//
//        for (int i = 1; i < r; i++) {
//            for (int j = 1; j < c; j++) {
//                if (matrix[i][j] == '1')
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//                result = Math.max(result, dp[i][j]);
//            }
//        }
//        return result*result; // don't forget to square the result
//    }
}
