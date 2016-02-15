/**
 * Created by jun on 2/10/16.
 * 283. Move Zeroes
 * <p>
 * <p>
 * Two pointers i and j:
 * i will track the leftmost zero
 * j will track first non-zero element to the right of i
 * if j goes out of bound means all zeroes are on the right already
 */
public class P283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
