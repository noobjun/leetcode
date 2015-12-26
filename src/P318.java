import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jun on 12/25/15.
 * Maximum Product of Word Lengths
 */
public class P318 {
    public int maxProduct(String[] words) {
        if (words.length < 2)
            return 0;

        /**
         * Do not sort the array, it's incorrect to advance two pointers one after another,
         * if there is an optimal product that is in location [0, 1, 2, 4, 5] 0 and 4, it will not find it.
         *
         * Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
         */

        int[] chars = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray())
                chars[i] |= 1 << c - 'a';
        }

        int result = 0;
        for (int i = 0; i < words.length - 1; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((chars[i] & chars[j]) == 0)
                    result = Math.max(result, words[i].length() * words[j].length());

        return result;
    }
}
