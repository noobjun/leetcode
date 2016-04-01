/**
 * Created by jun on 3/31/16.
 * 238. Product of Array Except Self
 */
public class P238 {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                prod[i] = nums[i];
            else
                prod[i] = prod[i - 1] * nums[i];
        }

        int soFar = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                prod[i] = prod[i - 1];
            else if (i == 0)
                prod[i] = soFar;
            else
                prod[i] = prod[i - 1] * soFar;

            soFar *= nums[i];
        }

        return prod;
    }
}
