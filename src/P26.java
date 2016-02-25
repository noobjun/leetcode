/**
 * Created by jun on 2/24/16.
 * 26. Remove Duplicates from Sorted Array
 */
public class P26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2)
            return nums.length;

        int i =0;
        for (int j =1; j<nums.length; j++){
            if (nums[j]!=nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i+1;
    }
}
