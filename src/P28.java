/**
 * Created by jun on 2/7/16.
 * 28. Implement strStr()
 * <p>
 * Here's a naive way to do it without KMP.
 */
public class P28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n)
            return -1;

        int i, j;
        for (i = 0; i < m - n + 1; i++) {
            for (j = 0; j < n; j++)
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;

            if (j == n)
                return i;
        }

        return -1;
    }
}
