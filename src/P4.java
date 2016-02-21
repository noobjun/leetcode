/**
 * Created by jun on 1/17/16.
 * 4. Median of Two Sorted Arrays
 */
public class P4 {
    /*
    Assume array a has less elements than array b.
    Use two pointers, pa and pb. Point them at pa = Math.min(k/2, sizeOfArr1) and pb = k- i

    sizeA=0 or sizeB = 0 means the corresponding array is empty already, we return kth from the other array
    if k=1 we return the smaller element from two arrays
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return helper(nums1, nums2, 0, 0, total / 2 + 1);
        } else {
            return (helper(nums1, nums2, 0, 0, total / 2) + helper(nums1, nums2, 0, 0, total / 2 + 1)) / 2;
        }
    }

    public double helper(int[] a, int[] b, int offsetA, int offsetB, int k) {
        int sizeA = a.length - offsetA;
        int sizeB = b.length - offsetB;

        if (sizeA > sizeB) {
            return helper(b, a, offsetB, offsetA, k);
        }

        if (sizeA == 0) {
            return b[offsetB + k - 1];
        } else if (k == 1) {
            return Math.min(a[offsetA], b[offsetB]);
        }

        int pa = Math.min(k / 2, sizeA);
        int pb = k - pa;

        if (a[offsetA + pa - 1] < b[offsetB + pb - 1]) {
            return helper(a, b, offsetA + pa, offsetB, k - pa);
        } else if (a[offsetA + pa - 1] > b[offsetB + pb - 1]) {
            return helper(a, b, offsetA, offsetB + pb, k - pb);
        } else {
            return a[offsetA + pa - 1];
        }

    }
}
