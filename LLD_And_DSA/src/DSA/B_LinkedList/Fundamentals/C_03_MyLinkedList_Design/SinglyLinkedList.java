package DSA.B_LinkedList.Fundamentals.C_03_MyLinkedList_Design;

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
        Node prev = head;
        Node newNode = new Node(data);
        for (int i = 1; i <= position - 2; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    // TODO: Traversal
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
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
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
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
        Node temp = head;
        for (int i = 1; i <= size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
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
        Node prev = head;
        for (int i = 1; i <= position - 2; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
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
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {

            if (prev.next.data == value) {
                Node fwd = prev.next;
                prev.next = fwd.next;
                curr.next = null;
                size--;
                if (curr == tail) {
                    tail = prev;
                }
                return;
            }
            prev = prev.next;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("==============================================");
        System.out.println("          SINGLY LINKED LIST DEMO");
        System.out.println("==============================================");


        // ==================================================
        // 1. ADD AT HEAD
        // ==================================================

        System.out.println("\n1️⃣  ADD AT HEAD");
        System.out.println("----------------------------------------------");

        list.addAtHead(30);
        list.addAtHead(20);
        list.addAtHead(10);

        printStructure(list);


        // ==================================================
        // 2. ADD AT TAIL
        // ==================================================

        System.out.println("\n2️⃣  ADD AT TAIL");
        System.out.println("----------------------------------------------");

        list.addAtTail(40);
        list.addAtTail(50);

        printStructure(list);


        // ==================================================
        // 3. ADD AT POSITION
        // ==================================================

        System.out.println("\n3️⃣  ADD AT POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Adding 25 at position 3...");

        list.addAtPosition(3, 25);

        printStructure(list);


        // ==================================================
        // 4. FORWARD TRAVERSAL
        // ==================================================

        System.out.println("\n4️⃣  FORWARD TRAVERSAL");
        System.out.println("----------------------------------------------");

        list.printList();


        // ==================================================
        // 5. ACCESS
        // ==================================================

        System.out.println("\n5️⃣  ACCESS");
        System.out.println("----------------------------------------------");

        System.out.println("Size  : " + list.getSize());
        System.out.println("Empty : " + list.isEmpty());
        System.out.println("Head  : " + list.getHead());
        System.out.println("Tail  : " + list.getTail());


        // ==================================================
        // 6. SEARCH
        // ==================================================

        System.out.println("\n6️⃣  SEARCH");
        System.out.println("----------------------------------------------");

        int target = 25;

        System.out.println("Search " + target + " : " + list.search(target));

        System.out.println("Position of " + target + " : " + list.searchPosition(target));

        target = 100;

        System.out.println("Search " + target + " : " + list.search(target));

        System.out.println("Position of " + target + " : " + list.searchPosition(target));


        // ==================================================
        // 7. UPDATE POSITION
        // ==================================================

        System.out.println("\n7️⃣  UPDATE POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        System.out.println("\nUpdating position 3 → 35");

        list.updatePosition(3, 35);

        System.out.println("\nAfter:");
        printStructure(list);


        // ==================================================
        // 8. UPDATE VALUE
        // ==================================================

        System.out.println("\n8️⃣  UPDATE VALUE");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        System.out.println("\nUpdating value 40 → 45");

        list.updateValue(40, 45);

        System.out.println("\nAfter:");
        printStructure(list);


        // ==================================================
        // 9. DELETE AT HEAD
        // ==================================================

        System.out.println("\n9️⃣  DELETE AT HEAD");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        list.deleteAtHead();

        System.out.println("\nAfter deleting head:");
        printStructure(list);


        // ==================================================
        // 10. DELETE AT TAIL
        // ==================================================

        System.out.println("\n🔟  DELETE AT TAIL");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        list.deleteAtTail();

        System.out.println("\nAfter deleting tail:");
        printStructure(list);


        // ==================================================
        // 11. DELETE AT POSITION
        // ==================================================

        System.out.println("\n1️⃣1️⃣  DELETE AT POSITION");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        System.out.println("\nDeleting position 2...");

        list.deleteAtPosition(2);

        System.out.println("\nAfter:");
        printStructure(list);


        // ==================================================
        // 12. DELETE BY VALUE
        // ==================================================

        System.out.println("\n1️⃣2️⃣  DELETE BY VALUE");
        System.out.println("----------------------------------------------");

        System.out.println("Before:");
        printStructure(list);

        System.out.println("\nDeleting value 35...");

        list.deleteValue(35);

        System.out.println("\nAfter:");
        printStructure(list);


        // ==================================================
        // 13. EMPTY LIST TEST
        // ==================================================

        System.out.println("\n1️⃣3️⃣  EMPTY LIST TEST");
        System.out.println("----------------------------------------------");

        list.clear();

        System.out.println("After clear:");

        printStructure(list);

        System.out.println("Size  : " + list.getSize());
        System.out.println("Empty : " + list.isEmpty());
        System.out.println("Head  : " + list.getHead());
        System.out.println("Tail  : " + list.getTail());


        // ==================================================
        // 14. REBUILD LIST
        // ==================================================

        System.out.println("\n1️⃣4️⃣  REBUILD AFTER CLEAR");
        System.out.println("----------------------------------------------");

        list.addAtHead(100);
        list.addAtTail(200);
        list.addAtTail(300);

        printStructure(list);


        // ==================================================
        // 15. FINAL STATE
        // ==================================================

        System.out.println("\n1️⃣5️⃣  FINAL STATE");
        System.out.println("----------------------------------------------");

        printStructure(list);

        System.out.println("\n==============================================");
        System.out.println("             DEMO COMPLETED");
        System.out.println("==============================================");
    }

    public static void printStructure(SinglyLinkedList list) {

        if (list.head == null) {
            System.out.println("HEAD → null");
            System.out.println("TAIL → null");
            System.out.println("SIZE → 0");
            return;
        }

        System.out.println("HEAD");
        System.out.println(" ↓");

        Node temp = list.head;

        while (temp != null) {

            String next = temp.next == null ? "null" : String.valueOf(temp.next.data);

            System.out.println("┌───────────────────┐");
            System.out.printf("│ data : %-10d │%n", temp.data);
            System.out.printf("│ next → %-8s   │%n", next);
            System.out.println("└───────────────────┘");

            if (temp.next != null) {
                System.out.println("        ↓");
            }

            temp = temp.next;
        }

        System.out.println("        ↓");
        System.out.println("      null");

        System.out.println();
        System.out.println("TAIL → " + list.tail.data);
        System.out.println("SIZE → " + list.size);

        System.out.println();
        System.out.println("Simple View:");
        System.out.print("HEAD → ");

        temp = list.head;

        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

