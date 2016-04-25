import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun on 4/25/16.
 * 57. Insert Interval
 */
public class P57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int index = 0;

        for (Interval oldInterval : intervals) {
            if (oldInterval.end < newInterval.start) {
                result.add(oldInterval);
                index++;
            } else if (oldInterval.start > newInterval.end) {
                result.add(oldInterval);
            } else {
                newInterval.start = Math.min(oldInterval.start, newInterval.start);
                newInterval.end = Math.max(oldInterval.end, newInterval.end);
            }
        }
        result.add(index, newInterval);
        return result;
    }
}
