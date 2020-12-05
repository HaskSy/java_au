package LRUCache;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyLinkedHashMap<K, V> extends HashMap<K, V> implements Iterable<Map.Entry<K, V>>{

    @NotNull
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new IteratorLinkedHashMap<>(this);
    }

    class Node {
        private final Entry<K, V> entry;
        private Node nextNode;
        private Node prevNode;

        public Node(Entry<K, V> entry) {
            this.entry = entry;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    private Node startNode;
    private Node endNode;

    public Entry<K, V> get(int index) {
        Node head = this.startNode;
        if (index >= this.size() || index < 0) return null;
        for (int i = 0; i < index; i++) head = head.nextNode;
        return head.entry;
    }


    public V addAtHead(Entry<K, V> entry) {
        Node add = new Node(entry);
        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            super.put(entry.getKey(), entry.getValue());
            return entry.getValue();
        }
        add.nextNode = this.startNode;
        this.startNode.prevNode = add;
        this.startNode = add;
        super.put(entry.getKey(), entry.getValue());
        return entry.getValue();
    }

    public V addAtHead(K key, V value) {
        return addAtHead(new SimpleEntry<>(key ,value));
    }

    public V addAtTail(Entry<K, V> entry) {
        Node add = new Node(entry);
        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            super.put(entry.getKey(), entry.getValue());
            return entry.getValue();
        }
        add.prevNode = this.endNode;
        this.endNode.nextNode = add;
        this.endNode = add;
        super.put(entry.getKey(), entry.getValue());
        return entry.getValue();
    }

    public V addAtTail(K key, V value) {
        return addAtTail(new SimpleEntry<>(key, value));
    }

    public V addAtIndex(int index, Entry<K, V> entry) {
        if (index > this.size() || index < 0) return null;

        if (index == 0) {
            return addAtHead(entry);
        }

        if (index == this.size()) {
            return addAtTail(entry);
        }

        Node add = new Node(entry);

        Node head = this.startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;

        add.prevNode = head.prevNode;
        add.nextNode = head;
        head.prevNode.nextNode = add;
        head.prevNode = add;
        super.put(entry.getKey(), entry.getValue());
        return entry.getValue();
    }

    public void addAtIndex(int index, K key, V value) {
        addAtIndex(index, new SimpleEntry<>(key, value));
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size() || index < 0) return;

        if (index == 0) {
            if (this.size() == 1) {
                super.clear();
                this.startNode = null;
                this.endNode = null;
            } else {
                super.remove(this.startNode.entry.getKey());
                this.startNode = this.startNode.nextNode;
                this.startNode.prevNode.nextNode = null;
                this.startNode.prevNode = null;
            }
            return;
        }

        if (index == this.size() - 1) {
            super.remove(this.endNode.entry.getKey());
            this.endNode = this.endNode.prevNode;
            this.endNode.nextNode.prevNode = null;
            this.endNode.nextNode = null;
            return;
        }

        Node head = this.startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;
        super.remove(head.entry.getKey());
        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        head.nextNode = null;
        head.prevNode = null;
    }

    @Override
    public V put(K key, V value) {
        return addAtTail(key, value);
    }


}
