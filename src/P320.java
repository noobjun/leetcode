import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 3/21/16.
 * 320. Generalized Abbreviation
 */
public class P320 {

    public List<String> generateAbbreviations(String word) {
        int len = word.length();
        List<String> result = new LinkedList<>();
        result.add(word);

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                String a, b, c, d;
                a = word.substring(0, j);
                b = word.substring(j, j + i);
                c = "" + (j + i < len ? word.charAt(j + i) : "");
                d = j + i + 1 < len ? word.substring(j + i + 1) : "";

                String first = a + b.length() + c;
                for (String second : generateAbbreviations(d))
                    result.add(first + second);
            }
        }

        return result;
    }
}
