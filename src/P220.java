import java.util.TreeSet;

/**
 * Created by jun on 12/26/15.
 * 220. Contains Duplicate III My Submissions Question
 */
public class P220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (set.floor(num + t) != null && set.floor(num + t) >= num ||
                    set.ceiling(num - t) != null && set.ceiling(num - t) <= num)
                return true;

            set.add(num);

            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
