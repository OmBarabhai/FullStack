package DSA.B_LinkedList.A_NodeReferencesTraversal;

import DSA.B_LinkedList.Fundamentals.C_03_MyLinkedList_Design.SinglyLinkedList;

public class A_Pattern {

    public static SinglyLinkedList buildFromArray(int[] arr) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i <= arr.length - 1; i++) {
            list.addAtTail(arr[i]);
        }
        return list;
    }

    public static SinglyLinkedList.Node convert(int[] arr) {
        SinglyLinkedList.Node head = null;
        SinglyLinkedList.Node tail = null;
        for (int i : arr) {
            SinglyLinkedList.Node newNode = new SinglyLinkedList.Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static SinglyLinkedList.Node convertRec(int[] arr, int idx) {
        if (idx == arr.length) {
            return null;
        }
        SinglyLinkedList.Node newNode = new SinglyLinkedList.Node(arr[idx]);
        newNode.next = convertRec(arr, idx + 1);
        return newNode;
    }

    public static void traverse(SinglyLinkedList.Node list) {
        SinglyLinkedList.Node temp = list;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static int count(SinglyLinkedList.Node list) {
        SinglyLinkedList.Node temp = list;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int countRec(SinglyLinkedList.Node list) {
        if (list == null) {
            return 0;
        }
        int count = 1;
        return count + countRec(list.next);
    }

    public static int findMaxRec(SinglyLinkedList.Node list) {
        if (list == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(list.data, findMaxRec(list.next));
    }

    public static int findMax(SinglyLinkedList.Node list) {
        SinglyLinkedList.Node temp = list;
        int max = Integer.MIN_VALUE;
        while (temp != null) {
            max = Math.max(max, temp.data);
            temp = temp.next;
        }
        return max;
    }

    public static int findMinRec(SinglyLinkedList.Node list) {
        if (list == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(list.data, findMinRec(list.next));
    }

    public static int findMin(SinglyLinkedList.Node list) {
        SinglyLinkedList.Node temp = list;
        int min = Integer.MAX_VALUE;
        while (temp != null) {
            min = Math.min(min, temp.data);
            temp = temp.next;
        }
        return min;
    }

    public static boolean searchRec(SinglyLinkedList.Node head, int tar) {
        SinglyLinkedList.Node temp = head;
        if (temp == null) {
            return false;
        }
        if (temp.data == tar) {
            return true;
        }
        return searchRec(temp.next, tar);
    }

    public static boolean search(SinglyLinkedList.Node head, int tar) {
        SinglyLinkedList.Node temp = head;
        while (temp != null) {
            if (temp.data == tar) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node prevNode = null;
        SinglyLinkedList.Node currNode = head;

        while (currNode != null) {
            SinglyLinkedList.Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    public static SinglyLinkedList.Node reverseRec(SinglyLinkedList.Node curr, SinglyLinkedList.Node prev) {
        if (curr == null || curr.next == null) {
            return prev;
        }

        SinglyLinkedList.Node nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        return reverseRec(curr, prev);
    }

    public static void revPrint(SinglyLinkedList.Node head) {
        if (head == null) {
            return;
        }
        revPrint(head.next);
        System.out.println(head.data);
    }

    public static void traverseCircular(SinglyLinkedList.Node head) {
        if (head == null) {
            return;
        }
        SinglyLinkedList.Node temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != head);
    }

    public static int CountOccurrences(SinglyLinkedList.Node head, int tar) {
        if (head == null) {
            return 0;
        }
        SinglyLinkedList.Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == tar) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public static int CountOccurrencesRec(SinglyLinkedList.Node head, int tar) {
        if (head == null) {
            return 0;
        }
        if (head.data == tar) {
            return 1 + CountOccurrencesRec(head.next, tar);
        }
        return CountOccurrencesRec(head.next, tar);
    }
    public static SinglyLinkedList.Node remove(SinglyLinkedList.Node head, int tar) {
        if (head == null) {
            return null;
        }
        SinglyLinkedList.Node curr = head;
        SinglyLinkedList.Node prev = null;

        while (curr != null){
            SinglyLinkedList.Node currNext = curr.next;
            if(curr.data == tar){
                if(prev == null){
                    head = currNext;
                }else {
                    prev.next = currNext;

                }
            }else {
                prev = curr;
            }
            curr = currNext;


        }
        return head;
    }
    public static SinglyLinkedList.Node removeDummy(SinglyLinkedList.Node head, int tar) {
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        dummy.next = head;
        SinglyLinkedList.Node curr = dummy;
        while (curr.next != null){
            if(curr.next.data == tar){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    public static SinglyLinkedList.Node removeHead(SinglyLinkedList.Node head){
        if(head == null){
            return null;
        }
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(-1);
        dummy.next = head;
        SinglyLinkedList.Node curr = dummy;
        curr.next = curr.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        SinglyLinkedList list = A_Pattern.buildFromArray(arr);
//        list.printList();

        SinglyLinkedList.Node list2 = A_Pattern.convert(arr);
        SinglyLinkedList.Node list3 = A_Pattern.convertRec(arr, 0);
//        list.printList();
        traverse(list3);
        System.out.println(count(list3));
    }
}