import java.util.*;

/**
 * Created by jun on 2/22/16.
 * 17. Letter Combinations of a Phone Number
 */
public class P17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new LinkedList<>();

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new LinkedList<>();
        helper(digits, 0, "", map, result);

        return result;
    }

    public void helper(String digits, int pos, String current, Map<Character, List<Character>> map, List<String> result) {
        if (pos == digits.length()) {
            result.add(current);
            return;
        }

        if (map.containsKey(digits.charAt(pos))) {
            for (char c : map.get(digits.charAt(pos))) {
                helper(digits, pos + 1, current + c, map, result);
            }
        } else {
            helper(digits, pos + 1, current, map, result);
        }
    }
}
