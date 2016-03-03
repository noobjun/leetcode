import java.util.Arrays;

/**
 * Created by jun on 3/2/16.
 * 259. 3Sum Smaller
 */
public class P259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int a, b, c;
                a = nums[i];
                b = nums[j];
                c = nums[k];

                int sum = a + b + c;
                if (sum < target) {
                    result += k - j; // this step is the key, because if sum is less than target, then we keep the left pointer fixed, we move right pointer until it reaches left pointer, each pair would be valid
                    j++;
                } else {
                    k--;
                }
            }

        }
        return result;
    }
}
