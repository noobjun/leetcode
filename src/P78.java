import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 3/30/16.
 * 78. Subsets
 * <p>
 * Weird casting...
 */
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return (List) helper(nums, 0);
    }

    public List<LinkedList<Integer>> helper(int[] nums, int index) {
        List<LinkedList<Integer>> result = new LinkedList<>();

        if (index == nums.length) {
            result.add(new LinkedList<Integer>()); // this is the key, without the empty set it won't work.
            return result;
        }

        List<LinkedList<Integer>> next = helper(nums, index + 1);

        for (LinkedList<Integer> l : next) {
            result.add((LinkedList<Integer>) l.clone());
            l.addFirst(nums[index]);
            result.add(l);
        }

        return result;
    }
}
