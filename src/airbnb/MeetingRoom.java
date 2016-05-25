package airbnb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> free(List<List<Interval>> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        for (List<Interval> l : intervals)
            list.addAll(l);

        list.sort((a, b) -> {
            if (a.start == b.start)
                return Integer.compare(a.end, b.end);
            else
                return Integer.compare(a.start, b.start);
        });

        ArrayList<Interval> merged = new ArrayList<>();
        Interval prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if (curr.start > prev.end) {
                merged.add(prev);
                prev = curr;
            } else {
                prev = new Interval(prev.start, curr.end);
            }
        }
        merged.add(prev);

        List<Interval> result = new LinkedList<>();
        for (int i = 0; i < merged.size() - 1; i++) {
            result.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
        }

        return result;
    }


//
//    public List<Interval> free(List<List<Interval>> intervals) {
//        ArrayList<Interval> list = new ArrayList<>();
//        for (List<Interval> l : intervals)
//            list.addAll(l);
//
//        List<Interval> result = new LinkedList<>();
//        if (list.size() == 0)
//            return result;
//
//        Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));
//        ArrayList<Interval> merged = new ArrayList<>();
//        Interval prev = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            Interval current = list.get(i);
//            if (prev.end >= current.start) {
//                prev = new Interval(prev.start, Math.max(prev.end, current.end)); // don't forget the max() call
//            } else {
//                merged.add(prev);
//                prev = current;
//            }
//        }
//
//        merged.add(prev);
//
//        for (int i = 0; i < merged.size() - 1; i++) {
//            result.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
//        }
//
//        return result;
//    }
//
//    public static class Interval {
//        int start;
//        int end;
//
//        public Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }
}
