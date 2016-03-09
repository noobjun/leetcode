import java.util.*;

/**
 * Created by jun on 3/8/16.
 * 281. Zigzag Iterator
 * <p>
 * Just store iterators of the list, it's very simple! Also because it's circular access, it's convenient to store the row index so we can do mod division.
 */
public class P281 {
    public static class ZigzagIterator {
        private int k;
        private int row;
        List<Iterator<Integer>> li;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            k = 2;
            row = 0;
            li = new ArrayList<>();
            li.add(v1.iterator());
            li.add(v2.iterator());
        }

        public int next() {
            int result = li.get(row).next();
            row = (row + 1) % k;
            return result;
        }

        public boolean hasNext() {
            for (int i = 0; i < k; i++) {
                if (li.get(row).hasNext())
                    return true;
                row = (row + 1) % k;
            }
            return false;
        }
    }
}
