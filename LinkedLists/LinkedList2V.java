/**
 * Problem statement:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class LinkedList2V {
    public static class Node {
        Node next;
        int value;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static int findKthToLastElement(Node head, int k) {
        if(head == null || k < 0) {
            return Integer.MIN_VALUE;
        }

        Node start = head;
        Node kthelement = head;

        int count = 1;
        while(count < k && start.next != null) {
            start = start.next;
            count++;
        }

        while(start.next != null) {
            start = start.next;
            kthelement = kthelement.next;
        }

        return kthelement.value;
    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        System.out.println();
        while(temp != null) {
            System.out.print(temp.value);
            if(temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node (3, new Node (4, new Node (5, new Node (7, new Node (9, new Node (11, null))))));
        System.out.print("LinkedList: ");
        printLinkedList(head);
        System.out.println("\nprinting element 4 from last: " +findKthToLastElement(head, 4));
        System.out.println("\nprinting element 9 from last: " +findKthToLastElement(head, 9));
        System.out.println("\nprinting element 0 from last: " +findKthToLastElement(head, 0));

    }
}
