/**
 * Problem statement:
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */

public class TreesAndGraphs1V {
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

    private static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
        Node lr = new Node (5);
        Node rr = new Node (7);
        Node ll = new Node(4);
        Node rl = new Node(6);
        Node l = new Node(2, ll, lr);
        Node r = new Node(3, rl, rr);
        Node root = new Node(1, l, r);

        Node lr1 = new Node (5);
        Node rr1 = new Node (7);
        Node ll1 = new Node(4);
        Node rl11 = new Node(6, new Node(7), null);
        Node rl1 = new Node(6, rl11, null);
        Node l1 = new Node(2, ll1, lr1);
        Node r1 = new Node(3, rl1, rr1);
        Node root1 = new Node(1, l1, r1);

        System.out.println("Is balanced: " +isBalanced(root));
        System.out.println("Is balanced: " +isBalanced(root1));

    }
}
