package in.pervush.leetcode.problems;

import java.util.LinkedHashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(final int capacity) {
        this.cache = new LinkedHashMap<>(capacity + 1);
        this.capacity = capacity;
    }

    public int get(final int key) {
        final Integer removedValue = cache.remove(key);
        if (removedValue == null) {
            return -1;
        }
        cache.put(key, removedValue);
        return removedValue;
    }

    public void put(final int key, final int value) {
        cache.remove(key);
        cache.put(key, value);
        if (cache.size() > capacity) {
            final int firstKey = cache.keySet().stream().findFirst().get();
            cache.remove(firstKey);
        }
    }

    private static void test1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6);
        lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        lRUCache.get(1);
        lRUCache.get(2);
    }


    public static void main(String[] args) {
        test1();
    }
}
