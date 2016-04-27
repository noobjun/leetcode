import java.util.Stack;

/**
 * Created by jun on 4/26/16.
 * 42. Trapping Rain Water
 * <p>
 * Wow this took me so many trial and errors.
 * <p>
 * the key is:
 * if (!stack.empty())
 * water += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[bottom]);
 */
public class P42 {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;

        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottom = stack.pop();
                if (!stack.empty()) // if stack is already empty, then that means left side has no wall, don't add to water
                    water += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[bottom]); // the increment amount is min(current, and stack.peek()), both are taller than the bar kicked out.
            }
            stack.push(i);
        }

        return water;
    }
}
