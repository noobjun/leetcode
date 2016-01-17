import java.util.Stack;

/**
 * Created by jun on 1/16/16.
 * 20. Valid Parentheses
 */
public class P20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '}' ) {
                if (stack.isEmpty())
                    return false;

                if ('{' != stack.pop())
                    return false;
            } else if (c == ']' ) {
                if (stack.isEmpty())
                    return false;

                if ('[' != stack.pop())
                    return false;
            } else if (c == ')' ) {
                if (stack.isEmpty())
                    return false;

                if ('(' != stack.pop())
                    return false;
            } else {
                stack.push(c);
            }
        }

        if (!stack.isEmpty())
            return false;
        else
            return true;
    }
}
