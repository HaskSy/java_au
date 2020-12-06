package designpatterns.LRUCache;

import java.util.Map;

public class LRUCache<K, V> {
    public final MyLinkedHashMap<K, V> cache = new MyLinkedHashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Map.Entry<K, V> entry = cache.getByKey(key);
        cache.delete(key);
        cache.addAtTail(entry);
        return entry.getValue();
    }

    public V put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.delete(key);
            cache.put(key, value);
            return null;
        }
        if (cache.size() >= this.capacity) {
            cache.deleteAtIndex(0);
        }
        cache.put(key, value);
        return null;
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache +
                ", capacity=" + capacity +
                '}';
    }
}

