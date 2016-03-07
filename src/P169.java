/**
 * Created by jun on 3/4/16.
 * 169. Majority Element
 */
public class P169 {

    public static void main(String[] args) {
        P169 p = new P169();
        System.out.println(p.majorityElement(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 6}));
    }

    public int majorityElement(int[] nums) {

        int index = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int candidate = nums[index];

            count = current == candidate ? count + 1 : count - 1;

            if (count == 0) {
                index = i;
                count = 1;
            }
        }

        return nums[index];
    }
}
