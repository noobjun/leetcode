import java.util.Stack;

/**
 * Created by jun on 4/30/16.
 * 71. Simplify Path
 */
public class P71 {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals(".") || token.isEmpty()) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(token);
            }
        }

        String result = "";
        for (String token : stack)
            result += "/" + token;

        return result.isEmpty() ? "/" : result;
    }
}
