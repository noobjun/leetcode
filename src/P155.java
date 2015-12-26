import java.util.Stack;

/**
 * Created by jun on 12/24/15.
 * 155. Min Stack
 */
public class P155 {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int currentMin = Integer.MAX_VALUE;

    public void push(int x) {
        mainStack.push(x);
        currentMin = Math.min(currentMin, x);
        minStack.push(currentMin);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
        if (!minStack.isEmpty())
            currentMin = getMin();
        else
            currentMin = Integer.MAX_VALUE;
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
