import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jun on 4/22/16.
 * 146. LRU Cache
 */
public class P146 {
    public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<Integer, Integer>() {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return map.size() > capacity;
                }
            };
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (map.containsKey(key))
                map.remove(key);

            map.put(key, value);
        }
    }
}
