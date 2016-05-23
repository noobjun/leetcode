package facebook;


/**
 * Created by jun on 5/16/16.
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if ((nums[low] < nums[mid] && target >= nums[low] && target <= nums[mid]) ||
                    (nums[mid] < nums[high] && (target < nums[mid] || target > nums[high]))) {
                high = mid-1;

            } else {
                low = mid+1;
            }
        }

        return -1;

    }
}
