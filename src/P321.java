import java.util.Stack;

/**
 * Created by jun on 4/25/16.
 * 321. Create Maximum Number
 * <p>
 * Be careful about merge, it's not as simple as merge portion of merge sort. In merge-sort, the sub arrays are already sorted, but in this problem it's not.
 * We implement a greater() function, that will determine which element from the sub arrays should be picked. See below for details.
 */
public class P321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (k == 0)
            return new int[]{};

        int[] result = new int[k];
        for (int i = 0; i <= Math.min(m, k); i++) {
            int j = k - i;
            if (j > n)
                continue;

            int[] pick1 = pick(nums1, i);
            int[] pick2 = pick(nums2, j);
            result = max(result, merge(pick1, pick2));
        }

        return result;
    }

    private int[] max(int[] left, int[] right) {
        int len = left.length;
        for (int i = 0; i < len; i++) {
            if (left[i] < right[i])
                return right;
            else if (left[i] > right[i])
                return left;
        }

        return left;
    }


    private int[] pick(int[] nums, int k) {
        if (k == 0)
            return new int[]{};

        int total = nums.length;
        int remove = total - k;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < total; i++) {
            int current = nums[i];
            while (!stack.isEmpty() && remove > 0 && stack.peek() < current) {
                stack.pop();
                remove--;
            }
            stack.push(current);
        }

        while (remove-- > 0)
            stack.pop();

        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    private int[] merge(int[] pick1, int[] pick2) {
        int i = 0, j = 0;
        int[] result = new int[pick1.length + pick2.length];
        for (int k = 0; k < pick1.length + pick2.length; k++) {
            result[k] = greater(pick1, i, pick2, j) ? pick1[i++] : pick2[j++];
        }
        return result;
    }

    private boolean greater(int[] left, int i, int[] right, int j) {
        while (i < left.length && j < right.length && left[i] == right[j]) {
            i++;
            j++;
        }

        return j == right.length || i < left.length && left[i] > right[j];
    }
}
