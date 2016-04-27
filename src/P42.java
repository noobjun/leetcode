import java.util.Stack;

/**
 * Created by jun on 4/26/16.
 * 42. Trapping Rain Water
 */
public class P42 {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;

        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                stack.push(i);
            } else {
                int bottom = stack.peek();
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    water+=height[i] - stack.peek();
                    bottom = stack.pop();
                }
                if (!stack.isEmpty())
                    water += (height[i] - bottom) * (i - stack.peek() - 1);

                stack.push(i);
            }
        }
        return water;
    }
}
