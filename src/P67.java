/**
 * Created by jun on 4/2/16.
 * 67. Add Binary
 * <p>
 * There are many ways to do this, but this is one of the cleaner ways!
 * First figure out how long the result should be, then loop backward, be very careful that if one string is shorter than the other, still loop through max(len(a), len(b)), because carries can carry forward continuously.
 */
public class P67 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        int len = Math.max(m, n);
        String result = "";
        int carry = 0;
        for (int i = 0; i < len; i++) {

            int x = i < m ? a.charAt(m - 1 - i) - '0' : 0;
            int y = i < n ? b.charAt(n - 1 - i) - '0' : 0;

            int sum = carry + x + y;
            carry = sum / 2;
            result = sum % 2 + result;
        }

        return carry == 1 ? "1" + result : result;
    }
}
