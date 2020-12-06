package designpatterns.LRUCache;

import java.util.Iterator;
import java.util.Map;

public class IteratorLinkedHashMap<K, V> implements Iterator<Map.Entry<K, V>> {

    private final MyLinkedHashMap<K, V> map;
    private int index = 0;

    public IteratorLinkedHashMap(MyLinkedHashMap<K, V> map) {
        this.map = map;
    }

    @Override
    public boolean hasNext() {
        return this.map.size() >= this.index + 1;
    }

    @Override
    public Map.Entry<K, V> next() {
        return this.map.get(index++);
    }
}
