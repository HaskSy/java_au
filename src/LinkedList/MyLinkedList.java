package LinkedList;

class MyLinkedList {

    static class Node {
        private final int value;
        private Node nextNode;
        private Node prevNode;

        public Node(int value) {
            this.value = value;
            nextNode = null;
            prevNode = null;
        }
    }

    int length;
    Node startNode;
    Node endNode;

    public MyLinkedList() {
        this.length = 0;
        this.endNode = null;
        this.startNode = null;
    }

    public int get(int index) {
        Node head = startNode.nextNode;
        if (index >= length || index < 0) return -1;
        for (int i = 0; i < index; i++) head = head.nextNode;
        return head.value;
    }

    public void addAtHead(int val) {
        Node add = new Node(val);
        add.nextNode = startNode;
        add.prevNode = null;
        startNode = add;
        length++;
    }

    public void addAtTail(int val) {
        Node add = new Node(val);
        add.prevNode = endNode;
        add.nextNode = null;
        endNode = add;
        length++;
    }

    public void addAtIndex(int index, int val) {
        Node add = new Node(val);
        Node head = startNode.nextNode;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == length - 1) {
            addAtTail(val);
            return;
        }

        if (index >= length || index < 0)
            return;

        for (int i = 0; i < index; i++) head = head.nextNode;

        Node tmp = head.nextNode;
        head.nextNode = add;
        head.nextNode.nextNode = tmp;
        length++;
    }

    public void deleteAtIndex(int index) {
        Node head = startNode.nextNode;

        if (index == 0) {
            // Добавить удаление самого элемента
            startNode = startNode.nextNode;
            startNode.prevNode = null;
        }

        if (index == length - 1) {
            // Добавить удаление самого элемента
            endNode = endNode.prevNode;
            endNode.nextNode = null;
        }
        if (index >= length || index < 0)
            return;

        for (int i = 0; i < index; i++) head = head.nextNode;

        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        head = null;
        length--;
    }
}
