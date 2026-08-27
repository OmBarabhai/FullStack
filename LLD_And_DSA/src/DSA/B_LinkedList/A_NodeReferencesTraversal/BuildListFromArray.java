package DSA.B_LinkedList.A_NodeReferencesTraversal;

import DSA.B_LinkedList.Fundamentals.C_03_MyLinkedList_Design.SinglyLinkedList;

public class BuildListFromArray {

    public static SinglyLinkedList buildFromArray(int[] arr) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i <= arr.length-1; i++) {
            list.addAtTail(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        SinglyLinkedList list = BuildListFromArray.buildFromArray(arr);
        list.printList();
    }
}