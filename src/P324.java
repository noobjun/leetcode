import java.util.Arrays;

/**
 * Created by jun on 3/21/16.
 * 324. Wiggle Sort II
 * <p>
 * The difference here is that wiggleSort II is strictly greater than and less than.
 * <p>
 * This solution sort arrays first. The O(n) solution needs to first find a median and partition the arrays into 3 parts
 * such that[greater than, equal to, less than] median. Then it's easy to convert that array into wiggly-sorted.
 * <p>
 * We can use Dutch-flag sort to do 3-way partition.
 */
public class P324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int j = nums.length - 1;
        int i = j / 2;

        int[] result = new int[nums.length];

        for (int k = 0; k < nums.length; k++)
            result[k] = k % 2 == 0 ? nums[j--] : nums[i--];

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

}
