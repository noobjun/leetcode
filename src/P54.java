import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 4/24/16.
 * 54. Spiral Matrix
 */
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        int row = matrix.length;
        if (row == 0)
            return result;
        int col = matrix[0].length;
        if (col == 0)
            return result;

        int r = 0, c = 0;
        int i = -1, j = -1;

        int k = 0;
        while (row != r && col != c) {
            if (k % 4 == 0) {
                for (++i, ++j; j < col - c / 2; j++)
                    result.add(matrix[i][j]);
                r++;
            } else if (k % 4 == 1) {
                for (--j, ++i; i < row - r / 2; i++)
                    result.add(matrix[i][j]);
                c++;
            } else if (k % 4 == 2) {
                for (--i, --j; j >= c / 2; j--)
                    result.add(matrix[i][j]);
                r++;
            } else if (k % 4 == 3) {
                for (++j, --i; i >= r / 2; i--)
                    result.add(matrix[i][j]);
                c++;
            }
            k++;
        }

        return result;
    }
}
