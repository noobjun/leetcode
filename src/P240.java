/**
 * Created by jun on 4/24/16.
 * 240. Search a 2D Matrix II
 */
public class P240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        int col = matrix[0].length;
        if (col == 0)
            return false;


        int i = row - 1;
        int j = 0;

        while (i >= 0 && j < col) {
            int num = matrix[i][j];
            if (num == target)
                return true;
            else if (num < target)
                j++;
            else
                i--;
        }

        return false;
    }
}
