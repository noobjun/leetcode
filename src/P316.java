import java.util.Arrays;
import java.util.Stack;

/**
 * Created by jun on 4/25/16.
 * 316. Remove Duplicate Letters
 */
public class P316 {
    public static void main(String[] args) {

        P316 p = new P316();
        String s = p.removeDuplicateLetters("abacb");
        System.out.println(s);
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;

            if (visited[ch - 'a'])
                continue;

            while (!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && ch < stack.peek())
                visited[stack.pop() - 'a'] = false;

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack)
            sb.append(ch);

        return sb.toString();
    }
}
