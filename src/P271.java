import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 1/19/16.
 * 271. Encode and Decode Strings
 */
public class P271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            int len = str.length();
            result += len + "#" + str;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<>();
        int i = 0;
        String str = "";
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                int len = Integer.valueOf(str);
                str = s.substring(i + 1, i + 1 + len);
                list.add(str);
                str = "";
                i += len + 1;
            } else {
                str += s.charAt(i);
                i++;
            }
        }
        return list;
    }

    /** This alternative solution below will exceed time for large input set
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (c == '|')
                    result += "||";
                else
                    result += c;

            }
            result += '|';
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<>();
        String str = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '|') {
                if (i == s.length() - 1 || s.charAt(i + 1) == '|') {
                    str += '|';
                } else {
                    list.add(str);
                    str = "";
                }
            } else {
                str += s.charAt(i);
            }
        }
        if (str.length() > 0)
            list.add(str);
        return list;
    }
    */

}
