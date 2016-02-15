/**
 * Created by jun on 2/7/16.
 * 28. Implement strStr()
 */
public class P28 {
    public static void main(String[] args) {
        P28 p = new P28();
        int val = p.strStr("ballsack noodle", "oo");
        System.out.println(val);
    }
    public int strStr(String haystack, String needle) {
        int result = -1;

        for (int i = 0; i < haystack.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                char a, b;
                a = haystack.charAt(i);
                b = needle.charAt(j);

                if (a != b) {
                    match = false;
                    break;
                }
            }
            if (match)
                return i;
        }

        return result;
    }
}
