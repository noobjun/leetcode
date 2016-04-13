import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 4/12/16.
 * 68. Text Justification
 */
public class P68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        if (words.length == 0)
            return result;

        ArrayList<String> lineBuffer = new ArrayList<>();
        int charsLen = 0;

        for (String word : words) {
            int wordLen = word.length();
            int newLength = charsLen + lineBuffer.size() + wordLen;

            if (newLength > maxWidth) {
                result.add(print(lineBuffer, maxWidth, charsLen, false));
                lineBuffer.clear();
                lineBuffer.add(word);
                charsLen = wordLen;
            } else {
                lineBuffer.add(word);
                charsLen += wordLen;
            }
        }

        result.add(print(lineBuffer, maxWidth, charsLen, true));
        return result;
    }

    public String print(ArrayList<String> lineBuffer, int maxWidth, int totalChars, boolean lastLine) {
        int spaces = maxWidth - totalChars;
        int perWord, remain;

        if (lineBuffer.size() == 1) {
            perWord = 0;
            remain = maxWidth - totalChars;
        } else {
            if (lastLine) {
                perWord = 1;
                remain = maxWidth - totalChars - perWord * (lineBuffer.size() - 1);
            } else {
                perWord = spaces / (lineBuffer.size() - 1); // perWord needs to avoid division by zero
                remain = spaces % (lineBuffer.size() - 1);
            }
        }

        String result = "";
        for (int i = 0; i < lineBuffer.size(); i++) {
            String word = lineBuffer.get(i);
            if (i < lineBuffer.size() - 1) {  // This loop only covers add spaces in between until last word, doesn't cover remain logic, because a line can have additional space even with 1 word
                for (int j = 0; j < perWord; j++)
                    word += " ";
            }

            if (i == lineBuffer.size() - 1) {
                while (remain-- > 0) word += " ";
            } else if (!lastLine && remain-- > 0)
                word += " ";

            result += word;
        }

        return result;
    }

}
