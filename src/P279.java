import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jun on 3/21/16.
 * 279. Perfect Squares
 * <p>
 * The improved way to do it is don't pre-generate the squares array, but do it on the fly.
 * In for loop for j, do like for (int j =1; i + j*j<=n; j++) etc, it's more elegant!
 */
public class P279 {

    public int numSquares(int n) {
        int[] squares = new int[(int) Math.ceil(Math.sqrt(n))];
        for (int i = 1; i <= squares.length; i++)
            squares[i - 1] = i * i;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < squares.length && i + squares[j] <= n; j++) {
                dp[i + squares[j]] = Math.min(dp[i + squares[j]], dp[i] + 1);
            }
        }

        return dp[n];
    }


}
