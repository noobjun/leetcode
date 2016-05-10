package fun;

/**
 * Created by jun on 5/6/16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 1, 5, 6, 2, 9, 11, 2, 8};
        sort(arr);

        int[] arr2 = new int[]{1};
        sort(arr2);

        for (int num : arr)
            System.out.print(num);
        System.out.println();
        for (int num: arr2)
            System.out.print(num);
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}
