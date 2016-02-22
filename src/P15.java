import java.util.*;

/**
 * Created by jun on 2/21/16.
 * 15. 3Sum
 */
public class P15 {
    /*
    The key to solve this problem: fix one number i by iterating through array, then use the same two pointers technique
    present in 2Sum to sum up all 3 numbers, if less, then move left pointer, if greater, then move right pointer.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int a = nums[i], b = nums[j], c = nums[k];
                int sum = a + b + c;

                if (sum == 0) {
                    List<Integer> list = new LinkedList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    set.add(list);
                    // if equal, then we move both pointers, that is because if we move just left pointer, then sum would be greater than 0, if we just move right pointer, vice versa
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.addAll(set);
        return result;
    }
}
