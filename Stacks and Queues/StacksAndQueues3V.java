import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem statement:
 * 1. Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
 * we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structureSetOf Stacks that mimics this. SetOf Stacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 * (that is, pop() should return the same values as it would if there were just a single stack).
 *
 * 2. Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

public class StacksAndQueues3V {
    public static class SetOfStacks {
        private ArrayList<Stack<Integer>> listOfStacks;
        private int max;
        private int count;

        public SetOfStacks(int max) {
            this.listOfStacks = new ArrayList<>();
            this.max = max;
            this.count = 0;
        }

        public void push(int value) {
            if(count == 0 || listOfStacks.get(count-1).size() == max) {
                listOfStacks.add(new Stack<Integer>());
                count++;
            }

            listOfStacks.get(count-1).push(value);
        }

        public Integer pop() {
            if(count <= 0) {
                return Integer.MIN_VALUE;
            }

            int poppedValue = listOfStacks.get(count-1).pop();

            if(listOfStacks.get(count-1).isEmpty()) {
                listOfStacks.remove(count - 1);
                count--;
            }
            return poppedValue;
        }

//        public int popAt(int index) {
//            int poppedItem = Integer.MAX_VALUE;
//            if(index <= 0) {
//                index = 0;
//            } else if (index >= count) {
//                index = count-1;
//            } else {
//                index = index - 1;
//            }
//
//            if(!listOfStacks.isEmpty()) {
//                poppedItem = listOfStacks.get(index).pop();
//            }
//
//            if(index != count-1) {
//                initiateRollOver(index);
//            }
//
//            return poppedItem;
//        }

//        private void initiateRollOver(int index) {
//            Queue<Integer> q = new PriorityQueue();
//            for(int i = index + 1 ; i < count ; i++) {
//                while(!listOfStacks.get(i).isEmpty()) {
//                    q.(listOfStacks.get(i).pop());
//                }
//            }
//
//            count = index;
//            while(!q.isEmpty()) {
//                this.push(q.poll());
//            }
//        }

        public boolean isEmpty() {
            return count <= 0;
        }
    }

    public static void main(String[] args) {
        SetOfStacks specialStack = new SetOfStacks(2);

        specialStack.push(25);
        specialStack.push(12);
        specialStack.push(5);
        specialStack.push(29);
        specialStack.push(35);
        specialStack.push(9);

        // 12  29  9
        // 25  5  35
        while(!specialStack.isEmpty()) {
            System.out.println("POPPING: " +specialStack.pop());
        }

//        System.out.println(specialStack.popAt(-100));
//        System.out.println(specialStack.popAt(10));
//        System.out.println(specialStack.popAt(2));
//        System.out.println(specialStack.popAt(4));
    }
}
