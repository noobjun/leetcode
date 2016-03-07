/**
 * Created by jun on 3/4/16.
 * 162. Find Peak Element
 */
public class P162 {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else {
                hi = mid;
            }
        }

        return hi;
    }
}
