import java.util.Stack;

/**
 * Created by jun on 3/2/16.
 * 224. Basic Calculator
 */
public class P224 {

    public static void main(String[] args) {
        P224 p = new P224();
        String s1 = "2147483647";
        String s2 = "2-1 + 2";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        int a, b, c;
        a = p.calculate(s1);
        b = p.calculate(s2);
        c = p.calculate(s3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

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
