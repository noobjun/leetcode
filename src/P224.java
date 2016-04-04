import java.util.Stack;

/**
 * Created by jun on 3/2/16.
 * 224. Basic Calculator
 */
public class P224 {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('+');
        int result = 0;
        int i = 0;

        s = s.replaceAll(" ", ""); // We need to assign it back to s because string is immutable in Java

        while (i < s.length()) {
            char c = s.charAt(i);
            int num = -1;
            boolean eval = true;

            if (c == '(') {
                // Find where the parenthesis ends, and pass that into recursive call
                int sum = 1;
                int end = i;
                while (sum != 0) {
                    end++;
                    if (s.charAt(end) == '(')
                        sum++;
                    else if (s.charAt(end) == ')')
                        sum--;
                }
                num = calculate(s.substring(i + 1, end));
                i = end + 1;
            } else if (c == '-' || c == '+') {
                stack.push(c);
                i++;
                eval = false;
            } else {
                num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
            }

            if (eval && !stack.isEmpty())
                result = stack.pop() == '+' ? result + num : result - num;
        }

        return result;
    }
}
