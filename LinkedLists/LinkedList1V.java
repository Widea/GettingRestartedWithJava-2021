import java.util.HashMap;

/**
 * Problem statement:
 * 1. Write code to remove duplicates from an unsorted linked list.
 * 2. FOLLOW UP -> How would you solve this problem if a temporary buffer is not allowed?
 */

public class LinkedList1V {
    public static class Node {
        Node next;
        int value;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node removeDuplicatesWithBuffer(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Boolean> buffer = new HashMap<>();
        Node curr = head;
        Node prev = null;

        while(curr != null) {
        if(buffer.containsKey(curr.value)) {
            prev.next = curr.next;
        } else {
            buffer.put(curr.value, true);
            prev = curr;
        }
        curr = curr.next;
        }

        return head;
    }

    private static Node removeDuplicatesWithoutBuffer(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head.next;
        int currval = head.value;

        while(temp != null && temp.next != null) {
            if(temp.value == currval) {
                temp.value = temp.next.value;
                temp.next = temp.next.next;
            }

            temp = temp.next;
            currval = temp.value;
        }

        HashMap<Integer, Boolean> buffer = new HashMap<>();
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            if(buffer.containsKey(curr.value)) {
                prev.next = curr.next;
            } else {
                buffer.put(curr.value, true);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
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
        Node head = new Node (3, new Node (4, new Node (3, new Node (4, new Node (4, new Node (5, null))))));

        System.out.print("Input list: ");
        printLinkedList(head);

        System.out.print("\nPost duplicate removal with buffer: ");
        printLinkedList(removeDuplicatesWithBuffer(head));

        System.out.print("\nPost duplicate removal without buffer: ");
        printLinkedList(removeDuplicatesWithoutBuffer(head));
    }
}
