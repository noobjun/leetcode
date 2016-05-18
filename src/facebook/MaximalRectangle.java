package facebook;

import java.util.Arrays;

/**
 * Created by jun on 5/17/16.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0)
            return 0;
        int c = matrix[0].length;
        if (c == 0)
            return 0;

        int[] height = new int[c];
        int[] left = new int[c];
        int[] right = new int[c];

        Arrays.fill(right, c - 1);

        int result = 0;
        for (int i = 0; i < r; i++) {
            // compute height
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
                    right[j] = c-1;
                    currRight = j - 1;
                }
            }

            // compute area
            for (int j = 0; j < c; j++) {
                result = Math.max(result, (right[j] - left[j] + 1) * height[j]);
            }
        }

        return result;
    }
}
