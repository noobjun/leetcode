import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jun on 2/29/16.
 * 32. Longest Valid Parentheses
 * <p>
 * Note this problem can also be solved with DP. Keep an array where arr[i] is the max valid parentheses length with ')'
 * ending at index i.
 */
public class P32 {
    public int longestValidParentheses(String s) {
        Stack<Parenthesis> stack = new Stack<>();
        boolean[] arr = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            Parenthesis p = new Parenthesis(s.charAt(i), i);
            if (!stack.isEmpty() && p.c == ')') {
                if (stack.peek().c == '(') {
                    Parenthesis left = stack.pop();
                    arr[left.index] = true;
                    arr[p.index] = true;
                }
            } else {
                stack.push(p);
            }
        }

        int result = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                current++;
            } else {
                current = 0;
            }

            result = Math.max(result, current);

        }

        return result;
    }

    static class Parenthesis {
        private Character c;
        private int index;

        public Parenthesis(Character c, int index) {
            this.c = c;
            this.index = index;
        }
    }
}
