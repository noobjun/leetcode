package airbnb;

import java.util.*;

/**
 * Created by jun on 4/19/16.
 */

public class NSum {
    public static void main(String[] args) {
        NSum sum = new NSum();
        List<List<Integer>> list = sum.combinationSum(new int[]{2, 3, 6, 7}, 8);
        for (List<Integer> l : list) {
            for (int num : l)
                System.out.print(num);
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();

        helper(candidates, 0, 0, new LinkedList<>(), target, result);

        List<List<Integer>> list = new LinkedList<>();
        list.addAll(result);
        return list;
    }

    public void helper(int[] candidates, int index, int currSum, LinkedList<Integer> currList, int target, Set<List<Integer>> result) {
        if (currSum > target)
            return;
        else if (currSum == target) {
            result.add(new LinkedList<Integer>(currList));
        }

        for (int i = index; i < candidates.length; i++) {
            currList.add(candidates[i]);
            helper(candidates, i, currSum + candidates[i], currList, target, result);
            currList.removeLast();
        }
    }


}
