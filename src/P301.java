import java.util.*;

/**
 * Created by jun on 4/2/16.
 * 301. Remove Invalid Parentheses
 */
public class P301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        if (isValid(s)) {
            result.add(s);
            return result;
        }

        boolean found = false;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);

        while (!q.isEmpty() && !found) {
            int qSize = q.size(); // this needs to be fixed and not inside of the loop, otherwise q size will grow and q.size() gets called every time
            for (int i = 0; i < qSize; i++) {
                String str = q.poll();
                for (int j = 0; j < str.length(); j++) { // This is a neat trick for BFS at one level at a time, doesn't need two queues
                    String next = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);

                        if (isValid(next)) {
                            found = true;
                            result.add(next);
                        } else {
                            q.offer(next);
                        }
                    }
                }
            }

            visited.clear();
        }

        return result;
    }

    public boolean isValid(String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                counter++;
            else if (c == ')')
                counter--;

            if (counter < 0)
                return false;
        }

        return counter == 0;
    }
}
