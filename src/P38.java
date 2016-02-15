/**
 * Created by jun on 1/20/16.
 * 38. Count and Say
 */

public class P38 {
    public String countAndSay(int n) {
        String s = "1";
        String t = "";
        for (int i = 1; i < n; i++) {
            int count = 1;
            for (int j = 0; j < s.length(); j++) {
                if (j != s.length() - 1) {
                    if (s.charAt(j) == s.charAt(j + 1)) {
                        count++;
                    } else {
                        t += count + String.valueOf(s.charAt(j));
                        count = 1;
                    }
                } else {
                    t += count + String.valueOf(s.charAt(j));
                }
            }
            s = t;
            t = "";
        }

        return s;
    }
}
