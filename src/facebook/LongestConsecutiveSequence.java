package facebook;
import java.util.*;

/**
 * Created by jun on 5/2/16.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longest = new LongestConsecutiveSequence();
        int result = longest.longestConsecutive(new int[]{100,4 , 200, 3, 1, 2});
        System.out.println(result);

    }
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int result =0;
        Iterator<Integer> iterator;
        while (!set.isEmpty()){
            int partial = 1;
            iterator = set.iterator();
            int num = iterator.next();
            int temp = num;
            set.remove(num);
            while (set.contains(--num)){
                set.remove(num);
                partial++;
            }
            while (set.contains(++temp)){
                set.remove(temp);
                partial++;
            }

            result = Math.max(result, partial);

        }

        return result;

    }
}
