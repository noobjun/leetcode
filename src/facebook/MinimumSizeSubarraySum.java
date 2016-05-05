package facebook;

/**
 * Created by jun on 5/3/16.
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum min = new MinimumSizeSubarraySum();
        System.out.println(min.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0;
        int result = Integer.MAX_VALUE;

        while (j < nums.length) {

            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }

            if (j == nums.length && sum < s) // IMPORTANT
                break;

            while (i < j && sum >= s) {
                sum -= nums[i];
                i++;
            }

            result = Math.min(result, j - i + 1);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
