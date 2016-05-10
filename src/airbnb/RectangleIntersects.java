package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jun on 4/13/16.
 * You have a plain with lots of rectangles on it, find out maximum number of rectangles intersect at any point.
 */
public class RectangleIntersects {
    public static void main(String[] args) {
        RectangleIntersects intersects = new RectangleIntersects();
        List<int[][]> list = new ArrayList<>();
        list.add(new int[][]{{1, 1}, {2, 0}});
        list.add(new int[][]{{3, 1}, {4, 0}});
        list.add(new int[][]{{0, 2}, {5, 0}});
        int res = intersects.intersect(list);
        System.out.println(res);
    }

    public int intersect(List<int[][]> rectangles) {
        // the rectangles are represented by topLeft point and bottom bottomRight point
        // i.e. {1,3}, {4,1} actually represents {1,3}, {4,3}, {1,1}, {4,1}

        List<Event> horizontal = new ArrayList<>();
        for (int[][] r : rectangles) {
            horizontal.add(new Event(r[0][0], r));
            horizontal.add(new Event(r[1][0], r));
        }

        horizontal.sort((a, b) -> {
            if (a.value == b.value) {
                if (a.isLeft)
                    return -1;
                else
                    return 1;
            } else {
                return a.value - b.value;
            }
        });

        Set<Event> vertical = new TreeSet<>((a, b) -> {
            if (a.value == b.value) {
                if (Arrays.deepEquals(a.rectangle, b.rectangle))
                    return 0;
                else if (a.isTop)
                    return -1;
                else
                    return 1;
            } else {
                return b.value - a.value;
            }
        });


        int result = 0;
        for (Event e : horizontal) {
            if (e.isLeft) {
                Event a = new Event(e.rectangle[0][1], e.rectangle);
                Event b = new Event(e.rectangle[1][1], e.rectangle);
                vertical.add(a);
                vertical.add(b);
            } else {
                Event a = new Event(e.rectangle[0][1], e.rectangle);
                Event b = new Event(e.rectangle[1][1], e.rectangle);
                System.out.println(b.hashCode());
                System.out.println(vertical.remove(a));
                System.out.println(vertical.remove(b));
            }

            int count = 0;
            for (Event ee : vertical) {
                if (ee.isTop)
                    count++;
                else
                    count--;

                result = Math.max(result, count);
            }
        }


        return result;
    }

    public static class Event {
        boolean isLeft;
        boolean isTop;
        int value;
        int[][] rectangle;

        public Event(int value, int[][] rectangle) {
            this.value = value;
            this.rectangle = rectangle;
            this.isLeft = value == rectangle[0][0];
            this.isTop = value == rectangle[0][1];
        }

    }


}
