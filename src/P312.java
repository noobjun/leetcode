/**
 * Created by jun on 3/6/16.
 * 312. Burst Balloons
 * <p>
 * we maintain array dp[i][j], which means the max coin by popping all the balloons from i and j (inclusive)
 */
public class P312 {

    public static void main(String[] args) {
        System.out.println(String.valueOf(2.0/3.0));
    }
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[nums.length] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j + i - 1<= nums.length; j++) {


            }
        }
        return 0;

    }
}
