import java.util.Stack;

/**
 * Created by jun on 3/22/16.
 * 331. Verify Preorder Serialization of a Binary Tree
 * <p>
 * Of course we can solve this without using stacks, it's just for clarity.
 * <p>
 * So many traps, next time just tokenize it, don't be fancy and think it's all single digits.
 * <p>
 * Also dietpepsi has a solution based on difference between in-degree and out-degree differences.
 */
public class P331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> a = new Stack<>();
        Stack<String> b = new Stack<>();

        String[] arr = preorder.split(",");
        for (String token : arr)
            a.push(token);

        while (!a.isEmpty()) {
            String c = a.pop();
            if (c.equals("#")) {
                b.push(c);
            } else {
                if (b.size() < 2)
                    return false;

                if (!b.pop().equals("#") || !b.pop().equals("#")) // boolean logic, A AND B => A && B; Not A also not B, then it's !A || !B
                    return false;

                b.push("#"); // don't forget to push # after reduction
            }
        }

        return b.size() == 1 && b.pop().equals("#");
    }
}
