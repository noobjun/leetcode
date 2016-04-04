import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 3/31/16.
 * 43. Multiply Strings
 */
public class P43 {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] x = new int[m];
        for (int i = 0; i < m; i++)
            x[i] = num1.charAt(i) - '0';

        int[] y = new int[n];
        for (int i = 0; i < n; i++)
            y[i] = num2.charAt(i) - '0';

        int[] product = new int[m + n];

        for (int i = 0; i < n; i++) { // iterate num2
            for (int j = 0; j < m; j++) { // iterate num1
                product[i + j] += y[n-1-i] * x[m-1-j];
            }
        }

        int carry = 0;
        for (int i = 0; i < product.length; i++) {
            int total = product[i] + carry;
            carry = total / 10;
            product[i] = total % 10;
        }

        int k = product.length - 1;
        while (k >= 0 && product[k] == 0) k--;

        if (k < 0)
            return "0";

        String result = "";
        for (; k >= 0; k--) {
            result += product[k]; // the bug here was result += product[k] + '0'
        }

        return result;
    }


}
