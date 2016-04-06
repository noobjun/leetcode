/**
 * Created by jun on 4/6/16.
 * 275. H-Index II
 */
public class P275 {
    public int hIndex(int[] citations) {
        int len = citations.length;

        int lo = 0;
        int hi = len-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (len - mid < citations[mid])
                hi = mid - 1;
            else if (len - mid > citations[mid])
                lo = mid + 1;
            else
                return len - mid;
        }

        return len - lo;
    }
}
