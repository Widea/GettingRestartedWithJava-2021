/**
 * Problem statement:
 * 1. You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the last digit is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * 2. Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 */

public class LinkedList5V {
    public static class Node {
        Node next;
        int value;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node addListWhenReverseOrder(Node head1, Node head2) {
        if(head1 == null ) {
            return head2;
        }

        if(head2 == null ) {
            return head1;
        }

        Node list1 = head1, list2 = head2;

        Node sum = null;
        int carryover = 0;
        while(list1 != null && list2 != null) {
            int currVal = list1.value + list2.value + carryover;
            carryover = currVal/10;
            currVal = currVal % 10;
            sum = addToFront(sum, currVal);
            list1 = list1.next;
            list2 = list2.next;
        }

        if(list1 == null && list2 != null) {
            // values from list 2 to front of sum till we encounter null
            while(list2 != null) {
                int currVal = list2.value + carryover;
                carryover = currVal/10;
                currVal = currVal % 10;
                sum = addToFront(sum, currVal);
                list2 = list2.next;
            }
        } else if(list2 == null && list1 != null) {
            while(list1 != null) {
                int currVal = list1.value + carryover;
                carryover = currVal/10;
                currVal = currVal % 10;
                sum = addToFront(sum, currVal);
                list1 = list1.next;
            }
        }

        if(carryover != 0) {
            sum = addToFront(sum, carryover);
        }

        return sum;
    }

    private static Node addToFront(Node head, int value) {
        Node temp = new Node(value, null);
        if(head != null) {
            temp.next = head;
        }
        head = temp;
        return head;
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

    private static Node reverseList(Node head1) {
        Node newHead = null;
        while(head1 != null) {
            Node temp = head1;
            head1 = head1.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    private static Node addListWhenNotReversed(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        return addListWhenReverseOrder(head1, head2);
    }

    public static void main(String[] args) {
        Node head1 = new Node (7, new Node (1, new Node (6, null)));
        Node head2 = new Node (5, new Node (9, new Node (2, null)));
        Node head3 = new Node (2, new Node (3, null));
        Node head4 = new Node (2, new Node (9, new Node (5, null)));

        System.out.println("Testing lists in reverse order:");
        printLinkedList(head1);
        printLinkedList(head2);
        System.out.print("\nThe sum of above two lists : ");
        printLinkedList(addListWhenReverseOrder(head1, head2));

        System.out.println("\nTesting lists in non reverse order:");
        printLinkedList(head1);
        printLinkedList(head2);
        System.out.print("\nThe sum of above two lists : ");
        printLinkedList(addListWhenNotReversed(head1, head2));

        System.out.println("\nTesting lists in reverse order:");
        printLinkedList(head3);
        printLinkedList(head4);
        System.out.print("\nThe sum of above two lists : ");
        printLinkedList(addListWhenReverseOrder(head3, head4));

        System.out.println("\nTesting lists in non reverse order:");
        printLinkedList(head3);
        printLinkedList(head4);
        System.out.print("\nThe sum of above two lists : ");
        printLinkedList(addListWhenNotReversed(head3, head4));
    }
}
