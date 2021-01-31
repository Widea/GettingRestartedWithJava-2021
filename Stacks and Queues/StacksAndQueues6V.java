import java.util.Stack;

/**
 * Problem statement:
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy the elements into any other data
 * structure (such as an array).The stack supports the following operations: push, pop, peek, and isEmpty.
 */

public class StacksAndQueues6V {
    public static Stack<Integer> stackSorter(Stack<Integer> input) {
        Stack<Integer> buffer = new Stack<>();

        if(input == null || input.size() < 2) {
            return input;
        }

        buffer.push(input.pop());
        while(!input.isEmpty()) {
            int value = input.pop();
            while(!buffer.isEmpty() && buffer.peek() > value) {
                input.push(buffer.pop());
            }
            buffer.push(value);
        }

        return buffer;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-7);
        stack.push(3);
        stack.push(-2);
        stack.push(6);
        stack.push(5);
        stack.push(-1);
        stack.push(4);

        stack = stackSorter(stack);
        System.out.println("Printing sorted list");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}