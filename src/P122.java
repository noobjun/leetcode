/**
 * Created by jun on 3/5/16.
 */
public class P122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                result += prices[i] - prices[i - 1];
        }

        return result;
    }


}
