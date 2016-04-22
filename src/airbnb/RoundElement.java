package airbnb;

import java.util.Arrays;

/**
 * Created by jun on 4/17/16.
 * Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn)
 * We want to find a way to round each element in A such that after rounding we get a new array B = [y1, y2, ...., yn] such that y1+y2+...+yn = T where  yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.
 * We also want to minimize sum |x_i-y_i|
 * <p>
 * It can be positive and negative.
 */
public class RoundElement {
    public static void main(String[] args) {
        RoundElement re = new RoundElement();

        double[] test1 = new double[]{1.1, 1.2, 1.3, 1.4};
        double[] test2 = new double[]{-1.1, -1.2, -1.3, -1.4};
        double[] test3 = new double[]{-1.9, -1.9, -1.9, 1.4}; // difference of 1.5 vs 0.9
        double[] test4 = new double[]{-0.4, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3};

        int[] expect1 = new int[]{1, 1, 1, 2};
        int[] expect2 = new int[]{-1, -1, -1, -2};
        int[] expect3 = new int[]{-2, -2, -2, 2};
        int[] expect4 = new int[]{0, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1};

        int[] ans1 = re.smartRound(test1);
        int[] ans2 = re.smartRound(test2);
        int[] ans3 = re.smartRound(test3);
        int[] ans4 = re.smartRound(test4);
    }

    public int[] smartRound(double[] arr) {
        int len = arr.length;
        Number[] numbers = new Number[len];
        double sum = 0;
        int separateRoundedSum = 0;
        int togetherRoundedSum = 0;
        for (int i = 0; i < len; i++) {
            numbers[i] = new Number(arr[i], i);
            sum += arr[i];
            separateRoundedSum += (int) Math.round(arr[i]);
        }
        togetherRoundedSum = (int) Math.round(sum);

        int[] result = new int[len];
        int count = separateRoundedSum - togetherRoundedSum;

        if (count < 0) {
            count = -count;
            Arrays.sort(numbers, (a, b) -> (Double.compare(a.up, b.up))); // need to round up a few numbers
            for (int i = 0; i < len; i++) {
                Number number = numbers[i];
                if (number.up > 0.5 && count > 0) {
                    result[number.index] = (int) Math.ceil(number.number);
                    count--; //** dont forget to decrement
                } else {
                    result[number.index] = (int) Math.round(number.number);
                }
            }
        } else if (count > 0) {
            Arrays.sort(numbers, (a, b) -> (Double.compare(a.down, b.down))); // need to round down a few numbers
            for (int i = 0; i < len; i++) {
                Number number = numbers[i];
                if (number.down > 0.5 && count > 0) {
                    result[number.index] = (int) Math.floor(number.number);
                    count--; //** dont forget to decrement
                } else {
                    result[number.index] = (int) Math.round(number.number);
                }
            }
        } else {
            for (int i = 0; i < len; i++)
                result[i] = (int) Math.round(arr[i]);
        }

        return result;
    }

    class Number {
        double number;
        int index;
        double up;
        double down;

        public Number(double number, int index) {
            this.number = number;
            this.index = index;
            this.up = Math.ceil(number) - number;
            this.down = number - Math.floor(number);
        }
    }
}




