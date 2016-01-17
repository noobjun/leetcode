import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 1/16/16.
 * 22. Generate Parentheses
 */
public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(result, "", 0, 0, n);

        return result;
    }

    public void helper(List<String> list, String str, int left, int right, int N) {
        if (left == N && right == N) {
            list.add(str);
            return;
        }

        if (left < N) {
            helper(list, str + "(", left + 1, right, N);
        }

        if (left > right) {
            helper(list, str + ")", left, right + 1, N);
        }
    }

}
