package LinkedList;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this);
    }

    public class MyIterator<E> implements Iterator<E>{

        int index = 0;
        MyLinkedList<E> eMyLinkedList;

        public MyIterator(MyLinkedList<E> eMyLinkedList) {
            this.eMyLinkedList = eMyLinkedList;
        }

        @Override
        public boolean hasNext() {
            return eMyLinkedList.length >= index + 1;
        }

        @Override
        public E next() throws NoSuchElementException {
            return eMyLinkedList.get(index++);
        }

    }

    class Node {
        private final T value;
        private Node nextNode;
        private Node prevNode;

        public Node(T value) {
            this.value = value;
            nextNode = null;
            prevNode = null;
        }

    }

    int length;
    Node startNode;
    Node endNode;

    public MyLinkedList() {
        length = 0;
        startNode = null;
        endNode = null;
    }

    public T get(int index) {
        Node head = startNode;
        if (index >= length || index < 0) return null; //Здесь уже -1 не подходит, на что можно заменить?
        for (int i = 0; i < index; i++) head = head.nextNode;
        return head.value;
    }

    public void addAtHead(T val) {
        Node add = new Node(val);
        if (startNode == null) {
            startNode = add;
            endNode = add;
            length++;
            return;
        }
        add.nextNode = startNode;
        startNode.prevNode = add;
        startNode = add;
        length++;
    }

    public void addAtTail(T val) {
        Node add = new Node(val);
        if (startNode == null) {
            startNode = add;
            endNode = add;
            length++;
            return;
        }
        add.prevNode = endNode;
        endNode.nextNode = add;
        endNode = add;
        length++;
    }

    public void addAtIndex(int index, T val) {
        if (index > length || index < 0) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        Node add = new Node(val);

        Node head = startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;

        add.prevNode = head.prevNode;
        add.nextNode = head;
        head.prevNode.nextNode = add;
        head.prevNode = add;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) return;

        if (index == 0) {
            if (length == 1) {
                startNode = null;
                endNode = null;
            } else {
                startNode.nextNode.prevNode = null;
                startNode = startNode.nextNode;
            }
            length--;
            return;
        }

        if (index == length - 1) {
            endNode.prevNode.nextNode = null;
            endNode = endNode.prevNode;
            length--;
            return;
        }

        Node head = startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;
        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        length--;
    }
}
