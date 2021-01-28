/**
 * Problem statement:
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * DEFINITION:
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE:
 * Input:A ->B->C->D->E->(C)[the same C as earlier] Output:C
 */

public class LinkedList6V {
    public static class Node {
        Node next;
        char value;

        Node(char value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static char findCircularNode(Node head) {
        if(head == null ) {
            System.out.println("Invalid input");
            return '\0';
        }

        Node slow = head, fast = head;

        while(slow.next != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast.value;
    }

    private static void printLinkedList(Node head) {
        System.out.println();
        while(head != null) {
            System.out.print(head.value);
            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node a = new Node ('a', null);
        Node b = new Node ('b', null);
        Node v = new Node ('v', null);
        Node d = new Node ('d', null);
        Node e = new Node ('e', null);
        Node f = new Node ('f', null);

        a.next = b;
        b.next = v;
        v.next = d;
        d.next = e;
        e.next = f;
        f.next = v;

        System.out.println("The given has a cycle at point :" +findCircularNode(a));
    }
}
