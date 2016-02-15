/**
 * Created by jun on 1/17/16.
 * 4. Median of Two Sorted Arrays
 */
public class P4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        // assuming it's in the left array
//        int lo = 0, hi = nums1.length - 1;
//        int left = 0, right = 0;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            left += mid - lo;
//            right += hi - mid;
//
//            int pos = searchInsert(nums2, nums1[mid]);
//            left += pos;
//            right += nums2.length - pos;
//
//            if (left == right) {
//                return nums1[mid];
//            } else if (left - right == -1) {
//                if (mid==nums1.length-1){
//                    return ((double)nums1[mid] + nums2[pos])/2;
//                } else {
//                    searchInsert(nums2, )
//                    if (searchInsert)
//
//                }
//            } else if (left > right) {
//                hi = mid - 1;
//            } else {
//                lo = mid + 1;
//            }
//        }
//
//        // if it's not in left, then it's in right array
//        lo = 0;
//        hi = nums2.length - 1;
//        left = 0;
//        right = 0;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            left += mid - lo;
//            right += hi - mid;
//
//            int pos = searchInsert(nums1, nums2[mid]);
//            left += pos;
//            right += nums1.length - pos;
//
//            if (left == right || left - right == -1) {
//                return nums2[mid];
//            } else if (left > right) {
//                hi = mid - 1;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public int searchInsert(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length - 1;
//
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (target == nums[mid])
//                return mid;
//            else if (target < nums[mid])
//                hi = mid - 1;
//            else
//                lo = mid + 1;
//        }
//
//        return lo;
//    }
}
