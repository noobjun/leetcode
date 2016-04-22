package airbnb;

import java.util.*;
import java.util.Iterator;

/**
 * Created by jun on 4/19/16.
 */
public class FlattenIterator implements Iterator<Integer> {
    Iterator<List<Integer>> rowIterator;
    Iterator<Integer> colIterator;

    public FlattenIterator(List<List<Integer>> integers2d) {
        rowIterator = integers2d.iterator();
    }

    @Override
    public boolean hasNext() {
        while ((colIterator== null || !colIterator.hasNext()) && rowIterator.hasNext()){
            colIterator=rowIterator.next().iterator();
        }

        return colIterator!=null && colIterator.hasNext();
    }

    @Override
    public Integer next() {
        hasNext();
        return colIterator.next();
    }

    @Override
    public void remove() {
        colIterator.remove();
    }
}
