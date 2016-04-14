import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jun on 4/13/16.
 * 251. Flatten 2D Vector
 * <p>
 * We can try to do it with index as well.
 */
public class P251 {

    public static class Vector2D implements Iterator<Integer> {
        private LinkedList<ListIterator<Integer>> iterators;

        public Vector2D(List<List<Integer>> vec2d) {
            iterators = new LinkedList<>();
            for (List<Integer> list : vec2d) {
                iterators.add(list.listIterator());
            }
        }

        @Override
        public Integer next() {
            hasNext();
            return iterators.getFirst().next();
        }

        @Override
        public boolean hasNext() {
            while (!iterators.isEmpty()) {
                if (!iterators.getFirst().hasNext())
                    iterators.removeFirst();
                else
                    return true;
            }
            return false;
        }

        @Override
        public void remove() {
            iterators.getFirst().remove();
        }
    }

}
