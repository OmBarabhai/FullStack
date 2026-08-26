package DSA.B_LinkedList.Fundamentals.C_03_MyLinkedList_Design;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // TODO: Insertion
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void addAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid Position");
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
        Node prevNode = head;
        Node newNode = new Node(data);
        for (int i = 1; i <= position - 2; i++) {
            prevNode = prevNode.next;
        }
        Node currNext = prevNode.next;
        currNext.prev = newNode;
        newNode.next = currNext;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        size++;
    }

    // TODO: Traversal
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printListBack() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(" ⇄ " + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }

    // TODO: Access
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getHead() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public int getTail() {
        if (tail == null) {
            return -1;
        }
        return tail.data;
    }

    // TODO: Utility
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // TODO: Searching
    public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int searchPosition(int target) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == target) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    // TODO: Updating
    public void updatePosition(int position, int newData) {
        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            head.data = newData;
            return;
        }
        Node prev = head;
        for (int i = 1; i <= position - 2; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        curr.data = newData;
    }

    public void updateValue(int oldValue, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                return;
            }
            temp = temp.next;
        }
    }

    // TODO: Deletion
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0; //yaha mai mistake kiya
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteAtTail() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        Node currNode = tail.prev;
        Node prevNode = tail;
        currNode.next = null;
        prevNode.prev = null;
        tail = currNode;
        size--;
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            deleteAtHead();
            return;
        }
        if (position == size) {
            deleteAtTail();
            return;
        }
        Node prevNode = head;
        for (int i = 1; i <= position - 2; i++) {
            prevNode = prevNode.next;
        }
        Node currNode = prevNode.next;
        prevNode.next = currNode.next;
        currNode.next.prev = prevNode;

        currNode.next = null;
        currNode.prev = null;
        size--;
    }

    public void deleteValue(int value) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.data == value) {
            deleteAtHead();
            return;
        }
        Node currNode = head.next;

        while (currNode != null) {

            if (currNode.data == value) {
                Node prevNode = currNode.prev;
                Node nextNode = currNode.next;
                prevNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                } else {
                    tail = prevNode;
                }
                currNode.next = null;
                currNode.prev = null;
                size--;
                return;
            }
            currNode = currNode.next;
        }
    }

    public void printStructure() {

        if (head == null) {
            System.out.println("HEAD → null");
            System.out.println("TAIL → null");
            System.out.println("SIZE → 0");
            return;
        }

        System.out.println("        HEAD");
        System.out.println("         ↓");

        Node temp = head;

        while (temp != null) {

            String prev = temp.prev == null
                    ? "null"
                    : String.valueOf(temp.prev.data);

            String next = temp.next == null
                    ? "null"
                    : String.valueOf(temp.next.data);

            System.out.println("┌───────────────────┐");
            System.out.printf ("│ prev : %-10s │%n", prev);
            System.out.printf ("│ data : %-10d │%n", temp.data);
            System.out.printf ("│ next : %-10s │%n", next);
            System.out.println("└───────────────────┘");

            if (temp.next != null) {
                System.out.println("        ⇅");
            }

            temp = temp.next;
        }

        System.out.println("        ↑");
        System.out.println("       TAIL");

        System.out.println();
        System.out.println("SIZE → " + size);

        System.out.println();
        System.out.println("Forward:");
        printList();

        System.out.println("Backward:");
        printListBack();
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("==============================================");
        System.out.println("        DOUBLY LINKED LIST DEMO");
        System.out.println("==============================================");

        // --------------------------------------------------
        // 1. ADD AT HEAD
        // --------------------------------------------------

        System.out.println("\n1️⃣  ADD AT HEAD");
        System.out.println("----------------------------------------------");

        list.addAtHead(30);
        list.addAtHead(20);
        list.addAtHead(10);

        list.printStructure();


        // --------------------------------------------------
        // 2. ADD AT TAIL
        // --------------------------------------------------

        System.out.println("\n2️⃣  ADD AT TAIL");
        System.out.println("----------------------------------------------");

        list.addAtTail(40);
        list.addAtTail(50);

        list.printStructure();


        // --------------------------------------------------
        // 3. ADD AT POSITION
        // --------------------------------------------------

        System.out.println("\n3️⃣  ADD AT POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Adding 25 at position 3...");
        list.addAtPosition(3, 25);

        list.printStructure();


        // --------------------------------------------------
        // 4. FORWARD TRAVERSAL
        // --------------------------------------------------

        System.out.println("\n4️⃣  FORWARD TRAVERSAL");
        System.out.println("----------------------------------------------");

        list.printList();


        // --------------------------------------------------
        // 5. BACKWARD TRAVERSAL
        // --------------------------------------------------

        System.out.println("\n5️⃣  BACKWARD TRAVERSAL");
        System.out.println("----------------------------------------------");

        list.printListBack();


        // --------------------------------------------------
        // 6. ACCESS
        // --------------------------------------------------

        System.out.println("\n6️⃣  ACCESS");
        System.out.println("----------------------------------------------");

        System.out.println("Size  : " + list.getSize());
        System.out.println("Empty : " + list.isEmpty());
        System.out.println("Head  : " + list.getHead());
        System.out.println("Tail  : " + list.getTail());


        // --------------------------------------------------
        // 7. SEARCH
        // --------------------------------------------------

        System.out.println("\n7️⃣  SEARCH");
        System.out.println("----------------------------------------------");

        int target = 25;

        System.out.println("Search " + target + "       : " + list.search(target));
        System.out.println("Position of " + target + " : "
                + list.searchPosition(target));

        target = 100;

        System.out.println("Search " + target + "       : " + list.search(target));
        System.out.println("Position of " + target + " : "
                + list.searchPosition(target));


        // --------------------------------------------------
        // 8. UPDATE POSITION
        // --------------------------------------------------

        System.out.println("\n8️⃣  UPDATE POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Before update:");
        list.printStructure();

        System.out.println("\nUpdating position 3 → 35");
        list.updatePosition(3, 35);

        System.out.println("\nAfter update:");
        list.printStructure();


        // --------------------------------------------------
        // 9. UPDATE VALUE
        // --------------------------------------------------

        System.out.println("\n9️⃣  UPDATE VALUE");
        System.out.println("----------------------------------------------");

        System.out.println("Before update:");
        list.printStructure();

        System.out.println("\nUpdating value 40 → 45");
        list.updateValue(40, 45);

        System.out.println("\nAfter update:");
        list.printStructure();


        // --------------------------------------------------
        // 10. DELETE AT HEAD
        // --------------------------------------------------

        System.out.println("\n🔟  DELETE AT HEAD");
        System.out.println("----------------------------------------------");

        System.out.println("Before deletion:");
        list.printStructure();

        list.deleteAtHead();

        System.out.println("\nAfter deleting head:");
        list.printStructure();


        // --------------------------------------------------
        // 11. DELETE AT TAIL
        // --------------------------------------------------

        System.out.println("\n1️⃣1️⃣  DELETE AT TAIL");
        System.out.println("----------------------------------------------");

        System.out.println("Before deletion:");
        list.printStructure();

        list.deleteAtTail();

        System.out.println("\nAfter deleting tail:");
        list.printStructure();


        // --------------------------------------------------
        // 12. DELETE AT POSITION
        // --------------------------------------------------

        System.out.println("\n1️⃣2️⃣  DELETE AT POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Before deletion:");
        list.printStructure();

        System.out.println("\nDeleting position 2...");
        list.deleteAtPosition(2);

        System.out.println("\nAfter deletion:");
        list.printStructure();


        // --------------------------------------------------
        // 13. DELETE BY VALUE
        // --------------------------------------------------

        System.out.println("\n1️⃣3️⃣  DELETE BY VALUE");
        System.out.println("----------------------------------------------");

        System.out.println("Before deletion:");
        list.printStructure();

        System.out.println("\nDeleting value 35...");
        list.deleteValue(35);

        System.out.println("\nAfter deletion:");
        list.printStructure();


        // --------------------------------------------------
        // 14. FINAL STATE
        // --------------------------------------------------

        System.out.println("\n1️⃣4️⃣  FINAL STATE");
        System.out.println("----------------------------------------------");

        list.printStructure();


        // --------------------------------------------------
        // 15. CLEAR
        // --------------------------------------------------

        System.out.println("\n1️⃣5️⃣  CLEAR LIST");
        System.out.println("----------------------------------------------");

        list.clear();

        list.printStructure();

        System.out.println("\n==============================================");
        System.out.println("              DEMO COMPLETED");
        System.out.println("==============================================");
    }
}

