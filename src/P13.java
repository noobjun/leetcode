import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 2/21/16.
 * 13. Roman to Integer
 */
public class P13 {
    /*
    1   I
    2   II
    3   III
    4   IV
    5   V
    6   VI
    7   VII
    8   VIII
    9   IX
    10  X
    11  XI
    12  XII
    13  XIII
    14  XIV
    15  XV
    20  XX
    30  XXX
    50  L
    100 C
    500 D
    1000 M

    I 1
    IV 4
    V 5
    IX 9
    X 10
    XL 40
    L 50
    XC 90
    C 100
    CD 400
    D 500
    CM 900
    M 1000
     */

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i = 0;
        int result = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                result += map.get(String.valueOf(s.charAt(i)));
                i++;
            }
        }

        return result;
    }

}
