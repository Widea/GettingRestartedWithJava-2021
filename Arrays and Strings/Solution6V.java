/**
 * Problem statement:
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example: the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the
 * original string.
 */

public class Solution6V {
    private static String compressor(String input) {
        if(input == null || input.length() <= 2) {
            return input;
        }

        StringBuilder compressedString = new StringBuilder();

        for(int i = 0; i < input.length();) {
            int count = 0;
            char c = input.charAt(i);
            while(i < input.length() && input.charAt(i) == c) {
                count++;
                i++;
            }
            compressedString.append(c);
            compressedString.append(count);
        }

        if(compressedString.length() >= input.length()) {
            return input;
        }

        return compressedString.toString();
    }

//    public static void main(String args[]) {
//        System.out.println(compressor("aabcccccaaa"));
//        System.out.println(compressor("aa"));
//        System.out.println(compressor("aakfffbcggggcccffcaaddddda"));
//        System.out.println(compressor("a"));
//        System.out.println(compressor(null));
////        Output:
////        a2b1c5a3
////            aa
////        a2k1f3b1c1g4c3f2c1a2d5a1
////            a
////        null
//    }
}