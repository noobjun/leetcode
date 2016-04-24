/**
 * Created by jun on 4/23/16.
 * 31. Next Permutation
 */
public class P31 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        P31 p = new P31();
        p.nextPermutation(nums);
        p.print(nums);
    }

    private void print(int[] arr) {
        for (int a : arr)
            System.out.print(a);
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        // find right-most index of increasing pair
        int len = nums.length;
        if (len == 0)
            return;
        int i = len - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        int swap = i - 1;

        // sort the right portion from i
        int j = len - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

        // swap the number from non-increasing pair with the first number in the sorted portion which is greater
        if (swap != -1) {
            int k = swap + 1;
            while (k < len - 1 && nums[swap] >= nums[k]) {
                k++;
            }
            swap(nums, swap, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
