/**
 * Created by jun on 12/23/15.
 * <p/>
 * 121. Best Time to Buy and Sell Stock
 */
public class P121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low)
                low = prices[i];
            else
                profit = Math.max(profit, prices[i] - low);
        }

        return profit;
    }
}
