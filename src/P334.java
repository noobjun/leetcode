import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun on 4/3/16.
 * 334. Increasing Triplet Subsequence
 * <p>
 * Maintain a minimum and second minimum, if current number is less than smallest, update it, if less than second smallest, then update it, otherwise we have 3-length increasing triplet.
 */
public class P334 {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        for (int num : nums)
            if (num <= a)
                a = num;
            else if (num <= b)
                b = num;
            else
                return true;

        return false;
    }

// This is my initial way of doing it -_-
//    public boolean increasingTriplet(int[] nums) {
//        int a = 0, b = 0, c = 0;
//        int size = 0;
//
//        for (int num : nums) {
//            if (size == 0) {
//                a = num;
//                size++;
//            } else if (size == 1) {
//                if (num > a) {
//                    b = num;
//                    size++;
//                } else if (num < a) {
//                    a = num;
//                }
//            } else if (size == 2 || size == 3) {
//                if (num > b) {
//                    return true;
//                } else if (a < num && num < b) {
//                    b = num;
//                } else if (num < a) {
//                    if (size == 2) {
//                        c = num;
//                        size++;
//                    } else {
//                        if (num < c) {
//                            c = num;
//                        } else if (num > c) {
//                            a = c;
//                            b = num;
//                            size--;
//                        }
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
}
