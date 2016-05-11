package airbnb;

/**
 * Created by jun on 5/5/16.
 */
public class HilbertCurve {

    public static void main(String[] args) {
        HilbertCurve solution = new HilbertCurve();
        int res1 = solution.steps(1, 1, 2);
        int res2 = solution.steps(0, 1, 1);
        int res3 = solution.steps(2, 2, 2);
        int res4 = solution.steps(3, 5, 3);
        int res5 = solution.steps(5, 4, 3);
        int res6 = solution.steps(0, 4, 3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
    }

    /*
    quadrant naming convention
    2  |  1
    ------
    3  |  4
     */
    public int steps(int x, int y, int iteration) {
        if (iteration == 1) {
            if (x == 0 && y == 0)
                return 1;
            else if (x == 0 && y == 1)
                return 2;
            else if (x == 1 && y == 1)
                return 3;
            else
                return 4;
        }


        int width = (int) Math.pow(2, iteration);
        int half = width / 2;

        int quadrant;
        int step = 0;

        if (x < half && y < half) {
            quadrant = 3;
        } else if (x < half && y >= half) {
            quadrant = 2;
            step += half * half;
            y -= half;
        } else if (x >= half && y >= half) {
            quadrant = 1;
            step += 2 * (half * half);
            x -= half;
            y -= half;
        } else {
            quadrant = 4;
            step += 3 * (half * half);
            x -= half;
        }

        // shrink x, y to fix new width, done above;
        // map x, y to fix orientation

        int[] newXY = flip(x, y, quadrant, half);

        return step + steps(newXY[0], newXY[1], iteration - 1);
    }

    public int[] flip(int x, int y, int quadrant, int width) {
        if (quadrant == 1 || quadrant == 2)
            return new int[]{x, y};
        else if (quadrant == 3)
            return new int[]{y, x};
        else // quadrant == 4
            return new int[]{width - 1 - y, width - 1 - x};
    }

//    public int steps(int x, int y, int iteration) {
//        if (iteration == 1) {
//            if (x == 0 && y == 0)
//                return 1;
//            else if (x == 0 && y == 1)
//                return 2;
//            else if (x == 1 && y == 1)
//                return 3;
//            else
//                return 4;
//        }
//
//        int width = (int) Math.pow(2, iteration);
//        int half = width / 2;
//
//        int quadrant;
//        if (x < half && y < half)
//            quadrant = 3;
//        else if (x >= half && y >= half)
//            quadrant = 1;
//        else if (x < half && y >= half)
//            quadrant = 2;
//        else
//            quadrant = 4;
//
//        int result = 0;
//        if (quadrant == 1) {
//            result += (int) Math.pow(half, 2) * 2;
//            x -= half;
//            y -= half;
//        } else if (quadrant == 2) {
//            result += (int) Math.pow(half, 2);
//            y -= half;
//        } else if (quadrant == 3) {
//        } else {
//            result += (int) Math.pow(half, 2) * 3;
//            x -= half;
//        }
//
//        int[] newXY = mapCoordinate(x, y, half, quadrant);
//        return result+ steps(newXY[0], newXY[1], iteration - 1);
//    }
//
//
//    public int[] mapCoordinate(int x, int y, int width, int quadrant) {
//        if (quadrant <= 2)
//            return new int[]{x, y};
//        else if (quadrant == 3)
//            return new int[]{y, x};
//        else  //(quadrant==4)
//            return new int[]{width - 1 - y, width - 1 - x};
//    }
}
