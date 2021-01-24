/**
 * Problem statement:
 * Write a method to replace all spaces in a string with'%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: for Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith" Output: "Mr%20Dohn%20Smith"
 */

public class Solution5V {
    private static String replaceSpaces(char[] input) {
        if(input == null) {
            return null;
        }

        // Finding the actual length of the string
        int len = 0;
        while(input[len] != '\0') {
            len++;
        }
        len--;

        // setting pointer to end of array for altering the values
        int j = input.length - 1;

        // If the encountered character is space - add %20 in the two preceeding blocks and the current one,
        // else copy the exact character.
        while(j >= 0 && len >= 0) {
            if(input[len] == ' ') {
                input[j] = '0';
                input[j-1] = '2';
                input[j-2] = '%';
                j = j-3;
            } else {
                input[j] = input[len];
                j = j-1;
            }
            len--;
        }
        return String.valueOf(input);
    }

//    public static void main(String args[]) {
//        System.out.println(replaceSpaces("Mr John Smith\0\0\0\0".toCharArray()));
//        System.out.println(replaceSpaces(" Hello! How are you Mr Smith? \0\0\0\0\0\0\0\0\0\0\0\0\0\0".toCharArray()));
//        System.out.println(replaceSpaces("  \0\0\0\0".toCharArray()));
//
////         Solution:
////        Mr%20John%20Smith
////        %20Hello!%20How%20are%20you%20Mr%20Smith?%20
////        %20%20
//    }
}