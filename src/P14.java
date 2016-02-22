/**
 * Created by jun on 2/21/16.
 * 14. Longest Common Prefix
 */
public class P14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0)
            return result;

        for (int i = 0; i < strs[0].length(); i++) {
            char prefix = strs[0].charAt(i);

            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (i < str.length()) {
                    if (str.charAt(i) != prefix)
                        return result;
                } else {
                    return result;
                }
            }

            result += prefix;

        }

        return result;
    }
}
