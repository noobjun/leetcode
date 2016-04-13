import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by jun on 4/12/16.
 * 341. Flatten Nested List Iterator
 */
public class P341 {
    public class NestedIterator implements Iterator<Integer> {
        private Stack<ListIterator<NestedInteger>> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.listIterator());
        }

        public Integer next() {
            hasNext();
            return stack.peek().next().getInteger();
        }

        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger ni = stack.peek().next();
                    if (ni.isInteger()) {
                        stack.peek().previous();
                        return true;
                    } else {
                        stack.push(ni.getList().listIterator());
                    }
                }
            }
            return false;
        }
    }
}
