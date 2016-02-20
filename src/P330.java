/**
 * Created by jun on 2/19/16.
 * 330. Patching Array
 */
public class P330 {
    /*
    The key observation is that "the most optimal increment is sum of previous numbers + 1".
    If the next number from array is less than this target, include it in the sum. pointer++
    If the next number is equal to target, include it in the sum, pointer++
    If next number more than this range, we add/patch in the number. pointer no-op

    If we used up numbers in array already, then all targets afterwards are patched in.

    Also as extra knowledge, if we allow subtractions amongst numbers, then the optimal increment would be N_i+1 = Ni * 3.
    For example, 1, 3, 9, 27. They can form anything up until 1+3+9+27.
     */

    public int minPatches(int[] nums, int n) {
        // Some edge test cases are on the INTEGER boundaries, thus we need long type.
        long sum = 0;
        int i = 0;
        int patch = 0;
        while (sum < n) {
            long target = sum + 1;

            if (i < nums.length) {
                int num = nums[i];
                if (num <= target) {
                    sum += num;
                    i++;
                } else if (num == target) {
                    sum += num;
                    i++;
                } else {
                    sum += target;
                    patch++;
                }
            } else {
                sum += target;
                patch++;
            }
        }

        return patch;
    }
}
