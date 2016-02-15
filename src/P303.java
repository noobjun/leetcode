/**
 * Created by jun on 1/21/16.
 * Range Sum Query - Immutable
 */
public class P303 {
    public class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int size = nums.length;
            this.sums = new int[size];
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sums[j];
            } else {
                return sums[j] - sums[i - 1];
            }
        }
    }

}
