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
        length = 0;
        startNode = null;
        endNode = null;
    }

    public int get(int index) {
        Node head = startNode;
        if (index >= length || index < 0) return -1;
        for (int i = 0; i < index; i++) head = head.nextNode;
        return head.value;
    }

    public void addAtHead(int val) {
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

    public void addAtTail(int val) {
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

    public void addAtIndex(int index, int val) {
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
                Node del = startNode;
                startNode.nextNode.prevNode = null;
                startNode = startNode.nextNode;
                del = null;
            }
            length--;
            return;
        }

        if (index == length - 1) {
            Node del = endNode;
            endNode.prevNode.nextNode = null;
            endNode = endNode.prevNode;
            del = null;
            length--;
            return;
        }

        Node head = startNode;
        for (int i = 0; i < index; i++) head = head.nextNode;
        head.prevNode.nextNode = head.nextNode;
        head.nextNode.prevNode = head.prevNode;
        head = null;
        length--;
    }
}
