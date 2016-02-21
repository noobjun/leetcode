/**
 * Created by jun on 2/21/16.
 * 11. Container With Most Water
 */
public class P11 {
    /* This solution is O(N) where N is length of height array. */
    public int maxArea(int[] height) {
        int result = 0;
        if (height.length < 2)
            return result;

        int i = 0, j = height.length - 1;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            result = Math.max(result, Math.min(left, right) * (j - i));
            if (left < right)
                i++;
            else
                j--;
        }

        return result;
    }
    /* Time exceeded with this one
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 0; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * j - i);
            }
        }
        return result;
    }
    */

}
