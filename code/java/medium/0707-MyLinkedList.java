class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp == null ? -1 : temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */