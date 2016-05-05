package facebook;

/**
 * Created by jun on 5/2/16.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()<=1)
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) // remember to advance i and j here
                return false;
        }
        return true;
    }
}
