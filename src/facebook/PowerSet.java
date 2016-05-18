package facebook;

import java.util.*;


/**
 * Created by jun on 5/16/16.
 */
public class PowerSet {

    public static void main(String[] args) {

        PowerSet p = new PowerSet();
        p.subsetsWithDup(new int[]{0});

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
                count++;
            }

            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new LinkedList<>(result.get(j));
                for( int k =0; k<count; k++){
                    list.add(nums[i]);
                    result.add(list);
                    list = new LinkedList<>(list);
                }
            }
        }
        return result;
    }


}
