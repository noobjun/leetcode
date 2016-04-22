package airbnb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jun on 4/17/16.
 * given
 * [
 * [[1, 3], [6, 7]],
 * [[2, 4]],
 * [[2, 3], [9, 12]].
 * ]
 * return
 * [[4, 6], [7, 9]]
 */
public class MeetingRoom {
    public static void main(String[] args) {
        List<List<Interval>> intervals = new LinkedList<>();
        intervals.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        intervals.add(Arrays.asList(new Interval(2, 4)));
        intervals.add(Arrays.asList(new Interval(2, 3), new Interval(9, 12)));

        MeetingRoom mr = new MeetingRoom();
        List<Interval> free = mr.free(intervals);
        for (Interval interval : free)
            System.out.printf("[%d %d], ", interval.start, interval.end);
    }

    List<Interval> free(List<List<Interval>> intervals) {
        List<Interval> result = new LinkedList<>();

        ArrayList<Interval> list = new ArrayList<>();
        for (List<Interval> l : intervals)
            list.addAll(l);

        if (list.isEmpty())
            return result;

        list.sort((a, b) -> new Integer(a.start).compareTo(b.start));
        ArrayList<Interval> merged = new ArrayList<>();

        Interval prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if (curr.start <= prev.end) {
                prev = new Interval(prev.start, curr.end);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }

        merged.add(prev);

        for (int i = 1; i < merged.size(); i++) {
            result.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }

        return result;
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
