package airbnb;

/**
 * Created by jun on 4/13/16.
 * Interview Questions
 Given a set of numbers in an array which represent number of consecutive days of AirBnB reservation requested, as a host, pick the sequence which maximizes the number of days of occupancy, at the same time, leaving atleast 1 day gap in between bookings for cleaning. Problem reduces to finding max-sum of non-consecutive array elements.

 // [5, 1, 1, 5] => 10
 The above array would represent an example booking period as follows -
 // Dec 1 - 5
 // Dec 5 - 6
 // Dec 6 - 7
 // Dec 7 - 12

 The answer would be to pick dec 1-5 (5 days) and then pick dec 7-12 for a total of 10 days of occupancy, at the same time, leaving atleast 1 day gap for cleaning between reservations.

 Similarly,
 // [3, 6, 4] => 7
 // [4, 10, 3, 1, 5] => 15
 */
public class MaxOccupancy {

    // what if this problem can contain negative numbers?
    public static void main(String[] args) {
        System.out.printf("%s %s", "hi", "there");
        System.out.println("ho");
    }
}
