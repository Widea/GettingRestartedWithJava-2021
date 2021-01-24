/**
 * Problem statement:
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */

public class Solution9V {
    private static Boolean isRotation(String s1, String s2) {
        if(s1 == null || s2 ==  null || s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s1, s2+s2);
    }

    private static Boolean isSubstring(String s1, String s2) {

        return s2.contains(s1);
    }

    public static void main(String args[]) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("watebottl", "erbottlewat"));
        System.out.println(isRotation(null, "erbottlewat"));
        System.out.println(isRotation("llohe", "hello"));
        System.out.println(isRotation("lloeh", "hello"));
    }
}
