import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 3/3/16.
 * 282. Expression Add Operators
 */
public class P282 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        List<Integer> inter = new LinkedList<>();
        helper(result, num, target, 0, 0, "");
        return result;
    }

    public void helper(List<String> result, String rest, long target, long sum, long prev, String out) {
        if (rest.isEmpty()) {
            if (target == sum)
                result.add(out);
            return;
        }

        for (int i = 0; i < rest.length(); i++) {
            String numStr = rest.substring(0, i + 1);
            if (numStr.length() > 1 && numStr.charAt(0) == '0')
                return;

            long num = Long.valueOf(numStr);
            String next = rest.substring(i + 1);

            if (out.isEmpty()) {
                helper(result, next, target, num, num, numStr);
            } else {
                helper(result, next, target, sum + num, num, out + "+" + numStr); // add, simple enough
                helper(result, next, target, sum - num, -num, out + "-" + numStr); // subtract, remember to keep prevNum as -num
                helper(result, next, target, sum - prev + num * prev, num * prev, out + "*" + numStr); // multiply, back out the previous results
            }
        }
    }
}
