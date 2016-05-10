/**
 * Created by jun on 1/21/16.
 * 161. One Edit Distance
 */
public class P161 {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        for (int i = 0; i < Math.min(m, n); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (m < n)
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i));
            }
        }

        return Math.abs(m - n) == 1;
    }

}
