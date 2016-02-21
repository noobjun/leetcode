/**
 * Created by jun on 2/21/16.
 * 12. Integer to Roman
 */
public class P12 {
    /*
    Arabic number to Roman number
    Arabic to Roman:
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

    Input is guaranteed to be within the range from 1 to 3999.
     */

    public String intToRoman(int num) {
        int a = num % 10;
        num /= 10;
        int b = num % 10;
        num /= 10;
        int c = num % 10;
        num /= 10;
        int d = num % 10;

        String thousand = helper(d, "M", "", "");
        String hundred = helper(c, "C", "D", "M");
        String ten = helper(b, "X", "L", "C");
        String one = helper(a, "I", "V", "X");

        return thousand + hundred + ten + one;
    }

    public String helper(int n, String symbol1, String symbol2, String symbol3) {
        String result = "";
        if (n <= 3) {
            for (int i = 0; i < n; i++)
                result += symbol1;
        } else if (n == 4) {
            result = symbol1 + symbol2;
        } else if (n == 5) {
            result = symbol2;
        } else if (n >= 6 && n <= 8) {
            result += symbol2;
            for (int i = 5; i < n; i++)
                result += symbol1;
        } else {
            result += symbol1 + symbol3;
        }

        return result;
    }
}
