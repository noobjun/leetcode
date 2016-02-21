import java.math.BigInteger;

/**
 * Created by jun on 2/20/16.
 * 8. String to Integer (atoi)
 */
public class P8 {
    public int myAtoi(String str) {
        // strip str of any leading whitespaces
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                str = str.substring(i);
                break;
            }
        }

        if (str.length() == 0)
            return 0;

        double result = 0;
        int sign = 1;
        int i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        for (; i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9'); i++) {
            result *= 10;
            result += str.charAt(i) - '0';
        }

        result *= sign;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) result;
    }
}
