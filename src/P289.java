/**
 * Created by jun on 2/9/16.
 * 289. Game of Life
 */
public class P289 {
    /*
    Regular solution is trivial, but here is an interesting way to do it in-place. The hint is that each cell stores an
    integer instead a boolean value, and an integer can be used for bit-manipulation.

    00 is dead<-dead
    01 is dead<-live
    10 is live<-dead
    11 is live<-live


    [left, right] where the left bit represent the next state, and right bit represent the current state

    we can do & 1 to extract right bit
    and do | 2 to set left bit ot 1, that means next state the cell will be live

    after the algorithm, we can simply shift the bit >> 1

    We can do a modular division by 2
     if the remainder is 0 -> the cell

     */

    public void gameOfLife(int[][] board) {
        int x = board.length;
        int y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int current = board[i][j];
                int liveNeighbors = check(board, i, j);

                if (current == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3)
                        board[i][j] |= 2;
                } else {
                    if (liveNeighbors == 3)
                        board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                board[i][j] >>= 1;

    }

    int check(int[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        int result = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (x + i < 0 || x + i >= row || y + j < 0 || y + j >= col)
                    continue;

                int num = board[x + i][y + j];
                if ((num & 1) == 1)
                    result++;
            }
        }
        return result;
    }
}
