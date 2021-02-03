import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem statement:
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

public class TreesAndGraphs2V {
    public static class Node {
        ArrayList<Node> vertices;
        int value;
        boolean isVisited;

        Node(int value) {
            this.value = value;
            this.vertices = new ArrayList<>();
            this.isVisited = false;
        }
    }

    public static boolean isConnected(Node start, Node end) {
        if(start == null || end == null) {
            return false;
        }

        if(start.vertices.contains(end)) {
            return true;
        } else {
            LinkedList<Node> q = new LinkedList<>();
            q.addLast(start);

            while(!q.isEmpty()) {
                Node curr = q.pollFirst();
                if(curr != null && !curr.isVisited) {
                    if(curr == end)
                        return true;
                    }

                    for(Node n : curr.vertices) {
                        q.add(n);
                    }
                    curr.isVisited = true;
                }
            }

        return false;
    }

    public static void main(String[] args) {
        // a -> b, c
        // b -> c, d, e
        // e -> f, g, i
        // i -> h, c
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);

        ArrayList<Node> lista = new ArrayList<>(Arrays.asList(b, c));
        ArrayList<Node> listb = new ArrayList<>(Arrays.asList(c, d, e));
        ArrayList<Node> liste = new ArrayList<>(Arrays.asList(f, g, i));
        ArrayList<Node> listi = new ArrayList<>(Arrays.asList(h, c));

        a.vertices = lista;
        b.vertices = listb;
        e.vertices = liste;
        i.vertices = listi;

        System.out.println("Is Connected: " + isConnected(a, i));
    }
}
