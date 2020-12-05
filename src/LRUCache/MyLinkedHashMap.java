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
        if (index >= this.size() || index < 0) return null; //Здесь уже -1 не подходит, на что можно заменить?
        for (int i = 0; i < index; i++) head = head.nextNode;
        return head.entry;
    }

    public void addAtHead(Entry<K, V> val) {
        Node add = new Node(val);
        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            this.put(val.getKey(), val.getValue());
            return;
        }
        add.nextNode = this.startNode;
        this.startNode.prevNode = add;
        this.startNode = add;
        this.put(val.getKey(), val.getValue());
    }

    public void addAtHead(K k, V v) {
        addAtHead(new SimpleEntry<>(k ,v));
    }

    public void addAtTail(Entry<K, V> val) {
        Node add = new Node(val);
        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            this.put(val.getKey(), val.getValue());
            return;
        }
        add.prevNode = this.endNode;
        this.endNode.nextNode = add;
        this.endNode = add;
        this.put(val.getKey(), val.getValue());
    }

    public void addAtTail(K k, V v) {
        addAtTail(new SimpleEntry<>(k ,v));
    }

    public void addAtIndex(int index, Entry<K, V> val) {
        if (index > this.size() || index < 0) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == this.size()) {
            addAtTail(val);
            return;
        }

        Node add = new Node(val);

        Node head = this.startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;

        add.prevNode = head.prevNode;
        add.nextNode = head;
        head.prevNode.nextNode = add;
        head.prevNode = add;
        this.put(val.getKey(), val.getValue());
    }

    public void addAtIndex(int index, K k, V v) {
        addAtIndex(index, new SimpleEntry<>(k, v));
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size() || index < 0) return;

        if (index == 0) {
            if (this.size() == 1) {
                this.clear();
                this.startNode = null;
                this.endNode = null;
            } else {
                this.remove(this.startNode.entry.getKey());
                this.startNode = this.startNode.nextNode;
                this.startNode.prevNode.nextNode = null;
                this.startNode.prevNode = null;
            }
            return;
        }

        if (index == this.size() - 1) {
            this.remove(this.endNode.entry.getKey());
            this.endNode = this.endNode.prevNode;
            this.endNode.nextNode.prevNode = null;
            this.endNode.nextNode = null;
            return;
        }

        Node head = this.startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;
        this.remove(head.entry.getKey());
        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        head.nextNode = null;
        head.prevNode = null;
    }
}
