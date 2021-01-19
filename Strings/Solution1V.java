/*
 * Problem statement: Remove all duplicate characters from the given string.
 * Will be using a string builder here since we will be modifying the object constantly and
 * this will ensure we are not creating a new instance of string each time.
 * */

import java.util.HashSet;

public class Solution1V {
    private static String removeDuplicates(String input) {
        if(!input) {
            return null;
        }

        HashSet<Character> characterHashSet = new HashSet<>();
        StringBuilder inputString = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if(!characterHashSet.contains(c)) {
                inputString.append(c);
                characterHashSet.add(c);
            }
        }
        return new String(inputString);
    }

//        TEST CASES:
//        String testInput1 = " MR John  SMITH           "; Output:" MR John  SMITH           "
//        String testInput2 = "         ";
//        String testInput3 = "jfhds";
//        String testInput4 = null;
}