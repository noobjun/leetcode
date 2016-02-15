/**
 * Created by jun on 2/9/16.
 * 73. Set Matrix Zeroes
 */
public class P73 {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean rowZero = false;
        boolean colZero = false;

        // set colZero
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        // set rowZero
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        // use first row and first col to track if rest of matrix should be zero
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        // set rest of matrix to be zero based on first col tracking
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0)
                for (int j = 1; j < c; j++)
                    matrix[i][j] = 0;
        }

        // set rest of matrix to be zero based on first row tracking
        for (int i = 1; i < c; i++) {
            if (matrix[0][i] == 0)
                for (int j = 1; j < r; j++)
                    matrix[j][i] = 0;
        }

        // set first row to zero if it has any zeroes
        if (rowZero) {
            for (int i = 0; i < c; i++)
                matrix[0][i] = 0;
        }

        // set first col to zero if it has any zeroes
        if (colZero) {
            for (int i = 0; i < r; i++)
                matrix[i][0] = 0;
        }
    }
}
