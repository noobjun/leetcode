package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun on 4/19/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        if (words.length == 0 || maxWidth == 0) {
            result.add("");
            return result;
        }

        ArrayList<String> tokens = new ArrayList<>(); // use to hold words per line
        int rawLen = 0; // used to hold character length of words in the line without counting spaces

        for (String word : words) {
            int wordLen = word.length();
            int newLineLen = tokens.size() + rawLen + wordLen;

            if (newLineLen > maxWidth) {
                // print to line
                result.add(printLine(tokens, rawLen, maxWidth));
                tokens.clear();
                rawLen = 0;
            }
            // ** this cannot be part of else, need to append to current line each time without skipping word
            tokens.add(word);
            rawLen += wordLen;
        }

        // handle last line
        String lastLine = "";
        for (int i = 0; i < tokens.size(); i++) {
            if (i == 0) {
                lastLine = tokens.get(i);
            } else {
                lastLine += " " + tokens.get(i);
            }
        }

        // handle last white spaces
        for (int i = lastLine.length(); i < maxWidth; i++)
            lastLine += " ";

        result.add(lastLine);
        return result;
    }

    public String printLine(ArrayList<String> tokens, int rawLen, int maxWidth) {
        String line = "";

        if (tokens.size() == 1) {  // ** handle zero this way
            line += tokens.get(0);

            // handle last white spaces
            for (int i = line.length(); i < maxWidth; i++)
                line += " ";

            return line;
        }

        int spaces = maxWidth - rawLen;

        int spacesPerWord = spaces / (tokens.size() - 1);
        int remain = spaces % (tokens.size() - 1);

        for (int i = 0; i < tokens.size(); i++) {
            line += tokens.get(i);
            if (i == tokens.size() - 1)
                continue;

            for (int j = 0; j < spacesPerWord; j++)
                line += " ";

            if (remain > 0) {
                line += " ";
                remain--;
            }
        }

        return line;
    }
}



