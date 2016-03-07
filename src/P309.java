import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 3/5/16.
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class P309 {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;

        int len = prices.length;
        int[] buy = new int[len]; // array records the max profit with any sequence until i where buy is the last action
        int[] sell = new int[len]; // array records the max profit with any sequence until i where sell is the last action
        int[] rest = new int[len]; // array records the max profit with any sequence until i where rest is the last action

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                buy[i] = -prices[i];
                sell[i] = 0;
                rest[i] = 0;
            } else {
                buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                rest[i] = Math.max(rest[i - 1], Math.max(buy[i - 1], sell[i - 1]));
            }
        }

        /**
         * Since rest[i] = sell[i-1], we can take out rest[], and use buy[i] = max(buy[i-1], sell[i-2] - price.
         */

        return sell[len - 1];
    }
}
