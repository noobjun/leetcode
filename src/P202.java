import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun on 2/17/16.
 * 202. Happy Number
 */
public class P202 {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long m = n; // This prevents overflow

        long val;
        while ((val = helper(m)) != 1) {
            if (set.contains(val))
                return false;
            else
                set.add(val);
            m = val;
        }

        return true;
    }

    public long helper(long n) {
        String str = String.valueOf(n);

        int result = 0;
        for (char c : str.toCharArray()) {
            result += (c - '0') * (c - '0');
        }

        return result;
    }
}
