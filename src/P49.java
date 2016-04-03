import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Arrays
import java.util.Collections;

/**
 * Created by jun on 4/3/16.
 * 49. Group Anagrams
 * <p>
 * Ha, this problem was mentioned by Gayle in her FB prep sessions, shout-out goes to Gayyyyyyle~
 */
public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sorted = sortString(str);
            map.putIfAbsent(sorted, new LinkedList<String>());
            map.get(sorted).add(str);
        }

        List<List<String>> result = new LinkedList<>();
        for (List<String> group : map.values()) {
            Collections.sort(group);
            result.add(group);
        }

        return result;
    }

    public String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
