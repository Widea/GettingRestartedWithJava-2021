import java.util.Scanner;
import java.util.Stack;

/**
 * Problem statement:
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which
 * can slide on to any tower.The puzzle starts with disks sorted in ascending order of size from top
 * to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */

public class StacksAndQueues4V {
    public static class Tower {
        private Stack<Integer> disks;
        private int towerNumber;

        Tower(int towerNumber) {
            this.disks = new Stack<>();
            this.towerNumber = towerNumber;
        }

        private int index() {
            return this.towerNumber;
        }

        public void addDisk(int disk) {
            if(!disks.isEmpty() && disks.peek() < disk) {
                System.out.println("ERROR ADDING DISKS");
                return;
            }
            disks.push(disk);
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.addDisk(top);
            System.out.println("Move disk " + top + " from " + index() +
                                   " to " + t.index());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if(n == 0) {
                return;
            }

            moveDisks(n-1, buffer, destination);
            this.moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public static void towerOfHanoiHelper(Tower[] towers, int numberOfDisks) {
        moveDisks(numberOfDisks, towers[2], towers[0], towers[1]);
    }

    public static void moveDisks(int n, Tower destination, Tower from, Tower buffer) {
        if(n == 0) {
            return;
        }
        from.moveDisks(n-1, buffer, destination);
        from.moveTopTo(destination);
        buffer.moveDisks(n-1, buffer, destination);
    }

    public static void towerOfHanoi(int numberOfDisks) {
        System.out.println("- - - ENTERED TOWER OF HANOI - - - ");
        Tower[] towers = new Tower[3];
        towers[0] = new Tower(1);
        towers[1] = new Tower(2);
        towers[2] = new Tower(3);

        for(int i = numberOfDisks ; i > 0 ; i--) {
            towers[0].addDisk(i);
        }

        towerOfHanoiHelper(towers, numberOfDisks);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Hello! This is the tower of hanoi. How many disks do you want to play with?");
        String input = myObj.nextLine();
        Integer numberOfDisks = 0;
        try {
            numberOfDisks = Integer.valueOf(input);
        } catch(Exception e) {
            System.out.println("There was an issue with the provided input. Please enter a valid integer.");
        }

        towerOfHanoi(numberOfDisks);
    }
}
