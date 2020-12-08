package designpatterns.LRUCache;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyLinkedHashMap<K, V> extends HashMap<K, V> implements Iterable<Map.Entry<K, V>> {

    @NotNull
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new IteratorLinkedHashMap<>(this);
    }

    public MyLinkedHashMap() {
        this.startNode = null;
        this.endNode = null;
    }

    public class Node {
        private final Entry<K, V> entry;
        private Node nextNode;
        private Node prevNode;

        public Node(Entry<K, V> entry) {
            this.entry = entry;
            this.nextNode = null;
            this.prevNode = null;
        }

        @Override
        public String toString() {
            if (this.nextNode == null && this.prevNode == null) {
                return String.format("Node: prevNode= %s , entry= %s , nextNode= %s }",
                        null, entry, null);
            }
            if (this.prevNode == null) {
                return String.format("Node: prevNode= %s , entry= %s , nextNode= %s }",
                        null, entry, nextNode.entry);
            }
            if (this.nextNode == null) {
                return String.format("Node: prevNode= %s , entry= %s , nextNode= %s }",
                        prevNode.entry, entry, null);
            }
            return String.format("Node: prevNode= %s , entry= %s , nextNode= %s }",
                    prevNode.entry, entry, nextNode.entry);
        }
    }

    private Node startNode;
    private Node endNode;

    public Entry<K ,V> get(int index) {
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
        return addAtHead(new SimpleEntry<>(key, value));
    }

    public V addAtTail(Entry<K, V> entry) {
        Node add = new Node(entry);
        if (this.startNode == null) {
            this.startNode = add;
            this.endNode = add;
            super.put(entry.getKey(), entry.getValue());
            return entry.getValue();
        }
        if (this.containsKey(entry.getKey())) {
            this.replace(entry.getKey(), entry.getValue());
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

    public V addAtIndex(int index, K key, V value) {
        return addAtIndex(index, new SimpleEntry<>(key, value));
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

    private int findIndexByKey(K key) {
        Node iter = startNode;
        int index = 0;
        while (iter != null) {
            if (iter.entry != null && iter.entry.getKey().equals(key)) {
                return index;
            } else {
                iter = iter.nextNode;
                index++;
            }
        }
        return -1;
    }

    @Override
    public V put(K key, V value) {
        return addAtTail(key, value);
    }

    public Entry<K, V> getByKey(K key) {
        if (this.containsKey(key)) {
            return get(findIndexByKey(key));
        }
        else System.out.println("This key is not in Map");
        return null;
    }

    public void delete(K key) {
        if (this.containsKey(key)) {
            deleteAtIndex(findIndexByKey(key));
        }
        else System.out.println("This key is not in Map");
    }
}
