/**
 * Created by jun on 3/20/16.
 * 276. Paint Fence
 */
public class P276 {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;

        if (n == 1)
            return k;

        int s = k, d = 1; // s stands for number of ways to paint with last two colors being different, d for same last two colors
        for (int i = 2; i < n; i++) {
            int temp = s;
            s = (s + d) * (k - 1);
            d = temp;
        }

        return (s + d) * k;
    }
}
