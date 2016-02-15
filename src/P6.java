/**
 * Created by jun on 2/6/16.
 * 6. ZigZag Conversion
 */
public class P6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        String[] strs = new String[numRows];
        for (int i = 0; i < strs.length; i++)
            strs[i] = "";

        int row = 0;
        int sign = -1;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            strs[row] += letter;
            if (row == 0 || row == numRows - 1)
                sign *= -1;
            row += sign;
        }
        String result = "";
        for (String str : strs)
            result += str;

        return result;
    }

// Alternative solution below generates array which tells which row to place the letter, it uses MOD to avoid index overflow
//    public String convert(String s, int numRows) {
//        if (numRows == 1)
//            return s;
//
//        String[] strs = new String[numRows];
//        for (int i = 0; i < strs.length; i++)
//            strs[i] = "";
//
//        int[] row = new int[(numRows-1)*2];
//        for (int i = 0; i < numRows; i++)
//            row[i] = i;
//        for (int i = numRows; i < row.length; i++)
//            row[i] = row.length - i;
//
//        for (int i = 0; i < s.length(); i++) {
//            char letter = s.charAt(i);
//            strs[row[i % row.length]] += letter;
//        }
//        String result = "";
//        for (String str : strs)
//            result += str;
//
//        return result;
//    }
}
