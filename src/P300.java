/**
 * Created by jun on 3/29/16.
 * 300. Longest Increasing Subsequence
 */
public class P300 {

    public static void main(String[] args) {
        P300 p = new P300();

        int[] arr = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        int r = p.lengthOfLIS(arr);
        //System.out.println(r);
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;

        int[] dp = new int[len];
        dp[0] = 1;

        int result = 1;
        for (int i = 1; i < len; i++) {
            int localMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    localMax = Math.max(localMax, dp[j] + 1);
            }
            dp[i] = localMax;
            result = Math.max(result, localMax);
        }

        return result;
    }
}
