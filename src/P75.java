/**
 * Created by jun on 3/31/16.
 * 75. Sort Colors
 */
public class P75 {

    public void sortColors(int[] nums) {
        int left =0;
        int right = nums.length-1;

        for (int i =0; i<=right; i++){
            if (nums[i] == 0)
                swap(nums, i, left++);

            if (nums[i]==2)
                swap(nums, i--, right--);
        }
    }

// This is my own way, O(N), but dirty.
//    public void sortColors(int[] nums) {
//        int len = nums.length;
//        if (len == 0)
//            return;
//
//        int left = 0;
//        while (left < len && nums[left] == 0) left++;
//        int right = len - 1;
//        while (right >= 0 && nums[right] == 2) right--;
//
//        for (int i = left; left < right && i <= right; i++) {
//            if (nums[i] == 2) {
//                swap(nums, right, i);
//                while (right >= 0 && nums[right] == 2) right--;
//            }
//
//            if (nums[i] == 0) {
//                swap(nums, left, i);
//                left++;
//            }
//
//        }
//    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
