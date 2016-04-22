/**
 * Created by jun on 4/22/16.
 * 344. Reverse String
 * <p>
 * Remember to use StringBuilder, otherwise large test case will time out.
 */
public class P344 {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
