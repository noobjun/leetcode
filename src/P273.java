import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 4/29/16.
 * 273. Integer to English Words
 * <p>
 * Watch out for test cases such as 1800, 1000000, be sure don't print out empty spaces.
 * Another very clean solution.
 * https://leetcode.com/discuss/55462/my-clean-java-solution-very-easy-to-understand
 */
public class P273 {

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] units = {"", "Thousand", "Million", "Billion"};

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");

        String result = "";
        String str = String.valueOf(num);
        int i, j;
        for (i = str.length() - 1, j = 0; i >= 0; i = i - 3, j++) {
            String partial = convert(str.substring(Math.max(0, i - 2), i + 1), map);
            if (!partial.isEmpty())
                result = partial + units[j] + " " + result;
        }

        return result.trim();
    }

    public String convert(String triplet, Map<Integer, String> map) {
        String result = "";
        int num = Integer.valueOf(triplet);

        if (num >= 100) {
            result += map.get(num / 100) + " " + "Hundred" + " ";
            num %= 100;
        }

        if (num > 0) {
            if (num <= 20) {
                result += map.get(num) + " ";
            } else {
                int tenth = num / 10;
                result += map.get(tenth * 10) + " ";
                int oneth = num % 10;
                if (oneth > 0)
                    result += map.get(num % 10) + " ";
            }
        }

        return result;
    }
}
