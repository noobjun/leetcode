package airbnb;

/**
 * Created by jun on 4/17/16.
 * Given an array of strings where "L" indicates land and "W" indicates water, and a coordinate marking a starting point in the middle of the ocean
 * The Challenge:
 * Find and mark the ocean in the map by changing appropriate W's to O's. An ocean coordinate is defined to be any coordinate directly adjacent to any other ocean coordinate.
 * Input:
 * LLLLLLLLLLLLLLLLLLLL
 * LLLLLLLLLLLLLLWLLLLL
 * LLWWLLLLLLLLLLLLLLLL
 * LLWWLLLLLLLLLLLLLLLL
 * LLLLLLLLLLLLLLLLLLLL
 * LLLLLLLWWLLLLLLLLLLL
 * LLLLLLLLWWLLLLLLLLLL
 * LLLLLLLLLWWWLLLLLLLL
 * LLLLLLLLLLWWWWWWLLLL
 * LLLLLLLLLLWWWWWWLLLL
 * LLLLLLLLLLWWWWWWLLLL
 * LLLLWWLLLLWWWWWWLLLL
 * LLLLWWWLLLWWWWWWWWWW
 * LLLLLWWWWWWWWWWWLLLL
 * LLLLLLLLLLLLLLWWWWLL
 * LLLLLLLLLLLLLLWLLLLL
 * LLLLWLLLLLLLLLLLLWLL
 * LLLLLLLLLLLLLLLLLLWL
 * Ocean Coordinate:
 * row = 10
 * col = 12
 * Expected Output:
 * LLLLLLLLLLLLLLLLLLLL
 * LLLLLLLLLLLLLLWLLLLL
 * LLWWLLLLLLLLLLLLLLLL
 * LLWWLLLLLLLLLLLLLLLL
 * LLLLLLLLLLLLLLLLLLLL
 * LLLLLLLOOLLLLLLLLLLL
 * LLLLLLLLOOLLLLLLLLLL
 * LLLLLLLLLOOOLLLLLLLL
 * LLLLLLLLLLOOOOOOLLLL
 * LLLLLLLLLLOOOOOOLLLL
 * LLLLLLLLLLOOOOOOLLLL
 * LLLLOOLLLLOOOOOOLLLL
 * LLLLOOOLLLOOOOOOOOOO
 * LLLLLOOOOOOOOOOOLLLL
 * LLLLLLLLLLLLLLOOOOLL
 * LLLLLLLLLLLLLLOLLLLL
 * LLLLWLLLLLLLLLLLLWLL
 * LLLLLLLLLLLLLLLLLLWL
 * <p>
 * Given: An array of strings where L indicates land and W indicates water,
 * and a coordinate marking a starting point in the middle of the ocean.
 * <p>
 * Challenge: Find and mark the ocean in the map by changing appropriate Ws to Os.
 * An ocean coordinate is defined to be the initial coordinate if a W, and
 * any coordinate directly adjacent to any other ocean coordinate.
 * <p>
 * void findOcean(String[] map, int row, int column);
 * <p>
 * String[] map = new String[]{
 * "WWWLLLW",
 * "WWLLLWW",
 * "WLLLLWW"
 * };
 * printMap(map);
 * <p>
 * STDOUT:
 * WWWLLLW
 * WWLLLWW
 * WLLLLWW
 * <p>
 * findOcean(map, 0, 1);
 * <p>
 * printMap(map);
 * <p>
 * STDOUT:
 * OOOLLLW
 * OOLLLWW
 * OLLLLWW
 */
public class MarkOcean {
    public static void main(String[] args) {
        String[] map = new String[]{
                "WWWLLLW",
                "WWLLLWW",
                "WLLLLWW"};

        MarkOcean solution = new MarkOcean();
        solution.printMap(map);
        solution.findOcean(map, 0, 1);
        solution.printMap(map);
    }

    public void printMap(String[] map) {
        System.out.println();
        for (String s : map)
            System.out.println(s);
    }

    void findOcean(String[] map, int row, int column) {
        int r = map.length;
        int c = map[0].length();

        char[][] matrix = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = map[i].charAt(j);
            }
        }

        dfs(matrix, row, column);

        for (int i =0; i<r; i++){
            map[i] = String.valueOf(matrix[i]);
        }
    }

    public void dfs(char[][] matrix, int x, int y) {
        if (matrix[x][y] != 'W')
            return;

        matrix[x][y] = 'O';

        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (x + i >= 0 && x + i < r && y + j >= 0 && y + j < c)
                    dfs(matrix, x + i, y + j);
            }
        }
    }


}
