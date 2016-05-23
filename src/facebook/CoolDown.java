package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun on 5/18/16.
 */
public class CoolDown {
    public static void main(String[] args) {
        CoolDown cd = new CoolDown();
        int res = cd.time("AABBACABAB", 3);
        System.out.println(res);
    }

    public int time(String tasks, int k) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length(); i++) {
            char ch = tasks.charAt(i);

            if (map.containsKey(ch) && result - map.get(ch) <= k)
                result = map.get(ch) + k + 1;
            else
                result++;


            map.put(ch, result);
        }

        return result;
    }
}
