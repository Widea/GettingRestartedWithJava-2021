/*
a. Implement an algorithm to determine if a string has all unique characters.
b.What if you cannot use additional data structures?
 */

/*
 * Problem statement:
 * a. Implement an algorithm to determine if a string has all unique characters.
 * b. What if you cannot use additional data structures?
 * */

import java.util.HashMap;

public class Solution4V {
    private static Boolean hasUniqueCharacters(String input) {
        if(input == null) {
            return true;
        }

        HashMap<Character, Boolean> characterMap = new HashMap<>();

        for(int i = 0 ; i < input.length() ; i++) {
            Character character = input.charAt(i);
            if(characterMap.containsKey(character)) {
                return false;
            } else {
                characterMap.put(character, true);
            }
        }

        return true;
    }

    private static Boolean hasUniqueCharactersNoAdditionDs(String input) {
        if(input == null) {
            return true;
        }

        for(int i = 0 ; i < input.length() ; i++) {
            for(int j = i + 1 ; j < input.length(); j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

//    private static void printResult(String input) {
//        System.out.println("Input: " + input);
//        System.out.print("hasUniqueCharacters: " + hasUniqueCharacters(input) + "   ");
//        System.out.println("hasUniqueCharactersNoAdditionDs: " + hasUniqueCharactersNoAdditionDs(input));
//    }
//    
//    public static void main(String args[]) {
//        printResult("Keep");
//        printResult("Mother In Law");
//        printResult("");
//        printResult("jsdhk");
//        printResult(null);
//        Solution:
//        Input: Keep
//        hasUniqueCharacters: false   hasUniqueCharactersNoAdditionDs: false
//        Input: Mother In Law
//        hasUniqueCharacters: false   hasUniqueCharactersNoAdditionDs: false
//        Input:
//        hasUniqueCharacters: true   hasUniqueCharactersNoAdditionDs: true
//        Input: jsdhk
//        hasUniqueCharacters: true   hasUniqueCharactersNoAdditionDs: true
//        Input: null
//        hasUniqueCharacters: true   hasUniqueCharactersNoAdditionDs: true
//    }
}