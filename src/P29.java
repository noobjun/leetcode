/**
 * Created by jun on 2/28/16.
 * 29. Divide Two Integers My Submissions Question
 * <p>
 * To solve this problem, we should think out side of the box. The problem states that we cannot use multiplication, division,
 * or modular division. So we can use bitwise operations as well as addition and subtraction.
 * <p>
 * The algorithm to solve this problem is that, we subtract the power of divisors from the dividend. We keep track of the result
 * by doing result += 1 << i where i is the shift.
 */
public class P29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;

        long a = dividend;
        long b = divisor;

        boolean negative = a < 0 ^ b < 0;
        a = Math.abs(a);
        b = Math.abs(b);

        long result = 0;
        while (a >= b) {
            long k = b;
            int i = 0;
            while (a >= k) {
                a -= k;
                k <<= 1;
                result += 1 << i;
                i++;
            }
        }

        result = negative ? -result : result;

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) result;
    }
}
