/*
 * Problem statement: Given two string, identify if they are anagrams of each other.
 * */

import java.util.Arrays;

public class Solution3V {
    private static Boolean isAnagram(String input1, String input2) {
        if(input1 == null || input2 == null) {
            return false;
        }

        // Remove all the extra spaces before checking if the two strings are anagrams.
        input1 = input1.replaceAll("\\s", "");
        input2 = input2.replaceAll("\\s", "");

        if(input1.length() != input2.length()) {
            return false;
        }

        // changing all the characters to lower case and sorting.
        char[] inp1CharArray = input1.toLowerCase().toCharArray();
        Arrays.sort(inp1CharArray);
        char[] inp2CharArray = input2.toLowerCase().toCharArray();
        Arrays.sort(inp2CharArray);

        if(Arrays.equals(inp1CharArray, inp2CharArray)) {
            return true;
        }

        return false;
    }

//    public static void main(String args[]) {
//        System.out.println(isAnagram("Keep", "Peek"));
//        System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
//        System.out.println(isAnagram("heeelllooo", "hhheeelllo"));
//        System.out.println(isAnagram("jsdhsjk", null));
//
////        Solution:
////        true
////        true
////        false
////        false
//    }
}