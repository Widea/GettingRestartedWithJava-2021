import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem statement:
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */

public class TreesAndGraphs3V {
    public static class Node {
        Node left;
        Node right;
        int value;
        int level;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.level = 0;
        }
    }

    public static Node convertToTreeHelper(int[] sortedArray, int start, int end, int level) {
        if(start == end ) {
            Node temp = new Node(sortedArray[start]);
            temp.level = level;
            return temp;
        } else if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(sortedArray[mid]);
        root.level = level;
        root.left = convertToTreeHelper(sortedArray, start, mid-1, level+1);
        root.right = convertToTreeHelper(sortedArray, mid+1, end, level+1);

        return root;
    }

    public static Node convertToTree(int[] sortedArray) {
        return convertToTreeHelper(sortedArray, 0, sortedArray.length - 1, 0);
    }

    private static void printTree(Node root) {
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        int curLevel = 0;
        System.out.println();

        while(!q.isEmpty()) {

            Node curr = q.removeFirst();
            if(curr.level > curLevel) {
                System.out.println();
                curLevel = curr.level;
            }
            System.out.print("   " + curr.value + "   ");

            if(curr.left != null)
                q.add(curr.left);

            if(curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        int sortedArray1[] = {1, 2, 3, 4, 5, 6, 7, 8};
        printTree(convertToTree(sortedArray1));

        int sortedArray2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printTree(convertToTree(sortedArray2));
    }
}
