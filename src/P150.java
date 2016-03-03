import java.util.Stack;

/**
 * Created by jun on 3/3/16.
 * 150. Evaluate Reverse Polish Notation
 */
public class P150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        for (String element : tokens) {
            if (element.contentEquals("+") || element.contentEquals("-") || element.contentEquals("*") || element.contentEquals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(op(a, b, element));
            } else {
                int number = Integer.valueOf(element);
                stack.push(number);
            }
        }

        return stack.pop();
    }

    public int op(int a, int b, String operation) {
        if (operation.equals("+"))
            return a + b;
        else if (operation.equals("-"))
            return a - b;
        else if (operation.equals("*"))
            return a * b;
        else
            return a / b;
    }
}
