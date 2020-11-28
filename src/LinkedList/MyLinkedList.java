package LinkedList;

class MyLinkedList {

    static class Node {
        private int value;
        private Node nextNode;
        private Node prevNode;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
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
        Node head = startNode;
        if (index >= length || index < 0) return -1;
        for (int count = 0; count < index; count++) head = head.nextNode;
        return head.value;
    }

    public void addAtHead(int val) {
        Node add = new Node(val);
        add.nextNode = startNode;
        add.prevNode = null;
        startNode.prevNode = add;
        startNode = add;
        length++;
    }

    public void addAtTail(int val) {
        Node add = new Node(val);
        add.prevNode = endNode;
        add.nextNode = null;
        endNode.nextNode = add;
        endNode = add;
        length++;
    }

    public void addAtIndex(int index, int val) {
        Node add = new Node(val);
        Node head = startNode;

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

        add.nextNode = head.nextNode;
        add.prevNode = head;
        head.nextNode.nextNode.prevNode = add;
        head.nextNode = add;
        length++;
    }

    public void deleteAtIndex(int index) {
        Node head = startNode;
        if (index >= length || index < 0)
            return;

        for (int i = 0; i < index; i++) head = head.nextNode;

        length--;
    }
}
