/**
 * Created by jun on 1/21/16.
 * 161. One Edit Distance
 */
public class P161 {
    public static void main(String[] args) {
        P161 p = new P161();
        p.isOneEditDistance("a", "ac");
    }
    public boolean isOneEditDistance(String s, String t) {
        int a = s.length();
        int b = t.length();

        int counter = 0;
        if (a == b) {
            for (int i = 0; i < a; i++) {
                if (s.charAt(i) != t.charAt(i))
                    counter++;
            }
        } else if (Math.abs(a - b) > 1) {
            return false;
        } else if (a == 0 && b == 1 || a == 1 && b == 0) {
            return true;
        } else {
            if (b < a) {
                String temp = s;
                s = t;
                t = temp;
            }
            for (int i = 0, j = 0; i < s.length() && j < t.length(); ) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                    counter++;
                }
            }
        }

        if (counter != 0)
            return false;
        return true;
    }

}
