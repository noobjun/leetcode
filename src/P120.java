import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 1/16/16.
 * 120. Triangle
 */
public class P120 {
    public static void main(String[] args) {
        P120 p = new P120();

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();

        l1.add(-1);
        l2.add(2);
        l2.add(3);
        l3.add(1);
        l3.add(-1);
        l3.add(-1);

        LinkedList<List<Integer>> input = new LinkedList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);

        p.minimumTotal(input);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0)
            return 0;

        int result[] = new int[rows];
        int temp[] = new int[rows];
        for (int i = 0; i < rows; i++) {
            List<Integer> nums = triangle.get(i);

            for (int j = 0; j < nums.size(); j++) {
                if (j == 0)
                    temp[j] = result[j] + nums.get(j);
                else if (j == nums.size() - 1)
                    temp[j] = result[j - 1] + nums.get(j);
                else{
                    temp[j] = Math.min(result[j], result[j - 1]) + nums.get(j);

                }
            }

            for (int j = 0; j < nums.size(); j++){
                result[j] = temp[j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++)
            min = Math.min(result[i], min);

        return min;
    }
}
