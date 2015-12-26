import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun on 12/25/15.
 * 217. Contains Duplicate
 */
public class P217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int number : nums) {
            if (!set.add(number))
                return true;
        }
        return false;
    }
}
