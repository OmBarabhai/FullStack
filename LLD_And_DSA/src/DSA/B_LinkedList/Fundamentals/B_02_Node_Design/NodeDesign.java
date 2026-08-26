package DSA.B_LinkedList.Fundamentals.B_02_Node_Design;

public class NodeDesign {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);
        System.out.println(n1.data);
        System.out.println(n1.next.data);
        System.out.println(n1.next.next.data);
        System.out.println(n1.next.next.next);

    }
}
