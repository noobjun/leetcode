/**
 * Created by jun on 2/20/16.
 * 9. Palindrome Number
 */
public class P9 {
    /*
    For this problem, it's easiest to try it against reversed integer. If you directly try to compare head digit and tail
    digit, you will run into corner cases such as 100031. It's unwieldy to deal with, and not worth the trouble. Example of that COOL
    solution is shown at the bottom.
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

    /** COOL SOLUTION, div is tricky to get right
    public boolean isPalindrome(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div; // this line with variable div is the KEY to deal with edge cases with 0s such as 100031
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
    */
}
