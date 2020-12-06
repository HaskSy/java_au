package designpatterns.LRUCache;

import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

class LRUCacheLinkedHashMap<K, V> {
    private final LinkedHashMap<K, V> cache = new LinkedHashMap<>();
    private final int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        update(key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            update(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            K del = cache.keySet().iterator().next();
            cache.remove(del);
        }
        cache.put(key, value);
    }
    public void update(K key) {
        V val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}