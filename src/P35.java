/**
 * Created by jun on 12/23/15.
 * 35. Search Insert Position
 */
public class P35 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;

        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if (target==nums[mid])
                return mid;
            else if (target<nums[mid])
                hi = mid-1;
            else
                lo = mid+1;
        }

        return lo;
    }
}
