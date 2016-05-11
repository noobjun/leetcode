package airbnb;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by jun on 5/5/16.
 * Sort a list of numbers in which each number is at a distance k from its actual position.
 */
public class KDistanceSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 6, 2, 3, 8, 7, 9};
        kSort(arr, 3);

        for (int num : arr)
            System.out.print(num);

        assert Arrays.equals(arr, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static void kSort(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i+k<nums.length)
                minHeap.add(nums[i+k]);

            nums[i]=minHeap.poll();
        }

    }

//    public static void kSort(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int i = 0; i < k; i++)
//            heap.offer(nums[i]);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i + k < nums.length)
//                heap.offer(nums[i + k]);
//
//            nums[i] = heap.poll();
//        }
//    }


}
