import java.util.Arrays;

/**
 * Created by jun on 5/2/16.
 * 85. Maximal Rectangle
 */
public class P85 {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;

        int r = matrix.length;
        if (r == 0)
            return result;
        int c = matrix[0].length;
        if (c == 0)
            return result;

        int[] height = new int[c];
        int[] left = new int[c];
        int[] right = new int[c];
        Arrays.fill(right, c - 1);

        for (int i = 0; i < r; i++) {
            // computer height
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            // compute left
            int currLeft = 0;
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(currLeft, left[j]);
                else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // compute right
            int currRight = c - 1;
            for (int j = c - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(currRight, right[j]);
                else {
                    right[j] = c - 1; // this is VERY tricky, if "0" encountered, set right to be right-most edge, so that next line can pick up the correct right from min(currRight, right[j])
                    currRight = j - 1;
                }
            }

            // compute area
            for (int j = 0; j < c; j++)
                result = Math.max((right[j] - left[j] + 1) * height[j], result);
        }

        return result;
    }
}