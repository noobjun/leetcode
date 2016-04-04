/**
 * Created by jun on 4/3/16.
 * 168. Excel Sheet Column Title
 */
public class P168 {
    public String convertToTitle(int n) {
        String result = "";
        while (n-- > 0) { // don't forget n--
            int rem = n % 26;
            char c = (char) ('A' + rem);
            result = c + result;
            n /= 26;
        }

        return result;
    }
}
