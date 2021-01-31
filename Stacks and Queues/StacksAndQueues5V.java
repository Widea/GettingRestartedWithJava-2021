import java.util.Stack;

/**
 * Problem statement:
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class StacksAndQueues5V {
    public static class SpecialQueue {
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        SpecialQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void enqueue(int value) {
            stackIn.push(value);
            System.out.printf("Inserted value %d into the queue", value);
            System.out.println();
        }

        public int dequeue() {
            if(this.isEmpty()) {
                System.out.println("QUEUE IS EMPTY, RETURNING MIN INTEGER VALUE");
                return Integer.MIN_VALUE;
            }
            if(stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }

        public boolean isEmpty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        public int size() {
            return stackIn.size() + stackOut.size();
        }
    }

    public static void main(String[] args) {
        SpecialQueue q = new SpecialQueue();

        System.out.println("Queue size: " +q.size());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("Dequeuing: " +q.dequeue());
        System.out.println("Dequeuing: " +q.dequeue());
        System.out.println("Queue size: " +q.size());
        q.enqueue(5);
        q.enqueue(6);
        System.out.println("Queue size: " +q.size());
        System.out.println("Is queue empty? " +q.isEmpty());
        while(!q.isEmpty()) {
            System.out.println("Dequeuing: " +q.dequeue());
        }
        System.out.println("Queue size: " +q.size());
        System.out.println("Is queue empty? " +q.isEmpty());
        System.out.println("Attempting to dequeue from empty queue: " +q.dequeue());
    }
}
