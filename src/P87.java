import java.util.Arrays;

/**
 * Created by jun on 12/24/15.
 * 87. Scramble String My Submissions Question
 */
public class P87 {

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2))
            return true;

        int len = s1.length();


        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        /**
         * This is a cool fact that any strings and s1 and s2, if they have the same characters,
         * they would always be able to scramble. For this problem it's not necessary to prune this far.
         *
         * if (len <= 3)
         *     return true;
         */

        for (int i = 1; i < len; i++) {
            boolean scramble;

            String s11, s12, s21, s22;
            s11 = s1.substring(0, i);
            s12 = s1.substring(i);
            s21 = s2.substring(0, i);
            s22 = s2.substring(i);

            scramble = isScramble(s11, s21) && isScramble(s12, s22);
            if (scramble)
                return true;

            s21 = s2.substring(len - i);
            s22 = s2.substring(0, len - i);

            scramble = isScramble(s11, s21) && isScramble(s12, s22);
            if (scramble)
                return true;
        }
        return false;
    }

}
