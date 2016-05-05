/**
 * Created by jun on 5/4/16.
 * 136. Single Number
 */
public class P136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num;

        return result;
    }
}
