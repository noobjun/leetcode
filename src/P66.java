/**
 * Created by jun on 3/20/16.
 * 66. Plus One
 */
public class P66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            i--;
        }

        int[] result;
        if (i == -1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        } else {
            result = new int[digits.length];
            System.arraycopy(digits, 0, result, 0, i + 1);
            result[i]++;
        }

        return result;
    }
}
