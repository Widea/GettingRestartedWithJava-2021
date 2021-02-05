import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Problem statement:
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each
 * depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class TreesAndGraphs4V {
    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void convertToLinkedListsHelper(Node node, int level,
                                                                    ArrayList<LinkedList<Integer>> lists) {
        if(node == null) {
            return;
        }

        if(level == lists.size()) {
            lists.add(new LinkedList<Integer>());
        }

        (lists.get(level)).addLast(node.value);
        convertToLinkedListsHelper(node.left, level + 1, lists);
        convertToLinkedListsHelper(node.right, level + 1, lists);
    }

    public static ArrayList<LinkedList<Integer>> convertToLinkedLists(Node root) {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        convertToLinkedListsHelper(root, 0, lists);

        return lists;
    }


    public static void main(String[] args) {
        Node r = new Node(1,
            new Node(2,
                new Node(3),
                new Node(4)),
            new Node(5,
                new Node(6,
                    new Node(7),
                    new Node(8)),
                new Node(9)));


        ArrayList<LinkedList<Integer>> result = convertToLinkedLists(r);
        for (LinkedList l : result) {
            while(!l.isEmpty()) {
                System.out.print(l.removeFirst() + "    ");
            }
            System.out.println();
        }
    }
}
