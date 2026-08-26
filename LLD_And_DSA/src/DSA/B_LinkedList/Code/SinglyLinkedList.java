package DSA.B_LinkedList.Code;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            return;
        }
        if (position == 1) {
            addAtHead(data);
            return;
        }
        if (position == size + 1) {
            addAtTail(data);
            return;
        }
        Node newNode = new Node(data);
        Node prevNode = head;
        for (int i = 1; i < position; i++) {
            prevNode = prevNode.next;
        }
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        size++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(STR."\{temp.data} -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        } else {
            return tail.data;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean search(int tar) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == tar) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int searchPos(int tar) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == tar) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return pos;
    }

    public void updatePos(int pos, int newData) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid Position");
            return;
        }
        Node temp = head;
        for (int i = 1; i <= pos - 1; i++) {
            temp = temp.next;
        }
        temp.data = newData;
    }

    public void updateValue(int oldVal, int newVal) {
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            if (temp.data == oldVal) {
                temp.data = newVal;
                return;
            }
        }
    }

    public void deleteAtHead() {
        if (head == null) {
            System.out.println("LL is Empty! ");
            return;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public void deleteAtTail() {
        if (tail == null) {
            System.out.println("LL is Empty! ");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        Node temp = head;
        for (int i = 1; i <= size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid Case");
            return;
        }
        Node prev = head;
        for (int i =1;i<=pos-2;i++){
            prev = prev.next;
        }
        Node fwd = prev.next;
        prev.next = fwd.next;
        size--;
    }
    public void deleteValue(int val){
        int pos = 1;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            pos++;
            if(temp.data == val){
                break;
            }
        }
        size--;
    }
    public static void main(String[] args) {
        SinglyLinkedList mylist = new SinglyLinkedList();
        if (mylist.isEmpty()) {
            System.out.println("List IS Empty");
        }
        System.out.println(mylist.getSize());

        mylist.addAtHead(10);
        mylist.printList();

        mylist.addAtHead(20);
        mylist.printList();

        mylist.addAtHead(30);
        mylist.printList();

        mylist.addAtTail(100);
        mylist.printList();

        mylist.addAtTail(200);
        mylist.printList();

        mylist.addAtTail(300);
        mylist.printList();

        mylist.addAtTail(100);
        mylist.printList();

        mylist.addAtHead(30);
        mylist.printList();

        System.out.println(mylist.getHead());
        System.out.println(mylist.getTail());
        System.out.println(mylist.search(100));
        System.out.println(mylist.searchPos(100));
        mylist.updatePos(3, 90);
        mylist.updateValue(200, 199);
        mylist.deleteAtTail();
        mylist.deleteAtHead();
        mylist.printList();
    }
}

