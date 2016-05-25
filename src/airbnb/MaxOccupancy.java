package airbnb;

/**
 * Created by jun on 4/13/16.
 * Interview Questions
 * Given a set of numbers in an array which represent number of consecutive days of AirBnB reservation requested, as a host, pick the sequence which maximizes the number of days of occupancy, at the same time, leaving at least 1 day gap in between bookings for cleaning. Problem reduces to finding max-sum of non-consecutive array elements.
 * <p>
 * // [5, 1, 1, 5] => 10
 * The above array would represent an example booking period as follows -
 * // Dec 1 - 5
 * // Dec 5 - 6
 * // Dec 6 - 7
 * // Dec 7 - 12
 * <p>
 * The answer would be to pick dec 1-5 (5 days) and then pick dec 7-12 for a total of 10 days of occupancy, at the same time, leaving atleast 1 day gap for cleaning between reservations.
 * <p>
 * Similarly,
 * // [3, 6, 4] => 7
 * // [4, 10, 3, 1, 5] => 15
 */
public class MaxOccupancy {

    // what if this problem can contain negative numbers?
    public static void main(String[] args) {
        MaxOccupancy solution = new MaxOccupancy();
        int res = solution.maxDays(new int[]{5, 1, 1, 5});
        System.out.println(res);
    }


    public int maxDays(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int rob = nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
            int notRob = dp[i - 1];
            dp[i] = Math.max(rob, notRob);

        }
        return dp[nums.length - 1];
    }

//
//    public int maxDays(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            int robThis = nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
//            int dontRob = dp[i - 1];
//            dp[i] = Math.max(robThis, dontRob);
//        }
//
//        return dp[nums.length - 1];
//    }
}
