import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 3/22/16.
 * 163. Missing Ranges
 * <p>
 * The solution could be less verbose, ha!
 * One trick to use is to say for i =0 ; i<=nums.length, notice it's <=
 * And add an if-clause if (i==nums.length) num = upper
 */
public class P163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        int l = lower;
        int expect = lower;

        for (int num : nums) {
            if (num == expect)
                expect++;
            else {
                int h = num - 1;
                if (l == h)
                    result.add("" + l);
                else
                    result.add("" + l + "->" + h);

                expect = num + 1;
            }
            l = expect;
        }

        if (expect == upper)
            result.add("" + upper);
        else if (expect < upper)
            result.add("" + l + "->" + upper);

        return result;
    }
}
