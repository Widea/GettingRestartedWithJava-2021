/*
 * Problem statement: Identify if the given string is a palindrome..
 * */

public class Solution2V {
    private static Boolean isPalindrome(String input) {
        if(input == null) {
            return false;
        }

        int start = 0;
        int end = input.length() - 1;

        while(end > start) {
           if(Character.toLowerCase(input.charAt(start)) != Character.toLowerCase(input.charAt(end))) {
               return false;
           }
           end--;
           start++;
        }

        return true;
    }

//    public static void main(String args[]) {
//        String[] testStrings = {"testtest", "hdhhhhh", "helleh", "Bor rowor rob", "c", null};
//
//        for(String testString: testStrings) {
//            System.out.println(testString+ ": " +isPalindrome(testString));
//        }
//        Solution:
//        testtest: false
//        hdhhhhh: false
//        helleh: true
//        Bor rowor rob: true
//        c: true
//        null: false
//    }
}