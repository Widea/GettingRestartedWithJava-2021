import java.util.Stack;

/**
 * Problem statement:
 * Implement a function to check if a linked list is a palindrome.
 */

public class LinkedList7V {
    public static class Node {
        Node next;
        char value;

        Node(char value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static boolean isPalindromeUsingStacks(Node head) {
        if(head == null ) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Node temp = head;
        while(temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }

        temp = head;
        while(temp.next != null || stack.empty()) {
            if(stack.pop() != temp.value) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    private static void constructStrings(StringBuilder s1, StringBuilder s2, Node head) {
        if(head == null) {
            return;
        }

        s1.append(head.value);
        constructStrings(s1, s2, head.next);
        s2.append(head.value);
    }

    private static boolean isPalindromeRecursively(Node head) {
        if(head == null ) {
            return false;
        }
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        constructStrings(s1, s2, head);

        return s1.toString().equals(s2.toString());
    }

    private static void printLinkedList(Node head) {
        if(head == null) {
            System.out.print("null");
            return;
        }
        while(head != null) {
            System.out.print(head.value);
            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('h', new Node('e',
            new Node('l', new Node('l', new Node('e', new Node('h', null))))));

        System.out.print("Actual list: "); printLinkedList(head);
        System.out.print("\n Is palindrome? (using stacks): " + isPalindromeUsingStacks(head));
        System.out.println("\n Is palindrome? (using recusrion): " + isPalindromeRecursively(head));

        Node head1 = null;
        System.out.print("Actual list: "); printLinkedList(head1);
        System.out.print("\n Is palindrome? (using stacks): " + isPalindromeUsingStacks(head1));
        System.out.println("\n Is palindrome? (using recusrion): " + isPalindromeRecursively(head1));

        Node head2 = new Node('a', new Node('b',
            new Node('c', new Node('d', new Node('b', new Node('a', null))))));

        System.out.print("Actual list: "); printLinkedList(head2);
        System.out.print("\n Is palindrome? (using stacks): " + isPalindromeUsingStacks(head2));
        System.out.println("\n Is palindrome? (using recusrion): " + isPalindromeRecursively(head2));
    }
}
