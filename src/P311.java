/**
 * Created by jun on 4/29/16.
 * Sparse Matrix Multiplication
 */
public class P311 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 0, 0}, {-1, 0, 3}};
        int[][] B = new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        P311 p = new P311();
        int[][] res = p.multiply(A, B);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {

                System.out.print(res[i][j]+ " ");

            }
            System.out.println();
        }

    }

    public int[][] multiply(int[][] A, int[][] B) {
        int r = A.length;
        int c = B[0].length;
        int n = A[0].length;

        int[][] result = new int[r][c];

        boolean[] rows = new boolean[r]; // false represent not looked at yet, or at least one element is not zero
        boolean[] cols = new boolean[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i] || cols[j]) {
                    result[i][j] = 0;
                } else {
                    boolean rowZeroes = true;
                    boolean colZeroes = true;
                    int res = 0;
                    for (int k = 0; k < n; k++) {
                        res += A[i][k] * B[k][j];
                        if (A[i][k] != 0)
                            rowZeroes = false;
                        if (B[k][j] != 0)
                            colZeroes = false;
                    }
                    result[i][j] = res;
                    if (rowZeroes)
                        rows[i] = true;
                    if (colZeroes)
                        cols[j] = true;
                }
            }
        }

        return result;
    }
}
