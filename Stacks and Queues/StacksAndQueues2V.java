import java.util.Stack;

/**
 * Problem statement:
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 */

public class StacksAndQueues2V {
    public static class SpecialStack extends Stack<Integer>{
        Stack<Integer> minKeeper;
        public SpecialStack() {
            minKeeper = new Stack<>();
        }

        public void push(int value) {
            if(minKeeper.isEmpty() || minKeeper.peek() > value) {
                minKeeper.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int poppedValue = super.pop();
            if(!minKeeper.isEmpty() && minKeeper.peek() == poppedValue) {
                minKeeper.pop();
            }
            return poppedValue;
        }

        public int getMin() {
            if(minKeeper.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return minKeeper.peek();
        }
    }

    public static void main(String[] args) {
        StacksAndQueues2V solution;
        SpecialStack specialStack = new SpecialStack();

        specialStack.push(25);
        specialStack.push(12);
        specialStack.push(5);
        specialStack.push(29);
        specialStack.push(35);
        specialStack.push(9);

        while(!specialStack.isEmpty()) {
            System.out.println("CURR MIN: " +specialStack.getMin());
            System.out.println("POPPING: " +specialStack.pop());
            System.out.println("NEW MIN: " +specialStack.getMin());
        }
    }
}
