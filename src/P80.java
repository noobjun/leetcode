/**
 * Created by jun on 4/1/16.
 * 80. Remove Duplicates from Sorted Array II
 */
public class P80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int j = 0;
        int counter = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
                counter = 0;
            } else {
                counter++;
                if (counter < 2)
                    nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}
