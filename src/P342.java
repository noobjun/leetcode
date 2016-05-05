/**
 * Created by jun on 5/4/16.
 * 342. Power of Four
 */
public class P342 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;

        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt != num)
            return false;

        return ((sqrt - 1) & sqrt) == 0;
    }

    // Even smarter, since we know the power of 4 bit must occur in odd bits.
    // return ((num - 1) & num) == 0 && (num & 0x55555555) != 0;
}
