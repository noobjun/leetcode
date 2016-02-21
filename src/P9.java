/**
 * Created by jun on 2/20/16.
 * 9. Palindrome Number
 */
public class P9 {
    /*
    For this problem, it's easiest to try it against reversed integer. If you directly try to compare head digit and tail
    digit, you will run into corner cases such as 100031. It's unwieldy to deal with, and not worth the trouble.
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        return (x == reverse(x));
    }

    public long reverse(int x) {
        long sum = 0;
        while (x > 0) {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
