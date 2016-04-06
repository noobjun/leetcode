import java.util.Arrays;

/**
 * Created by jun on 4/6/16.
 * 274. H-Index
 */
public class P274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int j = 1;
        for (int i = citations.length - 1; i >= 0 && citations[i] >= j; i--, j++) ;
        return j - 1;
    }
}
