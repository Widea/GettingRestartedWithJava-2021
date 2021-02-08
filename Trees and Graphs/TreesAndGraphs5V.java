/**
 * Problem statement:
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent.
 */

public class TreesAndGraphs5V {
    public static class Node {
        Node left;
        Node right;
        Node parent;
        int value;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public static Node returnNextNode(Node node) {
        if(node == null) {
            return null;
        }

        if(node.right != null) {
           return leftmostChild(node.right);
        }
            // go the top most node
            Node n = node;
            Node np = node.parent;

            while(np != null && np.left != n) {
                n = np;
                np = np.parent;
            }
            return np;
    }

    private static Node leftmostChild(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.left = node2;
        node2.parent = node1;
        node1.right = node5;
        node5.parent = node1;

        node2.left = node3;
        node3.parent = node2;
        node2.right = node4;
        node4.parent = node2;

        node5.left = node6;
        node6.parent = node5;
        node5.right = node9;
        node9.parent = node5;

        node6.left = node7;
        node7.parent = node6;
        node6.right = node8;
        node8.parent = node6;

//        System.out.println(returnNextNode(node1).value);
        System.out.println(returnNextNode(node4).value);
//        System.out.println(returnNextNode(node5).value);
//        System.out.println(returnNextNode(node3).value);

    }
}
