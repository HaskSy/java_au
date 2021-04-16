# Design

+ [LRU Cache](#lru-cache)

## LRU Cache
https://leetcode.com/problems/lru-cache/
```java
class LRUCache {
    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        update(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            update(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            int del = cache.keySet().iterator().next();
            cache.remove(del);
        }
        cache.put(key, value);
    }
    public void update(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

```