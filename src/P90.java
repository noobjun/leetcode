import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jun on 4/30/16.
 * 90. Subsets II
 */
public class P90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            int count = i - start + 1;

            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> partial = new ArrayList<>(result.get(j));
                for (int k = 0; k < count; k++) {
                    partial.add(nums[i]);
                    result.add(new ArrayList<>(partial)); // this line is the magic
                }
            }
        }

        return result;
    }
}
