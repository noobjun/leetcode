import java.util.Arrays;

/**
 * Created by jun on 4/1/16.
 * 215. Kth Largest Element in an Array
 * <p>
 * This can be solved in 3 ways:
 * 1. sort array
 * 2. use max heap
 * 3. use quick select, which has avg runtime complexity of O(n), worst case is O(n^2)
 */

public class P215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return (nums[nums.length - k]);
    }
}
