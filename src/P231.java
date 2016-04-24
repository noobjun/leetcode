/**
 * Created by jun on 4/23/16.
 * 231. Power of Two
 */
public class P231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
