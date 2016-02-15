/**
 * Created by jun on 2/2/16.
 * 306. Additive Number
 */
public class P306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;

        boolean result = false;

        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = i + 1; j < num.length() - 1; j++) {
                String numA, numB, remain;
                numA = num.substring(0, i + 1);
                numB = num.substring(i + 1, j + 1);
                remain = num.substring(j + 1);
                if (!isValid(numA) || !isValid(numB) || !isValid(remain))
                    continue;

                long a, b;
                a = Long.valueOf(numA);
                b = Long.valueOf(numB);

                result |= helper(a, b, remain);
                if (result)
                    return true;
            }
        }

        return result;

    }

    public boolean helper(long a, long b, String num) {
        long sum = a + b;
        String s = String.valueOf(sum);
        if (s.equals(num))
            return true;

        if (num.indexOf(s) == 0) {
            return helper(b, a + b, num.substring(s.length()));
        }
        return false;
    }

    public boolean isValid(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            char c = num.charAt(i);
            if (num.charAt(i) == '0')
                return false;
            else
                return true;
        }
        return true;
    }
}
