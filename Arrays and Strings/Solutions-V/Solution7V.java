/**
 * Problem statement:
 * a.Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * b.Can you do this in place?
 */

public class Solution7V {
    private static Character[][] rotateMatrix(Character[][] input) {
        int dimension = input.length;

        if(input == null || dimension < 2 ) {
            return input;
        }

        Character[][] output = new Character[dimension][dimension];

        for(int i = 0; i < dimension ; i++) {
            int k = dimension - 1;
            for(int j = 0; j < dimension; j++) {
                output[i][j] = input[k][i];
                k--;
            }
        }
        return output;
    }

    private static Character[][] rotateMatrixInPlace(Character[][] input) {
        if(input == null ) {
            return null;
        }

        int dimension = input.length;
        for(int layer = 0; layer < dimension/2 ; layer++) {
            int first = layer;
            int last = dimension - layer - 1;

            for(int i = first; i < last ; i++) {
                int offset = i - first;
                // savetop
                char top = input[first][i];
                // left -> top
                input[first][i] = input[last-offset][first];
                // bottom -> left
                input[last-offset][first] = input[last][last - offset];
                // right -> bottom
                input[last][last - offset] = input[i][last];
                // top -> right
                input[i][last] = top ;
            }
        }

        return input;
    }

    private static void printOutput(Character[][] input) {
        if(input == null) {
            System.out.println("Invalid input");
            return;
        }
        int dimension = input.length;
        printMatrix("Given input: ", input, dimension);
        printMatrix("Printing output from function rotateMatrix: ", rotateMatrix(input), dimension);
        printMatrix("Printing output from function rotateMatrixInPlace: ", rotateMatrixInPlace(input), dimension);
    }

    private static void printMatrix(String statement, Character[][] input, int dimension) {
        System.out.print('\n' + statement);
        for(int i = 0; i < dimension ; i++) {
            System.out.println();
            for(int j = 0; j < dimension ; j++) {
                System.out.print(input[i][j] + "   ");
            }
        }
    }

    public static void main(String args[]) {
        Character[][] inputArr = {{'1', '2', '3'},
                                  {'4', '5', '6'},
                                  {'7', '8', '9'}};
//        Character[][] inputArr = {{'1', '2', '3', '4'},
//                                  {'5', '6', '7', '8'},
//                                  {'9', '0', '1', '2'},
//                                  {'3', '4', '5', '6'}};
//        Character[][] inputArr = {{'1'}};
//        Character[][] inputArr = null;

        printOutput(inputArr);
    }
}
