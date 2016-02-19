import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jun on 2/19/16.
 * 244. Shortest Word Distance II
 */
public class P244 {

    public class WordDistance {

        private Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            this.map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!this.map.containsKey(word)) {
                    this.map.put(word, new LinkedList<>());
                }

                List<Integer> list = this.map.get(word);
                list.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int result = Integer.MAX_VALUE;
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);


            for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
                result = Math.min(Math.abs(l1.get(i) - l2.get(j)), result);
                if (l1.get(i) < l2.get(j))
                    i++;
                else
                    j++;
            }
            return result;
        }
    }
}
