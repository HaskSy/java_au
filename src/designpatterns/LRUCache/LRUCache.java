package designpatterns.LRUCache;

public class LRUCache<K, V> {
    private final MyLinkedHashMap<K, V> cache = new MyLinkedHashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
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
