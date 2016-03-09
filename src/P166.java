import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 3/8/16.
 * 166. Fraction to Recurring Decimal
 */
public class P166 {
    public static void main(String[] args) {
        P166 p = new P166();
        System.out.println(p.fractionToDecimal(2, 1));
        System.out.println(p.fractionToDecimal(1, 2));
        System.out.println(p.fractionToDecimal(2, 3));
        System.out.println(p.fractionToDecimal(-2, 3));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        boolean negative = numerator > 0 ^ denominator > 0;
        long a = numerator;
        long b = denominator;
        a = Math.abs(a);
        b = Math.abs(b);

        long remainder = a % b;
        long quotient = a / b;
        String left = negative ? "-" + String.valueOf(quotient) : String.valueOf(quotient);
        if (remainder == 0) {
            return left;
        } else {
            left += '.';
            String right = "";
            Map<Integer, Integer> map = new HashMap<>();

            int i = 0;
            while (remainder != 0 && !map.containsKey((int) remainder)) {
                map.put((int) remainder, i++);
                quotient = remainder * 10 / b;
                remainder = remainder * 10 % b;
                right += String.valueOf(quotient);
            }

            if (remainder == 0) {
                return left + right;
            } else {
                i = map.get((int) remainder);
                return left + right.substring(0, i) + "(" + right.substring(i) + ")";
            }
        }
    }
}
