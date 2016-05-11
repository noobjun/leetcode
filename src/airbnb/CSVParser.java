package airbnb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 4/13/16.
 * input:
 * aa, bb, "aa","aa,bb", "aa""aa"""
 * output:
 * aa|bb|aa|aa,bb|aa"aa"
 * <p>
 * /*
 * John,Smith,john.smith@gmail.com,Los Angeles,1
 * Jane,Roberts,janer@msn.com,"San Francisco, CA",0
 * "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
 * """Alexandra Alex"""
 * John|Smith|john.smith@gmail.com|Los Angeles|1
 * Jane|Roberts|janer@msn.com|San Francisco, CA|0
 * Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
 * "Alexandra Alex"
 */
public class CSVParser {
    public static void main(String[] args) {
        String test1 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
        String test2 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
        String test3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
        String test4 = "\"\"\"Alexandra Alex\"\"\"";

        String expect1 = "John|Smith|john.smith@gmail.com|Los Angeles|1";
        String expect2 = "Jane|Roberts|janer@msn.com|San Francisco, CA|0";
        String expect3 = "Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1";
        String expect4 = "\"Alexandra Alex\"";
        CSVParser parser = new CSVParser();

        System.out.println(parser.parse(test1));
        System.out.println(parser.parse(test2));
        System.out.println(parser.parse(test3));
        System.out.println(parser.parse(test4));

        assert expect1.equals(parser.parse(test1));
        assert expect2.equals(parser.parse(test2));
        assert expect3.equals(parser.parse(test3));
        assert expect4.equals(parser.parse(test4));
    }

    public String parse(String input) {
        String result = "";
        if (input == null || input.length() == 0)
            return result;

        List<String> tokens = new ArrayList<>(); // store tokens that is to be separated by |
        String token = "";
        boolean inQuote = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '"') {
                inQuote = !inQuote;
                token += ch;
            } else if (ch == ',' && !inQuote) {
                tokens.add(token);
                token = "";
            } else {
                token += ch;
            }
        }

        tokens.add(token);

        // now we have a list of tokens, which might contain duplicate quotes
        // need to sanitize
        for (int i = 0; i < tokens.size(); i++) {
            if (i == 0)
                result += sanitize(tokens.get(i));
            else
                result += "|" + sanitize(tokens.get(i));
        }

        return result;
    }

    public String sanitize(String token) {
        String result = "";
        if (token == null || token.length() == 0)
            return result;

        if (token.charAt(0) == '"' && token.charAt(token.length() - 1) == '"')
            token = token.substring(1, token.length() - 1);

        // this skips double quotes
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) == '"' && i + 1 < token.length() && token.charAt(i + 1) == '"')
                continue;
            result += token.charAt(i);
        }

        return result;
    }


//    public String parse(String input) {
//        String result = "";
//        boolean inQuote = false;
//        ArrayList<String> tokens = new ArrayList<>();
//
//        String token = "";
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '"') {
//                inQuote = !inQuote;
//                token += c;
//            } else if (c == ',' && !inQuote) {
//                tokens.add(token);
//                token = "";
//            } else {
//                token += c;
//            }
//        }
//        tokens.add(token);
//
//        for (int i = 0; i < tokens.size(); i++) {
//            if (i == 0) {
//                result = sanitize(tokens.get(i));
//            } else {
//                result = result + "|" + sanitize(tokens.get(i));
//            }
//        }
//
//        return result;
//    }
//
//
//    public String sanitize(String str) {
//        if (str.length() == 0)
//            return "";
//
//        if (str.charAt(0) == '"')
//            str = str.substring(1, str.length() - 1);
//
//        String result = "";
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == '"' && i + 1 < str.length() && str.charAt(i + 1) == '"')
//                continue;
//
//            result += c;
//        }
//        return result;
//    }


//
//    public String parse(String line) {
//        String result = "";
//        ArrayList<String> tokens = new ArrayList<>();
//
//        boolean quotes = false;
//        String token = "";
//        for (int i = 0; i < line.length(); i++) {
//            char c = line.charAt(i);
//            if (c == '"') {
//                quotes = !quotes;
//                token += c;
//            } else if (c == ',' && !quotes) {
//                tokens.add(token);
//                token = "";
//            } else {
//                token += c;
//            }
//        }
//
//        if (!token.isEmpty())
//            tokens.add(token);
//
//
//        for (int i = 0; i < tokens.size(); i++) {
//            if (i == 0)
//                result = sanitize(tokens.get(i));
//            else
//                result = result + "|" + sanitize(tokens.get(i));
//        }
//        return result;
//    }
//
//    public String sanitize(String token) {
//        String result = "";
//
//        if (token.isEmpty()) {
//            return result;
//        }
//
//        if (token.charAt(0) == '"' && token.charAt(token.length() - 1) == '"')
//            token = token.substring(1, token.length() - 1);
//
//        for (int i = 0; i < token.length(); i++) {
//            if (token.charAt(i) == '"' && i + 1 < token.length() && token.charAt(i + 1) == '"')
//                continue;
//
//            result += token.charAt(i);
//        }
//
//        return result;
//    }
}
