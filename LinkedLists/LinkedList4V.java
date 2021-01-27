/**
 * Problem statement:
 * Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x.
 */

public class LinkedList4V {
    public static class Node {
        Node next;
        int value;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node partitionList(Node head, int value) {
        if(head == null ) {
            return null;
        }

        Node newHead = null;

        while(head != null) {
            if(newHead == null) {
                newHead = head;
                head = head.next;
                newHead.next = null;
            } else if(head.value < value) {
                // add to front of newHead
                Node temp = head;
                head = head.next;
                temp.next = newHead;
                newHead = temp;
            } else {
                // add to bottom of new list
                Node temp = newHead;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = head;
                head = head.next;
                temp.next.next = null;
            }
        }

        return newHead;
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
        Node head = new Node (3, new Node (4, new Node (5, new Node (7, new Node (9, new Node (11, new Node (1, null)))))));
        System.out.print("LinkedList: ");
        printLinkedList(head);

        System.out.print("\nUpdated linked list: ");
        printLinkedList(partitionList(head, 6));
    }
}
