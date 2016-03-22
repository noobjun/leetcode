/**
 * Created by jun on 3/21/16.
 * 280. Wiggle Sort
 */
public class P280 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (i % 2 == 0 && nums[i] > nums[i - 1] ||
                    i % 2 != 0 && nums[i] < nums[i - 1])
                swap(nums, i, i - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
