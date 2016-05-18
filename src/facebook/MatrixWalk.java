package facebook;

/**
 * Created by jun on 5/16/16.
 */
public class MatrixWalk {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        print(matrix);

    }

    public static void print(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int i = 0, j = 0;
        while (j < c) {
            int x=i;
            int y=j;

            while (x>=0 && y<c){
                System.out.print( matrix[x][y]+ " ");
                x--;
                y++;
            }

            if (i+1<r)
                i++;
            else
                j++;
        }


    }


}
