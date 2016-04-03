/**
 * Created by jun on 4/2/16.
 * 172. Factorial Trailing Zeroes
 * <p>
 * We need to find out how many 5s there are in n! factorial. However there are numbers like 25 and 125, which has more than one 5 factor. We need to consider those as well.
 * The forumula floor(n/5) + floor(n/25) + floor(n/125) would give the correct number of 5s.
 */
public class P172 {
    public int trailingZeroes(int n) {
        int result = 0;
        long m = 5; // needs to be long to avoid overflow

        while (n / m > 0) {
            result += n / m;
            m *= 5;
        }

        return result;
    }
}
