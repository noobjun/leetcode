/**
 * Created by jun on 3/29/16.
 * 88. Merge Sorted Array
 */
public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0)
            nums1[k--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

        while (n >= 0)
            nums1[k--] = nums2[n--];
    }
}
